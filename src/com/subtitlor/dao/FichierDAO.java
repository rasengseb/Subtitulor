package com.subtitlor.dao;

import com.subtitlor.model.Fichier;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class FichierDAO extends DAO<Fichier> {
    public FichierDAO() {
    }

    @Override
    public void create(Fichier obj) {
        PreparedStatement preparedStatement;
        try {
//            preparedStatement = this.getConnection().prepareStatement("INSERT INTO fichier(id, nom) VALUES(?, ?)");
//            preparedStatement.setInt(1, obj.getId());
//            preparedStatement.setString(2, obj.getNom());
            //-- OFA
            preparedStatement = this.getConnection().prepareStatement("INSERT INTO fichier(nom) VALUES(?)");
            preparedStatement.setString(1, obj.getNom());

            preparedStatement.execute();
            System.out.println("***** LOG : Insertion fichier bdd réussi.");
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

    public Fichier find(String nom){
        Fichier fichier = new Fichier(nom);
        try{
            ResultSet result = this.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM fichier WHERE nom ='" + nom + "'");
            if(result.first()){
                fichier = new Fichier(result.getInt("id"), nom);
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return fichier;
    }
    @Override
    public Fichier find(int id) {
        Fichier fichier = new Fichier();
        try {
            ResultSet result = this.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM fichier WHERE id = " + id);
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
        return null;
    }

    @Override
    public ArrayList<Fichier> findAll() {
        ArrayList<Fichier> fichiers = new ArrayList<>();
        try{
            ResultSet result = this.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM fichier");
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

    public ArrayList<Fichier> getAll(){
        ArrayList<Fichier> fichiers = new ArrayList<>();
        try{
            ResultSet resultSet = this.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM fichier");
            while (resultSet.next()){
                Fichier fichier = new Fichier(resultSet.getInt("id"), resultSet.getString("nom"));
                fichiers.add(fichier);
            }
        } catch(SQLException e){
            fichiers = null;
        }
        return fichiers;
    }

    public int getId(){
        ArrayList<Fichier> fichiers = getAll();
        if(fichiers == null){
            return 0;
        } else{
            return fichiers.get(fichiers.size()-1).getId() +1;
        }
    }

}
