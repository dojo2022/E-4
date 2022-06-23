<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/WEB-INF/jsp/Header.jsp" %>
<link rel="stylesheet" href="././css/CoordinateSearch.css">
<title>CCC｜コーディネート検索</title>
	<main>
		<div class = searchmemu>
			<c:forEach var="e" items="${CoordinateList}">
				<a href="/CCC/CoordinateDetailServlet?q=${e.coordinate_id}"><img src="${e.coordinate_image}" class= "searchlist"></a>
			</c:forEach>
		</div>
		<input id="search_input" class="search_hidden" type="checkbox">
		<div class="search_content">
			<form id="CoordinateSearch" method="POST" action="/CCC/CoordinateListServlet">
				<table>
					<tr>
						<td class="searchitems"><p class="searchtitle">SEARCH COORDINATE</p>
						<label for="search_input" class="btn"><span>×</span></label></td>
					</tr>
					<tr>
						<td class="searchitems"><label><input type="radio" name="search_purpose" value="兼用" checked>兼用</label>
						<label><input type="radio" name="search_purpose" value="ビジネス">ビジネス</label>
						<label><input type="radio" name="search_purpose" value="プライベート">プライベート</label></td>
					</tr>
					<tr>
						<td><label><input type="checkbox" name="search_season" value="春">春</label>
						<label><input type="checkbox" name="search_season" value="夏">夏</label>
						<label><input type="checkbox" name="search_season" value="秋">秋</label>
						<label><input type="checkbox" name="search_season" value="冬">冬</label>
						<input type="submit" name="search" value="GO" class="search_submit"></td>
					</tr>
				</table>
			</form>
		</div>
		<label for="search_input"><span class="search" id="searchBtn"></span></label>
	</main>
<%@ include file="/WEB-INF/jsp/Footer.jsp" %>