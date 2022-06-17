<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/Header2.jsp" %>
    <title>CCC｜ログイン</title>
        <main>
            <!--action空白-->
            <form id="login_form" method="POST" action="/CCC/LoginServlet">
                <table>
                    <tr><td class="data">ID</td><td><input type="text" name="ID"></td></tr>
                    <tr><td class="data">PW</td><td><input type="password" name="PW"></td></tr>
                  <tr>
                    <td colspan="2">
                      <input type="submit" name="submit" value="Login">
                      <span id="error_message"></span>
                    <td>
                  </tr>
                </table>
              </form>
            <hr id = "line">
            <a href = "C:\Users\User\Documents\justlooking\newuser.html">新規登録</a>

        </main>

<%@ include file="/WEB-INF/jsp/Footer.jsp" %>