<!DOCTYPE html>
<html lang="en">
 <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <title>Software Engineering</title>

    <!-- Bootstrap -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="css/style.css">
  </head>
  <body>
 	<?php include ('header.html'); ?>

 	<!-- Drop down menu populated with the names of applicaton in database
 	 -->
 	 <div class="dropdown">
      <button class="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdown">Application Select
      <span class="caret"></span></button>
      <ul class="dropdown-menu">
        <li><a href="alarmklock.php">Alarm Klock</a></li>
        <li><a href="#">App 2</a></li>
        <li><a href="#">App 3</a></li>
      </ul>
    </div>
	
  </body>
  </html>