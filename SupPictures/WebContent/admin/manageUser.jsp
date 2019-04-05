<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="header.jsp"%>
<div class="row container">
	<div class="col s12 m12">
		<br /> <br />
		<div class="card grey lighten-4">
			<br /> <br />
			<table class="highlight container">
				<thead>
					<tr>
						<th>Name</th>
						<th>Is Admin ?</th>
						<th>Delete User</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="user" items="${users}">
						<tr>
							<td>${user.getUsername()}</td>
							<td>
								 <form action="#">
    								<p>
      								<label>
      									<c:if test="${user.getIsAdmin()}">
        									<input type="checkbox" checked="checked" name="isAdmin" />
        									<span></span>        								        
        								</c:if>
        								<c:if test="${user.getIsAdmin()==false}">
        									<input type="checkbox" name="isAdmin"/>
        								    <span></span>
        								</c:if>
     								 </label>
    								</p>
    							</form>
							</td>
							<td>
								<form
									action="${pageContext.request.contextPath}/admin/manageUser"
									method="post">
									<input type="hidden" name="userId" value="${user.getId()}">
									<button class="btn waves-effect waves-light" type="submit">
										Delete <i class="material-icons right">delete</i>
									</button>
								</form>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<br /> <br />
		</div>
	</div>
</div>
<%@ include file="footer.jsp"%>