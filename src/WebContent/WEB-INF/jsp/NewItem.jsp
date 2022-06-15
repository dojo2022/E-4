<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CCC｜アイテム登録</title>
    <link rel="stylesheet" type="text/css" href="././css/Common.css">
</head>
<body>
    <header>
        <h1 class="logo"><img src="././image/ccc.png" alt=""></h1>
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
        <hr id="horizontal_rule">
    </header>

    <main>
        <div>
            <!-- fromの始まり -->
            <form action="test.html" method="post" enctype="multipart/form-data" >
            <!--fileのupload-->
            <div>
                <input type="file" id="item_upload">
            </div>
            <!--選択された画像の表示枠-->
            <div>

            </div>
            <!--破線-->
            <hr id="line">
            <!--カテゴリーのプルダウンメニュー-->
            <div>
                <p>アイテム情報</p>
                <select id="category">
                    <option value="tops">トップス</option>
                    <option value="outer">アウター</option>
                    <option value="pants">パンツ</option>
                    <option value="skirt">スカート</option>
                    <option value="onepiece">ワンピース</option>
                    <option value="shoes">シューズ</option>
                    <option value="accessories">小物</option>
                </select>
            </div>
            <!--ブランド入力欄-->
            <div>
                <p>ブランド：<input type="text" name="brand"></p>
            </div>
            <!--サイズ入力欄-->
            <div>
                <p>サイズ：<input type="text" name="size"></p>
            </div>
            <!--サイズ入力欄-->
            <div>
                <p>メモ：</p>
                <textarea name="remarks" rows="8" cols="30"></textarea>
            </div>
            <!--コーディネート登録ボタン-->
            <div>
                <input type="submit" id="coordinate_add" value="register">
            </div>
            </form>
        </div>
    </main>

    <footer>
        <p>&copy;2022 CCC All Rights Reserved</p>
    </footer>

</body>
</html>