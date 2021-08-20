<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>동물보호센터 정보</title>
    <script src="http://code.jquery.com/jquery-3.4.1.min.js"></script>
    <script src="/assets/js/center.js"></script>
</head>
<body>
    <div class="container">
        <%@include file="/WEB-INF/views/includes/menu.jsp" %>
        <h1 class="title">동물보호센터 정보</h1>
        <div class="right_area">
            <div class="center_list">
                <table id="center_table">
                    <thead>
                        <tr>
                            <td>지역</td>
                            <td>보호소 이름</td>
                            <td>보호소 주소</td>
                            <td>전화번호</td>
                            <td>보호중인 멍멍이</td>
                        </tr>
                    </thead>
                    <tbody id="center_table_body">

                    </tbody>
                </table>
            </div>
        </div>
    </div>
</body>
</html>
