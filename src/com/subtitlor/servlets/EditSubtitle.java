package com.subtitlor.servlets;

import com.subtitlor.utilities.SubtitlesHandler;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/EditSubtitle")
public class EditSubtitle extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String FILE_NAME = "/WEB-INF/ressources/password_presentation.srt";
	public static final String WEB_INF_EDIT_SUBTITLE_JSP = "/WEB-INF/edit_subtitle.jsp";

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		setCharacterEncoding(request, response);

		ServletContext context = getServletContext();
		System.out.println(context.getRealPath(FILE_NAME));
		SubtitlesHandler subtitles = new SubtitlesHandler(context.getRealPath(FILE_NAME));
		
		//request.setAttribute("subtitles", subtitles.getSubtitles());
		request.setAttribute("subtitles", subtitles.getLignes());


		this.getServletContext().getRequestDispatcher(WEB_INF_EDIT_SUBTITLE_JSP).forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		setCharacterEncoding(request, response);

		if(request.getParameter("fichier") != null){
			String nom = request.getParameter("nom_video");
			FILE_NAME = request.getParameter("btn_fichier");
			String langue = request.getParameter("langues");
			request.setAttribute("fichier", nom);
			request.setAttribute("langues", langue);
			request.setAttribute("file", FILE_NAME);
			ServletContext context = getServletContext();
			SubtitlesHandler subtitles = new SubtitlesHandler(context.getRealPath(FILE_NAME));
			//request.setAttribute("subtitles", subtitles.getSubtitles());
			request.setAttribute("subtitles", subtitles.getLignes());
		}

		if(request.getParameter("lire") != null){

		}
		this.getServletContext().getRequestDispatcher(WEB_INF_EDIT_SUBTITLE_JSP).forward(request, response);
	}

	/**
	 * Fixe l'encodage pour les méthodes doGet et doPost.
	 * @param request La requête http.
	 * @param response La réponse http.
	 * @throws UnsupportedEncodingException Exception levé en cas de problème d'encodage.
	 */
	private void setCharacterEncoding(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
	}

}
