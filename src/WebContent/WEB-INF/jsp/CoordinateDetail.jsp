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
				<img src="${e.coordinate_image}" >
			</div>
			<!-- 点線 -->
			<p class = "line"></p>
		</c:forEach>

		<!-- アイテム情報 -->
        <p class="article">アイテム情報</p>
        <form action="CoordinateDetailServlet" method="post"  name="coordinateupdate"><!-- enctype="multipart/form-data" -->
        	<div id= "iteminfo">
			    <c:forEach var="e" items="${CoordinateList}">
			    	<input type="hidden" value="${e.coordinate_id}" name="coordinate_id">

					<div class="box">
						<tr>
							<th class="brand"><label>ブランド:</label></th>
							<td><input class="text" type="text" size="30" value="${e.brand}" readonly="readonly" ></td>
						</tr>
						<br>

						<tr>
							<th class="size"><label>サイズ:</label></th>
							<td><input class="text" type="text" size="30" value="${e.size}" readonly="readonly" ></td>
						</tr>
						<br>
					</div>

					<p>アイテム画像</p>
					<a href="/CCC/ItemDetailServlet?q=${e.item_id}">
						<img class="photo" src="${e.item_image}">
					</a>
					<input type="hidden" value="${e.item_id}" name="item_id">
					<input class="delete" type="submit" value="delete" name="submit"><br>
				</c:forEach>
			</div>

			<input class="plus" type="button" value="+">
			<input class="minus" type="submit" value="Update this look" name="submit">
			<input class="minus" type="submit" value="Delete this look" name="submit">
		</form>
	</main>

<%@ include file="/WEB-INF/jsp/Footer.jsp" %>