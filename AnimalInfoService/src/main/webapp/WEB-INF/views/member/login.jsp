<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>로그인</title>
    <link rel="stylesheet" href="/assets/css/login.css">
    <script src="http://code.jquery.com/jquery-3.4.1.min.js"></script>
    <script src="/assets/js/login.js"></script>


</head>

<body>
    <h1 class="title">로그인</h1>
    <table class="login_table">
        <tbody>
            <tr>
                <td>아이디</td>
                <td colspan="3">
                    <input type="text" placeholder="아이디" id="user_id">
                </td>
            </tr>
            <tr>
                <td>비밀번호</td>
                <td colspan="3">
                    <input type="password" placeholder="비밀번호" id="user_pwd">
                </td>
            </tr>
            <tr>
                <td colspan="4">
                    <button id="login_btn">로그인</button>
                    <td><a href="/join">회원가입</a></td>
                </td>
            </tr>
        </tbody>
    </table>
</body>

</html>