module org.example.Digital_Clock {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens org.example.Digital_Clock to javafx.fxml;
    exports org.example.Digital_Clock;
}