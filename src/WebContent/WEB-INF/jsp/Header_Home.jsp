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
		<header>
    	<h1 class="logo"><a href = "/CCC/HomeServlet"><img src="././image/ccc.png" alt=""></a></h1>
        <!-- ヘッダーロゴ -->
        <!-- ハンバーガーメニュー部分 -->
        <div class="nav">

            <!-- ハンバーガーメニューの表示・非表示を切り替えるチェックボックス -->
            <input id="drawer_input" class="drawer_hidden" type="checkbox">

            <!-- ハンバーガーアイコン -->
            <label for="drawer_input" class="drawer_open"><span></span></label>
            <!-- メニュー -->
            <nav class="nav_content">
            <ul class="nav_list">
				<li class="nav_item"><a id="ham" href="/CCC/CoordinateListServlet">Your Outfits</a></li>
                <li class="nav_item"><a id="ham" href="/CCC/ItemListServlet">Your Items</a></li>
                <li class="nav_item"><a id="ham" href="/CCC/NewCoordinateServlet">Add New Outfit</a></li>
                <li class="nav_item"><a id="ham" href="/CCC/NewItemServlet">Add New Item</a></li>
            </ul>
            </nav>
        </div>
		<div id = "weather">
		    <nav class = "switch">
	            <label class="switch__label">
		        <input type="checkbox" class="switch__input" onclick="confirmChecked();">
		        <span class="switch__content"></span>
		        <span class="switch__circle"></span>
			    </label>
            </nav>

		</div>
        <hr>
        </header>
    <div class="container">

