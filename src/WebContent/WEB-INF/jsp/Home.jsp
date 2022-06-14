<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!DOCTYPE html>
    <html>
    <head>
    <meta charset="UTF-8">
    <title>CCC｜ホーム</title>
    <link rel="stylesheet" type="text/css" href="././css/Common.css">
    </head>
    <body>
        <header>
            <h1 class="logo"><img src="././image/ccc.png" alt="logo"></h1>
            <h2>天気予報</h2>
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
            <hr>
        </header>
        <img src="" alt="コーディネート画像">
        <!--javascriptで触る？-->
        <p>Business</p>
        <p>Private</p>
        <footer>
            <p>&copy;2022 CCC All Rights Reserved</p>
        </footer>

    </body>
    </html>