package fr.stayze.passwordmanager;

import fr.stayze.passwordmanager.controllers.Controller;
import fr.stayze.passwordmanager.controllers.LoginController;
import javafx.application.Application;
import javafx.stage.Stage;

public class PasswordManager extends Application {

    private static Stage _stage;
    private static Window _window;

    @Override
    public void start(Stage stage) throws Exception {
        _stage = stage;
        _window = new Window(stage);
        _window.setTitle("Password Manager");
        LoginController controller = new LoginController();
        controller.view();
    }

    public static Stage getStage() {
        return _stage;
    }

    public static Window getWindow() {
        return _window;
    }

    public static void main(String[] args) {
        launch();
    }

}
