package fr.stayze.passwordmanager;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Window {

    private Stage _stage;
    private FXMLLoader _loader;
    private Scene _scene;
    private String _title;

    public Window(Stage stage) {
        this._stage = stage;
        this._loader = new FXMLLoader();
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
     * Get the loader
     *
     * @return FXMLLoader
     */
    public FXMLLoader getLoader() {
        return this._loader;
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

    public void show() throws IOException {
        if (this._scene != null) {
            this._stage.setTitle(this._title);
            this._stage.setScene(this._scene);
            this._stage.show();
        }
    }


}
