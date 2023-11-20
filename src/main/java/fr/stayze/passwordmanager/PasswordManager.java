package fr.stayze.passwordmanager;

import fr.stayze.passwordmanager.controllers.Controller;
import fr.stayze.passwordmanager.controllers.LoginController;
import fr.stayze.passwordmanager.controllers.RegisterController;
import fr.stayze.passwordmanager.models.files.UserModel;
import fr.stayze.passwordmanager.views.View;
import javafx.application.Application;
import javafx.stage.Stage;

public class PasswordManager extends Application {

    private static Stage _stage;
    private static Window _window;

    @Override
    public void start(Stage stage) {
        _stage = stage;
        _window = new Window(stage);
        _window.setTitle("Password Manager");
        this.initialize();
    }

    /**
     * Initialize the application
     */
    private void initialize() {
        UserModel userModel = new UserModel();
        if (!userModel.isCreated()) {
            View.set("register");
        } else {
            View.set("login");
        }
    }

    /**
     * Get the stage of the application
     *
     * @return Stage
     */
    public static Stage getStage() {
        return _stage;
    }

    /**
     * Get the window of the application
     *
     * @return Window
     */
    public static Window getWindow() {
        return _window;
    }

    public static void main(String[] args) {
        launch();
    }

}
