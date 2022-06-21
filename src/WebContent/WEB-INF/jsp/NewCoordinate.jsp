 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/Header.jsp" %>

<title>CCC｜コーディネート登録</title>
    <main>
        <div>
            <!-- fromの始まり -->
            <form action="test.html" method="post" enctype="multipart/form-data" >
            <!--fileのupload-->
            <div>
                <input type="file" id="coordinate_upload">
            </div>
            <!--選択された画像の表示枠-->
            <img>


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


<%@ include file="/WEB-INF/jsp/Footer.jsp" %>