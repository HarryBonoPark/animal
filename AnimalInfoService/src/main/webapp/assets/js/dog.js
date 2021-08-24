$(function () {
    let totalPage = 0;
    let currentPage = 1;
    $.ajax({
        type: "get",
        url: "/api/dog/today",
        success: function (r) {
            console.log(r);
            $(".dog_area").html("");
            totalPage = Math.ceil(r.dogList.length / 12);
            $(".total").html(totalPage);
            for (let i = 0; i < totalPage; i++) {
                let tag = "<div class='dog-tbody'></div>";
                $(".dog_area").append(tag);
            }
            for (let i = 0; i < r.dogList.length; i++) {
                let page = Math.floor(i / 12);
                console.log(Math.floor(i / 12));
                if (r.dogList[i].filename == null) filename = "사진 파일이 없습니다";
                let tag =
                    '<div class="dog_box">' +
                    '<p class="dogfile">' +
                    '<img src="' + r.dogList[i].filename + '">' +
                    '</p>' +
                    '<p class="dogShelter">' +
                    '<span class="shelter">' + "[" + r.dogList[i].careNm + "]" + '</span>' +
                    '</p>' +
                    '<p class="kind">' +
                    '<span>품종: </span>' +
                    '<span class="dogKind">' + r.dogList[i].kindCd + '</span>' +
                    '</p>' +
                    '<p class="dogprofile">' +
                    '<span>등록일: </span>' +
                    '<span class="register">' + makeDate(new Date(r.dogList[i].noticeSdt)) + '</span>' +
                    '</p>' +
                    '<p class="dogGen">' +
                    '<span>성별: </span>' +
                    '<span class="gen">' + r.dogList[i].sex + '</span>' +
                    '</p>' +
                    '<p class="dogAge">' +
                    '<span>나이: </span>' +
                    '<span class=" age">' + r.dogList[i].age + '</span>' +
                    '</p>' +
                    '<button class="popOpenBtnCmmn" data-num="' + r.dogList[i].seq + '">상세정보</button>' +
                    '</div>'
                $(".dog-tbody").eq(page).append(tag);
            }
            
            // $(".dog-tbody").eq(0).addClass("active");
            $(".popOpenBtnCmmn").click(function () {
                $(".dog_form").css("display", "block");
                let seq = $(this).attr("data-num");
                console.log($(this).attr("data-num"));
                $.ajax({
                    type: "get",
                    url: "/api/dogDetailInfo/" + seq,
                    success: function (r) {
                        console.log(r);
                        $(".dog_form").html("");
                        let tag =
                            '<h1>상세 정보</h1>' +
                            '<p class="dogfile">' +
                            '<img src="' + r.data.popfile + '">' +
                            '</p>' +
                            '<p class="kind">' +
                            '<span>품종: </span>' +
                            '<span class="dogKind">' + r.data.kindCd + '</span>' +
                            '</p>' +
                            '<p class="dogprofile">' +
                            '<span>등록일: </span>' +
                            '<span class="register">' + makeDate(new Date(r.data.noticeSdt)) + '</span>' +
                            '</p>' +
                            '<p class="dogGen">' +
                            '<span>성별: </span>' +
                            '<span class="gen">' + r.data.sex + '</span>' +
                            '</p>' +
                            '<p class="dogAge">' +
                            '<span>나이: </span>' +
                            '<span class=" age">' + r.data.kindCd + '</span>' +
                            '</p>' +
                            '<p class="color">' +
                            '<span>색상: </span>' +
                            '<span class="color">' + r.data.colorCd + '</span>' +
                            '</p>' +
                            '<p class="weight">' +
                            '<span>무게: </span>' +
                            '<span class="weight">' + r.data.weight + '</span>' +
                            '</p>' +
                            '<p class="neuterYn">' +
                            '<span>중성화: </span>' +
                            '<span class="sexYn">' + r.data.sexYn + '</span>' +
                            '</p>' +
                            '<p class="dogShelters">' +
                            '<span>보호소: </span>' +
                            '<span class="shelters">' + r.data.careNm + '</span>' +
                            '</p>' +
                            '<p class="careAddr">' +
                            '<span>주소: </span>' +
                            '<span class="careAddr">' + r.data.careAddr + '</span>' +
                            '</p>' +
                            '<p class="careTel">' +
                            '<span>전화번호: </span>' +
                            '<span class="careTel">' + r.data.careTel + '</span>' +
                            '</p>' +
                            '<p class="happenPlace">' +
                            '<span>발견 장소: </span>' +
                            '<span class="happenPlace">' + r.data.happenPlace + '</span>' +
                            '</p>' +
                            '<p class="processState">' +
                            '<span>보호 여부: </span>' +
                            '<span class="processState">' + r.data.processState + '</span>' +
                            '</p>' +
                            '<p class="specialMark">' +
                            '<span>특징: </span>' +
                            '<span class="specialMark">' + r.data.specialMark + '</span>' +
                            '</p>' +
                            '<button id="popCloseBtnCmmn" data-num="1">확인</button>'
                        $(".dog_form").append(tag);
                        $("#popCloseBtnCmmn").click(function () {
                            $(".dog_form").css("display", "none");
                        })
                    }
                })
            })
            $(".dog-tbody").eq(0).addClass("active");
            $("#next").click(function () {
                // let currentPage = Number($(".current").html()); // 숫자형태로 바꿔주기
                currentPage++;
                if (currentPage > totalPage) currentPage = totalPage;
                $(".current").html(currentPage);
                $(".dog-tbody").removeClass("active");
                $(".dog-tbody").eq(currentPage - 1).addClass("active");
                console.log(currentPage);
            })
            $("#prev").click(function () {
                // let currentPage = Number($(".current").html());
                currentPage--;
                if (currentPage < 1) currentPage = 1;
                $(".current").html(currentPage);
                $(".dog-tbody").removeClass("active");
                $(".dog-tbody").eq(currentPage - 1).addClass("active");
            })
        }

    });
    $(".region").click(function () {
        // $(".content_head").css("display","block");
        // let region = $(".region").find("option:click").val();   
        // getRegionDog(region);
        let region = $(this).find(".plain_name").attr("data-region");
        getRegionDog(region);
    })

    getRegionDog("부산광");

    function getRegionDog(region) {
        let url = "http://localhost:8947/api/regionDog?region=" + region;
        $.ajax({
            type: "get",
            url: url,
            success: function (r) {
                console.log(r);
                currentPage = 1;
                $(".current").html(currentPage);
                $(".dog_area").html("");
                totalPage = Math.ceil(r.dogList.length / 12);
                $(".total").html(totalPage);
                for (let i = 0; i < totalPage; i++) {
                    let tag = "<div class='dog-tbody'></div>";
                    $(".dog_area").append(tag);
                }
                for (let i = 0; i < r.dogList.length; i++) {
                    let page = Math.floor(i / 12);
                    let tag =
                        '<div class="dog_box">' +
                        '<p class="dogfile">' +
                        '<img src="' + r.dogList[i].filename + '">' +
                        '</p>' +
                        '<p class="dogShelter">' +
                        '<span class="shelter">' + "[" + r.dogList[i].careNm + "]" + '</span>' +
                        '</p>' +
                        '<p class="kind">' +
                        '<span>품종: </span>' +
                        '<span class="dogKind">' + r.dogList[i].kindCd + '</span>' +
                        '</p>' +
                        '<p class="dogprofile">' +
                        '<span>등록일: </span>' +
                        '<span class="register">' + makeDate(new Date(r.dogList[i].noticeSdt)) + '</span>' +
                        '</p>' +
                        '<p class="dogGen">' +
                        '<span>성별: </span>' +
                        '<span class="gen">' + r.dogList[i].sex + '</span>' +
                        '</p>' +
                        '<p class="dogAge">' +
                        '<span>나이: </span>' +
                        '<span class=" age">' + r.dogList[i].age + '</span>' +
                        '</p>' +
                        '<button class="popOpenBtnCmmn" data-num="' + r.dogList[i].seq + '">상세정보</button>' +
                        '</div>'
                    $(".dog-tbody").eq(page).append(tag);
                }
                $(".dog-tbody").eq(0).addClass("active");
                $(".popOpenBtnCmmn").click(function () {
                    $(".dog_form").css("display", "block");
                    let seq = $(this).attr("data-num");
                    console.log($(this).attr("data-num"));
                    $.ajax({
                        type: "get",
                        url: "/api/dogDetailInfo/" + seq,
                        success: function (r) {
                            console.log(r);
                            $(".dog_form").html("");
                            let tag =
                                '<h1>상세 정보</h1>' +
                                '<p class="dogfile">' +
                                '<img src="' + r.data.popfile + '">' +
                                '</p>' +
                                '<p class="kind">' +
                                '<span>품종: </span>' +
                                '<span class="dogKind">' + r.data.kindCd + '</span>' +
                                '</p>' +
                                '<p class="dogprofile">' +
                                '<span>등록일: </span>' +
                                '<span class="register">' + makeDate(new Date(r.data.noticeSdt)) + '</span>' +
                                '</p>' +
                                '<p class="dogGen">' +
                                '<span>성별: </span>' +
                                '<span class="gen">' + r.data.sex + '</span>' +
                                '</p>' +
                                '<p class="dogAge">' +
                                '<span>나이: </span>' +
                                '<span class=" age">' + r.data.kindCd + '</span>' +
                                '</p>' +
                                '<p class="color">' +
                                '<span>색상: </span>' +
                                '<span class="color">' + r.data.colorCd + '</span>' +
                                '</p>' +
                                '<p class="weight">' +
                                '<span>무게: </span>' +
                                '<span class="weight">' + r.data.weight + '</span>' +
                                '</p>' +
                                '<p class="neuterYn">' +
                                '<span>중성화: </span>' +
                                '<span class="sexYn">' + r.data.sexYn + '</span>' +
                                '</p>' +
                                '<p class="dogShelters">' +
                                '<span>보호소: </span>' +
                                '<span class="shelters">' + r.data.careNm + '</span>' +
                                '</p>' +
                                '<p class="careAddr">' +
                                '<span>주소: </span>' +
                                '<span class="careAddr">' + r.data.careAddr + '</span>' +
                                '</p>' +
                                '<p class="careTel">' +
                                '<span>전화번호: </span>' +
                                '<span class="careTel">' + r.data.careTel + '</span>' +
                                '</p>' +
                                '<p class="happenPlace">' +
                                '<span>발견 장소: </span>' +
                                '<span class="happenPlace">' + r.data.happenPlace + '</span>' +
                                '</p>' +
                                '<p class="processState">' +
                                '<span>보호 여부: </span>' +
                                '<span class="processState">' + r.data.processState + '</span>' +
                                '</p>' +
                                '<p class="specialMark">' +
                                '<span>특징: </span>' +
                                '<span class="specialMark">' + r.data.specialMark + '</span>' +
                                '</p>' +
                                '<button id="popCloseBtnCmmn" data-num="1">확인</button>'
                            $(".dog_form").append(tag);
                            $("#popCloseBtnCmmn").click(function () {
                                $(".dog_form").css("display", "none");
                            })
                        }
                    })
                })
            }
        })
    }


    //     $.ajax({
    //         type:"get",
    //         url:"/api/dogDetailInfo/today",
    //         success:function(r){
    //             console.log(r);
    //             $(".dog_form").html("");
    //             for (let i=0; i<r.dogList.length; i++){
    //                 let tag = 
    //                 '<div id="popUp" class="dog_form">'+
    //                 '<div class="popBg" data-num="1"></div>'+
    //                 '<h1>상세 정보</h1>'+
    //                     '<p class="dogfile">'+
    //                         '<img src="'+r.dogList[i].filename+'">'+
    //                     '</p>'+
    //                     '<p class="kind">'+
    //                         '<span>품종</span>'+
    //                         '<span class="dogKind">'+r.dogList[i].kindCd+'</span>'+
    //                     '</p>'+
    //                     '<p class="dogprofile">'+
    //                         '<span>등록일</span>'+
    //                         '<span class="register">'+r.dogList[i].noticeSdt+'</span>'+
    //                     '</p>'+
    //                     '<p class="dogGen">'+
    //                         '<span>성별</span>'+
    //                         '<span class="gen">'+r.dogList[i].sex+'</span>'+
    //                     '</p>'+
    //                     '<p class="dogAge">'+
    //                         '<span>나이</span>'+
    //                         '<span class=" age">'+r.dogList[i].kindCd+'</span>'+
    //                     '</p>'+
    //                     '<p class="color">'+
    //                         '<span>색상</span>'+
    //                         '<span class="color">'+r.dogList[i].colorCd+'</span>'+
    //                     '</p>'+
    //                     '<p class="weight">'+
    //                         '<span>무게</span>'+
    //                         '<span class="weight">'+r.dogList[i].weight+'</span>'+
    //                     '</p>'+
    //                     '<p class="neuterYn">'+
    //                         '<span>중성화</span>'+
    //                         '<span class="sexYn">'+r.dogList[i].sexYn+'</span>'+
    //                     '</p>'+
    //                     '<p class="dogShelter">'+
    //                         '<span>보호소</span>'+
    //                         '<span class="shelter">'+r.dogList[i].careNm+'</span>'+
    //                     '</p>'+
    //                     '<p class="careAddr">'+
    //                         '<span>주소</span>'+
    //                         '<span class="careAddr">'+r.dogList[i].careAddr+'</span>'+
    //                     '</p>'+
    //                     '<p class="careTel">'+
    //                         '<span>전화번호</span>'+
    //                         '<span class="careTel">'+r.dogList[i].careTel+'</span>'+
    //                     '</p>'+
    //                     '<p class="happenPlace">'+
    //                         '<span>발견장소</span>'+
    //                         '<span class="happenPlace">'+r.dogList[i].happenPlace+'</span>'+
    //                     '</p>'
    //                     '<p class="processState">'
    //                         '<span>보호 여부</span>'
    //                         '<span class="processState">'+r.dogList[i].processState+'</span>'
    //                     '</p>'
    //                     '<p class="specialMark">'
    //                         '<span>특징: </span>'
    //                         '<span class="specialMark">'+r.dogList[i].specialMark+'</span>'
    //                     '</p>'+
    //                     '<button id="popCloseBtnCmmn" data-num="1">확인</button>'+
    //                 '</div>'
    //                 $(".dog_form").append(tag);
    //             }
    //         }
    //     })
    // });

})


function makeDate(dt) {
    return dt.getFullYear() + "-" + leadingZero(dt.getMonth() + 1) + "-" + leadingZero(dt.getDate());
}

function leadingZero(n) {
    return n < 10 ? "0" + n : "" + n;
}

$(function () {
    $(".dog_form").draggable({
        handle: "h1"
    })
})
