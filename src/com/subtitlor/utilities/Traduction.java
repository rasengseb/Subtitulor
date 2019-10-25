package com.subtitlor.utilities;


public class Traduction {

    private int id_fichier;
    private int numeroTrad;
    private String temps;
    private String ligne1_source;
    private String ligne2_source;
    private int id_langue_source;
    private String ligne1_trad;
    private String ligne2_trad;
    private int id_langue_trad;

    public Traduction() {
        this.numeroTrad = 0;
    }

    public Traduction(int id_fichier, int numeroTrad, String temps, int id_langue_source, String ligne1_source, String ligne2_source, String ligne1_trad, String ligne2_trad, int id_langue_trad) {
        this.id_fichier = id_fichier;
        this.numeroTrad = numeroTrad;
        this.temps = temps;
        this.id_langue_source = id_langue_source;
        this.ligne1_source = ligne1_source;
        this.ligne2_source = ligne2_source;
        this.ligne1_trad = ligne1_trad;
        this.ligne2_trad = ligne2_trad;
        this.id_langue_trad = id_langue_trad;
    }


    public int getNumeroTrad() {
        return numeroTrad;
    }

    public void setNumeroTrad(int numeroTrad) {
        this.numeroTrad = numeroTrad;
    }

    public int getId_fichier() {
        return id_fichier;
    }

    public void setId_fichier(int id_fichier) {
        this.id_fichier = id_fichier;
    }

    public String getTemps() {
        return temps;
    }

    public void setTemps(String temps) {
        this.temps = temps;
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

    public int getId_langue_source() {
        return id_langue_source;
    }

    public void setId_langue_source(int id_langue_source) {
        this.id_langue_source = id_langue_source;
    }

    @Override
    public String toString() {
        return "Traduction{" +
                "id_fichier=" + id_fichier +
                ", numeroTrad='" + numeroTrad + '\'' +
                ", temps='" + temps + '\'' +
                ", ligne1_source='" + ligne1_source + '\'' +
                ", ligne2_source='" + ligne2_source + '\'' +
                ", id_langue_source=" + id_langue_source +
                ", ligne1_trad='" + ligne1_trad + '\'' +
                ", ligne2_trad='" + ligne2_trad + '\'' +
                ", id_langue_trad=" + id_langue_trad +
                '}';
    }
}
