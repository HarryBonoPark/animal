$(function(){
    $("#category").addClass("current");

    $.ajax({
        type:"get",
        url:"/api/category/list",
        success:function(r){
            for(let i=0; i<r.data.length; i++){
                let tag = '<tr>'+
                '<td>'+r.data[i].cate_seq+'</td>'+
                '<td>'+r.data[i].cate_name+'</td>'+
                '<td><button data-seq="'+r.data[i].cate_seq+'" class="cate_del"'+'>삭제</button></td></tr>';
                $("#cate_tb_body").append(tag);
            }
            $(".cate_del").click(function(){
                // alert("delete"); // 메시지만 출력
                // $(this) - 클래스가 cate_del인 버튼 중 현재 클릭된 버튼
                // $(this) - 클래스가 cate_del인 것들 중 현재 클릭 이벤트를 발생시킨 태그
                // attr("data-seq") 태그에 지정된 속성 중 data-seq의 값을 가져온다.
                let seq = $(this).attr("data-seq");
                if(confirm("삭제하시겠습니까?")){
                    // 삭제동작
                    // console.log("삭제동작");
                    $.ajax({
                        type:"delete",
                        url:"/api/category/delete?seq="+seq,
                        success:function(r){
                            alert(r.message);
                            location.reload();
                        }
                    })
                }
            })
        }
    })

    $("#add").click(function(){
        let name = $("#cate_name").val();
        if(name == '' || name == null || name == undefined){
            alert("카테고리명을 입력하세요.");
            return;
        }
        let data = {
            cate_name:name
        }
        $.ajax({
            type:"get",
            url:"/api/category/add?name="+name,
            success:function(data){
                alert(data.message);
                location.reload();
            },
            error: function (data) {
                console.log(data);
            }
        })
    })
})