<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/Header2.jsp" %>
    <title>CCC｜新規登録</title>
    <link rel="stylesheet" href="././css/NewUser.css">
    	<main>
	        <p class= "register">Sign Up</p>
	        <form id="newregistration_form" method="POST" action="/CCC/NewUserServlet">
	            <!--form id と table class の名前適当＆action空白-->
	            <table class="newregistration">
	                    <tr>
	                      <td>
	                        <label>ID<br>
	                        <input id = "box" type="text" name="user_id">
	                        </label>
	                      </td>
	                    </tr>
	                    <tr>
	                      <td>
	                        <label for = "pass1">Password<br>
	                        <input class = "form-control" type="password" name="password" id = "password"><br>
	                        <!--<input class = "box"  type="password" name="password" placeholder="確認のため再入力してください">-->
	                        </label>
	                      </td>
	                    </tr>

	                    <tr>
	                    	<td>
								<label for = "pass2">
	                    		<input class = "form-control" type="password" name="password" oninput="CheckPassword(this)" placeholder="確認のため再入力してください">
	                    		</label>
	                    	</td>
	                    </tr>
	                      <tr><td class = "button" colspan="2">
	                        <input type="submit" name="submit" value="sign up">
                            <span id="error_message"></span>
	                    </td>
	                </tr>
	            </table>
	        </form>
        </main>
        <script src = "././js/NewUser.js"></script>
<%@ include file="/WEB-INF/jsp/Footer.jsp" %>