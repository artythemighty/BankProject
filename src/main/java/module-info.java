module com.example.homepage {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.net.http;
    requires jfxrt;
    requires rt;


    opens com.example.homepage to javafx.fxml;
    exports com.example.homepage;
}