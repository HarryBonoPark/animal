$(function(){
    $.ajax({
        type:"get",
        url:"/api/dog/2021-08-20",
        success:function(r){
            console.log(r);
            $(".dog_area").html("");
            for (let i=0; i<r.dogList.length; i++){
                let tag = 
                '<div class="dog_box">'+
                '<p class="dogfile">'+
                    '<img src="'+r.dogList[i].filename+'">'+
                '</p>'+
                '<p class="kind">'+
                    '<span>품종: </span>'+
                    '<span class="dogKind">'+r.dogList[i].kindCd+'</span>'+
                '</p>'+
                '<p class="dogprofile">'+
                    '<span>등록일: </span>'+
                    '<span class="register">'+makeDate(new Date(r.dogList[i].noticeSdt))+'</span>'+
                '</p>'+
                '<p class="dogGen">'+
                    '<span>성별: </span>'+
                    '<span class="gen">'+r.dogList[i].sexCd+'</span>'+
                '</p>'+
                '<p class="dogAge">'+
                    '<span>나이: </span>'+
                    '<span class=" age">'+r.dogList[i].age+'</span>'+
                '</p>'+
                '<p class="dogShelter">'+
                    '<span>보호소: </span>'+
                    '<span class="shelter">'+r.dogList[i].careNm+'</span>'+
                '</p>'+
            '</div>';
            $(".dog_area").append(tag);
            }
        }
    })
})

function makeDate(dt) {
    return dt.getFullYear()+"-"+leadingZero(dt.getMonth()+1)+"-"+leadingZero(dt.getDate());
}
function leadingZero(n) {
    return n<10?"0"+n:""+n;
}