<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>유기동물 조회 서비스</title>
    <link rel="stylesheet" href="/assets/css/index.css">
    <script src="http://code.jquery.com/jquery-3.4.1.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/chart.js@3.5.0/dist/chart.min.js"></script>
    <script src="/assets/js/index.js"></script>
</head>
<body>
    <%@include file="/WEB-INF/views/includes/menu.jsp"%>
    <div class="main_banner_area">
        <div class="main_banner_contents">
            <h1 class="banner_title">반려동물 유기는 범죄입니다.</h1>
            <p class="banner_text">따듯한 가족을 찾아주세요</p>
            <p class="banner_warn">반려동물 유기는 형사처벌 대상입니다.</p>
            <div class="banner_contents">
                <div class="content_left">
                    <p class="ani_title">하루간 발견된 강아지</p>
                    <p class="ani_number">${cnt.strCnt} 마리</p>
                    <p class="ani_title">하루간 발견된 고양이</p>
                    <p class="ani_number">${c_cnt.c_strCnt} 마리</p>
                </div>
                <div class="content_mid">
                    <p class="ani_title">최근 3개월간 가족을 잃은</p>
                    <p class="ani_number">강아지 ${allCnt.strAllCnt} 마리</p>
                    <p class="ani_number">고양이 ${c_AllCnt.c_strAllCnt} 마리</p>
                </div>
            </div>
        </div>
    </div>
    <div class="container">
        <div class="dashboard_content">
            
            <div class="content_mid live_confirm_area">
                <h1>어디에서 강아지가 가족을 많이 잃었나요?</h1>
                <canvas id="region_status" style="width: 100%; height: 100%;"></canvas>
            </div>
            <div class="pie_chart_area">
                <div class="content_right">
                    <h1>유기 된 강아지 성별비율</h1>
                    <canvas id="sex_chart" style="width: 100%; height: 100%;"></canvas>
                </div>
                <div class="content_right">
                    <h1>유기 된 강아지 중성화</h1>
                    <canvas id="neuter_chart" style="width: 100%; height: 100%;"></canvas>
                </div>
            </div>
        </div>
        <div class="dashboard_content">
            
            <div class="content_mid live_confirm_area">
                <h1>어디에서 고양이가 가족을 많이 잃었나요?</h1>
                <canvas id="c_region_status" style="width: 100%; height: 100%;"></canvas>
            </div>
            <div class="pie_chart_area">
                <div class="content_right">
                    <h1>유기 된 고양이 성별비율</h1>
                    <canvas id="c_sex_chart" style="width: 100%; height: 100%;"></canvas>
                </div>
                <div class="content_right">
                    <h1>유기 된 고양이 중성화</h1>
                    <canvas id="c_neuter_chart" style="width: 100%; height: 100%;"></canvas>
                </div>
            </div>
        </div>
        <div class="dashboard_content">
            <div class="content_mid content_data">
                <h1>최근 3개월간 많은 반려동물이 가족을 잃었어요</h1>
                <canvas id="dogcat_status" style="width: 100%; height: 100%;"></canvas>
            </div>
            <div class="pie_chart_area">
                <div class="content_right">
                    <h1>보호가 종료된 강아지</h1>
                    <canvas id="d_state_chart" style="width: 100%; height: 100%;"></canvas>
                </div>
                <div class="content_right">
                    <h1>보호가 종료된 고양이</h1>
                    <canvas id="c_state_chart" style="width: 100%; height: 100%;"></canvas>
                </div>
            </div>
        </div>
    </div>
    <%@include file="/WEB-INF/views/includes/footer.jsp"%>
</body>
</html>