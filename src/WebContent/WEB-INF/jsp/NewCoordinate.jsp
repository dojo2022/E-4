<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/WEB-INF/jsp/Header.jsp" %>
<link rel="stylesheet" href="././css/NewCoordinate.css">

<title>CCC｜コーディネート登録</title>
    <main>
        <div>
            <!-- fromの始まり -->
            <form action="NewCoordinateServlet" method="post" enctype="multipart/form-data" name = "coordinateregister">
	            <!--fileのupload-->
	            <div>
	                <input type="file" id="coordinate_upload">
	            </div>
	            <!--選択された画像の表示枠-->
	            <div id="imageplace">
	            	<img id="uploadimage" src="././image/白.jpg">
				</div>
				<div id="uploadbutton">
					<label class="label" id="upbtn">upload
	                	<input type="file" id="item_upload" onchange="upimage(this)">
	                </label>
	            </div>
	            <div>
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
<!--
コーディネートアイテム追加ボタン
<div>
<input type="button" id="item_add" value="+">
</div>
-->

						<div class = "category">
						<p id = "category">カテゴリー</p>
						<div class = "garments">
						<label class = "label"><input type="checkbox" name="search_category" value="tops" onchange="itemsearch()">トップス</label>
						<label class = "label"><input type="checkbox" name="search_category" value="outer" onchange="itemsearch()">アウター</label>
						<label class = "label"><input type="checkbox" name="search_category" value="pants" onchange="itemsearch()">パンツ</label>
						<label class = "label"><input type="checkbox" name="search_category" value="skirt" onchange="itemsearch()">スカート</label><br>
						<label class = "label"><input type="checkbox" name="search_category" value="onepiece" onchange="itemsearch()">ワンピース</label>
						<label class = "label"><input type="checkbox" name="search_category" value="shoes" onchange="itemsearch()">シューズ</label>
						<label class = "label"><input type="checkbox" name="search_category" value="accessories" onchange="itemsearch()">小物</label>
						</div>
						</div>



		            	<!--コーディネート登録ボタン-->
		            	<div id="coordinate_add">
		                	<input type="submit" onclick="imageError()" id="coordinate_add" value="register">
		            	</div>

		            	<!-- 選択アイテム表示欄 -->
		            	<div id="selectitems">

		            	</div>
					</div>
		        	<div id="allitemimage"><!-- 画像一覧表示枠 -->
		        	<c:set var="cnt" value="0"/>
						<table id = "searchimage">
							<tbody id = "search-tbody">
								<c:forEach var="e" items="${modelList}">
 									<c:if test="${cnt%3==0}">
										<tr>
									</c:if>
										<td>
											<input type="hidden" value = "${e.item_id}" id = "itemimage${e.item_id}">
											<input type="hidden" value = "${e.category}">
											<img src="${e.item_image}" id = "itemimage" name="${cnt+1}">
										</td>
									<c:set var="cnt" value="${cnt+1}"/>
									<c:if test="${cnt%3==0}">
										</tr>
									</c:if>
									</c:forEach>
    						</tbody>
						</table>
		        	</div>
		        </div>
	        </form>
	   </div>

    </main>

<script src ="././js/NewCoordinate.js"></script>
<!-- <script src="././js/RealTimeSort.js"></script> -->
<%@ include file="/WEB-INF/jsp/Footer.jsp" %>