module com.audtream.audtreamdesktop {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires java.desktop;
    requires jdk.compiler;

    opens com.audtream.audtreamdesktop to javafx.fxml;
    exports com.audtream.audtreamdesktop;
    opens com.audtream.audtreamdesktop.controller to javafx.fxml;
    exports com.audtream.audtreamdesktop.controller;
}