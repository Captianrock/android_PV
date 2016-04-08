// JavaScript source code

console.log(jsArray);

var method = [];
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
}
for (var i = 0; i < method.length; i++) 
{
    pie.push({
        name: method[i],
        y: diff[i]
    });
}

$(function () {
    $(document).ready(function () {
        // Build the chart
        $('#container').highcharts({
            chart: {
                plotBackgroundColor: null,
                plotBorderWidth: null,
                plotShadow: false,
                type: 'pie'
            },
            title: {
            text: 'Method Runtime Percentages'
            },
            tooltip: {
                pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>'
            },
            plotOptions: {
                pie: {
                    allowPointSelect: true,
                    cursor: 'pointer',
                    dataLabels: {
                        enabled: false
                    },
                    showInLegend: true
                }
            },
            series: [{
                name: 'Brands',
                colorByPoint: true,
                data: pie
            }]
        });
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