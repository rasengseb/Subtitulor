package com.subtitlor.model;

public class Language {
    private int id;
    private String langue;

    public Language(){

    }

    public Language(int id, String langue){
        this.id = id;
        this.langue = langue;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLangue() {
        return langue;
    }

    public void setLangue(String langue) {
        this.langue = langue;
    }

    @Override
    public String toString() {
        return "Language{" +
                "id=" + id +
                ", langue='" + langue + '\'' +
                '}';
    }
}
