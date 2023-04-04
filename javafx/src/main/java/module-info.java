module com.example.javafx {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.javafx to javafx.fxml;
    exports com.example.javafx;
    exports com.example.javafx.dataset;
    opens com.example.javafx.dataset to javafx.fxml;
    exports com.example.javafx.datastructures.LinkedList;
    opens com.example.javafx.datastructures.LinkedList to javafx.fxml;
}