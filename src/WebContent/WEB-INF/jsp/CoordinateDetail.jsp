<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/WEB-INF/jsp/Header.jsp" %>
	<title>CCC｜コーディネート詳細</title>
	<link rel="stylesheet" href="././css/CoordinateDetail.css">
	<main>
			<c:forEach var="e" items="${CoordinateList}" begin="0" end="0">
            <h1>コーディネート画像</h1>
            <div class="picbox">
	            <img class="photo" src="${e.coordinate_image}" >
	         </div>
	         <!-- 点線 -->
			<p class = "line"></p>
            </c:forEach>
            <p>アイテム情報</p>
            <div id= "iteminfo">
	            <c:forEach var="e" items="${CoordinateList}">
	            <p>ブランド:</p><input type="text" size="30" value="${e.brand}"><br>
	            <p>サイズ:</p><input type="text" size="30" value="${e.size}"><br>
	            <p>アイテム画像</p><img src="${e.item_image}">
	            <input type="submit" value="Delete"><br>
            </c:forEach>
            </div>
            <input type="submit" value="+">
            <input type="submit" value="Delete this look">
        </main>
<%@ include file="/WEB-INF/jsp/Footer.jsp" %>