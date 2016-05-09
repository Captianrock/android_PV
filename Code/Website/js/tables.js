// JavaScript source code

//console.log(jsArray);

var method = [];
var donutDic = {};
var start = [];
var end = [];
var diff = [];
var max = 0;
var min = Number.POSITIVE_INFINITY;
var maxQueue = [];
var minQueue = [];
var callQueue = [];

for (var i = 0; i < jsArray.length; i++) 
{
    var tempElem = method.indexOf(jsArray[i][1]);
	if(tempElem == -1){
       method.push(jsArray[i][1]);
	   start.push((parseInt(jsArray[i][2]))/1000);
	   end.push((parseInt(jsArray[i][3]))/1000);
	   diff.push(end[i] - start[i]);
    }
    else{
        start.push((parseInt(jsArray[i][2]))/1000);
        end.push((parseInt(jsArray[i][3]))/1000);
        diff[tempElem] += end[i] - start[i];
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

for (var i = 0; i < method.length; i++) 
{
	maxQueue.push({
		N: method[i],
		T: diff[i],
		O: donutDic[method[i]].length
	});
	minQueue.push({
		N: method[i],
		T: diff[i],
		O: donutDic[method[i]].length
	});
	callQueue.push({
		N: method[i],
		T: diff[i],
		O: donutDic[method[i]].length
	});
}

maxQueue.sort(function(a, b){return parseFloat(b.T) - parseFloat(a.T)});
minQueue.sort(function(a, b){return parseFloat(a.T) - parseFloat(b.T)});
callQueue.sort(function(a, b){return parseFloat(b.O) - parseFloat(a.O)});

var maxNames = function(i)
{
    if (i < maxQueue.length)
    {
        return maxQueue[i].N;
    }
    return "";
};
var maxTimes = function(i)
{
    if (i < maxQueue.length)
    {
        return maxQueue[i].T;
    }
    return "";
};
var maxOccurences = function(i)
{
    if (i < maxQueue.length)
    {
        return maxQueue[i].O;
    }
    return "";
};

var minNames = function(i)
{
    if (i < minQueue.length)
    {
        return minQueue[i].N;
    }
    return "";
};
var minTimes = function(i)
{
    if (i < minQueue.length)
    {
        return minQueue[i].T;
    }
    return "";
};
var minOccurences = function(i)
{
    if (i < minQueue.length)
    {
        return minQueue[i].O;
    }
    return "";
};

var callNames = function(i)
{
    if (i < callQueue.length)
    {
        return callQueue[i].N;
    }
    return "";
};
var callTimes = function(i)
{
    if (i < callQueue.length)
    {
        return callQueue[i].T;
    }
    return "";
};
var callOccurences = function(i)
{
    if (i < callQueue.length)
    {
        return callQueue[i].O;
    }
    return "";
};

document.getElementById( 'maxName1' ).innerHTML = maxNames(0);
document.getElementById( 'maxName2' ).innerHTML = maxNames(1);
document.getElementById( 'maxName3' ).innerHTML = maxNames(2);
document.getElementById( 'maxName4' ).innerHTML = maxNames(3);
document.getElementById( 'maxName5' ).innerHTML = maxNames(4);
document.getElementById( 'maxName6' ).innerHTML = maxNames(5);
document.getElementById( 'maxName7' ).innerHTML = maxNames(6);
document.getElementById( 'maxName8' ).innerHTML = maxNames(7);
document.getElementById( 'maxName9' ).innerHTML = maxNames(8);
document.getElementById( 'maxName10' ).innerHTML = maxNames(9);

document.getElementById( 'maxTime1' ).innerHTML = maxTimes(0);
document.getElementById( 'maxTime2' ).innerHTML = maxTimes(1);
document.getElementById( 'maxTime3' ).innerHTML = maxTimes(2);
document.getElementById( 'maxTime4' ).innerHTML = maxTimes(3);
document.getElementById( 'maxTime5' ).innerHTML = maxTimes(4);
document.getElementById( 'maxTime6' ).innerHTML = maxTimes(5);
document.getElementById( 'maxTime7' ).innerHTML = maxTimes(6);
document.getElementById( 'maxTime8' ).innerHTML = maxTimes(7);
document.getElementById( 'maxTime9' ).innerHTML = maxTimes(8);
document.getElementById( 'maxTime10' ).innerHTML = maxTimes(9);

document.getElementById( 'maxOccurence1' ).innerHTML = maxOccurences(0);
document.getElementById( 'maxOccurence2' ).innerHTML = maxOccurences(1);
document.getElementById( 'maxOccurence3' ).innerHTML = maxOccurences(2);
document.getElementById( 'maxOccurence4' ).innerHTML = maxOccurences(3);
document.getElementById( 'maxOccurence5' ).innerHTML = maxOccurences(4);
document.getElementById( 'maxOccurence6' ).innerHTML = maxOccurences(5);
document.getElementById( 'maxOccurence7' ).innerHTML = maxOccurences(6);
document.getElementById( 'maxOccurence8' ).innerHTML = maxOccurences(7);
document.getElementById( 'maxOccurence9' ).innerHTML = maxOccurences(8);
document.getElementById( 'maxOccurence10' ).innerHTML = maxOccurences(9);

document.getElementById( 'minName1' ).innerHTML = minNames(0);
document.getElementById( 'minName2' ).innerHTML = minNames(1);
document.getElementById( 'minName3' ).innerHTML = minNames(2);
document.getElementById( 'minName4' ).innerHTML = minNames(3);
document.getElementById( 'minName5' ).innerHTML = minNames(4);
document.getElementById( 'minName6' ).innerHTML = minNames(5);
document.getElementById( 'minName7' ).innerHTML = minNames(6);
document.getElementById( 'minName8' ).innerHTML = minNames(7);
document.getElementById( 'minName9' ).innerHTML = minNames(8);
document.getElementById( 'minName10' ).innerHTML = minNames(9);

document.getElementById( 'minTime1' ).innerHTML = minTimes(0);
document.getElementById( 'minTime2' ).innerHTML = minTimes(1);
document.getElementById( 'minTime3' ).innerHTML = minTimes(2);
document.getElementById( 'minTime4' ).innerHTML = minTimes(3);
document.getElementById( 'minTime5' ).innerHTML = minTimes(4);
document.getElementById( 'minTime6' ).innerHTML = minTimes(5);
document.getElementById( 'minTime7' ).innerHTML = minTimes(6);
document.getElementById( 'minTime8' ).innerHTML = minTimes(7);
document.getElementById( 'minTime9' ).innerHTML = minTimes(8);
document.getElementById( 'minTime10' ).innerHTML = minTimes(9);

document.getElementById( 'minOccurence1' ).innerHTML = minOccurences(0);
document.getElementById( 'minOccurence2' ).innerHTML = minOccurences(1);
document.getElementById( 'minOccurence3' ).innerHTML = minOccurences(2);
document.getElementById( 'minOccurence4' ).innerHTML = minOccurences(3);
document.getElementById( 'minOccurence5' ).innerHTML = minOccurences(4);
document.getElementById( 'minOccurence6' ).innerHTML = minOccurences(5);
document.getElementById( 'minOccurence7' ).innerHTML = minOccurences(6);
document.getElementById( 'minOccurence8' ).innerHTML = minOccurences(7);
document.getElementById( 'minOccurence9' ).innerHTML = minOccurences(8);
document.getElementById( 'minOccurence10' ).innerHTML = minOccurences(9);

document.getElementById( 'callName1' ).innerHTML = callNames(0);
document.getElementById( 'callName2' ).innerHTML = callNames(1);
document.getElementById( 'callName3' ).innerHTML = callNames(2);
document.getElementById( 'callName4' ).innerHTML = callNames(3);
document.getElementById( 'callName5' ).innerHTML = callNames(4);
document.getElementById( 'callName6' ).innerHTML = callNames(5);
document.getElementById( 'callName7' ).innerHTML = callNames(6);
document.getElementById( 'callName8' ).innerHTML = callNames(7);
document.getElementById( 'callName9' ).innerHTML = callNames(8);
document.getElementById( 'callName10' ).innerHTML = callNames(9);

document.getElementById( 'callTime1' ).innerHTML = callTimes(0);
document.getElementById( 'callTime2' ).innerHTML = callTimes(1);
document.getElementById( 'callTime3' ).innerHTML = callTimes(2);
document.getElementById( 'callTime4' ).innerHTML = callTimes(3);
document.getElementById( 'callTime5' ).innerHTML = callTimes(4);
document.getElementById( 'callTime6' ).innerHTML = callTimes(5);
document.getElementById( 'callTime7' ).innerHTML = callTimes(6);
document.getElementById( 'callTime8' ).innerHTML = callTimes(7);
document.getElementById( 'callTime9' ).innerHTML = callTimes(8);
document.getElementById( 'callTime10' ).innerHTML = callTimes(9);

document.getElementById( 'callOccurence1' ).innerHTML = callOccurences(0);
document.getElementById( 'callOccurence2' ).innerHTML = callOccurences(1);
document.getElementById( 'callOccurence3' ).innerHTML = callOccurences(2);
document.getElementById( 'callOccurence4' ).innerHTML = callOccurences(3);
document.getElementById( 'callOccurence5' ).innerHTML = callOccurences(4);
document.getElementById( 'callOccurence6' ).innerHTML = callOccurences(5);
document.getElementById( 'callOccurence7' ).innerHTML = callOccurences(6);
document.getElementById( 'callOccurence8' ).innerHTML = callOccurences(7);
document.getElementById( 'callOccurence9' ).innerHTML = callOccurences(8);
document.getElementById( 'callOccurence10' ).innerHTML = callOccurences(9);