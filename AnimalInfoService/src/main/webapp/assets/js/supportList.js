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
    //지역별 지원하기 보기
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
                for(let i=0; i<r.data.length; i++){
                    let page = Math.floor(i/10);
                    let tag = 
                    '<tr>'+
                    '<td>'+(i+1)+'</td>'+
                    '<td>'+r.data[i].kind+'</td>'+
                    '<td>'+r.data[i].name+'</td>'+
                    '<td>'+r.data[i].title+'</td>'+
                    '<td><button class="modify" data-seq="'+r.data[i].seq+'">수정</button></td>'+
                    '<td><button class="delete" data-seq="'+r.data[i].seq+'">삭제</button></td>'+
                    '</tr>'
                    $(".support_tbody").eq(page).append(tag);
                }
                //삭제버튼 활성화
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
                //수정하기 버튼 클릭 시.
                $(".modify").click(function(){
                    //비밀번호 확인해야지 수정 가능한 기능
                    let pwd = prompt("비밀번호를 입력하세요");
                    console.log(pwd);
                    let seq = $(this).attr("data-seq");
                    let data = {
                        seq:seq,
                        password:pwd
                    }
                    //비밀번호 post매핑 이용해서 boolean으로 true/false 정하기
                    $.ajax({
                        type:"post",
                        url:"/api/check_pwd",
                        data:JSON.stringify(data),
                        contentType:"application/json",
                        success:function(r){
                            if(r == true) {
                                location.href = "/support?seq="+seq;
                            }
                            else {
                                alert("비밀번호 오류입니다.");
                            }
                        }
                    })
                    return;
                    location.href = "/support?seq="+seq;
                })
                
                $(".support_tbody").eq(0).addClass("active");
            }
        });
    }

})