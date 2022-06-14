<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <!DOCTYPE html>
    <html>
    <head>
    <meta charset="UTF-8">
    <title>CCC｜アイテム詳細</title>
    </head>
    <link rel="stylesheet" type="text/css" href="././css/Common.css">
    <body>
        <header>
            <h1 class="logo"><img src="././image/ccc.png" alt=""></h1>
            <h2>天気予報</h2>
            <!-- ヘッダーロゴ -->
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
                    <li class="nav_item"><a href="">メニュー1</a></li>
                    <li class="nav_item"><a href="">メニュー2</a></li>
                    <li class="nav_item"><a href="">メニュー3</a></li>
                </ul>
                </nav>

            </div>
            <hr>
        </header>
    </body>

        <main>
            <h1>アイテム画像</h1>
            <hr id="line">
            <p>アイテム情報</p>
            <p>ブランド:</p><input type="text" size="30"><br>
            <p>サイズ:</p><input type="text" size="30"><br>
            <input type="button" value="update"><br>
            <input type="button" value="Delete">


        </main>

        <footer>
            <p>&copy;2022 CCC All Rights Reserved</p>
        </footer>

    </body>
    </html>