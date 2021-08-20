$(function() {

    getAnimalCenterInfo("보호중")

    function getAnimalCenterInfo(processState) {
        let url="http://localhost:8947/api/center?processState="+processState;
    }

    $.ajax({
        type:"get",
        url:url,
        success:function(r) {
            console.log(r);
            // for(let i=0; i<r.data.lenght; i++) {
            //     let tag =
            //     '<tr>'+
            //         '<td>'+r.data[i].orgNm+'</td>'+
            //         '<td>'+r.data[i].careNm+'</td>'+
            //         '<td>'+r.data[i].careAddr+'</td>'+
            //         '<td>'+r.data[i].careTel+'</td>'+
            //         '<td>'+r.data[i].careDogCnt+'</td>'+
            //     '</tr>'
            // $("#center_table_body").append(tag);
            // }
        }
    })
})