package com.subtitlor.dao;

import com.subtitlor.utilities.Traduction;

import java.sql.Connection;
import java.util.ArrayList;

public class TraductionDAO extends DAO<Traduction> {
    public TraductionDAO(Connection conn) {
        super(conn);
    }

    @Override
    public void create(Traduction obj) {
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

    @Override
    public ArrayList<Traduction> findAll(int id) {
        return null;
    }
}
