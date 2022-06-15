<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ItemSearch</title>
    <link rel="stylesheet" type="text/css" href="././css/Common.css">
<link rel="stylesheet" type="text/css" href="/CCC/css/ItemSearch.css">
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
		<c:forEach var="e" items="${itemList}">
			<img src="${e.item_image}">
		</c:forEach>
		<input id="search_input" class="search_hidden" type="checkbox">
		<div class="search_content">
			<form id="ItemSearch" method="POST" action="/CCC/ItemResultServlet">
				<table>
					<tr>
						<td><p>SEARCH ITEMS</p></td>
						<td><label for="search_input" class="btn"><span>×</span></label></td>
					</tr>
					<tr>
						<th><p>カテゴリー</p></th>
						<td><label><input type="checkbox" name="search_category" value="トップス">トップス</label>
						<label><input type="checkbox" name="search_category" value="アウター">アウター</label>
						<label><input type="checkbox" name="search_category" value="パンツ">パンツ</label>
						<label><input type="checkbox" name="search_category" value="スカート">スカート</label>
						<label><input type="checkbox" name="search_category" value="ワンピース">ワンピース</label>
						<label><input type="checkbox" name="search_category" value="シューズ">シューズ</label>
						<label><input type="checkbox" name="search_category" value="小物">小物</label></td>
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
	<footer>
		<p>&copy;2022 CCC All Rights Reserved</p>
	</footer>
</body>
</html>