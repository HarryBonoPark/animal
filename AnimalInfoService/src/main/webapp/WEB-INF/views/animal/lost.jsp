<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>lost animal</title>

    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.css" integrity="sha512-aOG0c6nPNzGk+5zjwyJaoRUgCdOrfSDhmMID2u4+OIslr0GjpLKo7Xm0Ao3xmpM4T8AmIouRkqwj1nrdVsLKEQ==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jqueryui/1.12.1/jquery-ui.structure.min.css" integrity="sha512-oM24YOsgj1yCDHwW895ZtK7zoDQgscnwkCLXcPUNsTRwoW1T1nDIuwkZq/O6oLYjpuz4DfEDr02Pguu68r4/3w==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jqueryui/1.12.1/jquery-ui.theme.min.css" integrity="sha512-9h7XRlUeUwcHUf9bNiWSTO9ovOWFELxTlViP801e5BbwNJ5ir9ua6L20tEroWZdm+HFBAWBLx2qH4l4QHHlRyg==" crossorigin="anonymous" referrerpolicy="no-referrer" />

    <link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css" integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p" crossorigin="anonymous"/>
    <link rel="stylesheet" href="/assets/css/lost.css">

    <script src="http://code.jquery.com/jquery-3.4.1.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.js" integrity="sha512-uto9mlQzrs59VwILcLiRYeLKPPbS/bT71da/OEBYEwcdNUk8jYIy+D176RYoop1Da+f9mvkYrmj5MCLZWEtQuA==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
    <script src="/assets/js/lost.js"></script>
</head>
<body>
    <%@include file="/WEB-INF/views/includes/menu.jsp"%>

    <div class="container">
        <table class="title_table">
            <tbody>
                <h1>분실 신고</h1>
                <span class="title_explain"><span class="red">*</span> 표시는 필수 입력 항목입니다.</span>
                <tr>
                    <td>지역 <span class="red">*</span></td>
                    <td>
                        <select id="region_select">
                            <option value="서울특별시">서울특별시</option>
                            <option value="부산광역시">부산광역시</option>
                            <option value="대구광역시">대구광역시</option>
                            <option value="인천광역시">인천광역시</option>
                            <option value="광주광역시">광주광역시</option>
                            <option value="대전광역시">대전광역시</option>
                            <option value="울산광역시">울산광역시</option>
                            <option value="세종특별자치시">세종특별자치시</option>
                            <option value="경기도">경기도</option>
                            <option value="강원도">강원도</option>
                            <option value="충청북도">충청북도</option>
                            <option value="충청남도">충청남도</option>
                            <option value="전라북도">전라북도</option>
                            <option value="전라남도">전라남도</option>
                            <option value="경상북도">경상북도</option>
                            <option value="경상남도">경상남도</option>
                            <option value="제주특별자치도">제주특별자치도</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>분실날짜 <span class="red">*</span></td>
                    <td><input type="text" id="lostDate"></td>
                </tr>
            </tbody>
        </table>

        <div class="writer_area">
            <table class="writer_table">
                <tbody>
                    <h1>신고자 정보</h1>
                    <tr>
                        <td>이름 <span class="red">*</span></td>
                        <td><input type="text" id="writer_name" value="${member.name}"></td>
                    </tr>
                    <tr>
                        <td>이메일 <span class="red">*</span></td>
                        <td><input type="text" id="writer_email" value="${member.email}"></td>
                    </tr>
                    <tr>
                        <td>연락처 <span class="red">*</span></td>
                        <td><input type="text" id="writer_phone" value="${member.phone}"></td>
                    </tr>
                </tbody>
            </table>
        </div>

        <div class="animal_area">
            <table class="animal_table">
                <tbody>
                    <h1>분실동물 정보</h1>
                    <tr>
                        <td>이름 <span class="red">*</span></td>
                        <td><input type="text" id="animal_name"></td>
                    </tr>
                    <tr>
                        <td>품종 <span class="red">*</span></td>
                        <td>
                            <select id="kind_select">
                                <option value="개">개</option>
                                <option value="고양이">고양이</option>
                                <option value="기타동물">기타동물</option>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td></td>
                        <td><input type="text" id="animal_kind_more" placeholder="기타동물 선택시 입력"></td>
                    </tr>
                    <tr>
                        <td>색상 <span class="red">*</span></td>
                        <td><input type="text" id="animal_color"></td>
                    </tr>
                    <tr>
                        <td>성별 <span class="red">*</span></td>
                        <td>
                            <select id="sex_select">
                                <option value="수컷">수컷</option>
                                <option value="암컷">암컷</option>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td>나이</td>
                        <td><input type="text" id="animal_age"></td>
                    </tr>
                    <tr>
                        <td>분실장소</td>
                        <td colspan="2"><input type="text" id="lost_place"></td>
                    </tr>
                    <tr>
                        <td>특징</td>
                        <td colspan="2"><input type="text" id="special_mark"></td>
                    </tr>
                    <tr>
                        <td>등록번호</td>
                        <td colspan="2"><input type="text" id="regist_number"></td>
                    </tr>
                    <tr>
                        <td>사진파일</td>
                        <td>
                            <span id="img_preview">
    
                            </span> 
                            <form id="image_form">
                                <span class="img_explain">※ 첨부파일은 200MByte를 넘을 수 없습니다.<br></span>
                                <span class="img_explain">※ 업로드 가능한 확장자는 gif, jpeg, png, jpg 입니다.<br></span>
                                <span class="img_explain">※'등록' 버튼을 누르셔야 사진이 업로드 됩니다.<br></span>
                                <input type="file" accept="image/gif, image/jpeg, image/png, image/jpg" name="file">
                                <button type="button" id="img_save">등록</button>
                                <button type="button" id="img_delete" disabled>삭제</button>
                            </form>
                        </td>
                    </tr>
                </tbody>
                <tr>
                    <td colspan="2">
                        <button id="save">등록하기</button>
                    </td>
                </tr>
            </table>
        </div>
        
    </div>

    <%@include file="/WEB-INF/views/includes/footer.jsp"%>
</body>
</html>