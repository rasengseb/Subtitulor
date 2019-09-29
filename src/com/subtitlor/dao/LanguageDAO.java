package com.subtitlor.dao;

import com.subtitlor.utilities.Language;

import java.sql.Connection;

public class LanguageDAO extends DAO<Language> {
    public LanguageDAO(Connection conn) {
        super(conn);
    }

    @Override
    public boolean create(Language obj) {
        return false;
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
        return null;
    }
}
