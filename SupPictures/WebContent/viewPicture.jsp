<%@page import="com.supinfo.suppictures.util.SavePicture"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<%@ include file="header.jsp"%>
<div class="row container">
    <div class="col s12 m12">
        <br /> <br />
        <div class="card grey lighten-4">
            <br /> <br />
            <h3 class="center-align">${picture.getName()}</h3>
            <div class="row">
                <div class="col s12 center-align">
                    <%! String picturePath = SavePicture.getPicturesDir().replaceAll("\\\\", "/");%>
					<img class="responsive-img" src="file:///<%= picturePath.toString()%>/<c:out value="${picture.getPictureName()}"/>"/> 
					
                </div>
            </div>
            <br /> <br />
            <blockquote class="container">
                ${picture.getDescription()}
            </blockquote>
            <br /> <br />
            <p>Published : ${picture.getPublishDate()}, by ${picture.getUser().getUsername()}</p>
            <p>Category : ${picture.getCategory().getName()}</p>
    		<p>Number of views : ${picture.getNbView()}</p>
            <br /> <br />
        </div>
    </div>
</div>
<%@ include file="footer.jsp"%>