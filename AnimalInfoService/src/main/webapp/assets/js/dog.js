$(function () {
    let totalPage = 0;

    $(".region").click(function () {
        $(".region").removeClass("selected");
        $(this).addClass("selected");
        let region = $(this).find(".plain_name").attr("data-region");
        getRegionDog(region);
    })
    
    getRegionDog('all');

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
                if(r.dogList.length == 0) {
                    $(".dog_area").append('<div class="nodata"><img src="/assets/images/logo.svg"><h1>등록된 유기동물이 없습니다.</h1></div>')
                }
                for (let i = 0; i < r.dogList.length; i++) {
                    let page = Math.floor(i / 12);
                    let tag =
                    '<div class="dog_box">' +
                    '<p class="dogfile">' +
                    '<img src="' + r.dogList[i].filename + '">' +
                    '</p>' +
                    '<p class="dogLine"></p>'+
                    '<p class="dogShelter">' +
                    '<span class="shelter">' + "[" + r.dogList[i].careNm + "]" + '</span>' +
                    '</p>' +
                    '<p class="kind">' +
                    '<span><i class="fas fa-dog"></i></span>' +
                    '<span class="dogKind">' + r.dogList[i].kindCd + '</span>' +
                    '</p>' +
                    '<p class="dogprofile">' +
                        '<span><i class="far fa-calendar-check"></i></span>' +
                        '<span class="register">' + makeDate(new Date(r.dogList[i].noticeSdt)) + '</span>' +
                    '</p>' +
                    '<p class="dogGen">' +
                        '<span><i class="fas fa-venus-mars"></i></span>' +
                        '<span class="gen">' + r.dogList[i].sex + '</span>, ' +
                        '<span class=" age">' + r.dogList[i].age + '</span>' +
                    '</p>' +
                    '<p class="dogAge">' +
                        '<span></span>' +
                    '</p>' +
                    '<button class="popOpenBtnCmmn" data-num="' + r.dogList[i].seq + '"><i class="fas fa-search-plus"></i><br><span>상세정보</span></button>' +
                    '</div>'
                    $(".dog-tbody").eq(page).append(tag);
                }
                
                resizeAnimalImageInit();
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
                        '<div class="dog_form_contents">'+
                                '<div class="dog_form_img_box">'+
                                    '<p class="dogfile">' +
                                        '<img src="' + r.data.popfile + '">' +
                                    '</p>' +
                                '</div>'+
                                '<div class="dog_form_description_box">'+
                                    '<p class="dogShelters">' +
                                        '<span class="shelters">' + r.data.careNm + '</span>' +
                                    '</p>' +
                                    '<p class="kind">' +
                                        '<span class="dogKind">' + r.data.kindCd + '</span>' +
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
                                    '<p class="dogAge">' +
                                        '<span>나이: </span>' +
                                        '<span class=" age">' + r.data.kindCd + '</span>' +
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
                                    '<p class="dogprofile">' +
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

    $("#next").click(function () {
        currentPage++;
        if (currentPage > totalPage) currentPage = totalPage;
        $(".current").html(currentPage);
        $(".dog-tbody").removeClass("active");
        $(".dog-tbody").eq(currentPage - 1).addClass("active");
        console.log(currentPage);
        resizeAnimalImage();
    })
    $("#prev").click(function () {
        currentPage--;
        if (currentPage < 1) currentPage = 1;
        $(".current").html(currentPage);
        $(".dog-tbody").removeClass("active");
        $(".dog-tbody").eq(currentPage - 1).addClass("active");
        resizeAnimalImage();
    })

    function resizeAnimalImageInit() {
        for(let i=0; i<$(".dog_box .dogfile img").length; i++) {
            $(".dog_box .dogfile img").eq(i).on("load", function(){
                let w = $(".dog_box .dogfile img").eq(i).width();
                let h = $(".dog_box .dogfile img").eq(i).height();
                console.log("w"+w, "h"+h)
                if(w >= h) {
                    $(".dog_box .dogfile img").eq(i).css("height", "110%");
                }
                else {
                    $(".dog_box .dogfile img").eq(i).css("width", "110%");
                }
            })
        }
    }
    function resizeAnimalImage() {
        for(let i=0; i<$(".dog_box .dogfile img").length; i++) {
            let w = $(".dog_box .dogfile img").eq(i).width();
            let h = $(".dog_box .dogfile img").eq(i).height();
            console.log("w"+w, "h"+h)
            if(w >= h) {
                $(".dog_box .dogfile img").eq(i).css("height", "110%");
            }
            else {
                $(".dog_box .dogfile img").eq(i).css("width", "110%");
            }
        }
    }
})


function makeDate(dt) {
    return dt.getFullYear() + "-" + leadingZero(dt.getMonth() + 1) + "-" + leadingZero(dt.getDate());
}

function leadingZero(n) {
    return n < 10 ? "0" + n : "" + n;
}

$(function () {
    // $(".dog_form").draggable({
    //     handle: "h1"
    // })
})
