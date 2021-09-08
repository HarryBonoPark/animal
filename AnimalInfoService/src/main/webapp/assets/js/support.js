$(function(){
    //select값 가져오기. 
    if(kind_val != '' || region_val != '') {
        console.log("editmode");
        $("#kind_select").val(kind_val).prop("selected", true);
        $("#region_select").val(region_val).prop("selected", true);
        
        getCenterRegionInfo(region_val);
        // console.log(center_val);
    }
    //겹쳐서 들어가서 나왔다 안나왔다 하는 것.
    //else로 넣어주자
    else {
        getCenterRegionInfo("all");
    }

    
    //등록 취소를 누르면 나오는 내용
    $("#cancel").click(function(){
        if(!confirm("작성중인 내용이 모두 삭제됩니다")){
            return;
        }
        history.back();
    })

    //등록하기 
    $("#regist").click(function(){
        const pattern=/\s/g;

        let user_name=$("#user_name").val();
        if(user_name==""||user_name==null||user_name==undefined){
            alert("이름을 입력하세요");
            return;
        }
        if(user_name.match(pattern)){
            alert("이름에는 공백문자가 들어갈 수 없습니다.");
            return;
        }
        let user_phone=$("#user_phone").val();
        if(user_phone=="" || user_phone==null ||user_phone==undefined){
            alert("전화번호를 입력하세요");
            return;
        }
        let user_pwd=$("#user_pwd").val();
        if(user_pwd=="" || user_pwd==null || user_pwd==undefined){
            alert("비밀번호를 입력하세요");
            return;
        }
        if(user_pwd.match(pattern)){
            alert("비밀번호에는 공백문자가 들어갈 수 없습니다.");
            return;
        }
        let user_pwd_confirm = $("#user_pwd_confirm").val();
        if(user_pwd != user_pwd_confirm){
            alert("비밀번호와 비밀번호 확인이 일치하지 않습니다.");
            return;
        }
        const patternEmail =/^[0-9a-zA-Z]([-_\.?]?[0-9a-zA-Z])*@[0-9a-zA]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/i;
        let user_email=$("#user_email").val();
        if(user_email=="" || user_email==null || user_email==undefined){
            alert("이메일을 입력하세요");
            return;
        }
        if(user_email.match(pattern)){
            alert("비밀번호에는 공백문자가 들어갈 수 없습니다.");
            return;
        }
        if(!user_email.match(patternEmail)){
            alert("올바른 이메일 형식을 입력하세요 \n 예시:nnn@naver.com");
            return;
        }
        let user_title=$("#user_title").val();
        if(user_title=="" || user_title==null || user_title==undefined){
            alert("제목을 입력하세요");
            return;
        }
        let user_content=$("#user_content").val();
        if(user_content=="" || user_content==null || user_content==undefined){
            alert("내용을 입력하세요");
            return;
        }

        let user_kind = $("#kind_select option:selected").val();
        let user_region =$("#region_select option:selected").val();
        let user_center =$("#center_select option:selected").val();
        
        let data = {
            name: user_name,
            phone: user_phone,
            password: user_pwd,
            email: user_email,
            title: user_title,
            content: user_content,
            kind: user_kind,
            region: user_region,
            careNm: user_center
        }
    
        $.ajax({
            type:"post",
            url:"/support/regist",
            data:JSON.stringify(data),
            contentType:"application/json",
            success:function(r){
                alert(r.message);
                history.back();
            },
            error:function(e){
                console.log(e);
            }
        })
    });

    //데이터 전송-지역별 center
    //지역 선택
    $("#region_select").change(function(){
        let region = $("#region_select").find("option:selected").val();
        getCenterRegionInfo(region);
    })

    function getCenterRegionInfo(region) {
        let url = "http://localhost:8947/support/center?region="+region;
        $.ajax({
            type:"get",
            url:url,
            success:function(r){
                console.log(r);
                //지역별 center 고르기
                $("#center_select").html("<option>선택</option>");
                for(let i=0; i<r.data.length; i++) {
                    let tag = '<option value="'+r.data[i].careNm+'">'+r.data[i].careNm+'</option>';
                    $("#center_select").append(tag);
                }
                console.log(center_val);
                if(center_val.length != 0){
                    $("#center_select").val(center_val).prop("selected", true);
                }
                else {
                    $("#center_select option").eq(0).prop("selected", true);
                }
            }
        })
    }

    //수정하기 눌렀을 때 나오는 창 
    $("#firmodify").click(function(){
        const pattern=/\s/g;

        let user_name=$("#user_name").val();
        if(user_name==""||user_name==null||user_name==undefined){
            alert("이름을 입력하세요");
            return;
        }
        if(user_name.match(pattern)){
            alert("이름에는 공백문자가 들어갈 수 없습니다.");
            return;
        }
        let user_phone=$("#user_phone").val();
        if(user_phone=="" || user_phone==null ||user_phone==undefined){
            alert("전화번호를 입력하세요");
            return;
        }
        let user_pwd=$("#user_pwd").val();
        if(user_pwd=="" || user_pwd==null || user_pwd==undefined){
            alert("비밀번호를 입력하세요");
            return;
        }
        if(user_pwd.match(pattern)){
            alert("비밀번호에는 공백문자가 들어갈 수 없습니다.");
            return;
        }
        let user_pwd_confirm = $("#user_pwd_confirm").val();
        if(user_pwd != user_pwd_confirm){
            alert("비밀번호와 비밀번호 확인이 일치하지 않습니다.");
            return;
        }
        const patternEmail =/^[0-9a-zA-Z]([-_\.?]?[0-9a-zA-Z])*@[0-9a-zA]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/i;
        let user_email=$("#user_email").val();
        if(user_email=="" || user_email==null || user_email==undefined){
            alert("이메일을 입력하세요");
            return;
        }
        if(user_email.match(pattern)){
            alert("비밀번호에는 공백문자가 들어갈 수 없습니다.");
            return;
        }
        if(!user_email.match(patternEmail)){
            alert("올바른 이메일 형식을 입력하세요 \n 예시:nnn@naver.com");
            return;
        }
        let user_title=$("#user_title").val();
        if(user_title=="" || user_title==null || user_title==undefined){
            alert("제목을 입력하세요");
            return;
        }
        let user_content=$("#user_content").val();
        if(user_content=="" || user_content==null || user_content==undefined){
            alert("내용을 입력하세요");
            return;
        }
        let user_kind = $("#kind_select option:selected").val();
        let user_region =$("#region_select option:selected").val();
        let user_center =$("#center_select option:selected").val();
        
        let data = {
            //seq값을 가져와서 수정하기 완료된 data 내보내기 
            seq:getParameterByName("seq"),
            name: user_name,
            phone: user_phone,
            password: user_pwd,
            email: user_email,
            title: user_title,
            content: user_content,
            kind: user_kind,
            region: user_region,
            careNm: user_center
        }
        
        //비밀번호를 가져오기 위한 ajax
        console.log(data);
        if(!confirm("수정하시겠습니까?")) return;
        //수정된 사항 저장
        $.ajax({
            type:"patch",
            url:"/api/update",
            data:JSON.stringify(data),
            contentType:"application/json",
            success:function(r){
                location.href = '/support/list';
            }
        })
    });
    

})

function getParameterByName(name) {
    name = name.replace(/[\[]/, "\\[").replace(/[\]]/, "\\]");
    var regex = new RegExp("[\\?&]" + name + "=([^&#]*)"), results = regex.exec(location.search); 
    return results == null ? "" : decodeURIComponent(results[1].replace(/\+/g, " ")); 
}

