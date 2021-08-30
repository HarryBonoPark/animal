$(function() {

    let data_length;
    let currentPage = 1;

    $(".region").click(function() {
        $(".region").removeClass("selected");
        $(this).addClass("selected");
        let region = $(this).find(".plain_name").attr("data-region");
        getCatRegionInfo(region);
    })

    getCatRegionInfo("all");

    function getCatRegionInfo(region) {
        let url = "http://localhost:8947/api/cat/list?region="+region;

        $.ajax({
            type:"get",
            url:url,
            success:function(r) {
                data_length = r.catList.length;
                currentPage = 1;
                $(".total").html(Math.ceil(data_length / 12));
                $(".cat_tbody").html("");
                let page = Math.ceil(data_length / 12);

                for(let i=0; i<page; i++) {
                    $(".cat_area").append("<div class='cat_tbody'></div>");
                }
                for(let i=0; i<data_length; i++) {
                    let page = Math.floor(i / 12) ;
                    if(r.catList[i].filename == null) filename = "사진 파일이 없습니다";
                    let tag =
                    '<div class="cat_box">'+
                        '<p class="catfile">'+
                            '<img src="'+r.catList[i].filename+'">'+
                        '</p>'+
                        '<p class="catLine"></p>'+
                        '<p class="catShelter">'+
                                '<span class="shelter">' + "[" + r.catList[i].careNm + "]" + '</span>'+
                        '</p>'+
                        '<p class="kind">'+
                                '<span><i class="fas fa-cat"></i></span>'+
                                '<span class="catKind">'+r.catList[i].kind+'</span>'+
                        '</p>'+
                        '<p class="catprofile">'+
                                '<span><i class="far fa-calendar-check"></i></span>'+
                                '<span class="register">'+makeDate(new Date(r.catList[i].noticeSdt))+'</span>'+
                        '</p>'+
                        '<p class="catGen">'+
                                '<span><i class="fas fa-venus-mars"></i></span>'+
                                '<span class="gen">'+r.catList[i].sex+'</span>, '+
                                '<span class="age">'+r.catList[i].age+'</span>'+
                        '</p>'+
                        '<p class="catAge">'+
                            '<span></span>'+
                        '</p>'+
                        '<button class="popOpenBtnCmmn" data-num="'+r.catList[i].seq+'"><i class="fas fa-search-plus"></i><br><span>상세정보</span></button>'+
                    '</div>'
                    $(".cat_tbody").eq(page).append(tag);
                }

                resizeAnimalImageInit();
                $(".cat_tbody").eq(0).addClass("active");

                // 팝업
                $(".popOpenBtnCmmn").click(function() {
                    $(".cat_form").css("display", "block");
                    let seq = $(this).attr("data-num");
                    let url = "http://localhost:8947/api/cat/detail?seq="+seq;
                    $.ajax({
                        type:"get",
                        url:url,
                        success:function(r) {
                            console.log(r);
                            $(".cat_form").html("");
                            let tag =
                            '<div class="cat_form_contents">'+
                                    '<div class="cat_form_img_box">'+
                                        '<p class="catfile">' +
                                            '<img src="' + r.data.popfile + '">' +
                                        '</p>' +
                                    '</div>'+
                                    '<div class="cat_form_description_box">'+
                                        '<p class="catShelters">' +
                                            '<span class="shelters">' + r.data.careNm + '</span>' +
                                        '</p>' +
                                        '<p class="kind">' +
                                            '<span class="catKind">' + r.data.kind + '</span>' +
                                            '<span class="gen"> (' + r.data.sex + ')</span>' +
                                        '</p>' +
                                        '<p class="happenPlace">' +
                                            '<span>발견 장소: </span>' +
                                            '<span class="happenPlace">' + r.data.happenPlace + '</span>' +
                                        '</p>' +
                                        '<p class="specialMark">' +
                                            '<span>특징: </span>' +
                                            '<span class="specialMark">' + r.data.specialMark + '</span>' +
                                        '</p>' +
                                        '<p class="color">' +
                                            '<span>색상: </span>' +
                                            '<span class="color">' + r.data.colorCd + '</span>' +
                                        '</p>' +
                                        '<p class="catAge">' +
                                            '<span>나이: </span>' +
                                            '<span class=" age">' + r.data.age + '</span>' +
                                        '</p>' +
                                        '<p class="weight">' +
                                            '<span>체중: </span>' +
                                            '<span class="weight">' + r.data.weight + '</span>' +
                                        '</p>' +
                                        '<p class="neuterYn">' +
                                            '<span>중성화: </span>' +
                                            '<span class="sexYn">' + r.data.sexYn + '</span>' +
                                        '</p>' +
                                        '<p class="processState">' +
                                            '<span>보호 여부: </span>' +
                                            '<span class="processState">' + r.data.processState + '</span>' +
                                        '</p>' +
                                        '<p class="catprofile">' +
                                            '<span>등록일: </span>' +
                                            '<span class="register">' + makeDate(new Date(r.data.noticeSdt)) + '</span>' +
                                        '</p>' +
                                        '<p class="careAddr">' +
                                            '<span>주소: </span>' +
                                            '<span class="careAddr">' + r.data.careAddr + '</span>' +
                                        '</p>' +
                                        '<p class="careTel">' +
                                            '<span>전화번호: </span>' +
                                            '<span class="careTel">' + r.data.careTel + '</span>' +
                                        '</p>' +
                                    '</div>'+
                                    '<button id="popCloseBtnCmmn" data-num="1"><i class="fas fa-times"></i><button>'+
                                '</div>'

                            $(".cat_form").append(tag);
                            $("#popCloseBtnCmmn").click(function() {
                                $(".cat_form").css("display", "none");
                            })
                        }
                    })
                })
            }
        })
    }
    $("#cat_page_next").click(function () {
        currentPage++;
        if (currentPage > data_length) currentPage = Math.ceil(data_length / 12);
        $(".current").html(currentPage);
        $(".cat_tbody").removeClass("active");
        $(".cat_tbody").eq(currentPage - 1).addClass("active");
        resizeAnimalImage();
    })
    $("#cat_page_prev").click(function () {
        currentPage--;
        if (currentPage < 1) currentPage = 1;
        $(".current").html(currentPage);
        $(".cat_tbody").removeClass("active");
        $(".cat_tbody").eq(currentPage - 1).addClass("active");
        resizeAnimalImage();
    })

    function resizeAnimalImageInit() {
        for(let i=0; i<$(".cat_box .catfile img").length; i++) {
            $(".cat_box .catfile img").eq(i).on("load", function(){
                let w = $(".cat_box .catfile img").eq(i).width();
                let h = $(".cat_box .catfile img").eq(i).height();
                // console.log("w"+w, "h"+h)
                if(w >= h) {
                    $(".cat_box .catfile img").eq(i).css("height", "110%");
                }
                else {
                    $(".cat_box .catfile img").eq(i).css("width", "110%");
                }
            })
        }
    }
    function resizeAnimalImage() {
        for(let i=0; i<$(".cat_box .catfile img").length; i++) {
            let w = $(".cat_box .catfile img").eq(i).width();
            let h = $(".cat_box .catfile img").eq(i).height();
            // console.log("w"+w, "h"+h)
            if(w >= h) {
                $(".cat_box .catfile img").eq(i).css("height", "110%");
            }
            else {
                $(".cat_box .catfile img").eq(i).css("width", "110%");
            }
        }
    }
})

function makeDate(dt) {
    return dt.getFullYear()+"-"+leadingZero(dt.getMonth() + 1)+"-"+leadingZero(dt.getDate());
}
function leadingZero(n) {
    return n < 10 ? "0" + n : "" + n;
}