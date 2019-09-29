package com.subtitlor.dao;

import com.subtitlor.utilities.Fichier;

import java.sql.Connection;

public class FichierDAO extends DAO<Fichier> {
    public FichierDAO(Connection conn) {
        super(conn);
    }

    @Override
    public boolean create(Fichier obj) {
        return false;
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
        return null;
    }
}
