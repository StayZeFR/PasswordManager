module fr.stayze.passwordmanager {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires org.json;
    requires java.sql;
    requires org.xerial.sqlitejdbc;

    opens fr.stayze.passwordmanager to javafx.fxml;
    exports fr.stayze.passwordmanager;

    opens fr.stayze.passwordmanager.controllers to javafx.fxml;
    exports fr.stayze.passwordmanager.controllers;
    exports fr.stayze.passwordmanager.utils;
    opens fr.stayze.passwordmanager.utils to javafx.fxml;
}