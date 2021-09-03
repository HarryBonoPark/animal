<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="/assets/css/noticeDetail.css">
    <script src="/assets/js/noticeDetail.js"></script>
</head>
<body>
    <%@include file="/WEB-INF/views/includes/menu.jsp"%>
    <div class="container">
        <h1>Notice</h1>
        <div class="tit_page">
            <table>
                <tr>
                    <th>제목</th>
                    <td>${notice.title}</td>
                    <th>작성일</th>
                    <td><fmt:formatDate value="${notice.create_dt}" pattern="yyyy-MM-dd" /></td>
                </tr>
            </table>
        </div>
        <div class="content">
            <td>${notice.content}</td>
        </div>
        <div>
            <button onclick="history.back()" id="back">목록</button>
        </div>
    </div>
    <%@include file="/WEB-INF/views/includes/footer.jsp"%>
</body>
</html>