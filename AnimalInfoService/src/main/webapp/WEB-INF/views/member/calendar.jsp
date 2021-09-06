<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.css"
        integrity="sha512-aOG0c6nPNzGk+5zjwyJaoRUgCdOrfSDhmMID2u4+OIslr0GjpLKo7Xm0Ao3xmpM4T8AmIouRkqwj1nrdVsLKEQ=="
        crossorigin="anonymous" referrerpolicy="no-referrer" />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jqueryui/1.12.1/jquery-ui.structure.min.css"
        integrity="sha512-oM24YOsgj1yCDHwW895ZtK7zoDQgscnwkCLXcPUNsTRwoW1T1nDIuwkZq/O6oLYjpuz4DfEDr02Pguu68r4/3w=="
        crossorigin="anonymous" referrerpolicy="no-referrer" />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jqueryui/1.12.1/jquery-ui.theme.min.css"
        integrity="sha512-9h7XRlUeUwcHUf9bNiWSTO9ovOWFELxTlViP801e5BbwNJ5ir9ua6L20tEroWZdm+HFBAWBLx2qH4l4QHHlRyg=="
        crossorigin="anonymous" referrerpolicy="no-referrer" />
    <script src="http://code.jquery.com/jquery-3.4.1.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.js"
        integrity="sha512-uto9mlQzrs59VwILcLiRYeLKPPbS/bT71da/OEBYEwcdNUk8jYIy+D176RYoop1Da+f9mvkYrmj5MCLZWEtQuA=="
        crossorigin="anonymous" referrerpolicy="no-referrer"></script>
    <link rel="stylesheet" href="/assets/css/calendar.css">
    <link rel="stylesheet" href="/assets/css/reset.css">
    <link href='/resources/fullcalendar-5.9.0/lib/main.css' rel='stylesheet' />
    <script src='/resources/fullcalendar-5.9.0/lib/main.js'></script>
    <script src="/assets/js/calendar.js"></script>
    <script>
        document.addEventListener('DOMContentLoaded', function () {
            
        });
    </script>
    <script>
        console.log("${member}");
        let memberInfo = {
            seq: "${member.seq}",
            id: "${member.id}",
            name: "${member.name}"
        }
    </script>
</head>
<body>
    <%@include file="/WEB-INF/views/includes/menu.jsp"%>
    <div class="dashboard_area">
        <h1>예약하기</h1>
        <div class="dashboard_content">
            <div class="content_left">
                <h1>예약하기</h1>
                <table class="content_table">
                    <tbody>
                        <tr>
                        <td>문 의</td>
                        <td><select id="kind_select">
                            <option value="all">전체</option>
                            <option value="입양 문의">입양 문의</option>
                            <option value="보호센터 문의">보호센터 문의</option>
                            <option value="파양 문의">파양 문의</option>
                        </select>
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
                    </td>
                    </tr>
                    <tr>
                        <td>분실센터</td>
                        <td>
                            <select id="center_select">
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td>이름</td>
                        <td>
                            <input type="text" id="user_name">
                        </td>
                    </tr>
                    <tr>
                        <td>제목</td>
                        <td>
                            <input type="text" id="user_title">
                        </td>
                    </tr>
                    <tr>
                        <td>상세 내용</td>
                        <td>
                            <input type="text" id="user_detail">
                        </td>
                    </tr>
                    <tr>
                        <td>날짜</td>
                        <td>
                            <input type="text" id="user_date">
                        </td>
                    </tr>
                    <tr>
                        <td>시간</td>
                        <td colspan="2">
                            <input type="text" id="user_datetime_h">
                            <input type="text" id="user_datetime_m">
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <button id="cal_btn">예약하기</button>
                            <button id="close_btn">닫기</button>
                        </td>
                    </tr>
                    </tbody>
                </table>
            </div> 
                <tr>
                    <td>
                        <button class="btn">예약하기</button>
                    </td>
                </tr>
                <div class="content_right">
                    <div id='calendar'>
                    </div>
                </div>
            </div>
        </div>
        <%@include file="/WEB-INF/views/includes/footer.jsp"%>
</body>

</html>