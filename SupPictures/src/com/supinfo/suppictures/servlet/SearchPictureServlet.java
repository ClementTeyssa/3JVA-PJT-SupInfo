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

import com.supinfo.suppictures.dao.DaoFactory;
import com.supinfo.suppictures.dao.PictureDao;
import com.supinfo.suppictures.entity.Picture;

/**
 * Servlet implementation class SearchPictureServlet
 */
@WebServlet("/resultSearch")
public class SearchPictureServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchPictureServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String search = (String) request.getAttribute("searchValue");
		PictureDao pictureDao = DaoFactory.getPictureDao();
		List<Picture> picturesAll = pictureDao.getAllPictures();
		
		if(picturesAll.size()!=0 && search != null) {
			List<Picture> pictures = new ArrayList<Picture>();
			
			for(Picture p : picturesAll) {
				System.out.println(p.getName());
				Boolean test = p.getCategory() != null && p.getCategory().getName().contains(search);
				if(p.getName().contains(search) || p.getDescription().contains(search) || test) {
					pictures.add(p);
				}
			}
			
			request.setAttribute("pictures", pictures);
		}
		
		request.setAttribute("title", "Recherche");
		RequestDispatcher rd = request.getRequestDispatcher("/resultSearch.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String search = request.getParameter("search");
		System.out.println(search);
		request.setAttribute("searchValue", search);
		doGet(request, response);
	}

}
