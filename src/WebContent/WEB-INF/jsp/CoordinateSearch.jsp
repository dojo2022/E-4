<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CoordinateSearch</title>
    <link rel="stylesheet" type="text/css" href="././css/Common.css">
<link rel="stylesheet" type="text/css" href="/CCC/css/CoordinateSearch.css">
</head>
<body>
	<header>
		<h1 class="logo">
			<a href="/CCC/HomeServlet">
			<img src="././image/ccc.png" alt="logo"></a>
		</h1>
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
		<h2>天気予報</h2>
		<hr>
	</header>
	<main>
		<c:forEach var="e" items="${coordinateList}">
			<img src="${e.coordinate_image}">
		</c:forEach>
		<input id="search_input" class="search_hidden" type="checkbox">
		<nav class="search_content">
			<form id="CoordinateSearch" method="POST" action="/CCC/CoordinateResultServlet">
				<table>
					<tr>
					<td><p>SEARCH COORDINATE</p></td>
					<td><label for="search_input" class="btn"><span>×</span></label></td>
					</tr>
					<tr>
						<td><input type="text" name="search_word"></td>
					</tr>
					<tr>
						<td><label><input type="radio" name="search_purpose" value="兼用" checked>兼用</label>
						<label><input type="radio" name="search_purpose" value="ビジネス">ビジネス</label>
						<label><input type="radio" name="search_purpose" value="プライベート">プライベート</label></td>
					</tr>
					<tr>
						<td><label><input type="checkbox" name="search_season" value="春">春</label>
						<label><input type="checkbox" name="search_season" value="夏">夏</label>
						<label><input type="checkbox" name="search_season" value="秋">秋</label>
						<label><input type="checkbox" name="search_season" value="冬">冬</label></td>
						<td><input type="submit" name="search" value="GO" class="search_submit"></td>
					</tr>
				</table>
			</form>
		</nav>
		<label for="search_input" class="container"><span>検索</span></label>
	</main>
	<footer>
		<p>&copy;2022 CCC All Rights Reserved</p>
	</footer>
</body>
</html>