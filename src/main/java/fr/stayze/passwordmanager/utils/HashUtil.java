package fr.stayze.passwordmanager.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashUtil {

    /**
     * Hash a password
     *
     * @param password
     * @return String
     * @throws NoSuchAlgorithmException
     */
    public static String hash(String password) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA3-256");
        byte[] hash = md.digest(password.getBytes());
        return new String(hash);
    }

    /**
     * Check if a password is equal to a hash
     *
     * @param password
     * @param hash
     * @return boolean
     * @throws NoSuchAlgorithmException
     */
    public static boolean checkHash(String password, String hash) throws NoSuchAlgorithmException {
        return hash(password).equals(hash);
    }

}
