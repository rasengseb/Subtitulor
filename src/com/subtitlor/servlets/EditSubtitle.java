package com.subtitlor.servlets;

import com.subtitlor.dao.FichierDAO;
import com.subtitlor.dao.LanguageDAO;
import com.subtitlor.dao.TraductionDAO;
import com.subtitlor.model.Fichier;
import com.subtitlor.model.Language;
import com.subtitlor.model.Traduction;
import com.subtitlor.utilities.SubtitlesHandler;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A RENSEIGNER...
 */
@WebServlet("/EditSubtitle")
public class EditSubtitle extends HttpServlet {

    public static final String VIDEO_NAME_ALREADY_EXISTS_IN_DATABASE = "Attention : le nom de la vidéo existe déjà en base de données !";
    public static final String ALL_FIELDS_ARE_MANDATORY = "Attention : Pour ouvrir un fichier, tous les champs sont obligatoires !";

    private static final long serialVersionUID = 1L;
    private static final String FILE_NAME = "D:/AppRessources/Subtitlor/";
    private static final String WEB_INF_EDIT_SUBTITLE_JSP = "/WEB-INF/edit_subtitle.jsp";
    private static final int TAILLE_TAMPON = 10240;
    public static final String CHEMIN_FICHIERS = "D:/AppRessources/Subtitlor/";
    private List<Traduction> sousTitres;
    private List<Language> langages;
    private String nomFichier;
    private String langueSource;
    private String messageErreur = "";

    /**
     * A RENSEIGNER...
     *
     * @param request  A RENSEIGNER...
     * @param response A RENSEIGNER...
     * @throws ServletException A RENSEIGNER...
     * @throws IOException      A RENSEIGNER...
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        setCharacterEncoding(request, response);

        LanguageDAO languagedao = new LanguageDAO();
        langages = languagedao.findAll();
        request.setAttribute("langages", langages);

        this.getServletContext().getRequestDispatcher(WEB_INF_EDIT_SUBTITLE_JSP).forward(request, response);
    }


    /**
     * A RENSEIGNER...
     *
     * @param request  A RENSEIGNER...
     * @param response A RENSEIGNER...
     * @throws ServletException A RENSEIGNER...
     * @throws IOException      A RENSEIGNER...
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        setCharacterEncoding(request, response);
        LanguageDAO languagedao = new LanguageDAO();
        langages = languagedao.findAll();
        request.setAttribute("langages", langages);

        //-- OFA
        boolean multipart = false;
        if (request.getContentType().substring(0, 19).equals("multipart/form-data")) {
            multipart = true;
        }

        if (multipart) {
            Part part = request.getPart("fichier");
            nomFichier = getNomFichier(part);

            if (nomFichier != null && !nomFichier.isEmpty() && !isDoublonTitreVideo(nomFichier)) {

                langueSource = request.getParameter("langues"); // Récupérer la langue source : C'est le seul moment où l'on peut car ce n'est pas le même formulaire et on en a besoin pour enregistrer en base.
                String nomChamp = part.getName();
                // Corrige un bug du fonctionnement d'Internet Explorer
                nomFichier = nomFichier.substring(nomFichier.lastIndexOf('/') + 1).substring(nomFichier.lastIndexOf('\\') + 1);

                // On écrit définitivement le fichier sur le disque
                ecrireFichier(part, nomFichier);

                request.setAttribute(nomChamp, nomFichier);

                FichierDAO fichierDAO = new FichierDAO();
                Fichier fichier = new Fichier(nomFichier);
                fichierDAO.create(fichier);

                SubtitlesHandler subtitles = new SubtitlesHandler(FILE_NAME + "/" + nomFichier);
                sousTitres = subtitles.getLignes();
            }
            else {
                if (isDoublonTitreVideo(nomFichier)) {
                    messageErreur = VIDEO_NAME_ALREADY_EXISTS_IN_DATABASE;
                } else {
                    messageErreur = ALL_FIELDS_ARE_MANDATORY;
                }
                request.setAttribute("messageErreur", messageErreur);
            }

            request.setAttribute("fichier", nomFichier);
            request.setAttribute("langues", langueSource);
            request.setAttribute("file", FILE_NAME);
            request.setAttribute("subtitles", sousTitres);
        }

        if (request.getParameter("lire") != null) {
        }

        if (request.getParameter("enregistrer") != null) {

            //-- On fixe les langues (Cible = "English" par défaut)
            Map<String, Language> listeLangues = transformListLangueToMap(langages); //-- La liste de langues sous forme de Map pour retrouver plus facilement grâce au nom ou à l'id
            int langueSource = listeLangues.get(this.langueSource).getId();
            int langueCible = listeLangues.get("English").getId();

            TraductionDAO traductionDAO = new TraductionDAO();
            FichierDAO fichierDAO = new FichierDAO();
            int id_fichier = fichierDAO.find(nomFichier).getId();
            if (!sousTitres.isEmpty()) {
                for (int i = 0; i < sousTitres.size(); i++) {
                    Traduction sousTitre = sousTitres.get(i);
                    sousTitre.setId_fichier(id_fichier);
                    sousTitre.setId_langue_source(langueSource);
                    sousTitre.setId_langue_trad(langueCible);
                    traductionDAO.create(sousTitre);
                }

            }

            request.setAttribute("langues", langages);
            List<Fichier> fichierBdd = new FichierDAO().findAll();
            request.setAttribute("fichiers", fichierBdd);
            request.setAttribute("subtitles", sousTitres);
        }

        this.getServletContext().getRequestDispatcher(WEB_INF_EDIT_SUBTITLE_JSP).forward(request, response);
    }

    /**
     * Fixe l'encodage pour les méthodes doGet et doPost.
     *
     * @param request  La requête http.
     * @param response La réponse http.
     * @throws UnsupportedEncodingException Exception levé en cas de problème d'encodage.
     */
    private void setCharacterEncoding(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
    }

    /**
     * Méthode qui découpe l'url d'un fichier pour n'avoir que le nom.
     *
     * @param part champ du fichier
     * @return nom du fichier
     */
    private String getNomFichier(Part part) {
        for (String contentDisposition : part.getHeader("content-disposition").split(";")) {
            if (contentDisposition.trim().startsWith("filename")) {
                return contentDisposition.substring(contentDisposition.indexOf('=') + 1).trim().replace("\"", "");
            }
        }
        return null;
    }

    /**
     * Copie le fichier dans un dossier pour un stockage définitif.
     *
     * @param part       A RENSEIGNER...
     * @param nomFichier A RENSEIGNER...
     * @throws IOException A RENSEIGNER...
     */
    private void ecrireFichier(Part part, String nomFichier) throws IOException {

        //-- OFA : Contrôler l'existence du répertoire cible.
        File file = new File(EditSubtitle.CHEMIN_FICHIERS);
        if (!file.exists()) {
            //-- Générer une exception si le répertoire n'existe pas !
            throw new IOException("Attention, le répertoire " + EditSubtitle.CHEMIN_FICHIERS + " n'existent pas !!!");
        }

        BufferedInputStream entree = null;
        BufferedOutputStream sortie = null;
        try {
            entree = new BufferedInputStream(part.getInputStream(), TAILLE_TAMPON);
            sortie = new BufferedOutputStream(new FileOutputStream(new File(EditSubtitle.CHEMIN_FICHIERS + "/" + nomFichier)), TAILLE_TAMPON);

            byte[] tampon = new byte[TAILLE_TAMPON];
            int longueur;
            while ((longueur = entree.read(tampon)) > 0) {
                sortie.write(tampon, 0, longueur);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                sortie.close();
            } catch (IOException ignore) {
            }
            try {
                entree.close();
            } catch (IOException ignore) {
            }
        }
    }

    /**
     * Teansforme une List de Langues en Map de Langues afin de faciliter la recherche d'une langue pas son nom.
     * @param listeLangues
     * @return
     */
    public HashMap<String, Language> transformListLangueToMap(List<Language> listeLangues) {
        HashMap<String, Language> productMap = new HashMap<>();
        for (Language language : listeLangues) {
            productMap.put(language.getLangue(), language);
            System.out.println(language.toString());
        }
        return productMap;
    }

    /**
     * Vérifier que le nom de la vidéo choisi lors de l'upload n'a pas déjàété choisi auparavant.
     * @return true si le nom de la vidéo est déjà utilisé.
     */
    private boolean isDoublonTitreVideo(String nomDuFichier) {
        boolean doublonTitreVideo = false;
        List<Fichier> listeFichiers = new FichierDAO().findAll();
        for (Fichier fichier : listeFichiers) {
            if ( nomDuFichier.equals(fichier.getNom()) )
                doublonTitreVideo = true;
        }
        return doublonTitreVideo;
    }
}
