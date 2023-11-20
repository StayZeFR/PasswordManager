package fr.stayze.passwordmanager.views;

import fr.stayze.passwordmanager.Config;
import fr.stayze.passwordmanager.PasswordManager;
import fr.stayze.passwordmanager.Window;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.io.IOException;
import java.util.Objects;

public class View {

    /**
     * Set the view of the application
     *
     * @param id
     */
    public static void set(String id) {
        if (Config.VIEWS.containsKey(id)) {
            String[] split = Config.VIEWS.get(id).split("::");
            String controller = split[0];
            String method = split[1];
            try {
                Class<?> clazz = Class.forName("fr.stayze.passwordmanager.controllers." + controller);
                clazz.getMethod(method).invoke(clazz.getConstructor().newInstance());
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static Scene buildScene(String resource, int w, int h) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(View.class.getResource("/fr/stayze/passwordmanager/views/" + resource)));
        return new Scene(root, w, h);
    }

    public static Scene buildScene(String resource, String css, int w, int h) throws IOException {
        Scene scene = buildScene(resource, w, h);
        scene.getStylesheets().add(View.class.getResource("/fr/stayze/passwordmanager/styles/" + css).toExternalForm());
        return scene;
    }

}
