package com.company.database;

import com.company.database.interfaces.IDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PostgreSQL implements IDB {
    private IDB db;

    public PostgreSQL(IDB db) {
        this.db = db;
    }

    public PostgreSQL() {

    }

    @Override
    public Connection getConnection() throws SQLException, ClassNotFoundException {
        String connectionUrl = "jdbc:postgresql://localhost:5432/java5";
        try {
            Class.forName("org.postgresql.Driver");

            Connection connection = DriverManager.getConnection(connectionUrl, "postgres", "ShNT.842657895123!");

            return connection;
        } catch (Exception exception) {
            System.out.println(exception);
            throw exception;
        }
    }
}
