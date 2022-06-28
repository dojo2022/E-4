<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/WEB-INF/jsp/Header.jsp" %>
	<title>CCC｜コーディネート詳細</title>
	<link rel="stylesheet" href="././css/CoordinateDetail.css">
	<main>
			<c:forEach var="e" items="${CoordinateList}" begin="0" end="0">
            <div class="picbox">
	            <img src="${e.coordinate_image}" >
	         </div>
	         <!-- 点線 -->
			<p class = "line"></p>
			</c:forEach>
			<!-- アイテム情報 -->
            <p class="article">アイテム情報</p>
            <c:forEach var="e" items="${CoordinateList}">
            <div id= "iteminfo">
            <div class = "box">
				<tr>
					<th class="brand"><label>ブランド:</label></th>
					<td><input class="text" type="text" size="30" value="${e.brand}"></td>
				</tr>
				<br>
				<tr>
		            <th class="size"><label>サイズ:</label></th>
		            <td><input class="text" type="text" size="30" value="${e.size}"></td>
				</tr></div>
				<br>
		            <div class = "float"><img class="photo" src="${e.item_image}"></div>
		            </div>

		            <div class = "delete"><input class="delete" type="submit" value="Delete"><br></div>
	            </c:forEach>
<!--             <div class = "plusbutton"><input class="plus" type="submit" value="+"></div> -->
            <div class = "deletethis"><input class="minus" type="submit" value="Delete this look"></div>
        </main>
<%@ include file="/WEB-INF/jsp/Footer.jsp" %>