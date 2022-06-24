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
						<td class="searchitems"><input type="text" name="search_word"></td>
					</tr>
					<tr>
						<!--  <td class="searchitems"><p class="category">カテゴリー</p>
						<label><input type="checkbox" name="search_category" value="tops">トップス</label>
						<label><input type="checkbox" name="search_category" value="outer">アウター</label>
						<label><input type="checkbox" name="search_category" value="pants">パンツ</label>
						<label><input type="checkbox" name="search_category" value="skirt">スカート</label>
						<label><input type="checkbox" name="search_category" value="onepiece">ワンピース</label>
						<label><input type="checkbox" name="search_category" value="shoes">シューズ</label>
						<label><input type="checkbox" name="search_category" value="accessories">小物</label></td>
						-->
						<td class="searchitems"><p class="category">カテゴリー</p>
						<label><input type="checkbox" name="search_category1" value="tops">トップス</label>
						<label><input type="checkbox" name="search_category2" value="outer">アウター</label>
						<label><input type="checkbox" name="search_category3" value="pants">パンツ</label>
						<label><input type="checkbox" name="search_category4" value="skirt">スカート</label>
						<label><input type="checkbox" name="search_category5" value="onepiece">ワンピース</label>
						<label><input type="checkbox" name="search_category6" value="shoes">シューズ</label>
						<label><input type="checkbox" name="search_category7" value="accessories">小物</label></td>
					</tr>
					<tr>
						<td><select name="search_brand">
								<option value="">ブランド</option>
								<c:forEach var="e" items="${brandList}">
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
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script>
$(document).ready(function(){
    $(window).on("scroll", function() {
        scrollHeight = $(document).height(); //ドキュメントの高さ
        scrollPosition = $(window).height() + $(window).scrollTop(); //現在地
        footHeight = $("footer").innerHeight(); //footerの高さ（＝止めたい位置）
        if ( scrollHeight - scrollPosition <= footHeight ) { //ドキュメントの高さと現在地の差がfooterの高さ以下になったら
            $("#searchBtn").css({
                "position":"relative",
                "bottom": footHeight + -60 + 'px'
            });
        } else { //それ以外の場合は
            $("#searchBtn").css({
                "position":"fixed", //固定表示
                "bottom": "15px"
            });
        }
    });
});
</script>
<%@ include file="/WEB-INF/jsp/Footer.jsp" %>