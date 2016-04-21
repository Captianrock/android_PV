console.log(traces);
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