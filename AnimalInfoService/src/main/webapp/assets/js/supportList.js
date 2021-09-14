$(function () {

    //지역별 리스트 가져오기
    let totalPage = 0;
    getSupportList("all")

    $(".region").click(function () {
        $(".region").removeClass("selected");
        $(this).addClass("selected");
        let region = $(this).find(".plain_name").attr("data-region");
        getSupportList(region);

    })
    function getSupportList(region) {
        let url = "http://localhost:8947/api/support?region=" + region;
        $.ajax({
            type: "get",
            url: url,
            success: function (r) {
                //console.log(r);
                currentPage = 1;
                $(".current").html(currentPage);
                $(".support-tbody").html("");
                totalPage = Math.ceil(r.data.length / 10);
                $(".total").html(totalPage);
                for (let i = 0; i < totalPage; i++) {
                    let tag = '<tbody class="support-tbody"></tbody>';
                    $("#support_table").append(tag);
                }
                if(r.data.length== 0) {
                    $(".support-tbody").append('<div class="nodata"><img src="/assets/images/logo.svg"><h1>등록된 게시글이 없습니다.</h1></div>')
                }
                for (let i = 0; i < r.data.length; i++) {
                    let page = Math.floor(i / 10);
                    console.log(Math.floor(i / 10));
                    let tag =
                        '<tr>' +
                        '<td>' + (i + 1) + '</td>' +
                        '<td>' + r.data[i].careNm + '</td>' +
                        '<td>' + r.data[i].name + '</td>' +
                        '<td>' + r.data[i].title + '</td>' +
                        '<td><button class="modify" data-seq="' + r.data[i].seq + '">조회</button></td>' +
                        '<td><button class="delete" data-seq="' + r.data[i].seq + '">삭제</button></td>' +
                        '</tr>'
                    $(".support-tbody").eq(page).append(tag);
                }
                $(".support-tbody").eq(0).addClass("active");

                //삭제버튼 활성화
                $(".delete").click(function () {
                    let seq = $(this).attr("data-seq");
                    if (confirm("삭제 하시겠습니까?")) {
                        $.ajax({
                            type: "delete",
                            url: "/api/delete?seq=" + seq,
                            success: function (r) {
                                alert(r.message);
                                location.reload();
                            }
                        })
                    }
                })
                //수정하기 버튼 클릭 시.
                $(".modify").click(function () {
                    //비밀번호 확인해야지 수정 가능한 기능
                    let pwd = prompt("비밀번호를 입력하세요");
                    //console.log(pwd);
                    let seq = $(this).attr("data-seq");
                    let data = {
                        seq: seq,
                        password: pwd
                    }
                    //비밀번호 post매핑 이용해서 boolean으로 true/false 정하기
                    $.ajax({
                        type: "post",
                        url: "/api/check_pwd",
                        data: JSON.stringify(data),
                        contentType: "application/json",
                        success: function (r) {
                            if (r == true) {
                                location.href = "/support?seq=" + seq;
                            } else {
                                alert("비밀번호 오류입니다.");
                            }
                        }
                    })
                    return;
                    location.href = "/support?seq=" + seq;
                })
            }
        });
    }
    //키워드 가져오기
    $("#search").click(function () {
        //alert("클릭")
        let keyword = $("#keyword").val();
        loadKeyword(keyword, 0);
    })

    function loadKeyword(keyword, offset) {
        $.ajax({
            type: "get",
            url: "/get/Keyword?keyword=" + keyword + "&offset=" + offset,
            success: function (r) {
                $(".support-tbody").html("");
                for (let i = 0; i < r.data.length; i++) {
                    let tag =
                        '<tr>' +
                        '<td>' + (i + 1) + '</td>' +
                        '<td>' + r.data[i].careNm + '</td>' +
                        '<td>' + r.data[i].name + '</td>' +
                        '<td>' + r.data[i].title + '</td>' +
                        '<td><button class="modify" data-seq="' + r.data[i].seq + '">조회</button></td>' +
                        '<td><button class="delete" data-seq="' + r.data[i].seq + '">삭제</button></td>' +
                        '</tr>'
                    $(".support-tbody").append(tag);
                }
                //삭제버튼 활성화
                $(".delete").click(function () {
                    let seq = $(this).attr("data-seq");
                    if (confirm("삭제 하시겠습니까?")) {
                        $.ajax({
                            type: "delete",
                            url: "/api/delete?seq=" + seq,
                            success: function (r) {
                                alert(r.message);
                                location.reload();
                            }
                        })
                    }
                })
                //수정하기 버튼 클릭 시.
                $(".modify").click(function () {
                    //비밀번호 확인해야지 수정 가능한 기능
                    let pwd = prompt("비밀번호를 입력하세요");
                    //console.log(pwd);
                    let seq = $(this).attr("data-seq");
                    let data = {
                        seq: seq,
                        password: pwd
                    }
                    //비밀번호 post매핑 이용해서 boolean으로 true/false 정하기
                    $.ajax({
                        type: "post",
                        url: "/api/check_pwd",
                        data: JSON.stringify(data),
                        contentType: "application/json",
                        success: function (r) {
                            if (r == true) {
                                location.href = "/support?seq=" + seq;
                            } else {
                                alert("비밀번호 오류입니다.");
                            }
                        }
                    })
                    return;
                    location.href = "/support?seq=" + seq;
                })
            }
        })
    }


    $("#next").click(function () {
        currentPage++;
        if (currentPage > totalPage) currentPage = totalPage;
        $(".current").html(currentPage);
        $(".support-tbody").removeClass("active");
        $(".support-tbody").eq(currentPage - 1).addClass("active");
        console.log(currentPage);
    })

    $("#prev").click(function () {
        currentPage--;
        if (currentPage < 1) currentPage = 1;
        $(".current").html(currentPage);
        $(".support-tbody").removeClass("active");
        $(".support-tbody").eq(currentPage - 1).addClass("active");
    })

})