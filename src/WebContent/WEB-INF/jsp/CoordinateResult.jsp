 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ include file="/WEB-INF/jsp/Header.jsp" %>
    <title>CCC｜検索結果</title>
        <main>
    　　<h1 class="Title_Result">Results</h1>
    <p id="searchword">検索タグ</p>
    <%--
     <table border="1" style="border-collapse: collapse">
      <c:forEach items="${ requestScope.imgtableList }" var="item">
       <tr>
       <td><c:out value="${ imgtable.id }" /></td>
       <td><c:out value="${ imgtable.faleName }" /></td>
        <td><a href="#"><img style="width: 100px; height: 100px" src="getImage?id=${ imgtable.id }"></a></td>
        </tr> </c:forEach> </table>
        --%>
        </main>

<%@ include file="/WEB-INF/jsp/Footer.jsp" %>