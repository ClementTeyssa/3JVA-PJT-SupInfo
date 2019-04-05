package com.supinfo.suppictures.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.supinfo.suppictures.dao.DaoFactory;
import com.supinfo.suppictures.dao.UserDao;
import com.supinfo.suppictures.entity.User;

/**
 * Servlet Filter implementation class AdminFilter
 */
@WebFilter("/admin/*")
public class AdminFilter implements Filter {

    /**
     * Default constructor. 
     */
    public AdminFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// pass the request along the filter chain
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		HttpSession session = httpRequest.getSession();
		
		//Verification si un utilisateur c'est connecté
		if (session.getAttribute("username") != null) {
			//Recuperation de l'utilisateur connecté
			UserDao userDao = DaoFactory.getUserDao();
			User user = userDao.getUserByUsername((String) session.getAttribute("username"));
			
			//Verification sur l'utilisateur si il est admin
			if(user != null && user.getIsAdmin()) {
				chain.doFilter(request, response);
				return;
			}
			//Redirection index l'utilisateur n'est pas admin
			httpResponse.sendRedirect(httpRequest.getContextPath() + "/index");
			return;
		}
		
		//Redirection login pas d'utilisateur connecter
		httpResponse.sendRedirect(httpRequest.getContextPath() + "/login");
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
