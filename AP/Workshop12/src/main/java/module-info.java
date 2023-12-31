module com.example.ws12 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.ws12 to javafx.fxml;
    exports com.example.ws12;
}