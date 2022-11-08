module com.mazebank.mazebank {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires org.xerial.sqlitejdbc;
    // requires de.jensd.fx.glyphs.fontawesome;

    opens com.mazebank.mazebank to javafx.fxml;
    exports com.mazebank.mazebank;
    exports com.mazebank.mazebank.Controllers;
    exports com.mazebank.mazebank.Controllers.Admin;
    exports com.mazebank.mazebank.Controllers.Client;
    exports com.mazebank.mazebank.Models;
    exports com.mazebank.mazebank.Views;
}