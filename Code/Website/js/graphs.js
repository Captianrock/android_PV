// JavaScript source code

console.log(jsArray);

var method = [];
var donutDic = {};
var start = [];
var end = [];
var diff = [];
var pie = [];
var max = 0;
var maxMethod = "None";

for (var i = 0; i < jsArray.length; i++) 
{
    var tempElem = method.indexOf(jsArray[i]["methodName"]);
	if(tempElem == -1){
       method.push(jsArray[i]["methodName"]);
	   start.push(parseInt(jsArray[i]["timeStart"]));
	   end.push(parseInt(jsArray[i]["timeEnd"]));
	   diff.push(end[i] - start[i]);
        if(end[i] - start[i] > max){
            max = end[i] - start[i];
            maxMethod = jsArray[i]["methodName"];
        }
    }
    else{
        start.push(parseInt(jsArray[i]["timeStart"]));
        end.push(parseInt(jsArray[i]["timeEnd"]));
        diff[tempElem] += end[i] - start[i];
        if(diff[tempElem] > max){
            max = end[i] - start[i];
            maxMethod = jsArray[i]["methodName"];
        }
    }
    if(jsArray[i]["methodName"] in donutDic){
        var temp = (donutDic[jsArray[i]["methodName"]]);
        if(jsArray[i]["methodName"] == "toString"){
            var temp = [];
            temp.push(parseInt(jsArray[i]["timeEnd"])- parseInt(jsArray[i]["timeStart"]));
            donutDic[jsArray[i]["methodName"]] = temp;
        }
        else{
            temp.push(parseInt(jsArray[i]["timeEnd"])- parseInt(jsArray[i]["timeStart"]));
            donutDic[jsArray[i]["methodName"]] = temp;
        }
    }
    else{
        var temp = [];
        temp.push(parseInt(jsArray[i]["timeEnd"])- parseInt(jsArray[i]["timeStart"]));
        donutDic[jsArray[i]["methodName"]] = temp;
        
    }
}
//Create Dynamic Data for Donut Graph
var colors = Highcharts.getOptions().colors;
for (i = 0; i < method.length; i++) 
{
    pie.push({
        y: diff[i],
        drilldown: {
            categories: method[i],
            data: donutDic[method[i]],
            color: colors[i]
        }
    });
}
$(function () {

    categories = method;
    data = pie;
    browserData = [];
    versionsData = [];
    dataLen = data.length;

    // Build the data arrays
    for (var i = 0; i < dataLen; i += 1) {

        // add browser data
        browserData.push({
            name: categories[i],
            y: data[i].y,
            color: data[i].color
        });

        // add version data
        drillDataLen = data[i].drilldown.data.length;
        for (var j = 0; j < drillDataLen; j += 1) {
            brightness = 0.2 - (j / drillDataLen) / 5;
            versionsData.push({
                name: data[i].drilldown.categories,
                y: data[i].drilldown.data[j],
                color: Highcharts.Color(data[i].color).brighten(brightness).get()
            });
        }
    }

    // Create the chart
    $('#container').highcharts({
        chart: {
            type: 'pie'
        },
        title: {
            text: 'Method Runtimes'
        },
        yAxis: {
            title: {
                text: 'Total percent market share'
            }
        },
        plotOptions: {
            pie: {
                shadow: false,
                center: ['50%', '50%'],
                allowPointSelect: true,
                cursor: 'pointer',
                dataLabels: {
                    enabled: false
                }
            }
        },
        series: [{
            name: 'Browsers',
            data: browserData,
            size: '55%',
            colorByPoint: true,
           
        }, {
            name: 'Versions',
            data: versionsData,
            size: '90%',
            innerSize: '70%',
           // colorByPoint: true,
            
        }]
    });
});

$(function () {
    $('#container2').highcharts({
        chart: {
            type: 'bar'
        },
        title: {
            text: 'Method Runtimes'
        },
        xAxis: {
            categories: method
        },
        yAxis: {
            min: 0,
            title: {
                text: 'time (nanoseconds)',
                align: 'high'
            },
            labels: {
                overflow: 'justify'
            }
        },
        tooltip: {
            valueSuffix: ' nanoseconds'
        },
        plotOptions: {
            bar: {
                dataLabels: {
                    enabled: false
                }
            }
        },
        series: [{
			colorByPoint: true,
            data: diff
        }]
    });
});

$(function () {
    $('#container3').highcharts({
        chart: {
            type: 'bar'
        },
        title: {
            text: 'Method Runtimes'
        },
        xAxis: {
            categories: method
        },
        yAxis: {
            min: 0,
            title: {
                text: 'time (nanoseconds)',
                align: 'high'
            },
            labels: {
                overflow: 'justify'
            }
        },
        tooltip: {
            valueSuffix: ' nanoseconds'
        },
        plotOptions: {
            bar: {
                dataLabels: {
                    enabled: false
                }
            }
        },
        series: [{
			colorByPoint: true,
            data: diff
        }]
    });
});

var highestMethod = function() {
    return maxMethod;    
};
var highestTime = function() {
    return max;    
};

document.getElementById( 'highestMethod' ).innerHTML = highestMethod();
document.getElementById( 'highestTime' ).innerHTML = highestTime();