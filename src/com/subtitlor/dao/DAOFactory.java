package com.subtitlor.dao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DAOFactory { //-- Variables d'instance
    private static String url = "jdbc:postgresql://localhost:5432/Subtitlor";
    private static String user = "rasen";
    private static String passwd = "Sebastien2";
    private static Connection connect;

    /**
     * * @return
     */
    public static Connection getInstance() {
        if (connect == null) {
            try {
                Class.forName("org.postgresql.Driver");
                connect = DriverManager.getConnection(url, user, passwd);
            } catch (ClassNotFoundException e) {
                System.out.println("ATTENTION : Driver POSTGRESQL non trouvé !");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Connexion PostgreSQL ouverte !"); //-- Trace
        return connect;
    }

}
