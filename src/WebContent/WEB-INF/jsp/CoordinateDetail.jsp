<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/WEB-INF/jsp/Header.jsp" %>

    <title>CCC｜コーディネート詳細</title>

        <main>
        <c:forEach var="e" items="${CoordinateList}">
            <h1>コーディネート画像</h1>
            <img src="${e.coordinate_image}">
            <hr  id="line">
            <p>アイテム情報</p>
            <p>ブランド:</p><input type="text" size="30" value="${e.brand}"><br>
            <p>サイズ:</p><input type="text" size="30" value="${e.size}"><br>
            <p>アイテム画像</p><img src="${e.item_image}">
            <input type="submit" value="Delete"><br>
            <input type="submit" value="+">
            <input type="submit" value="Delete this look">
</c:forEach>
        </main>

<%@ include file="/WEB-INF/jsp/Footer.jsp" %>