$(function() {
    $.ajax({
        type:"get",
        url:"/api/center",
        success:function(r) {
            console.log(r);

            for(let i=0; i<r.data.length; i++) {
                let page = Math.floor(i/10);
                // console.log(Math.floor(i/10));
                let tag = 
                '<tr>'+
                    // '<td>'+r.data[i].orgNm+'</td>'+
                    '<td>'+r.data[i].careNm+'</td>'+
                    '<td>'+r.data[i].careTel+'</td>'+
                    '<td>'+r.data[i].careAddr+'</td>'+
                    '<td>'+r.data[i].careDogCnt+' 마리'+'</td>'+
                '</tr>'
                $("#center_tbody").eq(page).append(tag);
            }
            $(".center_tbody").eq(0).addClass("active");
            
            $("#center_next").click(function() {
                let currentPage = Number($(".current").html());
                currentPage++;
                if(currentPage > r.data.length / 10) currentPage = Math.floor(r.data.length / 10) + 1;
                $(".current").html(currentPage);
                $(".center_tbody").removeClass("active");
                $(".center_tbody").eq(currentPage-1).addClass("active");
            })
            
            $("#center_prev").click(function() {
                let currentPage = Number($(".current").html());
                currentPage--;
                if(currentPage < 1) currentPage = 1;
                $(".current").html(currentPage);
                $(".center_tbody").removeClass("active");
                $(".center_tbody").eq(currentPage-1).addClass("active");
            })
        }
    })
})