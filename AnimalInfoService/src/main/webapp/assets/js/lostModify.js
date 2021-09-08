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
    $("#lostDate").datepicker();
    // $("#lostDate").datepicker("option", "maxDate", new Date());

    $("#cancel").click(function() {
        if(confirm("이전 페이지로 돌아가시겠습니까? \n변경 내용은 저장되지 않습니다.")) {
            location.href = '/lost/detail?seq='+$(this).attr("data_num");
        }
    })

    if(region_val != '') {
        $("#region_select").val(region_val).prop("selected", true);
    }
    if(kind_val != '') {
        $("#kind_select").val(kind_val).prop("selected", true);
    }
    if(sex_val != '') {
        $("#sex_select").val(sex_val).prop("selected", true);
    }

    $("#modify").click(function() {

        let region = $("#region_select option:selected").val();
        if(region == "" || region == null || region == undefined){
            alert("지역을 선택하세요");
            return;
        }

        let lostDate = $("#lostDate").val();
        if(lostDate == "" || lostDate == null || lostDate == undefined){
            alert("분실 날짜를 선택하세요");
            return;
        }

        let animal_kind_more = $("#animal_kind_more").val();
        let animal_age = $("#animal_age").val();
        let lost_place = $("#lost_place").val();
        let special_mark = $("#special_mark").val();
        let regist_number = $("#regist_number").val();

        let writer_name = $("#writer_name").val();
        if(writer_name == "" || writer_name == null || writer_name == undefined){
            alert("작성자 이름을 입력하세요");
            return;
        }

        let writer_email = $("#writer_email").val();
        if(writer_email == "" || writer_email == null || writer_email == undefined){
            alert("작성자 이메일을 입력하세요");
            return;
        }

        let writer_phone = $("#writer_phone").val();
        if(writer_phone == "" || writer_phone == null || writer_phone == undefined){
            alert("작성자 연락처를 입력하세요");
            return;
        }

        let animal_name = $("#animal_name").val();
        if(animal_name == "" || animal_name == null || animal_name == undefined){
            alert("분실동물의 이름를 입력하세요");
            return;
        }

        let aniaml_kind = $("#kind_select option:selected").val();
        if(aniaml_kind == "" || aniaml_kind == null || aniaml_kind == undefined){
            alert("분실동물의 품종을 입력하세요 (선택사항 : 개, 고양이, 기타동물)");
            return;
        }

        let animal_color = $("#animal_color").val();
        if(animal_color == "" || animal_color == null || animal_color == undefined){
            alert("분실동물의 색상을 입력하세요");
            return;
        }

        let animal_sex = $("#sex_select option:selected").val();
        if(animal_sex == "" || animal_sex == null || animal_sex == undefined){
            alert("분실동물의 성별을 입력하세요");
            return;
        }

        let data = {
            seq : $(this).attr("data_num"),
            region : region,
            lostDate : lostDate,
            writerName : writer_name,
            writerEmail : writer_email,
            writerPhone : writer_phone,
            animalName : animal_name,
            animalKind : aniaml_kind,
            animalKindMore : animal_kind_more,
            animalColor : animal_color,
            animalSex : animal_sex, 
            animalAge : animal_age,
            lostPlace : lost_place,
            specialMark : special_mark,
            registNumber : regist_number,
            image_uri : $("#img_preview").attr("img-uri")
        }
        console.log(data);

        $.ajax({
            type:"patch",
            url:"/api/lost/update", 
            data:JSON.stringify(data),
            contentType:"application/json",
            success:function(r){
                alert(r.message);
                history.back();
            }
        })
    })

    $("#img_save").click(function(){
        let form = $("#image_form");
        let formData = new FormData(form[0]);
        $.ajax({
            url:"/upload",
            type:"post",
            data:formData,
            contentType:false,
            processData:false,
            success:function(r){
                console.log(r);
                if(r.status){
                    $("#img_save").prop("disabled", true);
                    $("#img_delete").prop("disabled", false);
                    $("#image_delete > input").prop("disabled", true);
                    $("#img_preview").append('<img src="/image/'+r.image_uri+'">');
                    $("#img_preview").attr("img-uri", r.image_uri);
                }
                alert(r.message);
            }
        })
    })
    $("#img_delete").click(function(){
        $("#img_preview").html("");

        $("#image_form > input").val("");
        $(this).prop("disabled", true);
        $("#image_form > input").prop("disabled", false);
        $("#img_save").prop("disabled", false);

        alert("등록된 사진이 삭제됩니다.");
    })
})
