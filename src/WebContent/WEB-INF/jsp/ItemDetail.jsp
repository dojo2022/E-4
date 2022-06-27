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
					<p class = "iteminfo">アイテム情報</p>
				</div><br>
				<form id="update" method="POST" action="/CCC/ItemDetailServlet">
					<input type="text" name="item_id" value="${e.item_id}" readonly>
					<table>
						<tr>
							<td class="category">ブランド:</td>
							<td><input class = "box" type="text" name="brand" value="${e.brand}"></td>
							<td></td>
						</tr>
						<tr>
							<td class="category">サイズ:</td>
							<td><input class = "box" type="text" name="size" value="${e.size}"></td>
							<td></td>
						</tr>
						<tr>
							<td></td>
							<td></td>
							<td><input type="submit" name="submit" value="update"><br>
								<input type="submit" name="submit" value="delete">
					        </td>
						</tr>
	                </table>
				</form>
			</c:forEach>
        </main>

<%@ include file="/WEB-INF/jsp/Footer.jsp" %>