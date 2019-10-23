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
            int count = 0;
            while ((line = br.readLine()) != null) {
                switch (count) {
                    case (0): //numéro de la traduction
                        t.setNumeroTrad(line);
                        count++;
                        break;
                    case (1): //temps
                        t.setTemps(line);
                        count++;
                        break;
                    case (2): // ligne 1 à traduire
                        count++;
                        t.setLigne1_source(line);
                        break;
                    case (3): //ligne 2 à traduire
                        if (line.length() != 0) {
                            t.setLigne2_source(line);
                        }
                        lignes.add(t);
                        count = 0;
                        t.reset();
                        break;
                }
                // originalSubtitles.add(line);
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public ArrayList<String> getSubtitles() {
        return originalSubtitles;
    }

    public ArrayList<Traduction> getLignes() {
        return lignes;
    }


}
