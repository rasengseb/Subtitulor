package com.subtitlor.dao;

import com.subtitlor.utilities.Language;

import java.sql.Connection;
import java.util.ArrayList;

public class LanguageDAO extends DAO<Language> {
    public LanguageDAO(Connection conn) {
        super(conn);
    }

    @Override
    public void create(Language obj) {}

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
        return null;
    }

    @Override
    public ArrayList<Language> findAll(int id) {
        return null;
    }
}
