package fr.stayze.passwordmanager;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class Window {

    private final Stage _stage;
    private Scene _scene;
    private String _title;

    public Window(Stage stage) {
        this._stage = stage;

        Image logo = new Image(Objects.requireNonNull(this.getClass().getResourceAsStream("/fr/stayze/passwordmanager/resources/logo.png")));
        this._stage.getIcons().add(logo);
    }

    /**
     * Get the stage
     *
     * @return Stage
     */
    public Stage getStage() {
        return this._stage;
    }

    /**
     * Get the scene
     *
     * @return Scene
     */
    public Scene getScene() {
        return this._scene;
    }

    /**
     * Set the scene
     *
     * @param scene
     */
    public void setScene(Scene scene) {
        this._scene = scene;
    }

    /**
     * Set the title of the window
     *
     * @param title
     */
    public void setTitle(String title) {
        this._title = title;
    }

    /**
     * Set the resizable of the window
     *
     * @param resizable
     */
    public void setResizable(boolean resizable) {
        this._stage.setResizable(resizable);
    }

    /**
     * Show the window
     *
     * @throws IOException
     */
    public void show() throws IOException {
        if (this._scene != null) {
            this._stage.setTitle(this._title);
            this._stage.setScene(this._scene);
            this._stage.centerOnScreen();
            this._stage.show();
        }
    }


}
