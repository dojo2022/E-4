 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ include file="/WEB-INF/jsp/Header.jsp" %>
    <title>CCC｜検索結果</title>
    <link rel="stylesheet" href="././css/CoordinateResult.css">
        <main>
    　　<h1 class="Title_Result">Results</h1>
    <p id="search_content">
     <c:forEach var="tag" items="${CoordinateItemList}">
    </c:forEach>
    </p>
    <h1>コーディネート画像</h1>
    <c:forEach var="c" items="${}">
			<a href="/CCC/CoordinateDetailServlet?q=${e.coordinate_id}"><img src="${e.coordinate_image}"></a>
		</c:forEach>
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