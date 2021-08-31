<%@page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Document</title>
        <link rel="stylesheet" href="/assets/css/reset.css">
        <link rel="stylesheet" href="/assets/css/dog.css">
        <link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css"
                integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p"
                crossorigin="anonymous" />
        <script src="http://code.jquery.com/jquery-3.4.1.min.js"></script>
        <script src="/assets/js/dog.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.js"
                integrity="sha512-uto9mlQzrs59VwILcLiRYeLKPPbS/bT71da/OEBYEwcdNUk8jYIy+D176RYoop1Da+f9mvkYrmj5MCLZWEtQuA=="
                crossorigin="anonymous" referrerpolicy="no-referrer"></script>
</head>

<body>
        <%@include file="/WEB-INF/views/includes/menu.jsp"%>
        <div class="container">
                <h1>유기동물(강아지) 조회</h1>
                <ul class="content_head">
                        <li class="region selected">
                                <span class="plain_name" data-region="all">전국</span>
                        </li>
                        <li class="region">
                                <span class="plain_name" data-region="서울특">서울특별시</span>
                        </li>
                        <li class="region">
                                <span class="plain_name" data-region="경기도">경기도</span>
                        </li>
                        <li class="region">
                                <span class="plain_name" data-region="인천광">인천광역시</span>
                        </li>
                        <li class="region">
                                <span class="plain_name" data-region="세종특">세종특별자치시</span>
                        </li>
                        <li class="region">
                                <span class="plain_name" data-region="대전광">대전광역시</span>
                        </li>
                        <li class="region">
                                <span class="plain_name" data-region="대구광">대구광역시</span>
                        </li>
                        <li class="region">
                                <span class="plain_name" data-region="울산광">울산광역시</span>
                        </li>
                        <li class="region">
                                <span class="plain_name" data-region="광주광">광주광역시</span>
                        </li>
                        <li class="region">
                                <span class="plain_name" data-region="부산광">부산광역시</span>
                        </li>
                        <li class="region">
                                <span class="plain_name" data-region="제주특">제주특별자치도</span>
                        </li>
                        <li class="region">
                                <span class="plain_name" data-region="경상남">경상남도</span>
                        </li>
                        <li class="region">
                                <span class="plain_name" data-region="경상북">경상북도</span>
                        </li>
                        <li class="region">
                                <span class="plain_name" data-region="전라북">전라북도</span>
                        </li>
                        <li class="region">
                                <span class="plain_name" data-region="전라남">전라남도</span>
                        </li>
                        <li class="region">
                                <span class="plain_name" data-region="충청남">충청남도</span>
                        </li>
                        <li class="region">
                                <span class="plain_name" data-region="충청북">충청북도</span>
                        </li>
                        <li class="region">
                                <span class="plain_name" data-region="강원도">강원도</span>
                        </li>
                </ul>
                <div class="dog_area">

                </div>
                <!-- 팝업창 정보 -->
                <div class="dog_form" data-num="1">

                </div>
                <div class="pager_area">
                        <button id="prev">
                                <i class="fas fa-chevron-circle-left"></i>
                        </button>
                        <span class="current">1</span> / <span class="total">7</span>
                        <button id="next">
                                <i class="fas fa-chevron-circle-right"></i>
                        </button>
                </div>
        </div>
        <%@include file="/WEB-INF/views/includes/footer.jsp"%>
</body>

</html>