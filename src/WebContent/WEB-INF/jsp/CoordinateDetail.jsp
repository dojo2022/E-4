<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/WEB-INF/jsp/Header.jsp" %>
<link rel="stylesheet" href="././css/CoordinateDetail.css">

    <title>CCC｜コーディネート詳細</title>

        <main>
			<c:forEach var="e" items="${CoordinateList}" begin="0" end="0">
            	<h1>コーディネート画像</h1>
            	<div id = "coordinateImage">
		            <img src="${e.coordinate_image}">
	            </div>
            </c:forEach>
            <hr  id="line">

	        <p>アイテム情報</p>
	        <c:forEach var="e" items="${CoordinateList}">
			    <p>ブランド:</p><input type="text" size="30" value="${e.brand}">
			    <p>サイズ:</p><input type="text" size="30" value="${e.size}">
			    <p>アイテム画像</p><img src="${e.item_image}">
			    <input type="submit" value="Delete"><br>
	        </c:forEach>

	            <input type="submit" value="+">
	            <input type="submit" value="Delete this look">
        </main>
