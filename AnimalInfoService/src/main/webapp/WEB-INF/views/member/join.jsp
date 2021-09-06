<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="/assets/css/join.css">
    <script src="http://code.jquery.com/jquery-3.4.1.min.js"></script>
    <script src="/assets/js/join.js"></script>  
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.js"
            integrity="sha512-uto9mlQzrs59VwILcLiRYeLKPPbS/bT71da/OEBYEwcdNUk8jYIy+D176RYoop1Da+f9mvkYrmj5MCLZWEtQuA=="
            crossorigin="anonymous" referrerpolicy="no-referrer"></script>
            
    <script>
        <c:if test ="${member !=null}">
            location.href="/";
        </c:if>
    </script>
    <script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
    <script>
    window.onload = function(){
         //주소입력칸을 클릭하면
            //카카오 지도 발생
            $("#chk_addr").click(function(){
                new daum.Postcode({
                    oncomplete: function(data) { //선택시 입력값 세팅
                        document.getElementById("user_address").value = data.address; // 주소 넣기
                        document.querySelector("input[name=user_address_detail]").focus(); //상세입력 포커싱
                        
                    }
                }).open();
                self.close();
            });
        }
    </script>
</head>
<body>
    <%@include file="/WEB-INF/views/includes/menu.jsp"%>
    <h1 class="title">회원가입</h1>
    <table class="join_table">
        <tbody>
            <tr>
                <td>아이디</td>
                <td>
                    <input type="text" id="user_id">
                </td>
                <td>
                    <button id="chk_id">중복확인</button>
                </td>
            </tr>
            <tr>
                <td>비밀번호</td>
                <td>
                    <input type="password" id="user_pwd">
                </td>
            </tr>
            <tr>
                <td>비밀번호 확인</td>
                <td>
                    <input type="password" id="user_pwd_confirm">
                </td>
            </tr>
            <tr>
                <td>이름</td>
                <td>
                    <input type="text" id="user_name">
                </td>
            </tr>
            <tr>
                <td>이메일</td>
                <td>
                    <input type="text" id="user_email">
                </td>
                <td>
                    <button id="chk_email">중복확인</button>
                </td>
            </tr>
            <tr>
                <td>생년월일</td>
                <td>
                    <input type="text" id="user_birth_year">
                    <span>년</span>
                    <input type="text" id="user_birth_month">
                    <span>월</span>
                    <input type="text" id="user_birth_date">
                    <span>일</span>
                </td>
            </tr>
            <tr>
                <td>성별</td>
                <td>
                    <select id="user_gen">
                        <option value="0" selected>남</option>
                        <option value="1">여</option>
                        <option value="2">선택안함</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td>주소</td>
                <td>
                    <input type="text" id="user_address">
                    <span></span>
                    <input type="text" id="user_address_detail">
                </td>
                <td><button id="chk_addr">주소확인</button></td>
            </tr>
            <tr>
                <td>전화번호</td>
                <td>
                    <input type="text" id="user_phone">
                </td>
            </tr>
            <tr>
                <td colspan="3">
                    <button id="join">회원가입</button>
                </td>
            </tr>
        </tbody>
    </table>
    <%@include file="/WEB-INF/views/includes/footer.jsp"%>
</body>
</html>