package fr.stayze.passwordmanager.controllers;

import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TextField;

public class LoginController extends Controller {

    public LoginController() {
        super();
    }

    public void view() {
        this.render("login.fxml", "login.css", 400, 400);
    }

    public void login() {
        TextField username = (TextField) this._window.getScene().lookup("#username");
        TextField password = (TextField) this._window.getScene().lookup("#password");
        System.out.println(username.getText());
        System.out.println(password.getText());
    }

}
