function buildCSV() {

	var array = JSON.parse(JSON.stringify(jsArray));
	var str = '';

	for (var i = 0; i < array.length; i++) {
		var line = '';
		for (var index in array[i]) {
			if (line != '') {
				line +=',';
			}
			line += array[i][index];
		}
		str += line + '\r\n';
	}

	var csvContent = "data:text/csv;charset=utf-8," + str;

	var encodedUri = encodeURI(csvContent);
	window.open(encodedUri);
}

function buildPDF() {

	var doc = new jsPDF();
	
	var array = JSON.parse(JSON.stringify(jsArray));
	var str = '';

	for (var i = 0; i < array.length; i++) {
		var line = '';
		for (var index in array[i]) {
			if (line != '') {
				line +=',';
			}
			line += array[i][index];
		}
		str += line + '\r\n';
	}

	doc.text(20, 20, str);

	doc.save('Test.pdf');
	
}

function checkFilter(){
	var checkboxes = document.getElementById("checkboxList").getElementsByTagName("input");
	var checkboxesChecked = [];

	for (var i=0; i<checkboxes.length; i++) {
		if (checkboxes[i].checked) {
			checkboxesChecked.push(checkboxes[i]);
		}
	}
	if(checkboxesChecked.length > 0){
		var selectionList = document.getElementById("selectionResponse");
		var stringofPackages = "";
		for (var j = 0; j < checkboxesChecked.length; j++){
			stringofPackages += '(\''+checkboxesChecked[j].id+'\'),';
		}
		stringofPackages = stringofPackages.slice(0, -1);
		selectionList.setAttribute('href','charts.php?trace='+traceID+'&package='+stringofPackages);
	}
	else{
		alert("Please select at least one package!");
	}
}
function toggle(source) {
  checkboxes = document.getElementsByName('checkPackage');
  for(var i=0, n=checkboxes.length;i<n;i++) {
    if(source == "unCheck"){
    	checkboxes[i].checked = false;
	}
	else{
		checkboxes[i].checked = true;
	}
  }
}
function reNameAppClick(current){
  currentApp = current;
  document.getElementById('nameInput').value = currentApp;

  $('#renameModal').modal('show');
  console.log(currentApp);
}
function reNameApp(){
  var newAppName = document.getElementById('nameInput').value;
	console.log("rename",currentApp,newAppName);
  if(currentApp != newAppName){
	  $.ajax({
	        type: "POST",
	        url: 'classes/databaseChanges.php',
	        dataType: 'json',
	        data: {functionname: 'updateAppName', arguments: [name,currentApp,newAppName]},
	      complete: function(jqXHR, textStatus) {
	          console.log('AJAX reName call complete');
	          console.log(jqXHR);
	      },
	        success: function (obj, textstatus) {
	                      if( !('error' in obj) ) {
	                        console.log("SUCCESS");
	                      }
	                      else {
	                        console.log(obj.error);
	                      }
	              }
	    });
	    var currentLabel = document.getElementById(currentApp);
	    currentLabel.setAttribute('id',newAppName);
	    currentLabel.innerHTML = newAppName;

	    var currentButton = document.getElementById(currentApp+"CURRENT");
	    currentButton.setAttribute('id',newAppName);
	    currentButton.setAttribute('ondblclick','reNameAppClick(\'' + newAppName + '\')');

	    var currentLink = document.getElementById(currentApp+"LINK");
		currentLink.setAttribute('id',newAppName);
		currentLink.setAttribute('href',"trace.php?app=".concat(newAppName));
	}
}

function deleteTrace(traceID){
	console.log("DELETE",traceID);
	$.ajax({
	    type: "POST",
	    url: 'classes/databaseChanges.php',
	    dataType: 'json',
	    data: {functionname: 'deleteTrace', arguments: traceID},
		complete: function(jqXHR, textStatus) {
		    console.log('AJAX Delete call complete');
		},
	    success: function (obj, textstatus) {
	                  if( !('error' in obj) ) {
	                  	console.log("SUCCESS");
	                  }
	                  else {
	                  	console.log(obj.error);
	                  }
	    			}
	});
	for(var i = 0; i < trace2.length; i++){
		if(trace2[i][0] == traceID){
			trace2.splice(i,1);
		}	
	}
 	selectSort('traceList');
}
