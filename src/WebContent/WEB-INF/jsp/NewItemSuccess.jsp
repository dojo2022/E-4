<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/Header.jsp" %>
    <title>CCC｜アイテム登録成功</title>
	<link rel="stylesheet" href="././css/Success.css">
    <main>
    	<p id = "hurray">Hurray!</p>
    	<p>登録しました</p>
    	<div class="buttonBack">
    	<button onclick="location.href='/CCC/ItemListServlet'">Back to Your Items</button>
    	</div>
    </main>
<%@ include file="/WEB-INF/jsp/Footer.jsp" %>