package com.subtitlor.utilities;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class SubtitlesHandler {
    private ArrayList<Traduction> lignes = null;

    /**
     * Créer des objets traduction et les ajoutes dans une ArrayList.
     * @param fileName Chemin du fichier à lire.
     */
    public SubtitlesHandler(String fileName) {
        Charset inputCharset = StandardCharsets.UTF_8;
        BufferedReader br = null;
        lignes = new ArrayList<Traduction>();
        try {
            br = new BufferedReader(new InputStreamReader(new FileInputStream(fileName), inputCharset));
            String line;
            boolean finDeFichier = false;
            Traduction t = new Traduction();
            int count = 0;
            while ((line = br.readLine()) != null) {
                switch (count) {
                    case (0): //numéro de la traduction
                        t.setNumeroTrad(Integer.parseInt(line));
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
                        } else {
                            finDeFichier = true;
                        }
                        break;
                    case (4):
                        finDeFichier = true;
                        break;
                }
                if (finDeFichier) {
                    lignes.add(t);
                    count = 0;
                    t = new Traduction();
                    finDeFichier = false;
                }
            }
            for (Traduction trad : lignes) {
                System.out.println(trad.toString());
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public ArrayList<Traduction> getLignes() {
        return lignes;
    }


}
