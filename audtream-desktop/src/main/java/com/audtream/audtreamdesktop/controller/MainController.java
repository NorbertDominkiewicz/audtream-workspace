package com.audtream.audtreamdesktop.controller;

import com.audtream.audtreamdesktop.App;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;

import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class MainController implements Initializable {
    @FXML private ImageView imgPrev;
    @FXML private GridPane topBarPane;
    @FXML private Button closeBtn;

    private App app;
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
    }
}
