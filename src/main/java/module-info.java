module com.example.softeng {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.example.softeng to javafx.fxml;
    exports com.example.softeng;
}