$(function(){

    function makeDate(dt) {
        return dt.getFullYear()+"-"+leadingZero(dt.getMonth()+1)+"-"+leadingZero(dt.getDate());
    }
    function leadingZero(n) {
        return n<10?"0"+n:""+n;
    }

    $.ajax({
        type:"get",
        url:"/api/status/today",
        success:function(r){
            console.log(r);

            let dates = new Array();
            let statusCnts = new Array();
            for(let i=0; i<r.data.length; i++){
                let date = makeDate(new Date(r.data[i].noticeSdt));
                let statusCnt = r.data[i].processState;
                dates.push(date);
                statusCnts.push(statusCnt);
            }
            let ctx = $("#animal_status");
            let animalChart = new Chart(ctx, {
                type:'bar',
                options:{
                    responsive:false
                },
                data:{
                    labels:dates,
                    datasets:[{
                        label:"notice",
                        data:statusCnts,
                        backgoundColor:['rgb(220,20,60)']
                    }]
                }
            })
        }
    })
})