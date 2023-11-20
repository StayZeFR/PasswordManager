package fr.stayze.passwordmanager.controllers;

public class HomeController extends Controller {

    public HomeController() {
        super();
    }

    public void view() {
        this.render("home.fxml", "login.css", 800, 550);
    }

}
