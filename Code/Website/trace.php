<?php
require_once 'classes/membership.php';
require_once 'classes/methodExec.php';

$membership->confirmMember();

$userName = $_SESSION['user'];

if (isset($_GET['app'])){
    $traceData = $methodExecVar->getTraces($_GET['app'],$_SESSION['user']);
    $stringofTraces = "";
    for ($x = 0; $x < count($traceData); $x++) {
        $tempResult = implode(",", $traceData[$x]);
        $tempResult2 = explode(",", $tempResult);
        $stringofTraces .= '(\''.$tempResult2[0].'\'),';
    } 
    $stringofTraces = chop($stringofTraces,',');

    $maxMethod = $methodExecVar->getMaxMethod($stringofTraces);
} 



$_SESSION['app'] = $_GET['app'];
?>
<script type="text/javascript">var traces = <?php echo json_encode(str_replace('"','\'',$traceData)); ?>;
var maxMethod = <?php echo json_encode($maxMethod); ?>;</script>

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
    <link href="css/style2.css" rel="stylesheet">
    <link rel="stylesheet" href="css/animate.css">

    <!-- Custom Fonts -->
    <link href="font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">

</head>

<body>

    <div id="wrapper">

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
                    <li class>
                        <a href="index.php?user=<?php echo $userName ?>"><i class="fa fa-fw fa-dashboard"></i> Home</a>
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
                            <?php echo $_SESSION['app'] ?> <small>Trace History</small>
                        </h1>
                        <ol class="breadcrumb">
                            <li>
                                <i class="fa fa-dashboard"></i> <a href="index.php?user=<?php echo $userName ?>">Home</a>
                            </li>
                            <li class="active">
                                <i class="fa fa-database"></i> Traces
                            </li>
                        </ol>
                    </div>
                </div>
                <div class="row">
                    <h2 class="animated fadeInUp" style="text-align: center">
                        Browse Individual Traces
                    </h3>
                    <h3 id="fillMax" class="animated fadeInUp" style="text-align: center">
                    </h3>
                </div>
                <!-- /.row -->

                <div class="row col-lg-12">
                    <div class="panel panel-info">
                        <div class="panel-heading">
                            <h3 class="panel-title" style="height:20px;">
                                <div class="col-lg-1">
                                    <div class="dropdown">
                                        <a href="#" class="dropdown-toggle" data-toggle="dropdown"> Traces <b class="caret"></b></a>
                                        <ul class="dropdown-menu">
                                            <li>
                                                <a href="#" onclick="selectSort('traceList', '0', 'new')">Ten newest traces</a>
                                            </li>
                                            <li>
                                                <a href="#" onclick="selectSort('traceList', '0', 'old')">Ten oldest traces</a>
                                            </li>
                                            <li>
                                                <a href="#" onclick="selectSort('traceList', '0', 'allNew')">Newest to Oldest</a>
                                            </li>
                                            <li>
                                                <a href="#" onclick="selectSort('traceList', '0', 'allOld')">Oldest to Newest</a>
                                            </li>
                                        </ul>
                                    </div>
                                </div>
                            </h3>
                        </div>
                        <div class="panel-body">
                            <div class="list-group" id="traceList"></div>
                            <ul class="pager" style="padding-left: 30px; padding-right: 30px;">
                                <li class="previous"><a href="#" onclick="selectSort('traceList', '-')">Previous</a></li>
                                <li class="next"><a href="#" onclick="selectSort('traceList', '+')">Next</a></li>
                            </ul>
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

    <!-- Bootstrap Core JavaScript -->
    <script src="js/bootstrap.min.js"></script>
    <script src="js/main.js"></script>
    <script src="//mrrio.github.io/jsPDF/dist/jspdf.debug.js"></script> 
    <script src="js/dynamicLoading.js"></script>
    <script>selectSort('traceList', '0', 'new');</script>
    <script>getMaxMethod(maxMethod);</script>
</body>

</html>