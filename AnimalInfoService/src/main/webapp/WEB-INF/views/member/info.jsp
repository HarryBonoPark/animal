<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
    response.setHeader("Cache-Control", "no-store");
    response.setHeader("Pragma", "no-cache");
    response.setDateHeader("Expires", 0);
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="/assets/css/join.css">
    <script src="http://code.jquery.com/jquery-3.4.1.min.js"></script>
    <script>
        let gen_val = '${member.gen}';
    </script>
    <script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
    <script>
        window.onload = function(){
             //주소입력칸을 클릭하면
                //카카오 지도 발생
                $("#chk_addr").click(function(){
                    new daum.Postcode({
                        oncomplete: function(data) { //선택시 입력값 세팅
                            $("#user_address").val(data.address); // 주소 넣기
                            $("#user_address_detail").focus(); //상세입력 포커싱
                            
                        }
                    }).open();
                    self.close();
                });
            }
        </script>
        <script src="/assets/js/info.js"></script>
</head>
<body>
    <%@include file="/WEB-INF/views/includes/menu.jsp"%>
    <h1 class="title">회원 정보 수정</h1>
    <table class="join_table">
        <tbody>
            <tr id="user_id_tr" data-seq='${member.seq}'>
                <td>아이디</td>
                <td>
                    <input type="text" id="user_id" value="${member.id}">
                </td>
                <td>
                    <button id="chk_id">중복확인</button>
                </td>
            </tr>
            <tr>
                <td>비밀번호</td>
                <td>
                    <input type="password" id="user_pwd" value="${member.password}">
                </td>
            </tr>
            <tr>
                <td>비밀번호 확인</td>
                <td>
                    <input type="password" id="user_pwd_confirm" value="${member.password}">
                </td>
            </tr>
            <tr>
                <td>이름</td>
                <td>
                    <input type="text" id="user_name" value="${member.name}">
                </td>
            </tr>
            <tr>
                <td>이메일</td>
                <td>
                    <input type="text" id="user_email" value="${member.email}">
                </td>
                <td>
                    <button id="chk_email">중복확인</button>
                </td>
            </tr>
            <tr>
                <td>성별</td>
                <td>
                    <select id="user_gen">
                        <option value="0">남</option>
                        <option value="1">여</option>
                        <option value="2">선택안함</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td>주소</td>
                <td>
                    <input type="text" id="user_address" value="${member.address}">
                </td>
                <td>    
                    <button id="chk_addr">주소확인</button>
                </td>
            </tr>
            <tr>
                <td>상세주소</td>
                <td>
                    <input type="text" id="user_address_detail" value="${member.address_detail}">
                </td>
            </tr>
            <tr>
                <td>전화번호</td>
                <td>
                    <input type="text" id="user_phone" value="${member.phone}"> 
                </td>
            </tr>
            <tr>
                <td>등 급</td>
                <td>
                    <input type="text" id="user_status" value="${member.status}" readonly> 
                </td>
            </tr>
            <tr>
                <td colspan="3">
                    <button id="cancel">등록취소</button><button id="join_modify">수정하기</button>
                </td>
            </tr>
        </tbody>
    </table>
    <%@include file="/WEB-INF/views/includes/footer.jsp"%>
</body>
</html>