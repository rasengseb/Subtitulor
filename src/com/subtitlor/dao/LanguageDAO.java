package com.subtitlor.dao;

import com.subtitlor.utilities.Language;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class LanguageDAO extends DAO<Language> {
    public LanguageDAO(Connection conn) {
        super(conn);
    }

    @Override
    public void create(Language obj) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = this.connect.prepareStatement("INSERT INTO langues(langue) VALUES(?)");
            preparedStatement.setString(1, obj.getLangue());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean delete(Language obj) {
        return false;
    }

    @Override
    public boolean update(Language ob) {
        return false;
    }

    @Override
    public Language find(int id) {
        Language language = new Language();
        try {
            ResultSet result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM fichier WHERE id = " + id);
            if (result.first()) {
                language = new Language(id, result.getString("langue"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return language;
    }

    @Override
    public ArrayList<Language> findAll(int id) {
        ArrayList<Language> languages = new ArrayList<Language>();
        try{
            ResultSet result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM fichier WHERE id = " + id);
            while(result.next()){
                Language language = new Language();
                language.setLangue(result.getString("langue"));
                language.setId(Integer.parseInt(result.getString("id")));
                languages.add(language);
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return languages;
    }
}
