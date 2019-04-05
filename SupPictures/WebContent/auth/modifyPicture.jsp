<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="header.jsp"%>
<div class="row">
    <div class="col s12 m12">
        <br /> <br />
        <div class="card grey lighten-4">
            <br /> <br />
            <table class="highlight container">
                <thead>
                    <tr>
                        <th>Name</th>
                        <th>Description</th>
                        <th>Category</th>
                        <th>Change</th>
                        <th>Delete Picture</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="picture" items="${pictures}">
                        <tr>
                            <form
                                action="${pageContext.request.contextPath}/auth/modifyPicture"
                                method="post">
                                 <input type="hidden" name="pictureId"
                                        value="${picture.getId()}">
                                <td><input value="${picture.getName()}" id="name"
                                    type="text" name="name" required="required"> <label
                                    class="active" for="name">Name</label></td>
                                <td><input value="${picture.getDescription()}"
                                    id="description" type="text" name="description"
                                    required="required"> <label class="active"
                                    for="description">Description</label></td>
                                <td class="input-field">
                                <select name="category" class="browser-default">
                                		<option value="0">none</option>
                                        <c:if test="${not empty picture.getCategory()}">
                                            <option value="${picture.getCategory().getId()}" disabled
                                                selected>${picture.getCategory().getName()}</option>
                                            <c:forEach var="cat" items="${categories}">
                                                
                                                    <option value="${cat.getId()}">${cat.getName()}</option>
                                            </c:forEach>
                                        </c:if>
                                        <c:if test="${empty picture.getCategory()}">
                                            <option value="0" selected>none</option>
                                            <c:forEach var="cat" items="${categories}">
                                                <option value="${cat.getId()}">${cat.getName()}</option>
                                            </c:forEach>
                                        </c:if>
                                </select>
                           		<p>
                                 <label>Category</label></td>
                        		</p>
                                <td><button class="btn waves-effect waves-light"
                                        type="submit">Change</button></td>
                            </form>
                            <td>
                                <form
                                    action="${pageContext.request.contextPath}/auth/deletePicture"
                                    method="post">
                                    <input type="hidden" name="pictureId"
                                        value="${picture.getId()}">
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