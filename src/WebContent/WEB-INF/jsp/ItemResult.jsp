<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <!DOCTYPE html>
    <html>
    <head>
    <meta charset="UTF-8">
    <title>CCC｜ホーム</title>
    </head>
    <link rel="stylesheet" type="text/css" href="././css/Common.css">
    <body>
        <header>
            <h1 class="logo"><img src="././image/ccc.png" alt=""></h1>
            <h2>天気予報</h2>
            <!-- ヘッダーロゴ -->
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
            <hr>
        </header>
    </body>

        <main>
        <h1 class="Title_Result">Result</h1>
    <p id="searchword">検索タグ</p>
    <%--
     <table border="1" style="border-collapse: collapse">
      <c:forEach items="${ requestScope.imgtableList }" var="item">
       <tr>
       <td><c:out value="${ imgtable.id }" /></td>
       <td><c:out value="${ imgtable.faleName }" /></td>
        <td><a href="#"><img style="width: 100px; height: 100px" src="getImage?id=${ imgtable.id }"></a></td>
        </tr> </c:forEach> </table>
        --%>
        </main>

        <footer>
            <p>&copy;2022 CCC All Rights Reserved</p>
        </footer>

    </body>
    </html>