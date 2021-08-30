$(function () {
    let totalPage = 0;

    $(".region").click(function () {
        $(".region").removeClass("selected");
        $(this).addClass("selected");
        let region = $(this).find(".plain_name").attr("data-region");
        getOtherRegionInfo(region);
    })

    getOtherRegionInfo('all');

    function getOtherRegionInfo(region) {
        $.ajax({
            type: "get",
            url: "http://localhost:8947/api/regionOther?region="+region,
            success: function (r) {
                //console.log(r);
                currentPage = 1;
                $(".current").html(currentPage);
                $(".other_area").html("");
                totalPage = Math.ceil(r.otherList.length / 12);
                $(".total").html(totalPage);
                for(let i=0; i< totalPage; i++){
                    let tag = "<div class='other-tbody'></div>";
                    $(".other_area").append(tag);
                }
                if(r.otherList.length == 0) {
                    $(".other_area").append('<div class="nodata"><img src="/assets/images/logo.svg"><h1>등록된 유기동물이 없습니다.</h1></div>')
                }
                for (let i = 0; i < r.otherList.length; i++) {
                    let page =Math.floor(i / 12);
                    let tag =
                        '<div class="other_box">' +
                        '<p class="otherfile">' +
                        '<img src="' + r.otherList[i].filename + '">' +
                        '</p>' +
                        '<p class="otherLine"></p>' +
                        '<p class="otherShelter">' +
                        '<span class="shelter">' + "[" + r.otherList[i].careNm + "]" + '</span>' +
                        '</p>' +
                        '<p class="kind">' +
                        '<span><i class="fas fa-other"></i></span>' +
                        '<span class="otherKind">' + r.otherList[i].kindCd + '</span>' +
                        '</p>' +
                        '<p class="otherprofile">' +
                        '<span><i class="far fa-calendar-check"></i></span>' +
                        '<span class="register">' + makeDate(new Date(r.otherList[i].noticeSdt)) + '</span>' +
                        '</p>' +
                        '<p class="otherGen">' +
                        '<span><i class="fas fa-venus-mars"></i></span>' +
                        '<span class="gen">' + r.otherList[i].sex + '</span>, ' +
                        '<span class=" age">' + r.otherList[i].age + '</span>' +
                        '</p>' +
                        '<button class="popUpBtnCmmn" data-num="' + r.otherList[i].seq + '"><i class="fas fa-search-plus"></i><br><span>상세정보</span></button>' +
                        '</div>';
                    $(".other-tbody").eq(page).append(tag);
                }
                resizeAnimalImageInit();
                $(".other-tbody").eq(0).addClass("active");

                // 상세정보 보기
                $(".popUpBtnCmmn").click(function(){
                    $(".other_form").css("display","block");
                    let seq = $(this).attr("data-num");
                    //console.log($(this).attr("data-num"));
                    $.ajax({
                        type:"get",
                        url:"/api/OtherDetailInfo/"+ seq,
                        success:function(r){
                            //console.log(r);
                            $(".other_form").html("");
                            let tag =
                            '<div class="other_form_contents">'+
                            '<div class="other_form_img_box">'+
                                '<p class="otherfile">' +
                                    '<img src="' + r.data.popfile + '">' +
                                '</p>' +
                            '</div>'+
                            '<div class="other_form_description_box">'+
                                '<p class="otherShelters">' +
                                    '<span class="shelters">' + r.data.careNm + '</span>' +
                                '</p>' +
                                '<p class="kind">' +
                                    '<span class="otherKind">' + r.data.kind + '</span>' +
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
                                '<p class="otherAge">' +
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
                                '<p class="otherprofile">' +
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
                            '<button id="popCloseBtnCmmn" data-num="1"><i class="fas fa-times"></i></button>'+
                        '</div>'
                        $(".other_form").append(tag);
                        $("#popCloseBtnCmmn").click(function(){
                            $(".other_form").css("display","none");
                        })

                        }
                    })
                })
            }
        })
    }
    $("#next").click(function () {
        currentPage++;
        if (currentPage > totalPage) currentPage = totalPage;
        $(".current").html(currentPage);
        $(".other-tbody").removeClass("active");
        $(".other-tbody").eq(currentPage - 1).addClass("active");
        console.log(currentPage);
        resizeAnimalImage();
    })

    $("#prev").click(function () {
        currentPage--;
        if (currentPage < 1) currentPage = 1;
        $(".current").html(currentPage);
        $(".other-tbody").removeClass("active");
        $(".other-tbody").eq(currentPage - 1).addClass("active");
        resizeAnimalImage();
    })

    function resizeAnimalImageInit() {
        for(let i=0; i<$(".other_box .otherfile img").length; i++) {
            $(".other_box .otherfile img").eq(i).on("load", function(){
                let w = $(".other_box .otherfile img").eq(i).width();
                let h = $(".other_box .otherfile img").eq(i).height();
                //console.log("w"+w, "h"+h)
                if(w >= h) {
                    $(".other_box .otherfile img").eq(i).css("height", "110%");
                }
                else {
                    $(".other_box .otherfile img").eq(i).css("width", "110%");
                }
            })
        }
    }
    function resizeAnimalImage() {
        for(let i=0; i<$(".other_box .otherfile img").length; i++) {
            let w = $(".other_box .otherfile img").eq(i).width();
            let h = $(".other_box .otherfile img").eq(i).height();
            //console.log("w"+w, "h"+h)
            if(w >= h) {
                $(".other_box .otherfile img").eq(i).css("height", "110%");
            }
            else {
                $(".other_box .otherfile img").eq(i).css("width", "110%");
            }
        }
    }
});

function makeDate(dt) {
    return dt.getFullYear() + "-" + leadingZero(dt.getMonth() + 1) + "-" + leadingZero(dt.getDate());
}
function leadingZero(n) {
    return n < 10 ? "0" + n : "" + n;
}