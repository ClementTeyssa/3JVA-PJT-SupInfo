package com.supinfo.suppictures.servlet;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.supinfo.suppictures.dao.CategoryDao;
import com.supinfo.suppictures.dao.DaoFactory;
import com.supinfo.suppictures.dao.PictureDao;
import com.supinfo.suppictures.dao.UserDao;
import com.supinfo.suppictures.entity.Category;
import com.supinfo.suppictures.entity.Picture;
import com.supinfo.suppictures.entity.User;
import com.supinfo.suppictures.util.SavePicture;

/**
 * Servlet implementation class AddPictureServlet
 */
@WebServlet("/auth/addPicture")
@MultipartConfig
public class AddPictureServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private boolean isPictureUpload;
	private String picturePath;
	private File picture;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddPictureServlet() {
        super();
        // TODO Auto-generated constructor stub
    }  
    
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		picturePath = getServletContext().getInitParameter("pictureSaved");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Recuperation des categories existantes et envoye de la list en requete
		List<Category> l = DaoFactory.getCategoryDao().getAllCategories();
		request.setAttribute("categories", l);

		request.setAttribute("title", "Ajout de photo");
		RequestDispatcher rd = request.getRequestDispatcher("/auth/addPicture.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Recuperation des champs du formulaire addPicture
		String description = request.getParameter("pictureDescription");
		String name = request.getParameter("pictureName");
		Long categoryId = Long.parseLong(request.getParameter("category"));
		Category category = null;
		
		//Date de l'upload de la photo
		Date date = new Date();
		
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username");
		
		//Recuperation de l'utilisateur connexté
		UserDao userDao = DaoFactory.getUserDao();
		User user = userDao.getUserByUsername(username);
		
		//Recuperation des categories existantes
		CategoryDao categoryDao = DaoFactory.getCategoryDao();
		if(categoryId > 0) {
			category = categoryDao.findCategoryById(categoryId);		
		} 
		
		//Recuperation du fichier image a upload
		Part filePart = request.getPart("picture");
		//Save de l'image
		String picname = SavePicture.SavedPicture(filePart, Paths.get(filePart.getSubmittedFileName()).getFileName().toString() , user.getUsername());
	    String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
	    
	 
		Picture pic = new Picture(
				name,
				picname,
				description,
				date,
				user,
				category);
		
		//Ajout dans la BD
		PictureDao pictureDao = DaoFactory.getPictureDao();
		pictureDao.addPicture(pic);
		
		doGet(request, response);
	}
}
