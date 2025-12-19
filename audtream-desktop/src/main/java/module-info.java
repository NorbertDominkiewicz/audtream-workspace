module com.audtream.audtreamdesktop {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;

    requires org.controlsfx.controls;
    requires java.desktop;
    requires jdk.compiler;
    requires java.net.http;
    requires org.apache.commons.net;
    requires com.google.gson;

    opens com.audtream.audtreamdesktop to javafx.fxml;
    exports com.audtream.audtreamdesktop;
    opens com.audtream.audtreamdesktop.controller to javafx.fxml;
    exports com.audtream.audtreamdesktop.controller;
}