<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/WEB-INF/jsp/Header.jsp" %>
<link rel="stylesheet" href="././css/ItemResult.css">
    <title>CCC｜検索結果</title>

        <main>

		<div class="title">
        <h1 class="Title_Result">Results</h1>
        </div>


    <h1 class="img_title">Item Image</h1>

	<div class = searchmemu>
        <c:forEach var="e" items="${CoordinateItemList}">
			<a href="/CCC/ItemDetailServlet?q=${e.item_id}"><img src="${e.item_image}" class= "resultlist"></a>
		</c:forEach>
</div>

        </main>

<%@ include file="/WEB-INF/jsp/Footer.jsp" %>