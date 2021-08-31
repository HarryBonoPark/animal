<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>center detail infomation</title>
    <link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css" integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p" crossorigin="anonymous"/>
    <link rel="stylesheet" href="/assets/css/center.css">
    <script src="http://code.jquery.com/jquery-3.4.1.min.js"></script>
    <script src="/assets/js/center.js"></script>
</head>
<body>
    <%@include file="/WEB-INF/views/includes/menu.jsp"%>
    <div class="container">
        <h1>보호센터 상세정보</h1>

        <table class="center_detail_table">
            <tbody>
                <tr>
                    <td>동물보호센터 명</td>
                    <td>${detail.careNm}</td>
                </tr>
                <tr>
                    <td>유형</td>
                    <td>${detail.divisionNm}</td>
                </tr>
                <tr>
                    <td>동물 보호센터 지정 일자</td>
                    <td>${detail.dsignationDate}</td>
                </tr>
                <tr>
                    <td>구조대상 동물</td>
                    <td>${detail.saveTrgtAnimal}</td>
                </tr>
                <tr>
                    <td>주소</td>
                    <td><span>(도로명)</span> ${detail.careAddr}</td>
                    <td><span>(지번)</span> ${detail.jibunAddr}</td>
                </tr>
                <tr>
                    <td>평일 운영 시간 (분양 시간)</td>
                    <td>${detail.weekOprStime} - ${detail.weekOprEtime} (${detail.weekCellStime} - ${detail.weekCellEtime})</td>
                </tr>
                <tr>
                    <td>주말 운영 시간 (분양 시간)</td>
                    <td>${detail.weekendOprStime} - ${detail.weekendOprEtime} (${detail.weekendCellStime} - ${detail.weekendCellEtime})</td>
                </tr>
                <tr>
                    <td>휴무일</td>
                    <td>${detail.closeDay}</td>
                </tr>
                <tr>
                    <td>수의사</td>
                    <td>${detail.vetPersonCnt} <span>명</span></td>
                </tr>
                <tr>
                    <td>사양 관리사</td>
                    <td>${detail.specsPersonCnt} <span>명</span></td>
                </tr>
                <tr>
                    <td>진료실</td>
                    <td>${detail.medicalCnt} <span>개</span></td>
                </tr>
                <tr>
                    <td>사육실</td>
                    <td>${detail.breedCnt} <span>개</span></td>
                </tr>
                <tr>
                    <td>격리실</td>
                    <td>${detail.quarabtineCnt} <span>개</span></td>
                </tr>
                <tr>
                    <td>사료 보관실</td>
                    <td>${detail.feedCnt} <span>개</span></td>
                </tr>
                <tr>
                    <td>구조 운반용 차량 보유</td>
                    <td>${detail.transCarCnt} <span>대</span></td>
                </tr>
                <tr>
                    <td>전화번호</td>
                    <td>${detail.careTel}</td>
                </tr>
                <tr>
                    <td>마지막 업데이트</td>
                    <td>${detail.dataStdDt}</td>
                </tr>
            </tbody>
        </table>
    </div>

    <%@include file="/WEB-INF/views/includes/footer.jsp"%>
</body>
</html>