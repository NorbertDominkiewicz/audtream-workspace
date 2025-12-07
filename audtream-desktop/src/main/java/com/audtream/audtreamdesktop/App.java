package com.audtream.audtreamdesktop;

import com.audtream.audtreamdesktop.controller.LoginController;
import com.audtream.audtreamdesktop.controller.MainController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class App extends Application {
    private Stage primaryStage;
    @Override
    public void start(Stage stage) throws IOException {
        primaryStage = stage;
        primaryStage.setResizable(false);
        showLoginScene();
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

            Scene mainScene = new Scene(root, 1200, 800);
            primaryStage.setScene(mainScene);
            primaryStage.setTitle("Główna aplikacja");
            primaryStage.centerOnScreen();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch();
    }
}