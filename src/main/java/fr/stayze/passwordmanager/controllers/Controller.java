package fr.stayze.passwordmanager.controllers;

import fr.stayze.passwordmanager.PasswordManager;
import fr.stayze.passwordmanager.Window;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.io.IOException;
import java.util.Objects;

public abstract class Controller {

    Window _window;
    private FXMLLoader _loader;

    protected Controller() {
        this._window = PasswordManager.getWindow();
        this._loader = this._window.getLoader();
    }

    /**
     * Render a scene from a resource
     *
     * @param resource
     * @param h
     * @param w
     * @return Scene
     */
    protected void render(String resource, int h, int w) {
        try {
            this._loader.setLocation(getClass().getResource("/fr/stayze/passwordmanager/views/" + resource));
            Parent root = this._loader.load();
            this._window.setScene(new Scene(root, h, w));
            this._window.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    protected void render(String resource, String css, int h, int w) {
        this.render(resource, h, w);
        this._window.getScene().getStylesheets().add(Objects.requireNonNull(getClass().getResource("/fr/stayze/passwordmanager/styles/" + css)).toExternalForm());
    }

}
