var traceName = [];
var trace2 = traces.slice(0);
var page = 0;
var sort = 'new';

function addTrace() {

  var traceContainer = document.getElementById('traceList');
  for(var i = 0; i < traces.length; i++){
  	var traceID = traces[i][0];
  	var time = traces[i][1];
  	var divContain = document.createElement('div');
  	var newTrace = document.createElement('a');
  	arrayofString = time.split(" ");
  	arraydate = arrayofString[0];
  	arraytime = arrayofString[1].split(":");
  	var AmPm = "";
 	if(parseInt(arraytime[0]) > 12){
 		time = parseInt(arraytime[0]) - 12;
 		AmPm = "P.M";
 	}
 	else{
 		if(parseInt(arraytime[0]) == 0){
 			time = parseInt(arraytime[0]) + 12;
 		}
 		else{
 			time = parseInt(arraytime[0]);
 		}
 		AmPm = "A.M";
 	}
  	newTrace.innerHTML = "Trace " + (traceName[i]+1) + " recorded on " + arraydate+ " at "+ time + ":" + arraytime[1] + ":" + arraytime[2] + " "+ AmPm;
  	newTrace.setAttribute('href','package.php?trace=' + traceID);
  	newTrace.setAttribute('class','list-group-item');
  	newTrace.setAttribute('style',"width: 80%; float: left;");
  	divContain.appendChild(newTrace);

  	var deleteButton = document.createElement('button');
  	deleteButton.setAttribute('type','button');
  	deleteButton.setAttribute('id',traceID);
  	deleteButton.setAttribute('class','btn btn-danger');
  	deleteButton.setAttribute('style',"margin-left: 50px; margin-top: 10px;");
  	deleteButton.setAttribute('onclick','deleteTrace(\'' + traceID + '\')');
  	deleteButton.innerHTML = "Remove Trace";

  	var newSpan = document.createElement('span');
  	newSpan.setAttribute('class', 'glyphicon glyphicon-trash');

  	deleteButton.appendChild(newSpan);

  	divContain.appendChild(deleteButton);
  	traceContainer.appendChild(divContain);
  }
  if (traces.length == 0){
  	var newTrace = document.createElement('div');
  	newTrace.innerHTML = "No Traces Found"; 
  	traceContainer.appendChild(newTrace);
  }
}

function addApp(){
	var rowNumber = 1;
	var rowsLeft = apps.length;
	if(rowsLeft > 0){
		rowsLeft = rowsLeft - 3;
		addRow(rowNumber);
		while(rowsLeft > 0){
			rowsLeft = rowsLeft - 3;
			rowNumber++;
			addRow(rowNumber);
		}
		rowsId = 1;
		for (var i = 0; i < apps.length; i++){
			if(i % 3 == 0 && i != 0 ){
				rowsId++;
			}
			addButton('row'+ rowsId,apps[i][0]);
		}
	}
}
function addRow(rowNumber){
	var rowContainer = document.getElementById('rowContainer');
	var newRow = document.createElement('div');
	newRow.setAttribute('class','row');
	newRow.setAttribute('id','row'+rowNumber);
	rowContainer.appendChild(newRow);
}


function addButton(newRowId,appNameHeader){
	var newRow = document.getElementById(newRowId);

	var newPadding = document.createElement('div');
	newPadding.setAttribute('class','col-md-4');
	newPadding.setAttribute('style','padding-top: 50px; padding-left: 20px; padding-right: 20px;');

	newRow.appendChild(newPadding);

	var newPanel = document.createElement('div');
	newPanel.setAttribute('class','panel panel-primary');
  newPanel.setAttribute('id',appNameHeader+"CURRENT");
  newPanel.setAttribute('ondblclick','reNameAppClick(\'' + appNameHeader + '\')');

	newPadding.appendChild(newPanel);

	newPanelHeading = document.createElement('div');
	newPanelHeading.setAttribute('class','panel-heading');

	newPanel.appendChild(newPanelHeading);

	var newInsideRow = document.createElement('div');
	newInsideRow.setAttribute('class','row');

	newPanelHeading.appendChild(newInsideRow);

	var newCol = document.createElement('div');
	newCol.setAttribute('class','col-xs-3');

	newInsideRow.appendChild(newCol);

	var newClass = document.createElement('center');
	var newImg = document.createElement('i');
	newImg.setAttribute('class','fa fa-area-chart fa-5x');
	newClass.appendChild(newImg);

	var newCol2 = document.createElement('div');
	newCol2.setAttribute('class','col-xs-9 text-right');

	newInsideRow.appendChild(newCol2);

	var appName = document.createElement('div');
	appName.setAttribute('class','huge');
	appName.innerHTML = appNameHeader;
  appName.setAttribute('id',appNameHeader);
	newCol2.appendChild(appName);

	var link = document.createElement('div');
	link.innerHTML = 'High Charts Analysis';

	newCol2.appendChild(link);

	var newA = document.createElement('a');

  newA.setAttribute('id',appNameHeader+"LINK");
	newA.setAttribute('href',"trace.php?app=".concat(appNameHeader));

	newPanel.appendChild(newA);

	var classAPanel = document.createElement('div');
	classAPanel.setAttribute('class','panel-footer');
	newA.appendChild(classAPanel);

	var span1 = document.createElement('span');
	span1.setAttribute('class','pull-left');
	span1.innerHTML = 'View Details';

	classAPanel.appendChild(span1);

	var span2 = document.createElement('span');
	span1.setAttribute('class','pull-right');
	
	var newArrow = document.createElement('i');
	newArrow.setAttribute('class','fa fa-area-circle-right');
	span2.appendChild(newArrow);

	classAPanel.appendChild(span2);

	var newFix = document.createElement('div');
	newFix.setAttribute('class','clearfix');
	classAPanel.appendChild(newFix);
}

function addPackage(){
  var checkList = document.getElementById("checkboxList");
  for(var i =0; i < packages.length; i++){
    var checkBox = document.createElement('div');
    checkBox.setAttribute('class','checkbox');
    checkboxList.appendChild(checkBox);

    var newLabel = document.createElement('label');
    var newInput = document.createElement('input');
    newInput.setAttribute('type','checkbox');
    newInput.setAttribute('value','');
    newInput.setAttribute('style','width:18px; height:18px;');
    newInput.setAttribute('id',packages[i]);
    newInput.setAttribute('name','checkPackage');
    newInput.setAttribute('checked',"");
    var newFont = document.createElement('font');
    newFont.innerHTML = packages[i].toString();
    newFont.setAttribute('size','5');

    newLabel.appendChild(newInput);
    newLabel.appendChild(newFont);
    checkBox.appendChild(newLabel);
  }
}
function selectSort(elementID, page2, sort2)
{
    sort2 = sort2 || sort;
    page2 = page2 || page.toString();

    if (page2 == '-')
    {
        page--;
        if (page < 0)
        {
            page = 0;
        }
    }
    else if (page2 == '+')
    {
        page++;
    }
    else if (parseInt(page2) == 0)
    {
        page = 0;
    }

    sort = sort2;

    if (sort == 'old') {
        oldTen(elementID, sort, page);
    }
    else if (sort == 'new') {
        newTen(elementID, sort, page);
    }
    else if (sort == 'allOld')
    {
        oldAll(elementID);
    }
    else if (sort == 'allNew')
    {
        newAll(elementID);
    }
}

function newTen(elementID)
{
    document.getElementById(elementID).innerHTML = "";
    traceName.length = 0;

    traces = trace2.slice();

    traces.sort(function (a, b) { return ((a[1] > b[1]) ? -1 : ((a[1] < b[1]) ? 1 : 0)) });

    for (i = traces.length; i > 0; i--) {
        traceName[traces.length - i] = i - 1;
    }

    if (traces.length <= page * 10)
    {
        page--;
    }
    for (i = 0; i < page * 10; i++) {
        traces.shift();
        traceName.shift();
    }

    if (traces.length > 10)
    {
        traces.length = 10;
    }

    addTrace();
}

function oldTen(elementID)
{
    document.getElementById(elementID).innerHTML = "";
    traceName.length = 0;

    traces = trace2.slice();

    traces.sort(function (a, b) { return ((a[1] < b[1]) ? -1 : ((a[1] > b[1]) ? 1 : 0)) });

    for (i = 0; i < traces.length; i++) {
        traceName[i] = i;
    }

    if (traces.length <= page * 10) {
        page--;
    }
    for (i = 0; i < page * 10; i++) {
        traces.shift();
        traceName.shift();
    }

    if (traces.length > 10) {
        traces.length = 10;
    }

    addTrace();
}

function newAll(elementID)
{
    document.getElementById(elementID).innerHTML = "";
    traceName.length = 0;

    traces = trace2.slice();

    traces.sort(function (a, b) { return ((a[1] > b[1]) ? -1 : ((a[1] < b[1]) ? 1 : 0)) });

    for (i = traces.length; i > 0; i--) {
        traceName[traces.length - i] = i - 1;
    }

    addTrace();
}

function oldAll(elementID)
{
    document.getElementById(elementID).innerHTML = "";
    traceName.length = 0;
    
    traces = trace2.slice();

    traces.sort(function (a, b) { return ((a[1] < b[1]) ? -1 : ((a[1] > b[1]) ? 1 : 0)) });

    for (i = 0; i < traces.length; i++) {
        traceName[i] = i;
    }

    addTrace();
}