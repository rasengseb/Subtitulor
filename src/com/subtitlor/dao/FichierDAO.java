package com.subtitlor.dao;

import com.subtitlor.utilities.Fichier;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class FichierDAO extends DAO<Fichier> {
    public FichierDAO() {
    }

    @Override
    public void create(Fichier obj) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = this.daoFactory.getConnection().prepareStatement("INSERT INTO fichier(nom) VALUES(?)");
            preparedStatement.setString(1, obj.getNom());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean delete(Fichier obj) {
        return false;
    }

    @Override
    public boolean update(Fichier ob) {
        return false;
    }

    @Override
    public Fichier find(int id) {
        Fichier fichier = new Fichier();
        try {
            ResultSet result = this.daoFactory.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM fichier WHERE id = " + id);
            if (result.first()) {
                fichier = new Fichier(id, result.getString("nom"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return fichier;
    }

    @Override
    public ArrayList<Fichier> findAll(int id) {
        ArrayList<Fichier> fichiers = new ArrayList<Fichier>();
        try{
            ResultSet result = this.daoFactory.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM fichier WHERE id = " + id);
            while(result.next()){
                Fichier fichier = new Fichier();
                fichier.setNom(result.getString("nom"));
                fichier.setId(Integer.parseInt(result.getString("id")));
                fichiers.add(fichier);
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return fichiers;
    }

}
