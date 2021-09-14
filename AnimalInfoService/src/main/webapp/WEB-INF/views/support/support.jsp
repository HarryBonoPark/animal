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
    <script>
        // Model 을 통해 전달받은 데이터를 자바스크립트 변수에 저장
        // js 파일에 넣어버리면 작동 안함.
        let kind_val = '${data.kind}';
        let region_val = '${data.region}';
        let center_val = '${data.careNm}';
    </script>
    <script src="http://code.jquery.com/jquery-3.4.1.min.js"></script>
    <script src="/assets/js/support.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.js"
        integrity="sha512-uto9mlQzrs59VwILcLiRYeLKPPbS/bT71da/OEBYEwcdNUk8jYIy+D176RYoop1Da+f9mvkYrmj5MCLZWEtQuA=="
        crossorigin="anonymous" referrerpolicy="no-referrer"></script>
    
    
</head>
<body>
    <%@include file="/WEB-INF/views/includes/menu.jsp"%>
    <h1 class="title">문의하기</h1>
    <table class="regist_table">
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
                    <option value="all">선택 안함</option>
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
                <td><input type="text" id="user_name" value="${data.name}"></td>
            </tr>
            <tr>
                <td>연락처</td>
                <td><input type="text" id="user_phone" value="${data.phone}"></td>
            </tr>
            <tr>
                <td>비밀번호</td>
                <td><input type="password" id="user_pwd" value="${data.password}"></td>
            </tr>
            <tr>
                <td>비밀번호 확인</td>
                <td><input type="password" id="user_pwd_confirm" value="${data.password}"></td>
            </tr>
            <tr>
                <td>이메일</td>
                <td><input type="text" id="user_email" value="${data.email}"></td>
            </tr>
            <tr>
                <td>제목</td>
                <td><input type="text" id="user_title" value="${data.title}"></td>
            </tr>
            <tr>
                <td>내용</td>
                <td><input type="text" id="user_content" style="height: 150px;" value="${data.content}"></td>
            </tr>
            <tr>
                <td colspan="3"><button id="cancel">등록취소</button><button id="regist">등 록</button>
                    <button id="firmodify">수 정</button></td>
            </tr>
        </tbody>
    </table>
    <%@include file="/WEB-INF/views/includes/footer.jsp"%>
</body>
</html>    