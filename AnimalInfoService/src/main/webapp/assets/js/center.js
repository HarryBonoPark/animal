$(function() {
    let data_length;
    let currentPage = 1;

    $("#region_select").change(function(){
        let region = $("#region_select").find("option:selected").val();
        getCenterRegionInfo(region);
    })

    getCenterRegionInfo("서울특");

    function getCenterRegionInfo(region) {
        let url = "http://localhost:8947/api/center/region?region="+region;

        $.ajax({
            type:"get",
            url:url,
            success:function(r) {
                data_length = r.data.length;
                currentPage = 1;
                $(".total").html(Math.ceil(data_length / 20));
                console.log(r);
                $(".center_tbody").html("");
                let page = Math.ceil(r.data.length/20);
                for(let i=0; i<page; i++) {
                    $("#center_table").append('<tbody class="center_tbody"></tbody>');
                }
                for(let i=0; i<r.data.length; i++) {
                    let page = Math.floor(i/20);
                    // console.log(Math.floor(i/20));
                    let tag = 
                    '<tr>'+
                        '<td>'+(i+1)+'</td>'+
                        '<td>'+r.data[i].careNm+'</td>'+
                        '<td>'+r.data[i].careTel+'</td>'+
                        '<td>'+r.data[i].careAddr+'</td>'+
                        '<td><a href="/center/detail?seq='+r.data[i].seq+'" class="center_detail_a">detail</a></td>'+
                    '</tr>'
                    $(".center_tbody").eq(page).append(tag);
                }
                $(".center_tbody").eq(0).addClass("active");
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
    $("#center_next").click(function() {
        currentPage++;
        if(currentPage > data_length / 20) currentPage = Math.ceil(data_length / 20);
        $(".current").html(currentPage);
        $(".center_tbody").removeClass("active");
        $(".center_tbody").eq(currentPage-1).addClass("active");
    })
    $("#center_prev").click(function() {
        currentPage--;
        if(currentPage < 1) currentPage = 1;
        $(".current").html(currentPage);
        $(".center_tbody").removeClass("active");
        $(".center_tbody").eq(currentPage-1).addClass("active");
    })
})
