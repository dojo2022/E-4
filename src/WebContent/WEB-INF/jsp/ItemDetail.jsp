<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/WEB-INF/jsp/Header.jsp" %>
    <title>CCC｜アイテム詳細</title>
        <main>
        <c:forEach var="e" items="${itemList}" begin="0" end="0">
            <h1>アイテム画像</h1>
            <c:forEach var="e" items="${ModelList}">
			<a href="/CCC/ItemDetailServlet?q=${e.item_id}"><img src="${e.item_image}"></a>
		</c:forEach>
            <hr id="line">
            <p>アイテム情報</p>
            <p>ブランド:</p><input type="text" size="30" value="${e.brand}"><br>
            <p>サイズ:</p><input type="text" size="30" value="${e.size}"><br>
            <input type="button" value="update"><br>
            <input type="button" value="Delete">
		</c:forEach>


        </main>

<%@ include file="/WEB-INF/jsp/Footer.jsp" %>