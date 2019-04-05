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
 * Servlet implementation class registerServlet
 */
@WebServlet("/register")
public class registerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public registerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setAttribute("title", "Register");
		this.getServletContext().getRequestDispatcher("/register.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//Recuperation des input du formulaire
		String username = request.getParameter("username");
		String password = PasswordHashing.getPasswordHash(request.getParameter("password"));
		String lastName = request.getParameter("lastname");
		String firstName = request.getParameter("firstname");
		String address = request.getParameter("address");
		String city = request.getParameter("city");
		String email = request.getParameter("email");
		int phone = Integer.parseInt(request.getParameter("phone"));
		
		//Creation d'un nouvelle user
		User registeredUser = 
				new User(
						username,
						password,
						city,
						address,
						lastName,
						firstName,
						email);
		
		
		UserDao userDao = DaoFactory.getUserDao();
		
		//Verification si le username est deja utilisé par quelqu'un d'autre
		if(userDao.getUserByUsername(username)==null) {
			//ajout du user a la BD
			System.out.println(userDao.getAllUsers().size());
			if(userDao.getAllUsers().size() == 0 ) {
				registeredUser.setIsAdmin(true);
			}
			
			userDao.addUser(registeredUser);
			
			HttpSession session = request.getSession();
			session.setAttribute("username", username);
			if(registeredUser.getIsAdmin()) session.setAttribute("isAdmin", registeredUser.getIsAdmin());

			this.getServletContext().getRequestDispatcher("/index").forward(request, response);
		} else {
			doGet(request, response);
		}
	}

}
