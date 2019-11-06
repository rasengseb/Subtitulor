package com.subtitlor.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DAOFactory {
    private String url;
    private String username;
    private String password;

    public DAOFactory (String url, String username, String password){
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public static DAOFactory getInstance(){
        try{
            Class.forName("com.postgres.jdbc.Driver");
        } catch (ClassNotFoundException e){

        }
        DAOFactory instance = new DAOFactory("jdbc:postgres://localhost:5432/javaee", "postgres", "open");
        return instance;
    }

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }

}
