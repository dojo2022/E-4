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

     <c:forEach var="tag" items="${tag_list}">
     <p id="search_tag"><c:out value="${tag}" /></p>
    </c:forEach>

    <h2 class="img_title">Coordinate Image</h2>

    <c:forEach var="li" items="${CoordinateList}">

        <a id="coordinate_img" href="/CCC/CoordinateDetailServlet?q=${e.item_id}"><img src="${e.coordinate_image}"></a>

		</c:forEach>
        </main>

<%@ include file="/WEB-INF/jsp/Footer.jsp" %>