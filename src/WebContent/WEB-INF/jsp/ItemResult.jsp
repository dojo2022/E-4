<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/WEB-INF/jsp/Header.jsp" %>
<%
String category = (String)request.getAttribute("search_category");
String brand = (String)request.getAttribute("search_brand");
%>
<link rel="stylesheet" href="././css/ItemResult.css">
    <title>CCC｜検索結果</title>

        <main>

		<div class="title">
        <h1 class="Title_Result">Results</h1>
        </div>

     <!--
     <c:forEach var="tag" items="${iTagList}">
      <p id="search_tag"><c:out value="${tag}"></c:out></p>
    </c:forEach>
    -->

    <h1 class="img_title">Item Image</h1>

        <c:forEach var="e" items="${CoordinateItemList}">
			<a id="item_img" href="/CCC/ItemDetailServlet?q=${e.item_id}"><img src="${e.item_image}"></a>
		</c:forEach>


        </main>

<%@ include file="/WEB-INF/jsp/Footer.jsp" %>