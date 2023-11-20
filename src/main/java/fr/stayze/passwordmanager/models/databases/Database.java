package fr.stayze.passwordmanager.models.databases;

import fr.stayze.passwordmanager.Config;
import fr.stayze.passwordmanager.Security;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class Database {

    protected Connection _connection;

    /**
     * Connect to a local database
     */
    private void connectLocal(String password) {
        try {
            this._connection = DriverManager.getConnection("jdbc:sqlite:" + Config.DATABASEPATH + "?cipher=aes256&key=" + password);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Connect to a distant database
     */
    private void connectDistant() {
        try {
            this._connection = DriverManager.getConnection("...", "...", "...");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Close the connection
     */
    protected void close() {
        try {
            this._connection.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Initialize the connection
     *
     * @param type
     */
    protected void init(String type) {
        if (type.equals("LOCAL")) {
            this.connectLocal(Security.getPasswordDB());
        } else if (type.equals("DISTANT")) {
            this.connectDistant();
        }

    }

}
