package com.subtitlor.servlets;

import com.subtitlor.utilities.SubtitlesHandler;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/EditSubtitle")
public class EditSubtitle extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String FILE_NAME = "/WEB-INF/password_presentation.srt";
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

		ServletContext context = getServletContext();
		System.out.println(context.getRealPath(FILE_NAME));
		SubtitlesHandler subtitles = new SubtitlesHandler(context.getRealPath(FILE_NAME));
		
		request.setAttribute("subtitles", subtitles.getSubtitles());
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/edit_subtitle.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

        this.getServletContext().getRequestDispatcher("/WEB-INF/edit_subtitle.jsp").forward(request, response);
	}

}
