package com.subtitlor.utilities;

import com.subtitlor.model.Traduction;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class SubtitlesHandler {

    private List<Traduction> lignes = new ArrayList<>();

    /**
     * Créer des objets traduction et les ajoutes dans une ArrayList.
     * @param fileName Chemin du fichier à lire.
     */
    public SubtitlesHandler(String fileName) {
        Charset inputCharset = StandardCharsets.UTF_8;
        BufferedReader br;
        try {
            br = new BufferedReader(new InputStreamReader(new FileInputStream(fileName), inputCharset));
            String line;
            boolean finDeBloc = false;
            boolean finDeFichier = false;
            Traduction t = new Traduction();
            int count = 0;
            while (!finDeFichier) {
                line = br.readLine();
                if (line != null) {
                    switch (count) {
                        case (0): //numéro de la traduction
                            if ("".equals(line))
                                finDeFichier = true;
                            else
                                try {
                                    t.setNumeroTrad(Integer.parseInt(line));
                                }
                                catch (NumberFormatException e) {
                                    throw new IOException(">>>> Passage au step 1 - Problème de conversion => FinDeFichier \"" + line + "\"" );
                                }
                            break;
                        case (1): //temps
                            t.setTemps(line);
                            break;
                        case (2): // ligne 1 à traduire
                            t.setLigne1_source(line);
                            break;
                        case (3): //ligne 2 à traduire
                            if (line.length() != 0) {
                                t.setLigne2_source(line);
                            } else {
                                finDeBloc = true;
                            }
                            break;
                        case (4):
                            finDeBloc = true;
                            break;
                    }
                }
                else {
                    finDeBloc = true;
                    finDeFichier = true;
                }

                count++;

                if (finDeBloc) {
                    lignes.add(t);
                    count = 0;
                    t = new Traduction();
                    finDeBloc = false;
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

    /**
     * A RENSEIGNER...
     * @return A RENSEIGNER...
     */
    public List<Traduction> getLignes() {
        return lignes;
    }


}
