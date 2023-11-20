package fr.stayze.passwordmanager;

public class Security {

    private static String _passwordDB; // Password to enter the database
    private static String _passwordInDB; // Password to decrypt or encrypt the password in the database

    /**
     * Get the password to enter the database
     *
     * @return String
     */
    public static String getPasswordDB() {
        return _passwordDB;
    }

    /**
     * Get the password to decrypt or encrypt the password in the database
     *
     * @return String
     */
    public static String getPasswordInDB() {
        return _passwordInDB;
    }

    /**
     * Set the password to enter the database
     *
     * @param passwordDB
     */
    public static void setPasswordDB(String passwordDB) {
        _passwordDB = passwordDB;
    }

    /**
     * Set the password to decrypt or encrypt the password in the database
     *
     * @param passwordInDB
     */
    public static void setPasswordInDB(String passwordInDB) {
        _passwordInDB = passwordInDB;
    }

}
