<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<!--
	実際には各Servletにアノテーションでタイトルを指定するなど、変更できるように作る。
	-->
	<!-- cssやjsは、Servlet名やjsp名から自動追加することが多い -->
	<link rel="stylesheet" href="././css/Common.css">
</head>
	<body>
    	<h1 class="logo"><img src="././image/ccc.png" alt=""></h1>
        <!-- ヘッダーロゴ -->
		<div id = "weather">
		</div>
        <!-- ハンバーガーメニュー部分 -->
        <div class="nav">

            <!-- ハンバーガーメニューの表示・非表示を切り替えるチェックボックス -->
            <input id="drawer_input" class="drawer_hidden" type="checkbox">

            <!-- ハンバーガーアイコン -->
            <label for="drawer_input" class="drawer_open"><span></span></label>
            <!-- メニュー -->
            <nav class="nav_content">
            <ul class="nav_list">
				<li class="nav_item"><a href="/CCC/CoordinateListServlet">Your Outfits</a></li>
                <li class="nav_item"><a href="/CCC/ItemListServlet">Your Items</a></li>
                <li class="nav_item"><a href="/CCC/NewCoordinateServlet">Add New Outfit</a></li>
                <li class="nav_item"><a href="/CCC/NewItemtServlet">Add New Item</a></li>
            </ul>
            </nav>

        </div>
        <hr>
    <div class="container">

