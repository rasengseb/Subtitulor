package com.subtitlor.dao;

import com.subtitlor.utilities.Traduction;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TraductionDAO extends DAO<Traduction> {
    public TraductionDAO() {

    }

    /**
     * Ajoute un objet Traduction dans la table Traduction de la BDD.
     * @param obj Traduction à ajouter.
     */
    @Override
    public void create(Traduction obj) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = this.getConnection().prepareStatement("INSERT INTO traduction(numeroTrad, temps, ligne1_source, ligne2_source, id_langue_source, ligne1_trad, ligne2_trad, id_langue_trad) VALUES(?,?,?,?,?,?,?,?)");
            preparedStatement.setString(1, String.valueOf(obj.getNumeroTrad()));
            preparedStatement.setString(2, obj.getTemps());
            preparedStatement.setString(3, obj.getLigne1_source());
            preparedStatement.setString(4, obj.getLigne2_source());
            preparedStatement.setString(5, String.valueOf(obj.getId_langue_source()));
            preparedStatement.setString(6, obj.getLigne1_trad());
            preparedStatement.setString(7, obj.getLigne2_trad());
            preparedStatement.setString(8, String.valueOf(obj.getId_langue_trad()));
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean delete(Traduction obj) {
        return false;
    }

    @Override
    public boolean update(Traduction ob) {
        return false;
    }

    /**
     * Recherche un objet Traduction en utilisant l'id de l'objet.
     * @param id Permet de chercher l'objet souhaité.
     * @return Un objet Traduction
     */
    @Override
    public Traduction find(int id) {
        Traduction t = new Traduction();
        try {
            ResultSet result = this.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM fichier WHERE id = " + id);
            if (result.first()) {
                t = new Traduction(id, result.getInt("numeroTrad"), result.getString("temps"), result.getInt("id_langue_source"), result.getString("ligne1_source"), result.getString("ligne2_source"), result.getString("ligne1_trad"), result.getString("ligne2_trad"), result.getInt("id_langue_trad"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return t;
    }

    /**
     * Trouve toutes les Traduction grâce à l'id du fichier.
     * @param id Id du fichier dont on souhaite les traductions.
     * @return Liste des traductions du fichier.
     */
    @Override
    public ArrayList<Traduction> findAll(int id) {
        ArrayList<Traduction> traductions = new ArrayList<Traduction>();
        try{
            ResultSet result = this.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM Traduction WHERE id = " + id);
            while(result.next()){
                Traduction traduction = new Traduction();
                traduction.setId_fichier(Integer.parseInt(result.getString("id")));
                traduction.setNumeroTrad(Integer.parseInt(result.getString("numeroTrad")));
                traduction.setTemps(result.getString("temps"));
                traduction.setId_langue_source(Integer.parseInt(result.getString("id_langue_source")));
                traduction.setLigne1_source(result.getString("ligne1_source"));
                traduction.setLigne2_source(result.getString("ligne2_source"));
                traduction.setId_langue_trad(Integer.parseInt(result.getString("id_langue_trad")));
                traduction.setLigne1_trad(result.getString("ligne1_trad"));
                traduction.setLigne2_trad(result.getString("ligne2_trad"));
                traductions.add(traduction);
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return traductions;
    }
}
