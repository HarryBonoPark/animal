$(function(){

    function makeDate(dt) {
        return dt.getFullYear()+"-"+leadingZero(dt.getMonth()+1)+"-"+leadingZero(dt.getDate());
    }
    function leadingZero(n) {
        return n<10?"0"+n:""+n;
    }
    
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
                    labels:["Y", "N"],
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
                option:{
                    responsive:false
                },
                data:{
                    labels:regionLabel,
                    datasets:[{
                        label:"지역별 유기 수",
                        data:regionArr,
                        backgroundColor:['#ff9900']
                    }]
                }
            })
        }
    })
})