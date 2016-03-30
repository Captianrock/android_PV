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

	console.log(jsArray);

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