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
})