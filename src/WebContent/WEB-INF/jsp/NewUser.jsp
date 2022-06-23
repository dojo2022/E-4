<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/Header2.jsp" %>
    <title>CCC｜新規登録</title>
    <link rel="stylesheet" href="././css/NewUser.css">
    	<main>
	        <p class= "register">Sign Up</p>
	        <form id="newregistration_form" class="validationForm" novalidate method="POST" action="/CCC/NewUserServlet">
	            <!--form id と table class の名前適当＆action空白-->
	            <table class="newregistration">
	                    <tr>
	                     <td>
	                        <label>ID<br>
	                        <input id = "user_id" class = "box" type="text" name="user_id">
	                        </label>
	                      </td>
	                    </tr>
	                    <tr>
	                      <td>
	                        <label>Password<br>
	                        <div><label for="input1">
	                        <input id = "pass1" class = "box"  type="password" name="password"></label></div><br>
	                        <div><label for="input2">
	                        <input id = "pass2" class = "box" data-equal-to = "pass1" type="password" name="password" placeholder="確認のため再入力してください"></label></div>

	                        </label>
	                      </td>
	                    </tr>
	            </table>
	            	<div class = "login"><tr><td class = "button" colspan="2">
	                        <input type="submit" name="submit" value="sign up">
	                    </td>
	                </tr>
	                </div>

	            <div class="warning">
	            <span id = "warning">
	            </span>
				</div>

	        </form>

        </main>
        <script src = "././js/NewUser.js"></script>
<%@ include file="/WEB-INF/jsp/Footer.jsp" %>