<%@page import="com.supinfo.suppictures.util.SavePicture"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="header.jsp"%>
<br/><br/>
<div class="row">
	<div class="col s12 center-align">
		<h5>Welcome to SupPicture, <b>${nbrUsers} users</b> use this
		website and <b>${nbrPictures} pictures</b>  are posted.</h5>
	</div>
</div>
<br/><br/>
<div class="row container">
	<c:forEach var="picture" items="${pictures}">
		<div class="col s12 m6 l4">
			<div class="card">
				<div class="card-image">
					<%! String picturePath = SavePicture.getPicturesDir().replaceAll("\\\\", "/");%>
					<img class="responsive-img" src="file:///<%= picturePath.toString()%>/<c:out value="${picture.getPictureName()}"/>"/> 
					
					<span class="card-title">${picture.getName()}</span>
				</div>
				<div class="card-content">
					<p>${picture.getDescription()}</p>
				</div>
				<div class="card-action">
					<a href="${pageContext.request.contextPath}/viewPicture?id=${picture.getId()}">View more</a>
				</div>
			</div>
		</div>
	</c:forEach>
</div>
<br/><br/>
<%@ include file="footer.jsp"%>