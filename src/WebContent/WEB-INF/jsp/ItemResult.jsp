<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/WEB-INF/jsp/Header.jsp" %>
    <title>CCC｜検索結果</title>

        <main>

        <h1 class="Title_Result">Results</h1>

     <c:forEach var="tag" items="${CoordinateItemList}">
      <p class="search_tag">${}</p>
    </c:forEach>

    <h1>アイテム画像</h1>

                <c:forEach var="i" items="${ciModel}">
			<a id="item_img" href="/CCC/ItemDetailServlet?q=${e.item_id}"><img src="${e.item_image}"></a>
		</c:forEach>


        </main>

<%@ include file="/WEB-INF/jsp/Footer.jsp" %>