package com.audtream.audtreamdesktop.controller;

import com.audtream.audtreamdesktop.App;
import javafx.fxml.FXML;

public class LoginController {
    private App app;

    @FXML
    private void handleLogin() {
        if (true) {
            app.showMainAppScene();
        }
    }

    public void setMainApp(App app) {
        this.app = app;
    }
}