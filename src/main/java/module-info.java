module com.example.example2javafx {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.example2javafx to javafx.fxml;
    exports com.example.example2javafx;
}