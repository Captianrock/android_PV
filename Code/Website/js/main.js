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
	// loop over them all
	for (var i=0; i<checkboxes.length; i++) {
	 // And stick the checked ones onto an array...
	 if (checkboxes[i].checked) {
	 	checkboxesChecked.push(checkboxes[i]);
	 }
	}
	// Return the array if it is non-empty, or null
	var selectionList = document.getElementById("selectionResponse");
	var stringofPackages = "";
	console.log(checkboxesChecked);
	for (var j = 0; j < checkboxesChecked.length; j++){
		stringofPackages += '(\''+checkboxesChecked[j].id+'\'),';
	}
	stringofPackages = stringofPackages.slice(0, -1);
	console.log(stringofPackages);
	selectionList.setAttribute('href','charts.php?trace='+traceID+'&package='+stringofPackages);
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