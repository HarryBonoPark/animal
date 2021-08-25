<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>동물보호센터 정보</title>
    <link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css" integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p" crossorigin="anonymous"/>
    <link rel="stylesheet" href="/assets/css/center.css">
    <script src="http://code.jquery.com/jquery-3.4.1.min.js"></script>
    <script src="/assets/js/center.js"></script>
</head>
<body>
    <%@include file="/WEB-INF/views/includes/menu.jsp"%>
    <div class="container">
        <div class="right_area">
            <div class="content_left">
                <span>전국에</span>
                <span><span id="centerCntAll">0</span></span>
                <span>개의 보호소가 있어요</span>
            </div>
        </div>
        <select id="region_select">
            <option value="서울특">서울특별시</option>
            <option value="부산광">부산광역시</option>
            <option value="대구광">대구광역시</option>
            <option value="인천광">인천광역시</option>
            <option value="광주광">광주광역시</option>
            <option value="대전광">대전광역시</option>
            <option value="울산광">울산광역시</option>
            <option value="세종특">세종특별자치시</option>
            <option value="경기도">경기도</option>
            <option value="강원도">강원도</option>
            <option value="충청북">충청북도</option>
            <option value="충청남">충청남도</option>
            <option value="전라북">전라북도</option>
            <option value="전라남">전라남도</option>
            <option value="경상북">경상북도</option>
            <option value="경상남">경상남도</option>
            <option value="제주특">제주특별자치도</option>
        </select>
        <span class="title">에서는 <span class="centerRegionCnt">0</span>개의 보호소가 강아지를 관리하고 있어요</span>
        <div class="list">
            <table id="center_table">
                <thead>
                    <tr>
                        <td>No.</td>
                        <td>보호소</td>
                        <td>전화번호</td>
                        <td>주소</td>
                    </tr>
                </thead>
                
            </table>
            <div class="center_page_area">
                <button id="center_prev"><i class="fas fa-chevron-circle-left"></i></button>
                <span class="current">1</span> / <span class="total">2</span>
                <button id="center_next"><i class="fas fa-chevron-circle-right"></i></button>
            </div>
        </div>
    </div>
    <%@include file="/WEB-INF/views/includes/footer.jsp"%>
</body>
</html>
