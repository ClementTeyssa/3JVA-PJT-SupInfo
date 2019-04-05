package com.supinfo.suppictures.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.mail.Session;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.supinfo.suppictures.dao.DaoFactory;
import com.supinfo.suppictures.dao.PictureDao;
import com.supinfo.suppictures.dao.UserDao;
import com.supinfo.suppictures.entity.Picture;
import com.supinfo.suppictures.entity.User;

/**
 * Servlet implementation class ManagePictureServlet
 */
@WebServlet("/admin/managePicture")
public class ManagePictureServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManagePictureServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PictureDao pictureDao = DaoFactory.getPictureDao();
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username");
		UserDao userDao = DaoFactory.getUserDao();
		User user = userDao.getUserByUsername(username);
		
		if(user != null && user.getIsAdmin()) {
			
			List<Picture> pictures = pictureDao.getAllPictures();
			request.setAttribute("pictures", pictures);
			request.setAttribute("title", "Gestionnaire de photo");

			RequestDispatcher rd = request.getRequestDispatcher("/admin/managePicture.jsp");
			rd.forward(request, response);
		} else {
			response.sendRedirect(request.getContextPath() + "/index");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username");
		UserDao userDao = DaoFactory.getUserDao();
		User user = userDao.getUserByUsername(username);
		
		if(user != null && user.getIsAdmin()) {
			Long id =Long.parseLong(request.getParameter("pictureId"));
		
			PictureDao pictureDao = DaoFactory.getPictureDao();
			pictureDao.removePicture(pictureDao.getPictureById(id));
			doGet(request, response);
		} else {
			
		}
	}

}
