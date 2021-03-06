<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/Header.jsp" %>
<link rel="stylesheet" href="././css/NewItem.css">
<title>CCC｜アイテム登録</title>
    <main>
        <div>
            <!-- fromの始まり -->
            <form action="NewItemServlet" method="post" enctype="multipart/form-data">
            <!--fileのupload-->
            <!--選択された画像の表示枠-->
            <div id="imageplace">
            	<img id="uploadimage">
			</div>
			<div id="uploadbutton">
				<label class="label" id="upbtn">upload
                	<input type="file" id="item_upload" onchange="upimage(this)" name="item_image">
                </label>
            </div>
            <!--破線-->
            <hr id="line">
            <!--カテゴリーのプルダウンメニュー-->
            <div id="div">
                <p id="iteminfo">アイテム情報</p>
                <select id="category" name="category">
                    <option value="トップス">トップス</option>
                    <option value="アウター">アウター</option>
                    <option value="パンツ">パンツ</option>
                    <option value="スカート">スカート</option>
                    <option value="ワンピース">ワンピース</option>
                    <option value="シューズ">シューズ</option>
                    <option value="小物">小物</option>
                </select>

            <!--ブランド入力欄-->
            <div id="brand">
                <p>ブランド：<input type="text" name="brand" style="width: 500px;" placeholder="ブランドを入力してください
                "></p>
            </div>
            <!--サイズ入力欄-->
            <div id="size">
                <p>　サイズ：<input type="text" name="size" style="width: 500px;" placeholder="サイズを入力してください"></p>
            </div>
            <!--サイズ入力欄-->
            <div id = "remarks">
            	<div>
                	<p id="memo">　　メモ：</p>
                </div>
                <div>
                	<textarea name="remarks" rows="8" cols="30"></textarea>
                </div>
            </div>
            </div>
            <!--コーディネート登録ボタン-->
            <div id = "regibtn">
                <input type="submit" id="coordinate_add" value="register">
            </div>
            </form>
        </div>
    </main>


    <!-- 更新のためにコメントアウト -->

<%@ include file="/WEB-INF/jsp/Footer.jsp" %>