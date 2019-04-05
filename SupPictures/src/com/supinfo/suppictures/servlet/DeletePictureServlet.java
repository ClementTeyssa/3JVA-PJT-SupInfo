package com.supinfo.suppictures.servlet;

import java.io.IOException;

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
import com.supinfo.suppictures.entity.User;

/**
 * Servlet implementation class DeletePictureServlet
 */
@WebServlet("/auth/deletePicture")
public class DeletePictureServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeletePictureServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher rd = request.getRequestDispatcher("/auth/managePicture.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//Verification que l'utilisateur existe
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username");
		UserDao userDao = DaoFactory.getUserDao();
		User user = userDao.getUserByUsername(username);
		
		
		if(user != null) {
			Long id =Long.parseLong(request.getParameter("pictureId"));
			
			//Suppression de la photo avec l'id contenue dans le post
			PictureDao pictureDao = DaoFactory.getPictureDao();
			pictureDao.removePicture(pictureDao.getPictureById(id));
		} 
		doGet(request, response);
	}

}
