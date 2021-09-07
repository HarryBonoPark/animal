<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>분실 동물 상세정보</title>
    <link rel="stylesheet" href="/assets/css/lostDetail.css">
    <script src="http://code.jquery.com/jquery-3.4.1.min.js"></script>
    <script src="/assets/js/lostDetail.js"></script>
</head>
<body>
    <%@include file="/WEB-INF/views/includes/menu.jsp"%>

    <div class="container">
        <h1>분실 동물 상세정보</h1>
        <span>※ 게시글 수정 및 삭제는 관리자에 문의바랍니다.</span>

        <table class="lost_detail_table">
            <tbody class="lost_animal_info">
                <tr>
                    <img src="/image/${detail.image_uri}">
                </tr>
                <tr>
                    <td>이름</td>
                    <td>${detail.animalName}</td>
                </tr>
                <tr>
                    <td>품종</td>
                    <td>${detail.animalKind}</td>
                </tr>
                <tr>
                    <td>품종 기타 설명</td>
                    <td>${detail.animalKindMore}</td>
                </tr>
                <tr>
                    <td>색상</td>
                    <td>${detail.animalColor}</td>
                </tr>
                <tr>
                    <td>성별</td>
                    <td>${detail.animalSex}</td>
                </tr>
                <tr>
                    <td>나이</td>
                    <td>${detail.animalAge}</td>
                </tr>
                <tr>
                    <td>지역</td>
                    <td>${detail.region}</td>
                </tr>
                <tr>
                    <td>분실장소</td>
                    <td>${detail.lostPlace}</td>
                </tr>
                <tr>
                    <td>분실날짜</td>
                    <td>${detail.lostDate}</td>
                </tr>
                <tr>
                    <td>특징</td>
                    <td>${detail.specialMark}</td>
                </tr>
                <tr>
                    <td>등록번호</td>
                    <td>${detail.registNumber}</td>
                </tr>
            </tbody>
            <tbody class="writer_info">
                <h1>여기로 연락주세요 !</h1>
                <tr>
                    <td>신고자</td>
                    <td>${detail.writerName}</td>
                </tr>
                <tr>
                    <td>연락처</td>
                    <td>${detail.writerPhone}</td>
                </tr>
                <tr>
                    <td>이메일</td>
                    <td>${detail.writerEmail}</td>
                </tr>
            </tbody>
            <c:if test="${member.status == 0}">
                <tbody class="button_tbody">
                    <button class="delete_button" data_num="${detail.seq}">삭제하기</button>
                </tbody>
            </c:if>
        </table>
    </div>

    <%@include file="/WEB-INF/views/includes/footer.jsp"%>
</body>
</html>