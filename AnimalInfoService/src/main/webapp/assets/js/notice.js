$(function(){
    $("#save").click(function(){
        let title = $("#title").val();
        let content = $("#content").val();
        let ni_cate_seq = $("#ca_seq option:selected").val();

        if(title == null || title == "" || title == undefined){
            alert("공지명을 입력하세요");
            return;
        }
        if(content == null || content == "" || content == undefined){
            alert("공지 내용을 입력하세요");
            return;
        }
        if(ni_cate_seq == null || ni_cate_seq == "" || ni_cate_seq == undefined){
            alert("카테고리를 선택하세요");
            return;
        }
        let data = {
            title:title,
            content:content,
            ni_cate_seq:ni_cate_seq
        };
        $.ajax({
            type:"post",
            url:"/api/notice/add",
            data:JSON.stringify(data),
            contentType:"application/json",
            success:function(r){
                alert(r.message);
                location.reload();
            }
        })
    })
})