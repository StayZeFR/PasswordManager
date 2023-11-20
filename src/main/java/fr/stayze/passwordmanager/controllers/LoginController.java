package fr.stayze.passwordmanager.controllers;

import fr.stayze.passwordmanager.Security;
import fr.stayze.passwordmanager.models.files.UserModel;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TextField;

import java.security.NoSuchAlgorithmException;

public class LoginController extends Controller {

    @FXML
    private TextField username;
    @FXML
    private TextField password;
    @FXML
    private TextField secondPassword;

    public LoginController() {
        super();
    }

    public void view() {
        this._window.setResizable(false);
        this.render("login.fxml", "login.css", 400, 400);
    }

    /**
     * Login a user and open the main window
     */
    public void login() {
        String username = this.username.getText();
        String password = this.password.getText();
        String secondPassword = this.secondPassword.getText();

        try {
            if (!username.isEmpty() || !password.isEmpty()) {
                UserModel userModel = new UserModel();
                if (userModel.checkUser(username, password)) {
                    if (userModel.checkToken(secondPassword)) {
                        Security.setPasswordDB(password);
                        Security.setPasswordInDB(secondPassword);
                    }
                }
            }
        } catch (NoSuchAlgorithmException e) {
            System.out.println(e.getMessage());
        }
    }

}
