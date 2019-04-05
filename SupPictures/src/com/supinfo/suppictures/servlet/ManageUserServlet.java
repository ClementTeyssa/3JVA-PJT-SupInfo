package com.supinfo.suppictures.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.supinfo.suppictures.dao.DaoFactory;
import com.supinfo.suppictures.dao.UserDao;
import com.supinfo.suppictures.entity.User;

/**
 * Servlet implementation class ManageUserServlet
 */
@WebServlet("/admin/manageUser")
public class ManageUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManageUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		UserDao userDao = DaoFactory.getUserDao();
		User user = userDao.getUserByUsername((String) request.getSession().getAttribute("username"));
		
		if(user != null && user.getIsAdmin()) {
			
			List<User> users = userDao.getAllUsers();
			request.setAttribute("users", users);
			request.setAttribute("title", "Gestionnaire d'utilisateur");
			this.getServletContext().getRequestDispatcher("/admin/manageUser.jsp").forward(request, response);
			
		} else {
			response.sendRedirect(request.getContextPath() + "/index");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id =Integer.parseInt(request.getParameter("userId"));
		
		UserDao userDao = DaoFactory.getUserDao();
		userDao.removeUser(userDao.getUserById(id));
		
		doGet(request, response);
	}

}
