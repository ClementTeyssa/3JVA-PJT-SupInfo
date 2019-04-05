<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="header.jsp"%>
<div class="row container">
	<div class="col s12 m12">
		<br /> <br />
		<div class="card grey lighten-4">
			<br /> <br />
			<form method="post" action="${pageContext.request.contextPath}/login"
				class="container">
				<div class="row">
					<div class="input-field col s12 m6">
						<i class="material-icons prefix">account_circle</i> <input
							id="username" name="username" type="text" required="required">
						<label for="username">Username</label>
					</div>
					<div class="input-field col s12 m6">
						<i class="material-icons prefix">vpn_key</i> <input id="password"
							name="password" type="password" required="required"> <label
							for="password">Password</label>
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
<%@ include file="footer.jsp"%>