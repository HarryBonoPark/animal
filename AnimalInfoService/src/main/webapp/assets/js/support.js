$(function(){
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

        let data = {
                name: user_name,
                phone: user_phone,
                password: user_pwd,
                email: user_email,
                title: user_title,
                content: user_content        
        }
        $.ajax({
            type:"post",
            url:"/support/regist",
            data:JSON.stringify(data),
            contentType:"application/json",
            success:function(r){
                alert(r.message);
                location.reload();
            },
            error:function(e){
                console.log(e);
            }
        })
    });
})