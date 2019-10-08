package com.subtitlor.utilities;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class SubtitlesHandler {
    private ArrayList<String> originalSubtitles = null;
    private ArrayList<String> translatedSubtitles = null;
    private ArrayList<Traduction> lignes = null;

    public SubtitlesHandler(String fileName) {
        originalSubtitles = new ArrayList<String>();
        translatedSubtitles = new ArrayList<String>();
        lignes = new ArrayList<Traduction>();
        BufferedReader br;
        try {
            br = new BufferedReader(new FileReader(fileName));
            String line;
            Traduction t = new Traduction();
            while ((line = br.readLine()) != null) {
             /*if (Character.isDigit(line.charAt(0))) {
                	if (t.getNumeroTrad() != null){
                	    lignes.add(t);
                        t.reset();
                    }
					t.setNumeroTrad(line);
                } else {
                    if (Character.isDigit(line.charAt(0)) && (t.getNumeroTrad() != null)) { //Si le premier char de la ligne est un chiffre, alors c'est le temps
                        t.setTemps(line);
                    } else {
                        if (t.getLigne1_source() == null) { //si l'on a pas de ligne de traduite
                            t.setLigne1_source(line);
                        } else {
                            if (t.getLigne1_source() != null) { //si il y a déjà une première ligne
                                t.setLigne2_source(line);
                                lignes.add(t);
                            } else {
                                lignes.add(t);
                            }
                        }
                    }
                }*/
                originalSubtitles.add(line);
            }
            br.close();
        } catch (
                IOException e) {
            e.printStackTrace();
        }

    }

    public ArrayList<String> getSubtitles() {
        return originalSubtitles;
    }

    public ArrayList<Traduction> getLignes(){
    	return lignes;
	}


}
