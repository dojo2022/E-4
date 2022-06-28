 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ include file="/WEB-INF/jsp/Header.jsp" %>
    <title>CCC｜検索結果</title>
    <link rel="stylesheet" href="././css/CoordinateResult.css">
        <main>

        <div class="title">
    <h1 class="Title_Result">Results</h1>
    </div>
    <h2 class="img_title">Coordinate Image</h2>
    <div class = searchmemu>
    <c:forEach var="e" items="${CoordinateList}">
       <a id="coordinate_img" href="/CCC/CoordinateDetailServlet?q=${e.coordinate_id}"><img src="${e.coordinate_image}" class= "resultlist"></a>
	</c:forEach>
	</div>
        </main>

<%@ include file="/WEB-INF/jsp/Footer.jsp" %>