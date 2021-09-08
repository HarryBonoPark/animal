$(function(){
    
    //수정하기 취소버튼
    $("#cancel").click(function(){
        if(!confirm("수정 사항이 취소됩니다.")){
            return;
        }
        location.href = "/";
    })

    //수정하기 - select값인 gen가져오기
    if(gen_val != '') {
        console.log("editmode");
        $("#user_gen").val(gen_val).prop("selected", true);
    } 

    //수정하기 기능
    $("#join_modify").click(function(){
        const pattern = /\s/g;

        let user_id = $("#user_id").val();
        if (user_id == "" || user_id == null || user_id == undefined) {
            alert("아이디를 입력하세요.");
            return;
        }
        if (user_id.match(pattern)) {
            alert("아이디에는 공백문자가 들어갈 수 없습니다.");
            return;
        }
        let user_pwd = $("#user_pwd").val();
        if (user_pwd == "" || user_pwd == null || user_pwd == undefined) {
            alert("비밀번호를 입력하세요.");
            return;
        }
        if (user_pwd.match(pattern)) {
            alert("비밀번호에는 공백문자가 들어갈 수 없습니다.");
            return;
        }
        let user_pwd_confirm = $("#user_pwd_confirm").val();
        if (user_pwd != user_pwd_confirm) {
            alert("비밀번호와 비밀번호 확인이 일치하지 않습니다.");
            return;
        }
        let user_name = $("#user_name").val();
        if (user_name == "" || user_name == null || user_name == undefined) {
            alert("이름을 입력하세요");
            return;
        }
        if (user_name.match(pattern)) {
            alert("이름에는 공백문자가 들어갈 수 없습니다.");
            return;
        }
        const patternEmail = /^[0-9a-zA-Z]([-_\.?]?[0-9a-zA-Z])*@[0-9a-zA]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/i;
        let user_email = $("#user_email").val();
        if (user_email == "" || user_email == null || user_email == undefined) {
            alert("이메일을 입력하세요");
            return;
        }
        if (user_email.match(pattern)) {
            alert("이메일에는 공백문자가 들어갈 수 없습니다.");
            return;
        }
        if (!user_email.match(patternEmail)) {
            alert("올바른 이메일 형식을 입력하세요 \n 예시:nnn@naver.com");
            return;
        }         

        let user_status = $("#user_status").val(); 
        let user_address = $("#user_address").val();
        let user_address_detail = $("#user_address_detail").val();
        let user_phone = $("#user_phone").val();
        let user_gen = $("#user_gen option:selected").val();

        if(!inputValidation(user_address,"주소")){return;}
        if(!inputValidation(user_address_detail,"상세주소")){return;}
        if(!inputValidation(user_phone,"전화번호")){return;}

        let data={
            seq:$("#user_id_tr").attr("data-seq"),
            id: user_id,
            password: user_pwd,
            name: user_name,
            email: user_email,
            gen: user_gen,
            address: user_address,
            address_detail: user_address_detail,
            phone: user_phone,  
            status: user_status
        };    

        console.log(data);

        if(!confirm("수정하시겠습니까?")) return;
        $.ajax({
            type:"patch",
            url:"/member/update",
            data:JSON.stringify(data),
            contentType:"application/json",
            success:function(r){
                location.reload();
                location.href = '/';
            }
        })

    })
    //아이디 중복값 체크
    $("#chk_id").click(function(){
        const pattern = /\s/g;
        let user_id = $("#user_id").val();
        if(user_id == "" || user_id == null || user_id == undefined) {
            alert("아이디를 입력해주세요");
            return;
        }
        if(user_id.match(pattern)) {
            alert("아이디에는 공백문자가 들어갈 수 없습니다.");
            return;
        }
        $.ajax({
            type:"get",
            url:"/member/chk_id?id="+user_id,
            success:function(r){
                alert(r.message);
                idChk=r.status;
            }
        })
    });

    //이메일 중복값 체크
    $("#chk_email").click(function(){
        //alert("클릭");
        const pattern = /\s/g;
        const patternEmail = /^[0-9a-zA-Z]([-_\.?]?[0-9a-zA-Z])*@[0-9a-zA]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/i;
        let user_email = $("#user_email").val();
        if (user_email == "" || user_email == null || user_email == undefined) {
            alert("이메일을 입력하세요");
            return;
        }
        if (user_email.match(pattern)) {
            alert("이메일에는 공백문자가 들어갈 수 없습니다.");
            return;
        }
        if (!user_email.match(patternEmail)) {
            alert("올바른 이메일 형식을 입력하세요 \n 예시:nnn@naver.com");
            return;
        }
        $.ajax({
            type:"get",
            url:"/member/chk_email?email="+user_email,
            success:function(r){
                alert(r.message);
                emailChk = r.status;
            }
        })
    })

    //중복 체트 했는데 또 수정할 시 다시 중복하라고 체크해주기
    $("#user_id").change(function(){
        idChk=false;
    });
    $("#user_email").change(function(){
        emailChk=false;
    });
});


function inputValidation(input,type){
    if(input=""|| input==null|| input==undefined){
        alert(type+"을/를 입력하세요");
        return false;
    }
    return true;
}