<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!DOCTYPE html>
    <html>
    <head>
    <meta charset="UTF-8">
    <title>CCC｜ログイン</title>
    </head>
    <body>
        <header>
            <h1 class="logo"><img src="C:\DOJO6\src\WebContent\image\ccc.png" alt=""></h1>
            <h2>天気予報</h2>
            <hr>
        </header>
    
        <main>
            <!--action空白-->
            <form id="login_form" method="GET" action="">
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
        
        <footer>
            <p>&copy;2022 CCC All Rights Reserved</p>
        </footer>
    
    </body>
    </html>