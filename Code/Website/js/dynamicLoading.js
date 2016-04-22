function addTrace() {

  var traceContainer = document.getElementById('traceList');
  for(var i = 0; i < traces.length; i++){
  	var traceID = traces[i][0];
  	var time = traces[i][1];
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
  	newTrace.innerHTML = "Trace " + (i+1) + " recorded on " + arraydate+ " at "+ time + ":" + arraytime[1] + ":" + arraytime[2] + " "+ AmPm;
  	newTrace.setAttribute('href','charts.php?trace=' + traceID);
  	newTrace.setAttribute('class','list-group-item');
  	traceContainer.appendChild(newTrace);
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
	if(apps.length > 0){
		rowsLeft = rowsLeft -3;
		addRow(rowNumber);
		while(rowsLeft > 0){
			rowNumber++;
			addRow(rowNumber);
		}
		rowsId = rowNumber;
		for (var i = 1; i <= apps.length; i++){
			addButton('row1');
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


function addButton(newRowId){
	var newRow = document.getElementById(newRowId);

	var newPadding = document.createElement('div');
	newPadding.setAttribute('class','col-md-4');
	newPadding.setAttribute('style','padding-top: 50px; padding-left: 20px; padding-right: 20px;');

	newRow.appendChild(newPadding);

	var newPanel = document.createElement('div');
	newPanel.setAttribute('class','panel panel-primary');

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
	appName.innerHTML = 'AlarmKlock';

	newCol2.appendChild(appName);

	var link = document.createElement('div');
	link.innerHTML = 'View charts';

	newCol2.appendChild(link);

	var newA = document.createElement('a');
	newA.setAttribute('href',"trace.php?app=" + 'AlarmKlock');

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