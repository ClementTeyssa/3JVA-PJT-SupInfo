<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="header.jsp"%>
<div class="row container">
	<div class="col s12 m12">
		<br /> <br />
		<div class="card grey lighten-4">
			<br /> <br />
			<form method="post"
				action="${pageContext.request.contextPath}/auth/addPicture"
				class="container" enctype="multipart/form-data">
				<div class="row">
					<div class="input-field col s12 m6">
						<i class="material-icons prefix">assignment</i> <input
							id="pictureName" name="pictureName" type="text"
							required="required"> <label for="pictureName">Name</label>
					</div>
					<div class="input-field col s12 m6">
						<i class="material-icons prefix">comment</i> <input
							id="pictureDescription" name="pictureDescription" type="text"
							required="required"> <label for="pictureDescription">Description</label>
					</div>
					<div class="input-field col s12 m6">
						<select name="category" >
							<option value="0" disabled selected>none</option>
							<c:forEach var="cat" items="${categories}">
								<option value="${cat.getId()}">${cat.getName()}</option>
							</c:forEach>
						</select> <label>Category</label>
					</div>
					<div class="file-field input-field col s12 m6">
						<div class="btn">
							<span>File</span> <input type="file" name="picture"
								required="required">
						</div>
						<div class="file-path-wrapper">
							<input class="file-path validate" type="text">
						</div>
					</div>
					<div class="row">
						<div class="col s12 center-align">
							<button class="btn waves-effect waves-light" type="submit">
								Submit <i class="material-icons right">send</i>
							</button>
						</div>
					</div>
			</form>
			<br /> <br />
		</div>
	</div>
</div>
<script>
	$(document).ready(function() {
		$('select').formSelect();
	});
</script>
<%@ include file="footer.jsp"%>