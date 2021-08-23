$(function(){
    $.ajax({
        type:"get",
        url:"/api/dog/2021-08-20",
        success:function(r){
            console.log(r);
            $(".dog_area").html("");
            
            for(let i=0; i<1; i++){
            let tag ="<tbody class='dog-tbody'></tbody>";
            $(".dog_area").append(tag);
        }
            for (let i=0; i<r.dogList.length; i++){
                let page = Math.floor(i/12);
                console.log(Math.floor(i/12));
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
                '<button id="popOpenBtnCmmn" data-num="'+r.dogList[i].seq+'">상세정보</button>'+
            '</div>'

            //$(".dog-tbody").append(tag);
            $(".dog-tbody").eq(page).append(tag);
        }
        $(".dog-tbody").eq(0).addClass("active");   

        $("#next").click(function(){
            let currentPage = Number($(".current").html()); // 숫자형태로 바꿔주기
            currentPage++;
            if(currentPage > 5) currentPage = 5;
            $(".current").html(currentPage);
            $(".dog-tbody").removeClass("active");
            $(".dog-tbody").eq(currentPage-1).addClass("active");
        })
        $("#prev").click(function(){
            let currentPage = Number($(".current").html());
            currentPage--;
            if(currentPage < 1) currentPage = 1;
            $(".current").html(currentPage);
            $(".dog-tbody").removeClass("active");
            $(".dog-tbody").eq(currentPage-1).addClass("active");
        })
        }
    })  
})


function makeDate(dt) {
    return dt.getFullYear()+"-"+leadingZero(dt.getMonth()+1)+"-"+leadingZero(dt.getDate());
}
function leadingZero(n) {
    return n<10?"0"+n:""+n;
}



    
