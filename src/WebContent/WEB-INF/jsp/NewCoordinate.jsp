<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CCC｜コーディネート登録</title>
</head>
<body>
    <header>
        <h1 class="logo"><img src="C:\DOJO6\src\WebContent\image\ccc.png" alt=""></h1>
        <div class="logo">ハンバーガーメニュー</div>
        <!-- ハンバーガーメニュー部分 -->
        <div class="nav">
            <!-- ハンバーガーメニューの表示・非表示を切り替えるチェックボックス -->
            <input id="drawer_input" class="drawer_hidden" type="checkbox">
            <!-- ハンバーガーアイコン -->
            <label for="drawer_input" class="drawer_open"><span></span></label>
            <!-- メニュー -->
            <nav class="nav_content">
            <ul class="nav_list">
                <li class="nav_item"><a href="">Your Outfits</a></li>
                <li class="nav_item"><a href="">Your Items</a></li>
                <li class="nav_item"><a href="">Add New Outfit</a></li>
                <li class="nav_item"><a href="">Add New Item</a></li>
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
                <input type="file" id="coordinate_upload">
            </div>
            <!--選択された画像の表示枠-->
            <div>

            </div>
            <!--破線-->
            <hr id="line">
            <!--季節のプルダウンメニュー-->
            <div>
                <p>アイテム情報</p>
                <select id="season_select">
                    <option value="spring">春</option>
                    <option value="summer">夏</option>
                    <option value="fall">秋</option>
                    <option value="winter">冬</option>
                </select>
            </div>
            <!--登録する用途？のラジオボタン-->
            <div>
                <input type="radio" name="scene_select" value="business">ビジネス
                <input type="radio" name="scene_select" value="private">プライベート
                <input type="radio" name="scene_select" value="combination" checked>兼用
            </div>
            <!--コーディネートアイテム追加ボタン-->
            <div>
                <input type="button" id="item_add" value="+">
            </div>
            <!--コーディネート登録ボタン-->
            <div>
                <input type="submit" id="coordinate_add" value="register">
            </div>
            </form>
        </div>
        <div><!-- 画像一覧表示枠 -->

        </div>
    </main>

    <footer>
        <p>&copy;2022 CCC All Rights Reserved</p>
    </footer>

</body>
</html>