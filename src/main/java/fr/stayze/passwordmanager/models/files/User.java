package fr.stayze.passwordmanager.models.files;

import fr.stayze.passwordmanager.utils.CryptUtil;
import fr.stayze.passwordmanager.utils.HashUtil;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class User {

    private final String _username;
    private final String _password;
    private final String _token;
    private final String _type;

    public User(String username, String password, String token, String type) {
        this._username = username;
        this._password = password;
        this._token = token;
        this._type = type;
    }

    /**
     * Get the username
     *
     * @return String
     */
    public String getUsername() {
        return this._username;
    }

    /**
     * Get the password
     *
     * @return String
     */
    public String getPassword() {
        return this._password;
    }

    /**
     * Get the type
     *
     * @return String
     */
    public String getType() {
        return this._type;
    }

    /**
     * Get the token of the user
     *
     * @return String
     */
    public String getToken() {
        return _token;
    }

    /**
     * Check if the username is equal to the user's username
     *
     * @param username
     * @return boolean
     */
    public boolean checkUsername(String username) {
        return this._username.equals(username);
    }

    /**
     * Check if the password is equal to the user's password
     *
     * @param password
     * @return boolean
     * @throws NoSuchAlgorithmException
     */
    public boolean checkPassword(String password) throws NoSuchAlgorithmException {
        return HashUtil.checkHash(password, this._password);
    }

    /**
     * Check if the token is equal to the user's token
     *
     * @param password
     * @return boolean
     */
    public boolean checkToken(String password) {
        try {
            return CryptUtil.decrypt(this._token, password).equals(this._username);
        } catch (NoSuchPaddingException | NoSuchAlgorithmException | IllegalBlockSizeException | BadPaddingException | InvalidKeyException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

}
