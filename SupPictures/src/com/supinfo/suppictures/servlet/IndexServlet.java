package com.supinfo.suppictures.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.supinfo.suppictures.dao.DaoFactory;
import com.supinfo.suppictures.dao.PictureDao;
import com.supinfo.suppictures.dao.UserDao;
import com.supinfo.suppictures.entity.Picture;
import com.supinfo.suppictures.entity.User;
import com.supinfo.suppictures.util.SavePicture;

/**
 * Servlet implementation class IndexServlet
 */
@WebServlet("/index")
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IndexServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Recuperation de toutes les photos de la DB 
		PictureDao pictureDao = DaoFactory.getPictureDao();
		UserDao userDao = DaoFactory.getUserDao();
		List<User> users = userDao.getAllUsers();
		List<Picture> pictures = pictureDao.getAllPictures();
		request.setAttribute("nbrPictures", pictures.size());
		request.setAttribute("nbrUsers", users.size());
		request.setAttribute("pictures", pictures);
		request.setAttribute("pictureDir", SavePicture.getPicturesDir());
		
		request.setAttribute("title", "Accueil");

		this.getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
