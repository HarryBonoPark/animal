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
    <link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css" integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p" crossorigin="anonymous"/>
    <link rel="stylesheet" href="/assets/css/support.css">
    <script src="http://code.jquery.com/jquery-3.4.1.min.js"></script>
    <script src="/assets/js/support.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.js"
        integrity="sha512-uto9mlQzrs59VwILcLiRYeLKPPbS/bT71da/OEBYEwcdNUk8jYIy+D176RYoop1Da+f9mvkYrmj5MCLZWEtQuA=="
        crossorigin="anonymous" referrerpolicy="no-referrer"></script>
</head>
<body>
    <%@include file="/WEB-INF/views/includes/menu.jsp"%>
    <div class="main_banner_area">
        <div class="main_banner_contents">
            <h1 class="banner_title">반려동물에게 관심과 사랑을 주세요.</h1>
            <p class="banner_text">무엇이 궁금한가요?</p>
            <p class="banner_warn">질문해 주세요</p>
        </div>
    </div>

    <h1 class="title">문의하기</h1>
    <table class="regist_table">
        <tbody>
            <tr>
                <td>이름</td>
                <td><input type="text" id="user_name"></td>
            </tr>
            <tr>
                <td>연락처</td>
                <td><input type="text" id="user_phone"></td>
            </tr>
            <tr>
                <td>비밀번호</td>
                <td><input type="password" id="user_pwd"></td>
            </tr>
            <tr>
                <td>비밀번호 확인</td>
                <td><input type="password" id="user_pwd_confirm"></td>
            </tr>
            <tr>
                <td>이메일</td>
                <td><input type="text" id="user_email"></td>
            </tr>
            <tr>
                <td>제목</td>
                <td><input type="text" id="user_title"></td>
            </tr>
            <tr>
                <td>내용</td>
                <td><input type="text" id="user_content"></td>
            </tr>
            <tr>
                <td>
                    <button id="regist">등 록</button>
                </td>
            </tr>
        </tbody>
    </table>
    <%@include file="/WEB-INF/views/includes/footer.jsp"%>
</body>
</html>    