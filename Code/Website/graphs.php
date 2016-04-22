<?php include ('header.html');?>

<!DOCTYPE html>
<html lang="en">
	<head>
		<script type="text/javascript" src="http://code.highcharts.com/highcharts.js"></script>
		<script type="text/javascript" src="https://code.highcharts.com/modules/exporting.js"></script>
	</head>
	<body>
		<div id="container" style="min-width: 310px; max-width: 1300px; height: 700px; margin: auto;"></div>
		<div id="container2" style="min-width: 310px; max-width: 1300px; height: 1000px; margin: auto; padding-top: 50px;"></div>
		<div id="container3" style="min-width: 310px; max-width: 1300px; height: 1000px; margin: auto; padding-top: 50px;"></div>
		<div id="container4" style= "width: 400px; margin: auto; padding-top: 50px;">
		<div class="panel panel-danger">
		  <div class="panel-body">
		  	The most costly method is <span id = "highestMethod"></span> with a computation time of <span id = "highestTime"></span>
		  </div>
		</div>
		</div>
		<script type="text/javascript" src="js/graphs.js"></script>
	</body>
</html>