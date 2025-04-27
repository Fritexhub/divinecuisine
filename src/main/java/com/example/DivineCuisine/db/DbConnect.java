package com.example.DivineCuisine.db;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

public class DbConnect {
    private static DbConnect instance;
    private Connection connection;
    private String url = "jdbc:postgresql://dpg-cvq1k20dl3ps73ard0lg-a.oregon-postgres.render.com:5432/fridaydb";
    private String username = "fridaydb_user";
    private String password = "AewWVoggzLbZ5IDCTuZoHGqrSJc067in";

    private DbConnect() throws SQLException {
        try {
            Class.forName("org.postgresql.Driver");
            this.connection = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
            throw new SQLException(ex);
        }
    }
    public static DbConnect getInstance() throws SQLException {
        if (instance == null || instance.getConnection().isClosed()) {
            instance = new DbConnect();
        }
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }
}
