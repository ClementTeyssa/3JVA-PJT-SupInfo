<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp"%>
<div class="row container">
    <div class="col s12 m12">
        <br /> <br />
        <div class="card grey lighten-4">
            <br /> <br />
            <form method="post" action="${pageContext.request.contextPath}/userProfile"
                class="container">
                <div class="row">
                    <div class="input-field col s12 m6">
                        <input value="${user.getLastName()}" id="lastname" type="text"
                            name="lastname" required="required"> <label
                            class="active" for="lastname">Last Name</label>
                    </div>
                    <div class="input-field col s12 m6">
                        <input value="${user.getFirstName()}" id="firstname" type="text"
                            name="firstname" required="required"> <label
                            class="active" for="firstname">Last Name</label>
                    </div>
                    <div class="input-field col s12 m6">
                        <input value="${user.getEmail()}" id="email" type="email"
                            name="email" required="required"> <label class="active"
                            for="email">Email</label>
                    </div>
                    <div class="input-field col s12 m6">
                        <input value="${user.getAddress()}" id="adress" type="text"
                            name="adress" required="required"> <label class="active"
                            for="adress">Adress</label>
                    </div>
                    <div class="input-field col s12 m6">
                        <input value="${user.getCity()}" id="city" type="text" name="city"
                            required="required"> <label class="active" for="city">Adress</label>
                    </div>
                    <div class="input-field col s12 m6">
                        <input id="password" type="password" name="password"
                               required="required"> <label class="active" for="password">Password</label>
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