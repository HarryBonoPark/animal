$(function(){
    let data_length;
    let currentPage = 1;

    getSupportList("all")

    $(".region").click(function () {
        $(".region").removeClass("selected");
        $(this).addClass("selected");
        let region = $(this).find(".plain_name").attr("data-region");
        getSupportList(region);
    })

    function getSupportList(region){
        let url="http://localhost:8947/api/support?region="+region;

        $.ajax({
            type:"get",
            url:url,
            success:function(r){
                data_length = r.data.length;
                currentPage = 1;
                $(".total").html(Math.ceil(data_length / 10));
                console.log(r);
                $(".support_tbody").html("");
                let page = Math.ceil(r.data.length/10);
                for(let i=0; i<page; i++){
                    $("#support_table").append('<tbody class="support_tbody"></tbody>');
                }
                // if(r.data.length == 0) {
                //     $("#support_table").append('<div class="nodata"><img src="/assets/images/logo.svg"><h1>등록된 게시글이 없습니다.</h1></div>')
                // }
                for(let i=0; i<r.data.length; i++){
                    let page = Math.floor(i/10);
                    let tag = 
                    '<tr>'+
                    '<td>'+(i+1)+'</td>'+
                    '<td>'+r.data[i].kind+'</td>'+
                    '<td>'+r.data[i].name+'</td>'+
                    '<td>'+r.data[i].title+'</td>'+
                    '<td><button class="delete" data-seq="'+r.data[i].seq+'">삭제</button></td>'
                    '</tr>'
                    $(".support_tbody").eq(page).append(tag);
                }
                $(".delete").click(function(){
                    let seq = $(this).attr("data-seq");
                    if(confirm("삭제 하시겠습니까?")){
                        $.ajax({
                            type:"delete",
                            url:"/api/delete?seq="+seq,
                            success:function(r){
                                alert(r.message);
                                location.reload();
                            }
                        })
                    }
                })
                $(".support_tbody").eq(0).addClass("active");
            }



        });
    }

})