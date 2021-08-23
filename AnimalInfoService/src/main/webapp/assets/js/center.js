$(function() {

    $("#region_select").change(function(){
        let region = $("#region_select").find("option:selected").val();
        getCenterRegionInfo(region);
    })

    getCenterRegionInfo("서울특");

    function getCenterRegionInfo(region) {
        let url = "http://localhost:8947/api/center?region="+region;

        $.ajax({
            type:"get",
            url:url,
            success:function(r) {
                console.log(r);

                let page = Math.ceil(r.data.length/10);
                for(let i=0; i<page; i++) {
                    $("#center_table").append('<tbody class="center_tbody"></tbody>');
                }
                for(let i=0; i<r.data.length; i++) {
                    let page = Math.floor(i/10);
                    // console.log(Math.floor(i/10));
                    let tag = 
                    '<tr>'+
                        // '<td>'+r.data[i].orgNm+'</td>'+
                        '<td>'+r.data[i].careNm+'</td>'+
                        '<td>'+r.data[i].careTel+'</td>'+
                        '<td>'+r.data[i].careAddr+'</td>'+
                        // '<td>'+r.data[i].careDogCnt+' 마리'+'</td>'+
                    '</tr>'
                    $(".center_tbody").eq(page).append(tag);
                }
                $(".center_tbody").eq(0).addClass("active");
                $("#center_next").click(function() {
                    let currentPage = Number($(".current").html());
                    currentPage++;
                    if(currentPage > r.data.length / 10) currentPage = Math.ceil(r.data.length / 10);
                    $(".current").html(currentPage);
                    $(".center_tbody").removeClass("active");
                    $(".center_tbody").eq(currentPage-1).addClass("active");
                    $(".total").html(Math.ceil(r.data.length / 10));
                })
                $("#center_prev").click(function() {
                    let currentPage = Number($(".current").html());
                    currentPage--;
                    if(currentPage < 1) currentPage = 1;
                    $(".current").html(currentPage);
                    $(".center_tbody").removeClass("active");
                    $(".center_tbody").eq(currentPage-1).addClass("active");
                })
                $(".centerRegionCnt").html(r.data.length);

            }
        })
    }
    $.ajax({
        type:"get",
        url:"/api/center/cnt",
        success:function(r) {
            console.log(r);

            $("#centerCntAll").html(r.data.centerCnt);
        }
    })
})
