package fr.stayze.passwordmanager.controllers;

import fr.stayze.passwordmanager.PasswordManager;
import fr.stayze.passwordmanager.Window;
import fr.stayze.passwordmanager.views.View;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.io.IOException;
import java.util.Objects;

public abstract class Controller {

    protected final Window _window;

    protected Controller() {
        this._window = PasswordManager.getWindow();
    }

    /**
     * Render a scene from a resource
     *
     * @param resource
     * @param w
     * @param h
     */
    protected void render(String resource, int w, int h) {
        try {
            this._window.setScene(View.buildScene(resource, w, h));
            this._window.show();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Render a scene from a resource and a css file
     *
     * @param resource
     * @param css
     * @param w
     * @param h
     */
    protected void render(String resource, String css, int w, int h) {
        try {
            this._window.setScene(View.buildScene(resource, css, w, h));
            this._window.show();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

}
