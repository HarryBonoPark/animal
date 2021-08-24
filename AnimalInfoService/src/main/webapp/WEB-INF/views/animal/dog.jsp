<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="/assets/css/dog.css">
    <link rel="stylesheet" href="/assets/css/reset.css">
    <script src="http://code.jquery.com/jquery-3.4.1.min.js"></script>
    <script src="/assets/js/dog.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.js"
        integrity="sha512-uto9mlQzrs59VwILcLiRYeLKPPbS/bT71da/OEBYEwcdNUk8jYIy+D176RYoop1Da+f9mvkYrmj5MCLZWEtQuA=="
        crossorigin="anonymous" referrerpolicy="no-referrer"></script>
</head>

<body>
    <div class="container">
        <div class="content_head">
            <%@include file="/WEB-INF/views/includes/menu.jsp"%>
        </div>
            <li class="region">
                    <span class="plain_name" data-region="서울특">서울특별시</span>
            </li>
            <li class="region">
                    <span class="plain_name" data-region="경기도">경기도</span>
            </li>
            <li class="region">      
                    <span class="plain_name" data-region="인천광">인천광역시</span>   
            </li>
            <li class="region">   
                    <span class="plain_name" data-region="세종특">세종특별자치시</span>  
            </li>
            <li class="region">
                    <span class="plain_name" data-region="대전광">대전광역시</span>
            </li>
            <li class="region">
                    <span class="plain_name" data-region="대구광">대구광역시</span>  
            </li>
            <li class="region">
                    <span class="plain_name" data-region="울산광">울산광역시</span>  
            </li>
            <li class="region">
                    <span class="plain_name" data-region="광주광">광주광역시</span>
            </li>
            <li class="region">                
                    <span class="plain_name" data-region="부산광">부산광역시</span>    
            </li>
            <li class="region">
                    <span class="plain_name" data-region="제주특">제주특별자치도</span>
            </li>
            <li class="region">
                    <span class="plain_name" data-region="경상남">경상남도</span>
            </li>
            <li class="region">        
                    <span class="plain_name" data-region="경상북">경상북도</span>  
            </li>
            <li class="region">
                    <span class="plain_name" data-region="전라북">전라북도</span>
            </li>
            <li class="region"
                    <span class="plain_name" data-region="전라남">전라남도</span>
            </li>
            <li class="region">
                    <span class="plain_name" data-region="충청남">충청남도</span>
            </li>
            <li class="region">
                    <span class="plain_name" data-region="충청북">충청북도</span>
            </li>
            <li class="region">
                    <span class="plain_name" data-region="강원도">강원도</span>
            </li>
        
        <div class="dog_area">
            <!-- <div class="dog_box">
                    <p class="dogfile">
                        <img src="http://www.animal.go.kr/files/shelter/2021/08/20210820100869_s.jpg">
                    </p>
                    <p class="kind">
                        <span>품종</span>
                        <span class="dogKind">말티즈</span>
                    </p>
                    <p class="dogprofile">
                        <span>등록일</span>
                        <span class="register">2021-08-10</span>
                    </p>
                    <p class="dogGen">
                        <span>성별</span>
                        <span class="gen">수컷</span>
                    </p>
                    <p class="dogAge">
                        <span>나이</span>
                        <span class=" age">2살</span>
                    </p>
                    <p class="dogShelter">
                        <span>보호소</span>
                        <span class="shelter">2021-08-10</span>
                    </p>
                    <button id="popCloseBtnCmmn" data-num="1">확인</button>
                </div>
                <div class="dog_box">
                    <p class="dogfile">
                        <img src="http://www.animal.go.kr/files/shelter/2021/08/20210820100869_s.jpg">
                    </p>
                    <p class="kind">
                        <span>품종</span>
                        <span class="dogKind">말티즈</span>
                    </p>
                    <p class="dogprofile">
                        <span>등록일</span>
                        <span class="register">2021-08-10</span>
                    </p>
                    <p class="dogGen">
                        <span>성별</span>
                        <span class="gen">수컷</span>
                    </p>
                    <p class="dogAge">
                        <span>나이</span>
                        <span class=" age">2살</span>
                    </p>
                    <p class="dogShelter">
                        <span>보호소</span>
                        <span class="shelter">2021-08-10</span>
                    </p>
                    <button id="popOpenBtnCmmn" data-num="1">상세정보</button>
                </div> -->
        </div>
        <!-- 팝업창 정보 -->
        <div class="dog_form" data-num="1">
            <h1>상세 정보</h1>
            <p class="dogfile">
                <img src="http://www.animal.go.kr/files/shelter/2021/08/202108231008877.jpg">
            </p>
            <p class="kind">
                <span>품종</span>
                <span class="dogKind">말티즈</span>
            </p>
            <p class="dogprofile">
                <span>등록일</span>
                <span class="register">2021-08-10</span>
            </p>
            <p class="dogGen">
                <span>성별</span>
                <span class="gen">수컷</span>
            </p>
            <p class="dogAge">
                <span>나이</span>
                <span class=" age">2살</span>
            </p>
            <p class="color">
                <span>색상</span>
                <span class="color">흰색</span>
            </p>
            <p class="weight">
                <span>무게</span>
                <span class="weight">4kg</span>
            </p>
            <p class="neuterYn">
                <span>중성화</span>
                <span class="sexYn"> o</span>
            </p>
            <p class="dogShelter">
                <span>보호소</span>
                <span class="shelter">대구 사랑동물</span>
            </p>
            <p class="careAddr">
                <span>주소</span>
                <span class="careAddr">사랑시 고백구 행복동</span>
            </p>
            <p class="careTel">
                <span>전화번호</span>
                <span class="careTel">053-752-4281</span>
            </p>
            <p class="happenPlace">
                <span>발견장소</span>
                <span class="happenPlace">대구에서발견</span>
            </p>
            <p class="processState">
                <span>보호 여부</span>
                <span class="processState">보호중</span>
            </p>
            <p class="specialMark">
                <span>특징: </span>
                <span class="specialMark">동글동글 귀여운 외모</span>
            </p>
            <button id="popCloseBtnCmmn" data-num="1">확인</button>
        </div>
        <div class="pager_area">
            <button id="prev">&lt;</button>
            <span class="current">1</span> / <span class="total">7</span>
            <button id="next">&gt;</button>
        </div>
    </div>
    </div>
</body>
</html>