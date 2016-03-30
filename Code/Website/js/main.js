alert("Welcome to the site!");

function buildCSV() {

	console.log(jsArray);

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

	alert(str);

	var csvContent = "data:text/csv;charset=utf-8," + str;

	var encodedUri = encodeURI(csvContent);
	window.open(encodedUri);
}

function buildPDF() {


	
}