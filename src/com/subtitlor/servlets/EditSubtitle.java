package com.subtitlor.servlets;

import com.subtitlor.utilities.SubtitlesHandler;
import com.subtitlor.utilities.Traduction;

import java.io.*;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;


@WebServlet("/EditSubtitle")
public class EditSubtitle extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static String FILE_NAME = "/WEB-INF/ressources/password_presentation.srt";
    private static final String WEB_INF_EDIT_SUBTITLE_JSP = "/WEB-INF/edit_subtitle.jsp";
    private boolean fichierCharger = false;
    private static final int TAILLE_TAMPON = 10240;
    public static final String CHEMIN_FICHIERS = "/ressources";
    private ArrayList<Traduction> sousTitres;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        setCharacterEncoding(request, response);
        request.setAttribute("fichierCharger", fichierCharger);

        ServletContext context = getServletContext();
        System.out.println(context.getRealPath(FILE_NAME));
        SubtitlesHandler subtitles = new SubtitlesHandler(context.getRealPath(FILE_NAME));

        request.setAttribute("subtitles", subtitles.getLignes());


        this.getServletContext().getRequestDispatcher(WEB_INF_EDIT_SUBTITLE_JSP).forward(request, response);
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        setCharacterEncoding(request, response);
        request.setAttribute("fichierCharger", fichierCharger);

        if (request.getParameter("envoie_fichier") != null) {
            System.out.println("***** LOG :  Appui sur le bouton fichier.");
            fichierCharger = true;
            request.setAttribute("fichierCharger", fichierCharger);
            Part part = request.getPart("fichier");
            String nomFichier = getNomFichier(part);

            if (nomFichier != null && !nomFichier.isEmpty()) {
                String nomChamp = part.getName();
                // Corrige un bug du fonctionnement d'Internet Explorer
                nomFichier = nomFichier.substring(nomFichier.lastIndexOf('/') + 1)
                        .substring(nomFichier.lastIndexOf('\\') + 1);

                // On écrit définitivement le fichier sur le disque
                ecrireFichier(part, nomFichier, CHEMIN_FICHIERS);

                request.setAttribute(nomChamp, nomFichier);
            }

            String langue = request.getParameter("langues");
            request.setAttribute("fichier", nomFichier);
            request.setAttribute("langues", langue);
            request.setAttribute("file", FILE_NAME);
            ServletContext context = getServletContext();
            SubtitlesHandler subtitles = new SubtitlesHandler(context.getRealPath(FILE_NAME));
            request.setAttribute("subtitles", subtitles.getLignes());
            sousTitres = subtitles.getLignes();
        }

        if (request.getParameter("lire") != null) {
            System.out.println("***** LOG :  Appui sur le bouton lire.");
            fichierCharger = true;
            request.setAttribute("fichierCharger", fichierCharger);
            fichierCharger = false;
        }

        if(request.getParameter("Enregistrer") != null){
            System.out.println("***** LOG : Appui sur le bouton enregistrer");
            if (!sousTitres.isEmpty()){
                for (int i = 1; i<sousTitres.size(); i++){
                    sousTitres.get(i).setLigne1_trad(request.getParameter("line"+i+1));
                    if(sousTitres.get(i).getLigne2_source() != null){
                        sousTitres.get(i).setLigne2_trad(request.getParameter("line"+i+1+"2"));
                    }
                }

            }
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
     */
    private void ecrireFichier(Part part, String nomFichier, String chemin) throws IOException {
        BufferedInputStream entree = null;
        BufferedOutputStream sortie = null;
        try {
            entree = new BufferedInputStream(part.getInputStream(), TAILLE_TAMPON);
            sortie = new BufferedOutputStream(new FileOutputStream(new File(chemin + nomFichier)), TAILLE_TAMPON);

            byte[] tampon = new byte[TAILLE_TAMPON];
            int longueur;
            while ((longueur = entree.read(tampon)) > 0) {
                sortie.write(tampon, 0, longueur);
            }
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

}
