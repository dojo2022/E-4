<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<html>
	<head>
	<meta charset="UTF-8">
	<title>CCC｜エラー</title>
	   <link rel="stylesheet" type="text/css" href="././css/Common.css">
	    <link rel="stylesheet" type="text/css" href="././css/Error.css">
	</head>
	    <body>
	        <header>
	            <h1 class="logo"><img src="././image/ccc.png" alt=""></h1>
	            <h2>天気予報</h2>
	            <!-- ヘッダーロゴ -->
	            <hr>
	        </header>

	        <main>
				<h50>Oops！</h50>
				<p><h30>ログインに失敗しました</h30></p>
				<button onclick="location.href='Login.html'">Back to Login</button>
	        </main>

<%@ include file="/WEB-INF/jsp/Footer.jsp" %>