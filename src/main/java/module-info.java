module fr.stayze.passwordmanager {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;

    opens fr.stayze.passwordmanager to javafx.fxml;
    exports fr.stayze.passwordmanager;

    opens fr.stayze.passwordmanager.controllers to javafx.fxml;
    exports fr.stayze.passwordmanager.controllers;
}