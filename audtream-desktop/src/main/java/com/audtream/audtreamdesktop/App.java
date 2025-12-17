package com.audtream.audtreamdesktop;

import com.audtream.audtreamdesktop.controller.LoginController;
import com.audtream.audtreamdesktop.controller.MainController;
import com.audtream.audtreamdesktop.util.Position;
import com.audtream.audtreamdesktop.util.SizeManager;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

import java.io.IOException;

public class App extends Application {
    private static Stage primaryStage;
    private static Position position;
    @Override
    public void start(Stage stage) throws IOException {
        position = new Position();
        primaryStage = stage;
        primaryStage.setResizable(false);
        primaryStage.initStyle(StageStyle.TRANSPARENT);
        showMainAppScene();
    }

    public static void loadAppMovement(Node target) {
        target.setOnMousePressed((MouseEvent event) -> {
            position.setX((int) (event.getScreenX() - primaryStage.getX()));
            position.setY((int) (event.getScreenY() - primaryStage.getY()));
        });

        target.setOnMouseDragged((MouseEvent event) -> {
            primaryStage.setX(event.getScreenX() - position.getX());
            primaryStage.setY(event.getScreenY() - position.getY());
        });
    }

    public static void close() {
        Timeline timeline = new Timeline();
        KeyFrame keyFrame = new KeyFrame(
                Duration.millis(300),
                new KeyValue(primaryStage.getScene().getRoot().opacityProperty(), 0)
        );
        timeline.getKeyFrames().add(keyFrame);
        timeline.setOnFinished(actionEvent -> System.exit(0));
        timeline.play();
    }

    private void showLoginScene() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("fxml/views/LoginView.fxml"));
            Parent root = loader.load();
            LoginController controller = loader.getController();
            controller.setMainApp(this);

            Scene loginScene = new Scene(root, 900, 600);
            primaryStage.setScene(loginScene);
            primaryStage.setTitle("Login | AUDTREAM");
            primaryStage.setResizable(false);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showMainAppScene() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("fxml/views/MainAppView.fxml"));
            Parent root = loader.load();
            MainController controller = loader.getController();
            controller.setMainApp(this);

            Scene mainScene = new Scene(root, SizeManager.getScreenWidth() * 0.95, SizeManager.getScreenHeight() * 0.9);
            mainScene.setFill(Color.TRANSPARENT);
            primaryStage.setScene(mainScene);
            primaryStage.setTitle("Główna aplikacja");
            primaryStage.centerOnScreen();
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch();
    }
}