<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/Header2.jsp" %>
    <title>CCC｜ログイン</title>
    	<link rel="stylesheet" href="././css/Login.css">
        <main>
        <p class="login">Login</p>
            <!--action空白-->
            <form id="login_form" method="POST" action="/CCC/LoginServlet">
                <table>
                    <tr><td class="data">ID</td><td><input class = "box" type="text" name="user_id"></td></tr>
                    <tr><td class="data">Password</td><td><input class = "box" type="password" name="password"></td></tr>
                  <tr>
                    <td colspan="2">
                      <input type="submit" name="submit" value="Login"><br>
                      <span id="error_message"></span>
                    <td>
                  </tr>
                </table>
              </form>
			<p class = "line"></p>
            <div class = "href">
            <a class="newuser" href = "/CCC/NewUserServlet">新規登録</a>
			</div>
        </main>
        <script src = "././js/Login.js"></script>

<%@ include file="/WEB-INF/jsp/Footer.jsp" %>