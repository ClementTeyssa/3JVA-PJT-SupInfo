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
 * Servlet implementation class MofifyUserServlet
 */
@WebServlet("/auth/modifyUser")
public class MofifyUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MofifyUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username");
		
		UserDao userDao = DaoFactory.getUserDao();
		User user = userDao.getUserByUsername(username);
		request.setAttribute("user", user);

		request.setAttribute("title", "Information compte");
		this.getServletContext().getRequestDispatcher("/auth/modifyUser.jsp").forward(request, response);
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
		
		String password = PasswordHashing.getPasswordHash(request.getParameter("password"));
		String lastName = request.getParameter("lastname");
		String firstName = request.getParameter("firstname");
		String address = request.getParameter("address");
		String city = request.getParameter("city");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		
		User registeredUser = 
				new User(
						username,
						password,
						city,
						address,
						lastName,
						firstName,
						email);
		
		doGet(request, response);
	}

}
