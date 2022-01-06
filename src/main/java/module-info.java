module com.example.kuis_1972004 {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.hibernate.orm.core;
    requires java.sql;
    requires java.persistence;
    requires java.naming;


    opens com.example.kuis_1972004 to javafx.fxml;
    opens com.example.kuis_1972004.Controller to javafx.fxml;
    exports com.example.kuis_1972004;
    exports com.example.kuis_1972004.Model;
    exports com.example.kuis_1972004.Controller;

}