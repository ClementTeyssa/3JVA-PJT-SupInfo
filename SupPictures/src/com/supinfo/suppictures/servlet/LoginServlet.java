package com.supinfo.suppictures.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.supinfo.suppictures.dao.DaoFactory;
import com.supinfo.suppictures.dao.UserDao;
import com.supinfo.suppictures.entity.User;
import com.supinfo.suppictures.util.PasswordHashing;

/**
 * Servlet implementation class loginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setAttribute("title", "Login");
		this.getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//Recuperation des input du formulaire
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		UserDao userDao = DaoFactory.getUserDao();
		User user = userDao.getUserByUsername(username);
		
		//Verification que le username existe et que son mdp correspond
		if(user != null && PasswordHashing.verifyHashPasswords(password,user.getPassword())) {
			
			HttpSession session = request.getSession();
			session.setAttribute("username", username);
			if(user.getIsAdmin()) session.setAttribute("isAdmin", user.getIsAdmin());

			response.sendRedirect(request.getContextPath() + "/index");		
		} else {
			doGet(request,response);
		}
	}

}
