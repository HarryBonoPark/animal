$(function () {
    getOtherRegionInfo("대구광");
    function getOtherRegionInfo(region) {
        $.ajax({
            type: "get",
            url: "http://localhost:8947/api/regionOther?region="+region,
            success: function (r) {
                console.log(r);
                for (let i = 1; i < r.otherList.length; i++) {
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
                        '<p class="otherAge">' +
                        '<span></span>' +
                        '</p>' +
                        '<button class="popOpenBtnCmmn" data-num="' + r.otherList[i].seq + '"><i class="fas fa-search-plus"></i><br><span>상세정보</span></button>' +
                        '</div>';
                    $(".other_area").append(tag);
                }
            }
        })
    }
})

function makeDate(dt) {
    return dt.getFullYear() + "-" + leadingZero(dt.getMonth() + 1) + "-" + leadingZero(dt.getDate());
}
function leadingZero(n) {
    return n < 10 ? "0" + n : "" + n;
}