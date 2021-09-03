//날짜 선택 해주기
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

$(function(){
    var calendarEl = document.getElementById('calendar');
    var calendar = new FullCalendar.Calendar(calendarEl, {
        initialView: 'dayGridMonth'
    });
    $(".fc-next-button").click(function(){
        console.log(makeDateString(calendar.getDate()));
    })
    $(".fc-prev-button").click(function(){
        console.log(makeDateString(calendar.getDate()));
    })
    $(".fc-today-button").click(function(){
        console.log(makeDateString(calendar.getDate()));
        calendar.remove();
    })
    for(let i=0; i<10; i++) {
        calendar.addEvent({
            title: '테스트 이벤트',
            start: new Date("2021-09-"+leadingZero(i+1)),
            allDay: true
        })
    }

    calendar.render();


    //날짜 달력 보이기
    $("#user_date").datepicker();
    $("#user_date").datepicker("setDate", new Date());
    $("#user_date").datepicker("option","maxDate", '2021-12-31');
    $("#user_date").datepicker("option","minDate", '2021-03-11');

    //버튼 클릭시 입력 창 나온다    
    $(".btn").click(function(){
        $(".content_left").css("display","block");
    });
    //닫기 버튼
    $("#close_btn").click(function(){
        $(".content_left").css("display","")
    })

    //데이터 전송

    $("#region_select").change(function(){
        let region = $("#region_select").find("option:selected").val();
        getCenterRegionInfo(region);
    })
    
    getCenterRegionInfo("서울특");

    function getCenterRegionInfo(region) {
        let url = "http://localhost:8947/calendar/region?region="+region;

        $.ajax({
            type:"get",
            url:url,
            success:function(r){
                //console.log(r);
                $("#center_select").html("<option>선택</option>");
                for(let i=0; i<r.data.length; i++) {
                    let tag = '<option value="'+r.data[i].careNm+'">'+r.data[i].careNm+'</option>';
                    $("#center_select").append(tag);
                                
                }
                
            }
        })

    }

    $("#cal_btn").click(function(){
        if(memberInfo.seq==""||memberInfo.seq==null||memberInfo.seq==undefined){
            alert("로그인 후 사용하실 수 있습니다.");
            location.href = "/member/login";
            return;
        }
        
        let user_name=$("#user_name").val();
        if (user_name == "" || user_name == null || user_name == undefined) {
            alert("이름을 입력하세요.");
            return;
        }
        let user_title=$("#user_title").val();
        if (user_title == "" || user_title == null || user_title == undefined) {
            alert("제목을 입력하세요.");
            return;
        }
        let user_detail=$("#user_detail").val();
        if (user_detail == "" || user_detail == null || user_detail == undefined) {
            alert("상세 내용을 입력하세요.");
            return;
        }
        let user_date=$("#user_date").val();
        let user_datetime_h=$("#user_datetime_h").val();
        let user_datetime_m=$("#user_datetime_m").val();
        let user_kind = $("#kind_select option:selected").val();
        let user_region =$("#region_select option:selected").val();
        let user_careNm =$("#center_select option:selected").val();

        let data={ 
            mi_seq:memberInfo.seq,
            name: user_name,
            title: user_title,
            detail: user_detail,
            kind: user_kind,
            date: user_date,
            time_h:user_datetime_h,
            time_m:user_datetime_m,
            region:user_region,
            careNm:user_careNm
        }
        console.log(data);
        $.ajax({
            type:"post",
            url:"/calendar/add",
            data:JSON.stringify(data),
            contentType:"application/json", 
            success:function(r){
                alert(r.message);
                location.reload();
                
            }
        })
        
    });
    // let seq = memberInfo.mi_seq;

    // $.ajax({
    //     type:"get",
    //     url: "/calendar/list/"+seq,
    //     success: function(r){
    //         console.log(r);
            
    //     },
    // })
});


function makeDateString(dt) {
    return dt.getFullYear()+"-"+leadingZero(dt.getMonth()+1)+"-"+leadingZero(dt.getDate());
}
function leadingZero(n) {
    let num = Number(n);
    return num<10?"0"+num:""+num;
}