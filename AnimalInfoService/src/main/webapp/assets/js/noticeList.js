$(function(){
    function makeDate(dt) {
        return dt.getFullYear()+"-"+leadingZero(dt.getMonth()+1)+"-"+leadingZero(dt.getDate());
    }
    function leadingZero(n) {
        return n<10?"0"+n:""+n;
    }

    $("#notice").addClass("current");
    getNoticeDate();

    $("#search").click(function () {
        let seq = $("#cate_search option:selected").val();
        let keyword = $("#search_keyword").val();
        if (seq == "전체") seq = null;
        getNoticeDate(keyword, seq, 0);
    })

    $("#cate_search").change(function () {
        let seq = $("#cate_search option:selected").val();
        let keyword = $("#search_keyword").val();
        if (seq == "전체") seq = null;
        getNoticeDate(keyword, seq, 0);
    })

    function getNoticeDate(keyword, cate_seq, offset){
        $("#notice_tbody").html("");

        

        let url = "/api/notice/list";
        if (keyword == undefined || keyword == null) {
            keyword = "";
        }
        url += "?keyword=" + keyword
        if (cate_seq != undefined && cate_seq != null) {
            url += "&category=" + cate_seq
        }
        if (offset != undefined && offset != null) {
            url += "&offset=" + offset;
        }

        $.ajax({
            type:"get",
            url:url,
            success:function(r){
                $("#notice_tbody").html("");
                for(let i=0; i<r.data.length; i++){
                    let tag = '<tr>'+
                        '<td>'+r.data[i].seq+'</td>'+
                        '<td><a href="/noticeDetail?seq='+r.data[i].seq+'">'+'['+r.data[i].cate_name+'] '+r.data[i].title+'</a></td>'+
                        '<td>'+makeDate(new Date(r.data[i].create_dt))+'</td>'+
                    '</tr>'
                    $("#notice_tbody").append(tag);
                }
            }
        })
    }
    
})