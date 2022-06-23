 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ include file="/WEB-INF/jsp/Header.jsp" %>
    <title>CCC｜検索結果</title>
    <link rel="stylesheet" href="././css/CoordinateResult.css">
        <main>
        
        <div class="title">
    　　<h2 class="Title_Result">Results</h2>
    </div>
    
     <c:forEach var="tag" items="${tag_list}">
     <p id="search_content"><c:out value="${tag}" /></p>
    </c:forEach>
    
    <h2 class="img_title">コーディネート画像</h2>

    <c:forEach var="li" items="${cImgList}">
    <table>
    <tr>
      <td>
        <a id="coordinate_img" href="/CCC/CoordinateDetailServlet?q=${e.item_id}"><img src="${li}"></a>
      </td>
    </tr>
    </table>
		</c:forEach>
        </main>

<%@ include file="/WEB-INF/jsp/Footer.jsp" %>