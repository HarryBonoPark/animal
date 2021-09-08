$(function() {
    $(".delete_button").click(function(){
        console.log( $(this).attr("data_num") );
        if(confirm("삭제하시겠습니까?")) {
            $.ajax({
                url:"/api/lost/delete?seq="+$(this).attr("data_num"),
                type:"delete",
                success:function(r) {
                    alert(r.message);
                    location.href = '/lost/list';
                }
            })
        }
    })
    
    $(".modify_button").click(function(){
        console.log( $(this).attr("data_num") );
        if(confirm("수정하시겠습니까? \n'확인' 버튼을 클릭하시면 수정 페이지로 이동합니다.")) {
            location.href = '/lost/modify?seq='+$(this).attr("data_num");
        }
    })
})