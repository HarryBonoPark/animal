<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
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
        <div class="explain">
            <span>※ 게시글 수정 및 삭제는 관리자에 문의바랍니다.</span>
        </div>

        <table class="animal_table">
            <tbody>
                <tr>
                    <img src="/image/${detail.image_uri}" class="animal_img">
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
                    <td><fmt:formatDate value="${detail.lostDate}" pattern="yyyy-MM-dd" /></td>
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
            <table class="writer_table">
                <tbody>
                    <h1 class="writer_info">여기로 연락주세요 !</h1>
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
            </table>
            <c:if test="${member.status == 0}">
                <div class="button_area">
                    <button class="modify_button" data_num="${detail.seq}">수정하기</button>
                    <button class="delete_button" data_num="${detail.seq}">삭제하기</button>
                </div>
            </c:if>
        </table>
    </div>

    <%@include file="/WEB-INF/views/includes/footer.jsp"%>
</body>
</html>