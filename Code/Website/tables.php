<?php
require_once 'classes/membership.php';
require_once 'classes/methodExec.php';

$membership->confirmMember();

$methodExecVar = new methodExec();
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

    <div id="wrapper">
        
        <!-- Navigation -->
        <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
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
            <!-- Brand and toggle get grouped for better mobile display -->
           
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
                        <a href="charts.php?trace=<?php echo $_GET['trace'] ?>"><i class="fa fa-fw fa-bar-chart-o"></i> Charts</a>
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
                            <?php echo $_SESSION['app'] ?> <small>Tables</small>
                        </h1>
                        <ol class="breadcrumb">
                            <li>
                                <i class="fa fa-dashboard"></i>  <a href="index.php?user=<?php echo $userName ?>">Home</a>
                            </li>
							<li>
								<i class="fa fa-database"></i> <a href="trace.php?app=<?php echo $_SESSION['app'] ?>">Traces</a>
							</li>
							<li>
                                <i class="fa fa-bar-chart-o"></i> <a href="charts.php?trace=<?php echo $_GET['trace'] ?>">Charts</a>
                            </li>
                            <li class="active">
                                <i class="fa fa-table"></i> Tables
                            </li>
                        </ol>
                    </div>
                </div>
                <!-- /.row -->

                <div class="row">
                    <div class="col-lg-6">
                        <h2>Ten most time consuming methods</h2>
                        <div class="table-responsive">
                            <table class="table table-bordered table-hover table-striped">
                                <thead>
                                    <tr>
                                        <th>Method</th>
                                        <th>Runtime in Milliseconds</th>
                                        <th>Number of times run</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <td><span id = "maxName1"></span></td>
                                        <td><span id = "maxTime1"></span></td>
                                        <td><span id = "maxOccurence1"></span></td>
                                    </tr>
                                    <tr>
                                        <td><span id = "maxName2"></span></td>
                                        <td><span id = "maxTime2"></span></td>
                                        <td><span id = "maxOccurence2"></span></td>
                                    </tr>
                                    <tr>
                                        <td><span id = "maxName3"></span></td>
                                        <td><span id = "maxTime3"></span></td>
                                        <td><span id = "maxOccurence3"></span></td>
                                    </tr>
                                    <tr>
                                        <td><span id = "maxName4"></span></td>
                                        <td><span id = "maxTime4"></span></td>
                                        <td><span id = "maxOccurence4"></span></td>
                                    </tr>
                                    <tr>
                                        <td><span id = "maxName5"></span></td>
                                        <td><span id = "maxTime5"></span></td>
                                        <td><span id = "maxOccurence5"></span></td>
                                    </tr>
                                    <tr>
                                        <td><span id = "maxName6"></span></td>
                                        <td><span id = "maxTime6"></span></td>
                                        <td><span id = "maxOccurence6"></span></td>
                                    </tr>
                                    <tr>
                                        <td><span id = "maxName7"></span></td>
                                        <td><span id = "maxTime7"></span></td>
                                        <td><span id = "maxOccurence7"></span></td>
                                    </tr>
									<tr>
                                        <td><span id = "maxName8"></span></td>
                                        <td><span id = "maxTime8"></span></td>
                                        <td><span id = "maxOccurence8"></span></td>
                                    </tr>
									<tr>
                                        <td><span id = "maxName9"></span></td>
                                        <td><span id = "maxTime9"></span></td>
                                        <td><span id = "maxOccurence9"></span></td>
                                    </tr>
									<tr>
                                        <td><span id = "maxName10"></span></td>
                                        <td><span id = "maxTime10"></span></td>
                                        <td><span id = "maxOccurence10"></span></td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>
                    </div>
					<div class="col-lg-6">
                        <h2>Ten least time consuming methods</h2>
                        <div class="table-responsive">
                            <table class="table table-bordered table-hover table-striped">
                                <thead>
                                    <tr>
                                        <th>Method</th>
                                        <th>Runtime in Milliseconds</th>
                                        <th>Number of times run</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <td><span id = "minName1"></span></td>
                                        <td><span id = "minTime1"></span></td>
                                        <td><span id = "minOccurence1"></span></td>
                                    </tr>
                                    <tr>
                                        <td><span id = "minName2"></span></td>
                                        <td><span id = "minTime2"></span></td>
                                        <td><span id = "minOccurence2"></span></td>
                                    </tr>
                                    <tr>
                                        <td><span id = "minName3"></span></td>
                                        <td><span id = "minTime3"></span></td>
                                        <td><span id = "minOccurence3"></span></td>
                                    </tr>
                                    <tr>
                                        <td><span id = "minName4"></span></td>
                                        <td><span id = "minTime4"></span></td>
                                        <td><span id = "minOccurence4"></span></td>
                                    </tr>
                                    <tr>
                                        <td><span id = "minName5"></span></td>
                                        <td><span id = "minTime5"></span></td>
                                        <td><span id = "minOccurence5"></span></td>
                                    </tr>
                                    <tr>
                                        <td><span id = "minName6"></span></td>
                                        <td><span id = "minTime6"></span></td>
                                        <td><span id = "minOccurence6"></span></td>
                                    </tr>
                                    <tr>
                                        <td><span id = "minName7"></span></td>
                                        <td><span id = "minTime7"></span></td>
                                        <td><span id = "minOccurence7"></span></td>
                                    </tr>
									<tr>
                                        <td><span id = "minName8"></span></td>
                                        <td><span id = "minTime8"></span></td>
                                        <td><span id = "minOccurence8"></span></td>
                                    </tr>
									<tr>
                                        <td><span id = "minName9"></span></td>
                                        <td><span id = "minTime9"></span></td>
                                        <td><span id = "minOccurence9"></span></td>
                                    </tr>
									<tr>
                                        <td><span id = "minName10"></span></td>
                                        <td><span id = "minTime10"></span></td>
                                        <td><span id = "minOccurence10"></span></td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
				<!-- /.row -->

				<div class="row">
					<h2>Ten most called methods</h2>
                    <div class="table-responsive">
                        <table class="table table-bordered table-hover table-striped">
                            <thead>
                                <tr>
                                    <th>Method</th>
                                    <th>Runtime in Milliseconds</th>
                                    <th>Number of times run</th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <td><span id = "callName1"></span></td>
                                    <td><span id = "callTime1"></span></td>
                                    <td><span id = "callOccurence1"></span></td>
                                </tr>
                                <tr>
                                    <td><span id = "callName2"></span></td>
                                    <td><span id = "callTime2"></span></td>
                                    <td><span id = "callOccurence2"></span></td>
                                </tr>
                                <tr>
                                    <td><span id = "callName3"></span></td>
                                    <td><span id = "callTime3"></span></td>
                                    <td><span id = "callOccurence3"></span></td>
                                </tr>
                                <tr>
                                    <td><span id = "callName4"></span></td>
                                    <td><span id = "callTime4"></span></td>
                                    <td><span id = "callOccurence4"></span></td>
                                </tr>
                                <tr>
                                    <td><span id = "callName5"></span></td>
                                    <td><span id = "callTime5"></span></td>
                                    <td><span id = "callOccurence5"></span></td>
                                </tr>
                                <tr>
                                    <td><span id = "callName6"></span></td>
                                    <td><span id = "callTime6"></span></td>
                                    <td><span id = "callOccurence6"></span></td>
                                </tr>
                                <tr>
                                    <td><span id = "callName7"></span></td>
                                    <td><span id = "callTime7"></span></td>
                                    <td><span id = "callOccurence7"></span></td>
                                </tr>
								<tr>
                                    <td><span id = "callName8"></span></td>
                                    <td><span id = "callTime8"></span></td>
                                    <td><span id = "callOccurence8"></span></td>
                                </tr>
								<tr>
                                    <td><span id = "callName9"></span></td>
                                    <td><span id = "callTime9"></span></td>
                                    <td><span id = "callOccurence9"></span></td>
                                </tr>
								<tr>
                                    <td><span id = "callName10"></span></td>
                                    <td><span id = "callTime10"></span></td>
                                    <td><span id = "callOccurence10"></span></td>
                                </tr>
                            </tbody>
                        </table>
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

    <!-- Bootstrap Core JavaScript -->
    <script src="js/bootstrap.min.js"></script>
	<script src="js/main.js"></script>
    <script src="//mrrio.github.io/jsPDF/dist/jspdf.debug.js"></script> 
 <!--   <script type="text/javascript">var jsArray = "<?php echo json_encode($traceData); ?>;"</script>
    <script type="text/javascript">var jsArray2 = "<?php echo json_encode($traceData); ?>;"</script> -->
	<script type="text/javascript" src="js/tables.js"></script>

</body>

</html>