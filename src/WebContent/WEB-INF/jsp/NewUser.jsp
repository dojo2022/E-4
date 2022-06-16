<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!DOCTYPE html>
    <html>
    <head>
    <meta charset="UTF-8">
    <title>CCC｜新規登録</title>
    </head>
        <link rel="stylesheet" type="text/css" href="././css/Common.css">
    <body>
        <header>
          <h1 class="logo"><img src="././image/ccc.png" alt="logo"></h1>
            <h2>天気予報</h2>
            <hr>
        </header>
    　　
        <p>新規登録</p>
        <form id="newregistration_form" method="POST" action="">
            <!--form id と table class の名前適当＆action空白-->
            <table class="newregistration">
                <table>
                    <tr>
                      <td>
                        <label>ID<br>
                        <input type="text" name="user_id">
                        </label>
                      </td>
                    </tr>
                    <tr>
                      <td>
                        <label>Password<br>
                        <input type="password" name="password"><br>
                        <input type="password" name="password">
                        </label>
                      </td>
                    </tr>
                      <tr><td colspan="2">
                        <input type="submit" name="submit" value="register">
                    </td>
                </tr>
            </table>
        </form>
<%@ include file="/WEB-INF/jsp/Footer.jsp" %>