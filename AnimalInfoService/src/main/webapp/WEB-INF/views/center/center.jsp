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
        <div class="right_area">
            <div class="content_left">
                <p>전국 보호소 수</p>
                <p><span id="centerCntAll">0</span></p>
            </div>
            <!-- <div class="content_right">
                <p>가족을 찾고 있는 강아지</p>
                <p><span id="abandonedDogCntAll">0</span></p>
            </div> -->
        </div>
        <select id="region_select">
            <option value="서울">서울특별시</option>
            <option value="경기">경기도</option>
            <option value="인천">인천광역시</option>
            <option value="세종">세종특별자치시</option>
            <option value="대전">대전광역시</option>
            <option value="대구">대구광역시</option>
            <option value="울산">울산광역시</option>
            <option value="광주">광주광역시</option>
            <option value="부산">부산광역시</option>
            <option value="제주">제주특별자치도</option>
            <option value="경남">경상남도</option>
            <option value="경북">경상북도</option>
            <option value="전남">전라남도</option>
            <option value="전북">전라북도</option>
            <option value="충남">충청남도</option>
            <option value="충북">충청북도</option>
            <option value="강원">강원도</option>
        </select>
        <span class="title">유기동물 보호센터 정보</span>
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
