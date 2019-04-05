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
            <table class="highlight container">
                <thead>
                    <tr>
                        <th>Picture</th>
                        <th>Name</th>
                        <th>Delete Picture</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="picture" items="${pictures}">
                        <tr>
                            <td><%! String picturePath = SavePicture.getPicturesDir().replaceAll("\\\\", "/");%>
								<img class="responsive-img" src="file:///<%= picturePath.toString()%>/<c:out value="${picture.getPictureName()}"/>"/> </td>
                            <td>${picture.getName()}</td>
                            <td>
                                <form
                                    action="${pageContext.request.contextPath}/admin/managePicture"
                                    method="post">
                                    <input type="hidden" name="pictureId" value="${picture.getId()}">
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