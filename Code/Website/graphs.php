<?php
require_once 'classes/membership.php';
require_once 'classes/methodExec.php';
$membership = New membership();

$membership->confirmMember();
?>

<?php include ('header.html'); ?>

<!DOCTYPE html>
<html lang="en">
	<head>
		<script type="text/javascript" src="http://code.highcharts.com/highcharts.js"></script>
		<script type="text/javascript" src="https://code.highcharts.com/modules/exporting.js"></script>
	</head>
	<body>
		<div id="container" style="min-width: 310px; max-width: 1300px; height: 2000px; margin: auto;"></div>
		<div id="container2" style="min-width: 310px; max-width: 1300px; height: 700px; margin: auto; padding-top: 50px;"></div>

		<script type="text/javascript" src="js/graphs.js"></script>
	</body>
</html>