package com.supinfo.suppictures.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.supinfo.suppictures.dao.CategoryDao;
import com.supinfo.suppictures.dao.DaoFactory;
import com.supinfo.suppictures.dao.PictureDao;
import com.supinfo.suppictures.dao.UserDao;
import com.supinfo.suppictures.entity.Category;
import com.supinfo.suppictures.entity.Picture;
import com.supinfo.suppictures.entity.User;

/**
 * Servlet implementation class ModifyPictureServlet
 */
@WebServlet("/auth/modifyPicture")
public class ModifyPictureServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifyPictureServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PictureDao pictureDao = DaoFactory.getPictureDao();
		CategoryDao categoryDao = DaoFactory.getCategoryDao();
		List<Category> categories = categoryDao.getAllCategories();
		List<Picture> pictures = pictureDao.getAllPictures();
		List<Picture> picturesUser = new ArrayList<Picture>();
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username");
		UserDao userDao = DaoFactory.getUserDao();
		User user = userDao.getUserByUsername(username);
		
		if(user != null ) {
			for(Picture p : pictures) {
				if(p.getUser().getUsername().equals(username)) {
					picturesUser.add(p);
					System.out.println(p.getCategory());
				}
			}
			request.setAttribute("pictures", pictures);
			request.setAttribute("categories", categories);
			request.setAttribute("title", "Modification de photo");
			RequestDispatcher rd = request.getRequestDispatcher("/auth/modifyPicture.jsp");
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
		Long id =Long.parseLong(request.getParameter("pictureId"));
		
		PictureDao pictureDao = DaoFactory.getPictureDao();
		Picture picture = pictureDao.getPictureById(id);
		if(picture != null) {
			picture.setName(request.getParameter("name"));
			picture.setDescription(request.getParameter("description"));
			if(Integer.parseInt(request.getParameter("category")) > 0) {
				CategoryDao categoryDao = DaoFactory.getCategoryDao();
				
				picture.setCategory((Category) categoryDao.findCategoryById(Long.parseLong(request.getParameter("category"))));
			}
			pictureDao.updatePicture(picture);
		}
		
		
		doGet(request, response);
	}

}
