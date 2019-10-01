package com.subtitlor.utilities;

import java.sql.Time;

public class Traduction  {

    private int id;
    private int id_fichier;
    private Time temps_debut;
    private Time temps_fin;
    private String ligne1_source;
    private String ligne2_source;
    private String ligne1_trad;
    private String ligne2_trad;
    private int id_langue_trad;

    public Traduction(int id, int id_fichier, Time temps_debut, Time temps_fin, String ligne1_source, String ligne2_source, String ligne1_trad, String ligne2_trad, int id_langue_trad) {
        this.id = id;
        this.id_fichier = id_fichier;
        this.temps_debut = temps_debut;
        this.temps_fin = temps_fin;
        this.ligne1_source = ligne1_source;
        this.ligne2_source = ligne2_source;
        this.ligne1_trad = ligne1_trad;
        this.ligne2_trad = ligne2_trad;
        this.id_langue_trad = id_langue_trad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_fichier() {
        return id_fichier;
    }

    public void setId_fichier(int id_fichier) {
        this.id_fichier = id_fichier;
    }

    public Time getTemps_debut() {
        return temps_debut;
    }

    public void setTemps_debut(Time temps_debut) {
        this.temps_debut = temps_debut;
    }

    public Time getTemps_fin() {
        return temps_fin;
    }

    public void setTemps_fin(Time temps_fin) {
        this.temps_fin = temps_fin;
    }

    public String getLigne1_source() {
        return ligne1_source;
    }

    public void setLigne1_source(String ligne1_source) {
        this.ligne1_source = ligne1_source;
    }

    public String getLigne2_source() {
        return ligne2_source;
    }

    public void setLigne2_source(String ligne2_source) {
        this.ligne2_source = ligne2_source;
    }

    public String getLigne1_trad() {
        return ligne1_trad;
    }

    public void setLigne1_trad(String ligne1_trad) {
        this.ligne1_trad = ligne1_trad;
    }

    public String getLigne2_trad() {
        return ligne2_trad;
    }

    public void setLigne2_trad(String ligne2_trad) {
        this.ligne2_trad = ligne2_trad;
    }

    public int getId_langue_trad() {
        return id_langue_trad;
    }

    public void setId_langue_trad(int id_langue_trad) {
        this.id_langue_trad = id_langue_trad;
    }
}
