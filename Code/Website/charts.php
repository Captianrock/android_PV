<?php
require_once 'classes/membership.php';
require_once 'classes/methodExec.php';

$membership->confirmMember();

if (isset($_GET['trace']))
{
    $traceData = $methodExecVar->getTimes($_GET['trace']);
}

if (strpos($_GET['trace'], $_SESSION['user']) === false)
{
	$redirect = 'location: index.php?user=' . $_SESSION['user'];
    header($redirect);
}

$userName = $_SESSION['user'];
?>

<script type="text/javascript">var jsArray = <?php echo json_encode(str_replace('"','\'',$traceData)); ?>;</script>

<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Software Development</title>

    <!-- Bootstrap Core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="css/sb-admin.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
</head>

<body>

    <div id="wrapper" >

        <!-- Navigation -->
        <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
            <!-- Brand and toggle get grouped for better mobile display -->
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="index.php?user=<?php echo $userName ?> "> <img class ="pull-left" src="images\logo.png"  align="middle" style=" max-height:150%; max-width:110%" hspace="20"></img> <font size="6">Android Performance Visualizer</font></a>
            </div>
			<!-- Top Menu Items -->
			<ul class="nav navbar-right top-nav">
				<li class="dropdown">
					<a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-user"></i> <?php echo $userName ?> <b class="caret"></b></a>
					<ul class="dropdown-menu">
						<li>
							<a href="login.php?status=loggedout"><i class="fa fa-fw fa-power-off"></i> Log Out</a>
						</li>
					</ul>
				</li>
			</ul>
<!-- Sidebar Menu Items - These collapse to the responsive navigation menu on small screens -->
            <!-- Sidebar Menu Items - These collapse to the responsive navigation menu on small screens -->
            <div class="collapse navbar-collapse navbar-ex1-collapse">
                <ul class="nav navbar-nav side-nav">
                    <li>
                        <a href="index.php?user=<?php echo $userName ?>"><i class="fa fa-fw fa-dashboard"></i> Home</a>
                    </li>
					<li>
						<a href="trace.php?app=<?php echo $_SESSION['app'] ?>"><i class="fa fa-database"></i> Traces</a>
					</li>
					<li>
                        <a href="package.php?trace=<?php echo $_GET['trace'] ?>"><i class="fa fa-database"></i> Packages</a>
                    </li>
					<li>
                        <a href="tables.php?trace=<?php echo $_GET['trace'] ?>"><i class="fa fa-fw fa-table"></i> Tables</a>
                    </li>
					<li>
						<a role="button" id="csvButton" onclick="buildCSV()"> <i class="fa fa-fw fa-file"></i> Make CSV</a>
					</li>
					<li>
						<a role="button" id="pdfButton" onclick="buildPDF()"> <i class="fa fa-fw fa-file"></i> Make PDF</a>
					</li>
                    <li>
                        <a href="login.php?status=loggedout"><i class="fa fa-fw fa-power-off"></i> Log Out</a>
                    </li>
                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </nav>

        <div id="page-wrapper">

            <div class="container-fluid">

                <!-- Page Heading -->
                <div class="row">
                    <div class="col-lg-12">
                        <h1 class="page-header">
                            <?php echo $_SESSION['app'] ?> <small>Charts</small>
                        </h1>
                        <ol class="breadcrumb">
                            <li>
                                <i class="fa fa-dashboard"></i> <a href="index.php?user=<?php echo $userName ?>">Home</a>
                            </li>
							<li>
								<i class="fa fa-database"></i> <a href="trace.php?app=<?php echo $_SESSION['app'] ?>">Traces</a>
							</li>
							<li>
								<i class="fa fa-database"></i> <a href="package.php?trace=<?php echo $_GET['trace'] ?>">Packages</a>
							</li>
                            <li class="active">
                                <i class="fa fa-bar-chart-o"></i> Charts
                            </li>
                        </ol>
                    </div>
                </div>
                <!-- /.row -->

				<div class="row">
					<div class="col-lg-12">
						<h3 class="page-header">
		  					<center>The most costly method is <b><span id = "highestMethod"></span></b> with a computation time of <span id = "highestTime"></span> microseconds.</center>
						</h3>
					</div>
				</div>

                <div class="row">
                    <div class="col-lg-12">
                        <div class="panel panel-primary">
                            <div class="panel-heading">
                                <h3 class="panel-title"><i class="fa fa-bar-chart-o"></i> Bar Chart of Total Method Runtimes</h3>
                            </div>
                            <div class="panel-body" id="container2" style="min-height: 700px"></div>
							<a href="barChart.php?trace=<?php echo $_GET['trace'] ?>"><button type="button" class="btn btn-lg btn-danger" style="width:100%; border-radius:2px;">Click for larger view</button></a>
                        </div>
                    </div>
                </div>
                <!-- /.row -->

                <div class="row">
                    <div class="col-lg-5">
                        <div class="panel panel-green">
                            <div class="panel-heading">
                                <h3 class="panel-title"><i class="fa fa-bar-chart-o"></i> Column Chart of Individual Method Runtimes</h3>
                            </div>
                            <div class="panel-body" id="container3" style="min-height: 1200px"></div>
							<a href="columnChart.php?trace=<?php echo $_GET['trace'] ?>"><button type="button" class="btn btn-lg btn-danger" style="width:100%; border-radius:2px;">Click for larger view</button></a>
                        </div>
                    </div>
                    <div class="col-lg-7">
                        <div class="panel panel-yellow">
                            <div class="panel-heading">
                                <h3 class="panel-title"><i class="fa fa-pie-chart"></i> Pie Chart of Total and Individual Method Runtimes</h3>
                            </div>
                            <div class="panel-body" id="container" style="min-height: 1200px"></div>
							<a href="pieChart.php?trace=<?php echo $_GET['trace'] ?>"><button type="button" class="btn btn-lg btn-danger" style="width:100%; border-radius:2px;">Click for larger view</button></a>
                        </div>
                    </div>
                </div>
                <!-- /.row -->

            </div>
            <!-- /.container-fluid -->

        </div>
        <!-- /#page-wrapper -->

    </div>
    <!-- /#wrapper -->

    <!-- jQuery -->
    <script src="js/jquery.js"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>

	<!-- Highchart js -->
	<script type="text/javascript" src="http://code.highcharts.com/highcharts.js"></script>
	<script type="text/javascript" src="https://code.highcharts.com/modules/exporting.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="js/bootstrap.min.js"></script>
	<script src="js/main.js"></script>
    <script src="//mrrio.github.io/jsPDF/dist/jspdf.debug.js"></script> 
	<script type="text/javascript" src="js/graphs.js"></script>

</body>

</html>