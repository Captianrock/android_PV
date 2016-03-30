// JavaScript source code

console.log(jsArray);

var method = [];
var start = [];
var end = [];
var diff = [];
var pie = [];

for (var i = 0; i < jsArray.length; i++) 
{
	method.push(jsArray[i]["methodName"]);
	start.push(parseInt(jsArray[i]["timeStart"]));
	end.push(parseInt(jsArray[i]["timeEnd"]));
	diff.push(end[i] - start[i]);
	pie.push({
		name: method[i],
		y: diff[i]
	});
}

$(function () { 
	
    $('#container').highcharts({
        chart: {
            type: 'column'
        },
        title: {
            text: 'Method Runtimes'
        },
        xAxis: {
            categories: method
        },
        yAxis: {
            title: {
                text: 'time (ns)'
            }
        },
        series: [{
			colorByPoint: true,
            data: diff
        }]
    });
});

$(function () {
    $(document).ready(function () {
        // Build the chart
        $('#container2').highcharts({
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