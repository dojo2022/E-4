<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/WEB-INF/jsp/Header.jsp" %>
<link rel="stylesheet" href="././css/ItemDetail.css">

    <title>CCC｜アイテム詳細</title>

        <main>
        	<c:forEach var="e" items="${itemList}" begin="0" end="0">
            	<div id = "item_image">
					<img src="${e.item_image}" class = "item_place">
            	</div>
            	<hr>

				<div>
	            	<p>アイテム情報</p><br>
	            	<div class = "category">
			            <p>ブランド:</p>
			            <div class = "categorybox">
			            	<input type="text" size="30" value="${e.brand}">
			            </div><br>

			            <p>サイズ:</p>
			            <div class = "categorybox">
			            	<input type="text" size="30" value="${e.size}">
			            </div>

			        </div><br>
			            <input type="button" value="update"><br>
			            <input type="button" value="Delete">
			    </div>
			</c:forEach>
        </main>

<%@ include file="/WEB-INF/jsp/Footer.jsp" %>