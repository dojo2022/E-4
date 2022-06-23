<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/WEB-INF/jsp/Header.jsp" %>
<link rel="stylesheet" href="././css/ItemSearch.css">
<title>CCC｜アイテム検索</title>
	<main>
		<div class = searchmemu>
			<c:forEach var="e" items="${ModelList}">
				<a href="/CCC/ItemDetailServlet?q=${e.item_id}"><img src="${e.item_image}" class= "searchlist"></a>
			</c:forEach>
		</div>
		<input id="search_input" class="search_hidden" type="checkbox">
		<div class="search_content">
			<form id="ItemSearch" method="POST" action="/CCC/ItemListServlet">
				<table>
					<tr>
						<td class="searchitems"><p class="searchtitle">SEARCH ITEMS</p>
						<label for="search_input" class="btn"><span>×</span></label></td>
					</tr>
					<tr>
						<td class="searchitems" id= "searchtext"><input type="text" name="search_word"></td>
					</tr>
					<tr>
						<td class="searchitems"><p class="category">カテゴリー</p>
						<label><input type="checkbox" name="search_category" value="tops">トップス</label>
						<label><input type="checkbox" name="search_category" value="outer">アウター</label>
						<label><input type="checkbox" name="search_category" value="pants">パンツ</label>
						<label><input type="checkbox" name="search_category" value="skirt">スカート</label>
						<label><input type="checkbox" name="search_category" value="onepiece">ワンピース</label>
						<label><input type="checkbox" name="search_category" value="shoes">シューズ</label>
						<label><input type="checkbox" name="search_category" value="accessories">小物</label></td>
					</tr>
					<tr>
						<td id= "searchtop"><select name="search_brand">
								<option value="">ブランド</option>
								<c:forEach var="e" items="${ModelList}">
									<option value="${e.brand}">${e.brand}</option>
								</c:forEach>
							</select>
						<input type="submit" name="search" value="GO" class="search_submit"></td>
					</tr>
				</table>
			</form>
		</div>
		<label for="search_input"><span  class="search" id="searchBtn"></span></label>
	</main>

<%@ include file="/WEB-INF/jsp/Footer.jsp" %>