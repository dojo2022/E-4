 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/Header.jsp" %>
<link rel="stylesheet" href="././css/NewCoordinate.css">
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
	            <div id="imageplace">
	            	<img id="uploadimage">
				</div>
				<div id="uploadbutton">
					<label class="label" id="upbtn">upload
	                	<input type="file" id="item_upload" onchange="upimage(this)">
	                </label>
	            </div>
	            <!--破線-->
	            <hr id="line">
	            <div id="side_by_side">
	            	<div id="itemform">
	            		<!--季節のプルダウンメニュー-->
	            		<div>
	                		<p id="iteminfo">アイテム情報</p>
	                		<select id="season_select">
	                    		<option value="spring">春</option>
	                    		<option value="summer">夏</option>
	                    		<option value="fall">秋</option>
	                    		<option value="winter">冬</option>
	                		</select>
	            		</div>
	            		<!--登録する用途？のラジオボタン-->
	            		<div id="scene_select">
		                	<input type="radio" name="scene_select" value="business">ビジネス
		                	<input type="radio" name="scene_select" value="private">プライベート<br>
		                	<input type="radio" name="scene_select" value="combination" checked>兼用
		            	</div>
	            		<!--コーディネートアイテム追加ボタン-->
	            		<div>
	                		<input type="button" id="item_add" value="+">
	            		</div>

		            	<!--コーディネート登録ボタン-->
		            	<div id="coordinate_add">
		                	<input type="submit" id="coordinate_add" value="register">
		            	</div>
					</div>
		        	<div id="allitemimage"><!-- 画像一覧表示枠 -->

		        	</div>
		        </div>
	        </form>
	   </div>

    </main>


<%@ include file="/WEB-INF/jsp/Footer.jsp" %>