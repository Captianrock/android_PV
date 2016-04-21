// JavaScript source code

//console.log(jsArray);

var method = [];
var donutDic = {};
var start = [];
var end = [];
var diff = [];
var pie = [];
var indieRun = [];
var max = 0;
var maxMethod = "None";

for (var i = 0; i < jsArray.length; i++) 
{
    var tempElem = method.indexOf(jsArray[i][1]);
	if(tempElem == -1){
       method.push(jsArray[i][1]);
	   start.push((parseInt(jsArray[i][2]))/1000);
	   end.push((parseInt(jsArray[i][3]))/1000);
	   diff.push(end[i] - start[i]);
       if(end[i] - start[i] > max){
            max = end[i] - start[i];
            maxMethod = jsArray[i][1];
        }
    }
    else{
        start.push((parseInt(jsArray[i][2]))/1000);
        end.push((parseInt(jsArray[i][3]))/1000);
        diff[tempElem] += end[i] - start[i];
        if(diff[tempElem] > max){
            max = diff[tempElem];
            maxMethod = jsArray[i][1];
        }
    }
    if(jsArray[i][1] in donutDic){
        var temp = (donutDic[jsArray[i][1]]);
        if(jsArray[i][1] == "toString"){
            var temp = [];
            temp.push(parseInt(jsArray[i][3])- parseInt(jsArray[i][2]));
            donutDic[jsArray[i][1]] = temp;
        }
        else{
            temp.push(parseInt(jsArray[i][3])- parseInt(jsArray[i][2]));
            donutDic[jsArray[i][1]] = temp;
        }
    }
    else{
        var temp = [];
        temp.push(parseInt(jsArray[i][3])- parseInt(jsArray[i][2]));
        donutDic[jsArray[i][1]] = temp;
        
    }
}
//Create Dynamic Data for Donut Graph
var colors = Highcharts.getOptions().colors;
for (i = 0; i < method.length; i++) 
{
    pie.push({
        y: diff[i],
		color: colors[i%10],
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
    totalRun = [];
    dataLen = data.length;
    // Build the data arrays
    for (var i = 0; i < dataLen; i += 1) {

        // add browser data
        totalRun.push({
            name: categories[i],
            y: data[i].y,
            color: data[i].color,
			id: i
        });

        // add version data
        drillDataLen = data[i].drilldown.data.length;
        for (var j = 0; j < drillDataLen; j += 1) {
            brightness = 0.2 - (j / drillDataLen) / 5;
            indieRun.push({
                name: data[i].drilldown.categories,
                y: data[i].drilldown.data[j],
                color: Highcharts.Color(data[i].color).brighten(brightness).get(),
				parentId: i
            });
        }
    }

    // Create the chart
    $('#container').highcharts({
        chart: {
            type: 'pie'
        },
		title: {
			text: null
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
                    enabled: false,
					format: '<b>{point.name}</b>: {point.percentage:.2f} %',
                },
			},
			series: {
				point: {
					events: {
						legendItemClick: function () {
							var id = this.id,
							indieRun = this.series.chart.series[0].data;
							$.each(indieRun, function (i, point) {
								//console.log(i);
								//console.log(point);
								if (point.parentId == id) {
									if(point.visible)
										point.setVisible(false);
									else
										point.setVisible(true);
								}
							});
						}
					}
                }
            },
        },
		tooltip: {
            pointFormat: '{series.name}: <b>{point.percentage:.2f}%</b>'
        },
        series: [{
            name: 'Total Runtime',
            data: totalRun,
            size: '60%',
			showInLegend: true,
        }, {
            name: 'Individual Runtimes',
            data: indieRun,
            size: '90%',
            innerSize: '70%',
			showInLegend: false,
        }]
    });
});

$(function () {
    $('#container2').highcharts({
        chart: {
            type: 'bar'
        },
		title: {
			text: null
		},
        xAxis: {
            categories: method
        },
        yAxis: {
            min: 0,
            title: {
                text: 'time (microseconds)',
                align: 'high'
            },
            labels: {
                overflow: 'justify'
            }
        },
        tooltip: {
            valueSuffix: ' microseconds',
			pointFormat: '{series.name}: <b>{point.y:.0f} microseconds</b>'
        },
        plotOptions: {
            bar: {
                dataLabels: {
                    enabled: false
                }
            }
        },
				legend: {
			enabled: false
		},
        series: [{
			name: "Runtime",
			colorByPoint: true,
            data: diff
        }]
    });
});
//console.log(indieRun);
$(function () {
    $('#container3').highcharts({
        chart: {
            type: 'column'
        },
		title: {
			text: null
		},
        xAxis: {
            categories: method
        },
        yAxis: {
            min: 0,
            title: {
                text: 'time (microseconds)',
                align: 'high'
            },
            labels: {
                overflow: 'justify'
            }
        },
        tooltip: {
            valueSuffix: ' microseconds',
			pointFormat: '{series.name}: <b>{point.y:.0f} microseconds</b>'
        },
        plotOptions: {
            column: {
                dataLabels: {
                    enabled: false
                }
            }
        },
		legend: {
			enabled: false
		},
        series: [{
			name: "Runtime",
			colorByPoint: true,
            data: indieRun
        }]
    });
});

var highestMethod = function() {
    return maxMethod;    
};
var highestTime = function() {
    return max.toFixed(2);    
};

document.getElementById( 'highestMethod' ).innerHTML = highestMethod();
document.getElementById( 'highestTime' ).innerHTML = highestTime();