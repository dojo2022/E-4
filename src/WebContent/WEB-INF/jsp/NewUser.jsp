<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/Header2.jsp" %>
    <title>CCC｜新規登録</title>
    <link rel="stylesheet" href="././css/NewUser.css">
    	<main>
	        <p>新規登録</p>
	        <form id="newregistration_form" method="POST" action="/CCC/NewUserServlet">
	            <!--form id と table class の名前適当＆action空白-->
	            <table class="newregistration">
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
        </main>
<%@ include file="/WEB-INF/jsp/Footer.jsp" %>