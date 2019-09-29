package com.subtitlor.dao;

import com.subtitlor.utilities.Traduction;

import java.sql.Connection;

public class TraductionDAO extends DAO<Traduction> {
    public TraductionDAO(Connection conn) {
        super(conn);
    }

    @Override
    public boolean create(Traduction obj) {
        return false;
    }

    @Override
    public boolean delete(Traduction obj) {
        return false;
    }

    @Override
    public boolean update(Traduction ob) {
        return false;
    }

    @Override
    public Traduction find(int id) {
        return null;
    }
}
