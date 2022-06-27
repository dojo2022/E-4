<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/WEB-INF/jsp/Header.jsp" %>
    <title>CCC｜ホーム</title>
      <link rel="stylesheet" href="././css/Home.css">

		<c:forEach var="e" items="${cModel}">
			<a href="/CCC/CoordinateDetailServlet?q=${e.coordinate_id}"><img src="${e.coordinate_image}"></a>
		</c:forEach>

        <!--javascriptで触る？-->
<meta name="viewport" content="width=device-width,initial-scale=1.0">
<!--==============レイアウトを制御する独自のCSSを読み込み===============-->
<link rel="stylesheet" type="text/css" href="https://coco-factory.jp/ugokuweb/wp-content/themes/ugokuweb/data/reset.css">
<link rel="stylesheet" type="text/css" href="Home.css">
</head>

<body>

<div class="wrapper">

<div class="tabs">
  <input id="business" type="radio" name="tab_item" checked>
  <label class="tab_item" for="business">Business</label>
  <input id="private" type="radio" name="tab_item">
  <label class="tab_item" for="private">Casual</label>
  <div class="tab_content" id="business_content">
    <div class="tab_content_description">
<ul class="slider">
    <li class="slider-item slider-item01"></li>
    <li class="slider-item slider-item02"></li>
    <li class="slider-item slider-item03"></li>
  </ul>
    </div>
  </div>
  <div class="tab_content" id="private_content">
    <div class="tab_content_description">
<ul class="slider">
    <li class="slider-item slider-item01"></li>
    <li class="slider-item slider-item02"></li>
    <li class="slider-item slider-item03"></li>
  </ul>
    </div>
  </div>
</div>
<!--/wrapper--></div>

<script src="https://code.jquery.com/jquery-3.4.1.min.js" integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo=" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick.min.js"></script>
<script src="Home.js"></script>





<!--         <main>
        <ul id="switch">
			<li id="business">Business</li>
			<li id="casual">Casual</li>
		</ul>

        <p id = "switch1">Business</p>
        <p id = "switch2">Casual</p>
        </main>
 -->        <script src = "././js/Home.js"></script>
<%@ include file="/WEB-INF/jsp/Footer.jsp" %>
