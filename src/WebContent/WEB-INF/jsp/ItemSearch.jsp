<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/WEB-INF/jsp/Header.jsp" %>
<title>CCC｜アイテム検索</title>
	<main>
		<c:forEach var="e" items="${itemList}">
			<img src="${e.item_image}">
		</c:forEach>
		<input id="search_input" class="search_hidden" type="checkbox">
		<div class="search_content">
			<form id="ItemSearch" method="POST" action="/CCC/ItemListServlet">
				<table>
					<tr>
						<td><p>SEARCH ITEMS</p></td>
						<td><label for="search_input" class="btn"><span>×</span></label></td>
					</tr>
					<tr>
						<th><p>カテゴリー</p></th>
						<td><label><input type="checkbox" name="search_category" value="tops">トップス</label>
						<label><input type="checkbox" name="search_category" value="outer">アウター</label>
						<label><input type="checkbox" name="search_category" value="pants">パンツ</label>
						<label><input type="checkbox" name="search_category" value="skirt">スカート</label>
						<label><input type="checkbox" name="search_category" value="onepiece">ワンピース</label>
						<label><input type="checkbox" name="search_category" value="shoes">シューズ</label>
						<label><input type="checkbox" name="search_category" value="accessories">小物</label></td>
					</tr>
					<tr>
						<td><select name="search_brand">
								<option value="">ブランド</option>
								<c:forEach var="e" items="${itemList}">
									<option value="${e.brand}">${e.brand}</option>
								</c:forEach>
							</select>
						</td>
						<td><input type="submit" name="search" value="GO" class="search_submit"></td>
					</tr>
				</table>
			</form>
		</div>
		<label for="search_input" class="container"><span>検索</span></label>
	</main>
<%@ include file="/WEB-INF/jsp/Footer.jsp" %>