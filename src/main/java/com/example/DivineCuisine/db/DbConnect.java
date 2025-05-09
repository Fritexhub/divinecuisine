package com.example.DivineCuisine.db;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

public class DbConnect {
    private static DbConnect instance;
    private Connection connection;
    private String url = "jdbc:postgresql://dpg-d0cfnn15pdvs73dldln0-a.oregon-postgres.render.com:5432/divinecuisinedb";
    private String username = "divinecuisinedb_user";
    private String password = "4IM6tlvyixldG6e3J0SIPg3sVGUNaPzE";

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
