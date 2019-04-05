<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<!--Import Google Icon Font-->
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">


<!--Import materialize.css-->
<link type="text/css" rel="stylesheet" href="css/materialize.min.css"
	media="screen,projection" />
<link type="text/css" rel="stylesheet" href="css/myStyle.css"
	media="screen,projection" />

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
<script type="text/javascript" src="js/materialize.min.js"></script>

<!--Let browser know website is optimized for mobile-->
<meta name="viewport" content="width=device-width, initial-scale=1.0"
	charset="UTF-8" />
<title>${title}</title>
</head>
<body>
	
	<!-- Dropdown Structure -->
	<ul id="dropdown-me" class="dropdown-content">
		<li><a href="${pageContext.request.contextPath}/auth/modifyUser">My Profile</a></li>
		<li class="divider"></li>
		<li><a href="${pageContext.request.contextPath}/auth/addPicture">Add a Picture</a></li>
		<li class="divider"></li>
		<li><a href="${pageContext.request.contextPath}/auth/modifyPicture">My Pictures</a></li>
		<%
			if (session.getAttribute("isAdmin") != null) {
		%>
			<li class="divider"></li>
			<li><a href="${pageContext.request.contextPath}/admin/manageUser">Users</a></li>
			<li class="divider"></li>
			<li><a href="${pageContext.request.contextPath}/admin/managePicture">Pictures</a></li>
		<%
			}
		%>
	</ul>
	
	<!-- Dropdown Structure -->
	<ul id="dropdown-me2" class="dropdown-content">
		<li><a href="${pageContext.request.contextPath}/auth/modifyUser">My Profile</a></li>
		<li class="divider"></li>
		<li><a href="${pageContext.request.contextPath}/auth/addPicture">Add a Picture</a></li>
		<li class="divider"></li>
		<li><a href="${pageContext.request.contextPath}/auth/modifyPicture">My Pictures</a></li>
		<%
			if (session.getAttribute("isAdmin") != null) {
		%>
			<li class="divider"></li>
			<li><a href="${pageContext.request.contextPath}/admin/manageUser">Users</a></li>
			<li class="divider"></li>
			<li><a href="${pageContext.request.contextPath}/admin/managePicture">Pictures</a></li>
		<%
			}
		%>
	</ul>
	<nav class="nav-extended">
		<div class="nav-wrapper">
			<a href="${pageContext.request.contextPath}" class="brand-logo">SupPictures</a>
			<a href="#" data-target="mobile-demo" class="sidenav-trigger"><i
				class="material-icons">menu</i></a>
			<ul class="right hide-on-med-and-down">
				<li>
					<form method="post" action="${pageContext.request.contextPath}/resultSearch">
						<div class="input-field">
							<i class="material-icons prefix">search</i> <input
								id="icon_prefix" name="search" type="text" class="validate"> <label
								for="icon_prefix">To Search</label>
						</div>
					</form>
				</li>
				<%
					if (session.getAttribute("username") == null) {
				%>
				<li><a href="${pageContext.request.contextPath}/login">Log
						In</a></li>
				<li><a href="${pageContext.request.contextPath}/register">Register</a></li>
				<%
					} else {
				%>
				
				<li><a class="dropdown-button" href="#!"
					data-target="dropdown-me">Me<i class="material-icons right">arrow_drop_down</i></a></li>
				<li><a href="${pageContext.request.contextPath}/logout">Log Out</a></li>
				<%
					}
				%>
			</ul>
		</div>
		<div class="nav-content hide-on-large-only">
			<form method="post" action="${pageContext.request.contextPath}/resultSearch">
				<div class="input-field">
					<input id="search" name="search" type="search" required> <label
						class="label-icon" for="search"><i class="material-icons">search</i></label>
					<i class="material-icons">close</i>
				</div>
			</form>
		</div>
	</nav>
	<ul class="sidenav" id="mobile-demo">
		<%
			if (session.getAttribute("username") == null) {
		%>
		<li><a href="${pageContext.request.contextPath}/login">Log In</a></li>
		<li><a href="${pageContext.request.contextPath}/register">Register</a></li>
		<%
			} else {
		%>
		
		<li><a class="dropdown-button" href="#!"
			data-target="dropdown-me2">Me<i class="material-icons right">arrow_drop_down</i></a></li>
		<li><a href="${pageContext.request.contextPath}/logout">Log Out</a></li>
		<%
			}
		%>
	</ul>
	<script>
		$(document).ready(function() {
			$(".dropdown-button").dropdown();
			$('.sidenav').sidenav();
		});
	</script>
	<main>