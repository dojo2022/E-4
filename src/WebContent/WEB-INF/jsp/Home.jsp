<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/WEB-INF/jsp/Header.jsp" %>
    <title>CCC｜ホーム</title>
      <link rel="stylesheet" href="././css/Home.css">

		<c:forEach var="e" items="${cModel}">
			<a href="/CCC/CoordinateDetailServlet?q=${e.coordinate_id}"><img src="${e.coordinate_image}"></a>
		</c:forEach>

      <img src="" alt="コーディネート画像">
        <!--javascriptで触る？-->
        <main>
        <p id = "changeable">Business</p>
        <p id = "changeable">Private</p>
        </main>
<%@ include file="/WEB-INF/jsp/Footer.jsp" %>