<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="header.jsp"%>
<div class="row container">
	<div class="col s12 m12">
		<br /> <br />
		<div class="card grey lighten-4">
			<br /> <br />
			<form method="post"
				action="${pageContext.request.contextPath}/register"
				class="container">
				<div class="row">
					<div class="input-field col s12 m6">
						<i class="material-icons prefix">account_circle</i> <input
							id="username" name="username" type="text" required="required">
						<label for="username">Username</label>
					</div>
					<div class="input-field col s12 m6">
						<i class="material-icons prefix">vpn_key</i> <input id="password"
							type="password" name="password" required="required"> <label
							for="password">Password</label>
					</div>
					<div class="input-field col s12 m6">
						<i class="material-icons prefix">local_phone</i> <input id="phone"
							type="number" name="phone" required="required"> <label
							for="phone">Phone number</label>
					</div>
					<div class="input-field col s12 m6">
						<i class="material-icons prefix">people_outline</i> <input
							id="lastname" type="text" name="lastname" required="required">
						<label for="lastname">Last Name</label>
					</div>
					<div class="input-field col s12 m6">
						<i class="material-icons prefix">people</i> <input id="firstname"
							type="text" name="firstname" required="required"> <label
							for="firstname">First Name</label>
					</div>
					<div class="input-field col s12 m6">
						<i class="material-icons prefix">map</i> <input id="address"
							type="text" name="address" required="required"> <label
							for="address">Adress</label>
					</div>
					<div class="input-field col s12 m6">
						<i class="material-icons prefix">location_city</i> <input
							id="city" type="text" name="city" required="required"> <label
							for="city">City</label>
					</div>
					<div class="input-field col s12 m6">
						<i class="material-icons prefix">email</i> <input id="email"
							type="email" name="email" required="required"> <label
							for="email">Email</label>
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