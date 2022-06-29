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
						<label for="search_input" class="btn"><span class="cancel">×</span></label></td>
					</tr>
					<tr>
						<td class="searchitems"><label class="item"><input type="radio" name="search_purpose" value="兼用" checked>兼用</label>
						<label class="item"><input type="radio" name="search_purpose" value="ビジネス">ビジネス</label>
						<label class="item"><input type="radio" name="search_purpose" value="プライベート">プライベート</label></td>
					</tr>
					<tr>
						<td><label class="item"><input type="checkbox" name="search_season" value="春">春</label>
						<label class="item"><input type="checkbox" name="search_season" value="夏">夏</label>
						<label class="item"><input type="checkbox" name="search_season" value="秋">秋</label>
						<label class="item"><input type="checkbox" name="search_season" value="冬">冬</label>
						<input type="submit" name="search" value="GO" class="search_submit"></td>
					</tr>
				</table>
			</form>
		</div>
		<label for="search_input"><span class="search" id="searchBtn"><span class="icon">▲</span></span></label>
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