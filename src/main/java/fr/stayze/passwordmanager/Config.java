package fr.stayze.passwordmanager;

import java.util.Map;

public class Config {

    public static final String VERSION = "1.0.0";
    public static final String LOCALPATH = System.getProperty("user.home") + "/.PasswordManager/";
    public static final String DATABASEPATH = LOCALPATH + "database.db";
    public static final String USERFILEPATH = LOCALPATH + ".user.json";
    public static final Map<String, String> VIEWS = Map.of(
            "login", "LoginController::view",
            "register", "RegisterController::view",
            "home", "HomeController::view",
            "add", "AddController::view",
            "edit", "EditController::view",
            "delete", "DeleteController::view",
            "settings", "SettingsController::view"
    );



}
