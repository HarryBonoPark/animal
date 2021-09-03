$(function(){

    function makeDate(dt) {
        return dt.getFullYear()+"-"+leadingZero(dt.getMonth()+1)+"-"+leadingZero(dt.getDate());
    }
    function leadingZero(n) {
        return n<10?"0"+n:""+n;
    }

    $.ajax({
        type:"get",
        url:"/api/dogState/today",
        success:function(r){
            console.log("강아지 보호종료 상태");
            console.log(r);

            let dogArr = new Array();
            let dogLabel = new Array();
            for(let i=0; i<r.data.length; i++){
                dogArr.push(r.data[i].dogState);
                dogLabel.push(r.data[i].p_state);
            }
            let dogStateChart = new Chart($("#d_state_chart"), {
                type:"pie",
                data:{
                    labels:dogLabel,
                    datasets:[{
                        label:"DOG",
                        data:dogArr,
                        backgroundColor:['#ffde99','#fecb5e','#ffc240','#ffbb2b','#ffb20f','#f2a400']
                    }]
                },
                options:{
                    plugins: {
                        legend: {
                            display: false
                        }
                    },
                    responsive:false
                }
            })
        }
    })
    $.ajax({
        type:"get",
        url:"/api/catState/today",
        success:function(r){
            console.log("고양이 보호종료 상태");
            console.log(r);

            let catArr = new Array();
            let catLabel = new Array();
            for(let i=0; i<r.data.length; i++){
                catArr.push(r.data[i].catState);
                catLabel.push(r.data[i].p_state);
            }
            let catStateChart = new Chart($("#c_state_chart"), {
                type:"pie",
                data:{
                    labels:catLabel,
                    datasets:[{
                        label:"CAT",
                        data:catArr,
                        backgroundColor:['#ff9900','#ffa826','#ffb74d','#ffc878','#ffd599','#ffe6c2','#fff1de']
                    }]
                },
                options:{
                    plugins: {
                        legend: {
                            display: false
                        }
                    },
                    responsive:false
                }
            })
        }
    })

    $.ajax({
        type:"get",
        url:"/api/month/today",
        success:function(r){
            console.log("강아지/고양이 최근 3개월 월별 데이터");
            console.log(r);

            let dArr = new Array();
            let cArr = new Array();
            let oArr = new Array();
            let dLabel = new Array();
            let cLabel = new Array();
            let oLabel = new Array();
            for(let i=0; i<r.d_data.length; i++){
                dArr.push(r.d_data[i].dogCnt);
                dLabel.push(r.d_data[i].month+"월");
            }
            for(let i=0; i<r.c_data.length; i++){
                cArr.push(r.c_data[i].catCnt);
                cLabel.push(r.c_data[i].month+"월");
            }
            for(let i=0; i<r.o_data.length; i++){
                oArr.push(r.o_data[i].otherCnt);
                oLabel.push(r.o_data[i].month+"월");
            }
            let dogCatChart = new Chart($("#dogcat_status"), {
                type:"line",
                options:{
                    responsive:false
                },
                data:{
                    labels:dLabel,
                    datasets:[{
                        label:"DOG",
                        data:dArr,
                        backgroundColor:['#fecb5e']
                    },{
                        label:"CAT",
                        data:cArr,
                        backgroundColor:['#ff9900']
                    },{
                        label:"OTHER",
                        data:oArr,
                        backgroundColor:['#ff6600']
                    }]
                }
            })
        }
    })

    $.ajax({
        type:"get",
        url:"/api/neuter/today",
        success:function(r){
            console.log("중성화 여부");
            console.log(r);

            let neuterArr = new Array();
            let neuterLabel = new Array();
            for(let i=0; i<r.data.length; i++){
                neuterArr.push(r.data[i].neuter);
                neuterLabel.push(r.data[i].neuterYn);
            }
            let neuterChart = new Chart($("#neuter_chart"), {
                type:"pie",
                options:{
                    responsive:false
                },
                data:{
                    labels:["중성화 했어요", "중성화 안했어요"],
                    datasets:[{
                        label:"구조된 강아지 중성화 여부",
                        data:neuterArr,
                        backgroundColor:['#fecb5e', '#ff9900']
                    }]
                }
            })
        }
    })

    $.ajax({
        type:"get",
        url:"/api/sexInfo/today",
        success:function(r){
            console.log("동물 성별 유기 비율");
            console.log(r);

            let confArr = new Array();
            let confLabel = new Array();
            for(let i=0; i<r.data.length; i++){
                confArr.push(r.data[i].sex);
                confLabel.push(r.data[i].sexCd);
            }
            let ageChart = new Chart($("#sex_chart"), {
                type:"pie",
                options:{
                    responsive:false
                },
                data:{
                    labels:["수컷","암컷"],
                    datasets:[{
                        label:"구조된 강아지 성별 비율",
                        data:confArr,
                        backgroundColor:['#fecb5e', '#ff9900']
                    }]
                }
            })
        }
    })

    $.ajax({
        type:"get",
        url:"/api/regionInfo/today",
        success:function(r){
            console.log("지역별 유기 현황");
            console.log(r);

            let regionArr = new Array();
            let regionLabel = new Array();
            for(let i=0; i<r.data.length; i++){
                regionArr.push(r.data[i].careDogCnt);
                regionLabel.push(r.data[i].region);
            }
            let regionChart = new Chart($("#region_status"), {
                type:"bar",
                options:{
                    plugins: {
                        legend: {
                            display: false
                        }
                    },
                    responsive:false
                },
                data:{
                    labels:regionLabel,
                    datasets:[{
                        label:"지역별 강아지 유기 수",
                        data:regionArr,
                        backgroundColor:['#ff9900']
                    }]
                }
            })
        }
    })




    $.ajax({
        type:"get",
        url:"/api/catNeuter/today",
        success:function(r){
            console.log("중성화 여부");
            console.log(r);

            let cNeuterArr = new Array();
            let cNeuterLabel = new Array();
            for(let i=0; i<r.data.length; i++){
                cNeuterArr.push(r.data[i].c_neuter);
                cNeuterLabel.push(r.data[i].neuterYn);
            }
            let cNeuterChart = new Chart($("#c_neuter_chart"), {
                type:"pie",
                options:{
                    responsive:false
                },
                data:{
                    labels:["중성화 했어요", "중성화 안했어요"],
                    datasets:[{
                        label:"구조된 고양이 중성화 여부",
                        data:cNeuterArr,
                        backgroundColor:['#fecb5e', '#ff9900']
                    }]
                }
            })
        }
    })

    $.ajax({
        type:"get",
        url:"/api/catSexInfo/today",
        success:function(r){
            console.log("동물 성별 유기 비율");
            console.log(r);

            let cConfArr = new Array();
            let cConfLabel = new Array();
            for(let i=0; i<r.data.length; i++){
                cConfArr.push(r.data[i].c_sex);
                cConfLabel.push(r.data[i].sexCd);
            }
            let ageChart = new Chart($("#c_sex_chart"), {
                type:"pie",
                options:{
                    responsive:false
                },
                data:{
                    labels:["수컷","암컷"],
                    datasets:[{
                        label:"구조된 고양이 성별 비율",
                        data:cConfArr,
                        backgroundColor:['#fecb5e', '#ff9900']
                    }]
                }
            })
        }
    })

    $.ajax({
        type:"get",
        url:"/api/catRegionInfo/today",
        success:function(r){
            console.log("지역별 유기 현황");
            console.log(r);

            let cRegionArr = new Array();
            let cRegionLabel = new Array();
            for(let i=0; i<r.data.length; i++){
                cRegionArr.push(r.data[i].c_careDogCnt);
                cRegionLabel.push(r.data[i].c_region);
            }
            let regionChart = new Chart($("#c_region_status"), {
                type:"bar",
                options:{
                    plugins: {
                        legend: {
                            display: false
                        }
                    },
                    responsive:false
                },
                data:{
                    labels:cRegionLabel,
                    datasets:[{
                        label:"지역별 고양이 유기 수",
                        data:cRegionArr,
                        backgroundColor:['#ff9900']
                    }]
                }
            })
        }
    })



    $.ajax({
        type:"get",
        url:"/api/otherNeuter/today",
        success:function(r){
            console.log("중성화 여부");
            console.log(r);

            let o_neuterArr = new Array();
            let o_neuterLabel = new Array();
            for(let i=0; i<r.data.length; i++){
                o_neuterArr.push(r.data[i].o_neuter);
                o_neuterLabel.push(r.data[i].neuterYn);
            }
            let neuterChart = new Chart($("#o_neuter_chart"), {
                type:"pie",
                options:{
                    responsive:false
                },
                data:{
                    labels:["중성화 했어요", "중성화 안했어요"],
                    datasets:[{
                        label:"구조된 다른동물 중성화 여부",
                        data:o_neuterArr,
                        backgroundColor:['#fecb5e', '#ff9900']
                    }]
                }
            })
        }
    })

    $.ajax({
        type:"get",
        url:"/api/otherSexInfo/today",
        success:function(r){
            console.log("동물 성별 유기 비율");
            console.log(r);

            let o_confArr = new Array();
            let o_confLabel = new Array();
            for(let i=0; i<r.data.length; i++){
                o_confArr.push(r.data[i].o_sex);
                o_confLabel.push(r.data[i].sexCd);
            }
            let ageChart = new Chart($("#o_sex_chart"), {
                type:"pie",
                options:{
                    responsive:false
                },
                data:{
                    labels:["수컷","암컷"],
                    datasets:[{
                        label:"구조된 다른동물 성별 비율",
                        data:o_confArr,
                        backgroundColor:['#fecb5e', '#ff9900']
                    }]
                }
            })
        }
    })

    $.ajax({
        type:"get",
        url:"/api/otherRegionInfo/today",
        success:function(r){
            console.log("지역별 유기 현황");
            console.log(r);

            let o_regionArr = new Array();
            let o_regionLabel = new Array();
            for(let i=0; i<r.data.length; i++){
                o_regionArr.push(r.data[i].careOtherCnt);
                o_regionLabel.push(r.data[i].o_region);
            }
            let regionChart = new Chart($("#o_region_status"), {
                type:"bar",
                options:{
                    plugins: {
                        legend: {
                            display: false
                        }
                    },
                    responsive:false
                },
                data:{
                    labels:o_regionLabel,
                    datasets:[{
                        label:"지역별 강아지 유기 수",
                        data:o_regionArr,
                        backgroundColor:['#ff9900']
                    }]
                }
            })
        }
    })
})