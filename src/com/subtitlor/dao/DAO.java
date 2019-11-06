package com.subtitlor.dao;

import java.sql.Connection;
import java.util.ArrayList;

public abstract class DAO<T> {
    protected DAOFactory daoFactory;

    public DAO(){
        this.daoFactory = DAOFactory.getInstance();
    }

    public abstract void create(T obj);

    public abstract boolean delete(T obj);

    public abstract boolean update(T ob);

    public abstract T find(int id);

    public abstract ArrayList<T> findAll(int id);
}
