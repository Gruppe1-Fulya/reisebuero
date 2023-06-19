module com.example.reisebuero2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires org.testng;


    opens com.example.reisebuero2 to javafx.fxml;
    exports com.example.reisebuero2;
}