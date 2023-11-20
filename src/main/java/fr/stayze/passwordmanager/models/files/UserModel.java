package fr.stayze.passwordmanager.models.files;

import java.io.File;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import fr.stayze.passwordmanager.Config;
import fr.stayze.passwordmanager.utils.CryptUtil;
import fr.stayze.passwordmanager.utils.FileUtil;
import fr.stayze.passwordmanager.utils.HashUtil;
import org.json.JSONObject;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

public class UserModel {

    private File _userFile;
    private User _user;
    private boolean _isCreated = false;

    public UserModel() {
        try {
            this._userFile = new File(Config.USERFILEPATH);
            this.initUserFile();
            this.initUserInfo();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Initialize the user file
     *
     * @throws IOException
     */
    public void initUserFile() throws IOException {
        if (!this._userFile.exists()) {
            if (!this._userFile.getParentFile().exists()) {
                this._userFile.getParentFile().mkdirs();
            }
            this._userFile.createNewFile();
            this._isCreated = false;
        }
    }

    /**
     * Initialize the user info
     */
    public void initUserInfo() {
        String content = FileUtil.getContentFile(this._userFile);
        JSONObject json = new JSONObject(content.isEmpty() ? "{}" : content);
        if (!json.isEmpty() && json.has("username") && json.has("password") && json.has("type")) {
            this._isCreated = true;
            this._user = new User(json.getString("username"), json.getString("password"), json.getString("type"), json.getString("token"));
        } else {
            this._isCreated = false;
        }
    }

    /**
     * Save the user info
     */
    public void saveUserInfo() {
        JSONObject json = new JSONObject();
        json.put("username", this._user.getUsername());
        json.put("password", this._user.getPassword());
        json.put("token", this._user.getToken());
        json.put("type", this._user.getType());
        FileUtil.setContentFile(this._userFile, json.toString());
    }

    /**
     * Create a user
     *
     * @param username
     * @param password
     * @param type
     */
    public void createUser(String username, String password, String secondPassword, String type) throws NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException, InvalidKeyException {
        password = HashUtil.hash(password);
        this._user = new User(username, password, CryptUtil.encrypt(username, secondPassword), type);
        this.saveUserInfo();
    }

    /**
     * Check if the user is valid
     *
     * @param username
     * @param password
     * @return boolean
     * @throws NoSuchAlgorithmException
     */
    public boolean checkUser(String username, String password) throws NoSuchAlgorithmException {
        return this._user.checkUsername(username) && this._user.checkPassword(password);
    }

    /**
     * Check if the token is valid
     *
     * @param password
     * @return boolean
     */
    public boolean checkToken(String password) {
        return this._user.checkToken(password);
    }

    /**
     * Check if the user is created
     *
     * @return boolean
     */
    public boolean isCreated() {
        return this._isCreated;
    }

}
