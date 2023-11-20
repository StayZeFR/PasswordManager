package fr.stayze.passwordmanager.controllers;

import fr.stayze.passwordmanager.Security;
import fr.stayze.passwordmanager.models.files.UserModel;
import fr.stayze.passwordmanager.utils.CryptUtil;
import fr.stayze.passwordmanager.views.View;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class RegisterController extends Controller {

    @FXML
    private TextField username;
    @FXML
    private TextField password;
    @FXML
    private TextField passwordConfirm;
    @FXML
    private TextField secondPassword;
    @FXML
    private TextField secondPasswordConfirm;
    @FXML
    private ToggleGroup group;

    public void view() {
        this._window.setResizable(false);
        this.render("register.fxml", "register.css", 400, 550);
    }

    /**
     * Register a user
     */
    public void register() {
        String username = this.username.getText();
        String password = this.password.getText();
        String passwordConfirm = this.passwordConfirm.getText();
        String secondPassword = this.secondPassword.getText();
        String secondPasswordConfirm = this.secondPasswordConfirm.getText();
        String type = ((RadioButton) this.group.getSelectedToggle()).getText();

        View.set("home");

        /*if ((!username.isEmpty() || !password.isEmpty() || !passwordConfirm.isEmpty()) && password.equals(passwordConfirm) && !type.isEmpty() && secondPassword.equals(secondPasswordConfirm)) {
            UserModel userModel = new UserModel();
            try {
                Security.setPasswordDB(password);
                userModel.createUser(username, password, secondPassword, type.toUpperCase());
                View.set("home");
            } catch (NoSuchPaddingException | IllegalBlockSizeException | BadPaddingException | InvalidKeyException | NoSuchAlgorithmException e) {
                System.out.println(e.getMessage());
            }

        }*/
    }

}
