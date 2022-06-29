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
            	<hr class = "line">

				<form id="update" method="POST" action="/CCC/ItemDetailServlet">
					 <input type="hidden" name="item_id" value="${e.item_id}" >
					<table>
						<tr>
							<td class="category">カテゴリー:</td>
							<td id = "category"><select name="item_category">
								<option value="トップス" ${e.category == "トップス" ? "selected": ""}>トップス</option>
								<option value="アウター" ${e.category == "アウター" ? "selected": ""}>アウター</option>
								<option value="パンツ" ${e.category == "パンツ" ? "selected": ""}>パンツ</option>
								<option value="スカート" ${e.category == "スカート" ? "selected": ""}>スカート</option>
								<option value="ワンピース" ${e.category == "ワンピース" ? "selected": ""}>ワンピース</option>
								<option value="シューズ" ${e.category == "シューズ" ? "selected": ""}>シューズ</option>
								<option value="小物" ${e.category == "小物" ? "selected": ""}>小物</option>
								</select>
							</td>
						</tr>
						<tr>
							<td class="category">ブランド:</td>
							<td><input class = "box" type="text" name="brand" value="${e.brand}"></td>
						</tr>
						<tr>
							<td class="category">サイズ:</td>
							<td><input class = "box" type="text" name="size" value="${e.size}"></td>
						</tr>
						<tr>
							<td class="category">備考:</td>
							<td><textarea name="remarks">${e.remarks}</textarea></td>
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