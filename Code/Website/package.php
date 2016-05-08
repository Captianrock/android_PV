<?php
require_once 'classes/membership.php';
require_once 'classes/methodExec.php';

$membership->confirmMember();

$userName = $_SESSION['user'];

if (isset($_GET['trace']))
{
    $packageData = $methodExecVar->getPackage($_GET['trace']);
}
?>
<script type="text/javascript">var packages = <?php echo json_encode(str_replace('"','\'',$packageData)); ?>;</script>

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
						<a href="trace.php?app=<?php echo $_SESSION['app'] ?>"><i class="fa fa-database"></i> Traces</a>
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
							<li>
								<i class="fa fa-database"></i> <a href="trace.php?app=<?php echo $_SESSION['app'] ?>">Traces</a>
							</li>
                            <li class="active">
                                <i class="fa fa-database"></i> Packages
                            </li>
                        </ol>
                    </div>
                </div>
                <!-- /.row -->

                <div class="row col-lg-12">
                    <div class="panel panel-info">
                        <div class="panel-heading">
                            <h3 class="panel-title" style="height:20px;">
                                <div class="col-lg-1">
                                    <div class="dropdown">
                                        <a href="#" class="dropdown-toggle" data-toggle="dropdown"> Packages <b class="caret"></b></a>
                                        <ul class="dropdown-menu">
                                            <li>
                                                <a id="rowSelectAll">Select All</a>
                                            </li>
                                            <li>
                                                <a id="rowDeselectAll">Deselect All</a>
                                            </li>
                                        </ul>
                                    </div>
                                </div>
                            </h3>
                        </div>
                        <div class="panel-body">
                            <!-- <div class="list-group" id="packageList"></div> -->
                            <div id="checkboxList">

                            </div>
							<a href="charts.php?trace=<?php echo $_GET['trace'] ?>"><button type="button" class="btn btn-lg btn-danger" style="width:100%; border-radius:2px;">View Charts</button></a>
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
    <script>addPackage();</script>
</body>

</html>