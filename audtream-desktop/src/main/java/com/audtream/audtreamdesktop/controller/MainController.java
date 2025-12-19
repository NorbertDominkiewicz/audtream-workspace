package com.audtream.audtreamdesktop.controller;

import com.audtream.audtreamdesktop.App;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;

import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.io.*;
import java.net.HttpURLConnection;

public class MainController implements Initializable {
    @FXML private ImageView imgPrev;
    @FXML private GridPane topBarPane;
    @FXML private Button closeBtn;

    /**
     * Music Controller
     */
    @FXML private GridPane musicPlayerGrid;
    @FXML private Label musicTitleLabel;
    @FXML private Label musicAuthorLabel;
    @FXML private Button musicPlayButton;
    @FXML private ProgressBar musicProgressBar;

    private App app;
    private MediaPlayer mediaPlayer;
    private boolean isPlaying = false;
    private final Gson gson = new Gson();

    // Dane FTP - zmień na swoje!
    private static final String FTP_HOST = "audtream.cba.pl/";
    private static final String FTP_USERNAME = "nd89273";
    private static final String FTP_PASSWORD = "Dei1.nnnn";
    private static final int FTP_PORT = 21;
    private static final String FTP_BASE_PATH = "/tracks/";

    public void setMainApp(App app) {
        this.app = app;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        imgPrev.setPreserveRatio(false);
        imgPrev.setFitHeight(150);
        imgPrev.setFitWidth(150);
        imgPrev.setImage(new Image(Objects.requireNonNull(getClass().getResource("/com/audtream/audtreamdesktop/assets/img/temp/me.jpg")).toExternalForm()));
        Circle clip = new Circle(75, 75, 75);
        imgPrev.setClip(clip);

        App.loadAppMovement(topBarPane);
        closeBtn.setOnAction(actionEvent -> App.close());

        // Inicjalizacja przycisku play
        musicPlayButton.setOnAction(event -> togglePlay());
    }

    @FXML
    private void togglePlay() {
        if (isPlaying) {
            pauseMusic();
        } else {
            play();
        }
    }

    public void play() {
        // Pokaż stan ładowania
        musicPlayButton.setText("⏳");
        musicPlayButton.setDisable(true);

        // Uruchom w osobnym wątku, aby nie blokować UI
        new Thread(() -> {
            try {
                // 1. Pobierz metadane utworu z API
                System.out.println("Pobieranie metadanych dla ID: 329123");
                String trackJson = fetchTrackMetadata(329123);
                System.out.println("Otrzymano: " + trackJson);

                // 2. Parsuj JSON
                JsonObject trackData = gson.fromJson(trackJson, JsonObject.class);
                int trackId = trackData.get("id").getAsInt();
                String title = trackData.get("title").getAsString();
                String author = trackData.get("author").getAsString();
                int length = trackData.get("length").getAsInt();

                // 3. Zaktualizuj UI (musi być w wątku JavaFX)
                javafx.application.Platform.runLater(() -> {
                    musicTitleLabel.setText(title);
                    musicAuthorLabel.setText(author);
                });

                // 4. Pobierz plik z FTP i odtwórz
                String fileName = title.replaceAll("\\s+", "") + ".mp3";
                String ftpFilePath = FTP_BASE_PATH + trackId + "/" + fileName;

                System.out.println("Ścieżka FTP: " + ftpFilePath);
                System.out.println("Nazwa pliku: " + fileName);

                File audioFile = downloadFromFTP(ftpFilePath);

                if (audioFile != null) {
                    System.out.println("Plik pobrany pomyślnie, rozmiar: " + audioFile.length());
                    // 5. Odtwórz plik w wątku JavaFX
                    javafx.application.Platform.runLater(() -> {
                        playAudioFile(audioFile, length);
                    });
                } else {
                    System.err.println("Nie udało się pobrać pliku z FTP");
                    javafx.application.Platform.runLater(() -> {
                        musicPlayButton.setText("▶️");
                        musicPlayButton.setDisable(false);
                    });
                }

            } catch (Exception e) {
                e.printStackTrace();
                javafx.application.Platform.runLater(() -> {
                    musicPlayButton.setText("▶️");
                    musicPlayButton.setDisable(false);
                    System.err.println("Błąd odtwarzania: " + e.getMessage());
                });
            }
        }).start();
    }

    private String fetchTrackMetadata(int trackId) throws Exception {
        HttpClient httpClient = HttpClient.newHttpClient();
        String url = "http://localhost:8080/api/v1/desktop/track?id=" + trackId;
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() == 200) {
            return response.body();
        } else {
            throw new RuntimeException("API error: " + response.statusCode());
        }
    }

    private File downloadFromFTP(String remoteFilePath) {
        FTPClient ftpClient = new FTPClient();

        try {
            System.out.println("Łączenie z FTP: " + FTP_HOST + ":" + FTP_PORT);

            ftpClient.connect(FTP_HOST, FTP_PORT);
            int replyCode = ftpClient.getReplyCode();

            if (!FTPReply.isPositiveCompletion(replyCode)) {
                System.err.println("FTP odmówił połączenia. Kod: " + replyCode);
                ftpClient.disconnect();
                return null;
            }

            System.out.println("Logowanie: " + FTP_USERNAME);
            boolean loginSuccess = ftpClient.login(FTP_USERNAME, FTP_PASSWORD);

            if (!loginSuccess) {
                System.err.println("Błąd logowania FTP");
                ftpClient.logout();
                ftpClient.disconnect();
                return null;
            }

            ftpClient.enterLocalPassiveMode();
            ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
            ftpClient.setControlEncoding("UTF-8");

            // Sprawdź czy plik istnieje
            System.out.println("Sprawdzam plik: " + remoteFilePath);

            File tempFile = File.createTempFile("audtream_", ".mp3");
            tempFile.deleteOnExit();

            try (OutputStream outputStream = new BufferedOutputStream(new FileOutputStream(tempFile))) {
                System.out.println("Rozpoczynam pobieranie...");

                boolean success = ftpClient.retrieveFile(remoteFilePath, outputStream);

                if (success) {
                    long fileSize = tempFile.length();
                    System.out.println("Pobrano plik: " + fileSize + " bajtów do " + tempFile.getAbsolutePath());
                    return tempFile;
                } else {
                    System.err.println("Nie udało się pobrać pliku: " + remoteFilePath);
                    System.err.println("Odpowiedź FTP: " + ftpClient.getReplyString());

                    // Sprawdź listę plików w katalogu dla debugowania
                    String dirPath = FTP_BASE_PATH + 329123 + "/";
                    System.out.println("Sprawdzam zawartość: " + dirPath);
                    String[] files = ftpClient.listNames(dirPath);
                    if (files != null) {
                        System.out.println("Pliki w katalogu:");
                        for (String file : files) {
                            System.out.println("  - " + file);
                        }
                    }
                    return null;
                }
            }

        } catch (Exception e) {
            System.err.println("FTP error: " + e.getMessage());
            e.printStackTrace();
            return null;
        } finally {
            try {
                if (ftpClient.isConnected()) {
                    ftpClient.logout();
                    ftpClient.disconnect();
                    System.out.println("Połączenie FTP zamknięte");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void playAudioFile(File audioFile, int lengthInSeconds) {
        try {
            // Zatrzymaj poprzedni odtwarzacz jeśli istnieje
            if (mediaPlayer != null) {
                mediaPlayer.stop();
                mediaPlayer.dispose();
            }

            // Utwórz nowy Media i MediaPlayer
            Media media = new Media(audioFile.toURI().toString());
            mediaPlayer = new MediaPlayer(media);

            // Skonfiguruj obsługę zdarzeń
            setupMediaPlayerListeners();

            // Rozpocznij odtwarzanie
            mediaPlayer.play();
            isPlaying = true;
            musicPlayButton.setText("⏸️");
            musicPlayButton.setDisable(false);

            // Ustaw maksymalny czas trwania dla progress bar
            musicProgressBar.setProgress(0);

        } catch (Exception e) {
            System.err.println("Błąd odtwarzania pliku: " + e.getMessage());
            e.printStackTrace();
            musicPlayButton.setText("▶️");
            musicPlayButton.setDisable(false);
        }
    }

    private void setupMediaPlayerListeners() {
        if (mediaPlayer == null) return;

        // Aktualizuj pasek postępu
        mediaPlayer.currentTimeProperty().addListener((obs, oldTime, newTime) -> {
            if (mediaPlayer.getTotalDuration().toSeconds() > 0) {
                double progress = newTime.toSeconds() / mediaPlayer.getTotalDuration().toSeconds();
                musicProgressBar.setProgress(progress);
            }
        });

        // Obsługa zakończenia odtwarzania
        mediaPlayer.setOnEndOfMedia(() -> {
            musicPlayButton.setText("▶️");
            musicProgressBar.setProgress(0);
            isPlaying = false;
        });

        // Obsługa błędów
        mediaPlayer.setOnError(() -> {
            System.err.println("Błąd odtwarzacza: " + mediaPlayer.getError());
            musicPlayButton.setText("▶️");
            musicPlayButton.setDisable(false);
            isPlaying = false;
        });
    }

    private void pauseMusic() {
        if (mediaPlayer != null && isPlaying) {
            mediaPlayer.pause();
            musicPlayButton.setText("▶️");
            isPlaying = false;
        }
    }

    // Metoda do zatrzymania odtwarzania przy zamykaniu aplikacji
    public void stopPlayback() {
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            mediaPlayer.dispose();
        }
    }
}