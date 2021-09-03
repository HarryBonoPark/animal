$.datepicker.setDefaults({
    dateFormat: 'yy-mm-dd',
    prevText: '이전 달',
    nextText: '다음 달',
    monthNames: ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월'],
    monthNamesShort: ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월'],
    dayNames: ['일', '월', '화', '수', '목', '금', '토'],
    dayNamesShort: ['일', '월', '화', '수', '목', '금', '토'],
    dayNamesMin: ['일', '월', '화', '수', '목', '금', '토'],
    showMonthAfterYear: true,
    yearSuffix: '년'
});

$(function() {
    let data_length;
    let currentPage = 1;

    $("#startDate").datepicker();
    let dt = new Date();
    dt.setMonth(dt.getMonth() -1);
    $("#startDate").datepicker("setDate", dt);

    $("#endDate").datepicker();
    $("#endDate").datepicker("setDate", new Date());

    $("#region_select").change(function(){
        let region = $("#region_select").find("option:selected").val();
        getLostAnimalList(region, $("#startDate").val(), $("#endDate").val());
    })
    $("#startDate").change(function(){
        let region = $("#region_select").find("option:selected").val();
        getLostAnimalList(region, $("#startDate").val(), $("#endDate").val());
    })
    $("#endDate").change(function(){
        let region = $("#region_select").find("option:selected").val();
        getLostAnimalList(region, $("#startDate").val(), $("#endDate").val());
    })

    getLostAnimalList("all", $("#startDate").val(), $("#endDate").val());

    function getLostAnimalList(region, startDate, endDate) {

        let url = "http://localhost:8947/api/lost/list?region="+region+"&startDate="+startDate+"&endDate="+endDate;

        $.ajax({
            type:"get",
            url:url,
            success:function(r) {

                data_length = r.data.length;
                currentPage = 1;
                $(".total_page").html(Math.ceil(data_length / 6));

                $(".lost_animal").html("");
                let page = Math.ceil(r.data.length/6);
                for(let i=0; i<page; i++) {
                    $(".lost_area").append('<div class="lost_animal"></div>');
                }

                for(let i=0; i<r.data.length; i++) {
                    let page = Math.floor(i/6);
                    let tag = 
                    '<div class="lost_box">'+
                        '<p>'+
                            '<img src='+"/image/"+r.data[i].image_uri+'>'+
                        '</p>'+
                        '<p>'+
                            '<span>이름</span>'+
                            '<span class="animal_name">'+r.data[i].animalName+'</span>'+
                        '</p>'+
                        '<p>'+
                            '<span>신고자</span>'+
                            '<span class="writer_name">'+r.data[i].writerName+'</span>'+
                        '</p>'+
                        '<p>'+
                            '<span>품종</span>'+
                            '<span class="animal_kind">'+r.data[i].animalKind+'</span>'+
                        '</p>'+
                        '<p>'+
                            '<span>분실 날짜</span>'+
                            '<span class="lostDate">'+r.data[i].lostDate+'</span>'+
                        '</p>'+
                        '<p>'+
                            '<span>분실 지역</span>'+
                            '<span class="region">'+r.data[i].region+'</span>'+
                        '</p>'+
                        '<a href="/lost/detail?seq='+r.data[i].seq+'">자세히보기</a>'
                    '</div>'
                    $(".lost_animal").eq(page).append(tag);
                }
                $(".lost_animal").eq(0).addClass("active");
                $(".lost_cnt").html(r.data.length);
            }
        })
    }
    $("#lost_page_next").click(function() {
        currentPage++;
        if(currentPage > data_length / 6) currentPage = Math.ceil(data_length / 6);
        $(".current_page").html(currentPage);
        $(".lost_animal").removeClass("active");
        $(".lost_animal").eq(currentPage-1).addClass("active");
    })
    $("#lost_page_prev").click(function() {
        currentPage--;
        if(currentPage < 1) currentPage = 1;
        $(".current_page").html(currentPage);
        $(".lost_animal").removeClass("active");
        $(".lost_animal").eq(currentPage-1).addClass("active");
    })
})