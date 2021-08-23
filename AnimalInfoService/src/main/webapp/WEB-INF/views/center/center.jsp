<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>동물보호센터 정보</title>
    <link rel="stylesheet" href="/assets/css/center.css">
    <script src="http://code.jquery.com/jquery-3.4.1.min.js"></script>
    <script src="/assets/js/center.js"></script>
</head>
<body>
    <div class="container">
        <%@include file="/WEB-INF/views/includes/menu.jsp"%>
        <h1 class="title">center information</h1>
        <div class="list">
            <table id="center_table">
                <thead>
                    <tr>
                        <!-- <td>지역</td> -->
                        <td>보호소</td>
                        <td>전화번호</td>
                        <td>보호소 주소</td>
                        <td>보호중</td>
                    </tr>
                </thead>
                <tbody id="center_tbody">

                </tbody>
            </table>
            <div class="center_page_area">
                <button id="center_prev">&lt;</button>
                <span class="current">1</span> / <span class="total">23</span>
                <button id="center_next">&gt;</button>
            </div>
        </div>
    </div>
</body>
</html>
