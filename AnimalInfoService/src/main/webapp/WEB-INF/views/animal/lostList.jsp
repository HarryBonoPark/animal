<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>lost animal</title>

    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.css" integrity="sha512-aOG0c6nPNzGk+5zjwyJaoRUgCdOrfSDhmMID2u4+OIslr0GjpLKo7Xm0Ao3xmpM4T8AmIouRkqwj1nrdVsLKEQ==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jqueryui/1.12.1/jquery-ui.structure.min.css" integrity="sha512-oM24YOsgj1yCDHwW895ZtK7zoDQgscnwkCLXcPUNsTRwoW1T1nDIuwkZq/O6oLYjpuz4DfEDr02Pguu68r4/3w==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jqueryui/1.12.1/jquery-ui.theme.min.css" integrity="sha512-9h7XRlUeUwcHUf9bNiWSTO9ovOWFELxTlViP801e5BbwNJ5ir9ua6L20tEroWZdm+HFBAWBLx2qH4l4QHHlRyg==" crossorigin="anonymous" referrerpolicy="no-referrer" />

    <link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css" integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p" crossorigin="anonymous"/>
    <link rel="stylesheet" href="/assets/css/lostList.css">

    <script src="http://code.jquery.com/jquery-3.4.1.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.js" integrity="sha512-uto9mlQzrs59VwILcLiRYeLKPPbS/bT71da/OEBYEwcdNUk8jYIy+D176RYoop1Da+f9mvkYrmj5MCLZWEtQuA==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
    <script src="/assets/js/lostList.js"></script>
</head>
<body>
    <%@include file="/WEB-INF/views/includes/menu.jsp"%>

    <div class="container">
        <h1> 분실 동물 </h1>
        <span>여기는 동물을 분실한 경우 동물정보를 올려 분실 동물을 찾을 수 있는 공간입니다.</span>
        <span>동물을 분실한 경우 동물보호법 제12조 제1항 및 같은 법 시행규칙 제8조 제1항 및 제9조 제2항에 따라</span>
        <span>등록대상동물을 10일 이내 시장, 군수, 구청장에게 분실 신고하셔야 합니다.</span>
        <span>로그인 후, 분실 신고를 등록할 수 있습니다.</span>

        <div>
            <h1>search</h1>
            <p>날짜</p>
            <input type="text" id="startDate"><span> ~ </span>
            <input type="text" id="endDate">
            <span>날짜는 분실 날짜 기준입니다.</span>
            <p>지역</p>
            <select id="region_select">
                <option value="all">전국</option>
                <option value="서울특별시">서울특별시</option>
                <option value="부산광역시">부산광역시</option>
                <option value="대구광역시">대구광역시</option>
                <option value="인천광역시">인천광역시</option>
                <option value="광주광역시">광주광역시</option>
                <option value="대전광역시">대전광역시</option>
                <option value="울산광역시">울산광역시</option>
                <option value="세종특별자치시">세종특별자치시</option>
                <option value="경기도">경기도</option>
                <option value="강원도">강원도</option>
                <option value="충청북도">충청북도</option>
                <option value="충청남도">충청남도</option>
                <option value="전라북도">전라북도</option>
                <option value="전라남도">전라남도</option>
                <option value="경상북도">경상북도</option>
                <option value="경상남도">경상남도</option>
                <option value="제주특별자치도">제주특별자치도</option>
            </select>
        </div>

        <div>
            <span>총 <span class="lost_cnt">0</span>건의 분실동물 신고가 있습니다.</span>
        </div>

        <div class="lost_area">
            
        </div>

        <div class="lost_page_area">
            <button id="lost_page_prev">&lt;</button>
            <span class="current_page">1</span> / <span class="total_page">10</span>
            <button id="lost_page_next">&gt;</button>
        </div>
    </div>
    <c:if test="${member != null}">
        <button class="lost_regist" onclick="location.href='/lost'">분실 신고하기</button>
    </c:if>

    <%@include file="/WEB-INF/views/includes/footer.jsp"%>
</body>
</html>