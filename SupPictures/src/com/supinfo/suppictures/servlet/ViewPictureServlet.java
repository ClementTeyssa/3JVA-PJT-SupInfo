package com.supinfo.suppictures.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.supinfo.suppictures.dao.DaoFactory;
import com.supinfo.suppictures.dao.PictureDao;
import com.supinfo.suppictures.entity.Category;
import com.supinfo.suppictures.entity.Picture;
import com.supinfo.suppictures.entity.User;

/**
 * Servlet implementation class ViewPictureServlet
 */
@WebServlet("/viewPicture")
public class ViewPictureServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewPictureServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = request.getParameter("id");
		RequestDispatcher rd;
		
		if(id != null) {
			PictureDao pictureDao = DaoFactory.getPictureDao();
			try {
				Picture picture = pictureDao.getPictureById(Long.parseLong(id));
				
				if(picture != null) {
					picture.setNbView(picture.getNbView()+1);
					pictureDao.updatePicture(picture);
					
					request.setAttribute("picture", picture);
					
					request.setAttribute("title", "Detail de la photo");

					rd = request.getRequestDispatcher("/viewPicture.jsp");
					rd.forward(request, response);
				} else {
					response.sendRedirect(request.getContextPath() + "/index");
				}
			}catch(NumberFormatException e) {
				response.sendRedirect(request.getContextPath() + "/index");
			}
		}  else {
			response.sendRedirect(request.getContextPath() + "/index");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
