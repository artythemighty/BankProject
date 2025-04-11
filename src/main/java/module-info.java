module com.example.homepage {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.net.http;
    requires java.desktop;


    opens com.example.homepage to javafx.fxml;
    exports com.example.homepage;
}