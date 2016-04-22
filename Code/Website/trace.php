<?php
require_once 'classes/membership.php';
require_once 'classes/methodExec.php';

$userName = $_SESSION['user'];

$membership->confirmMember();

if (isset($_GET['app'])){
    $traceData = $methodExecVar->getTraces($_GET['app'],$_SESSION['user']);
} 

$_SESSION['app'] = $_GET['app'];
?>
<script type="text/javascript">var traces = <?php echo json_encode(str_replace('"','\'',$traceData)); ?>;</script>
<!-- HEADER JS REQUIRED -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script> 
<script> 
$(function(){
  $("#includedContent").load("headers.html"); 
});
</script> 

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

    <!-- Morris Charts CSS -->
    <link href="css/plugins/morris.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">

</head>

<body>

    <div id="wrapper">

        <!-- Navigation -->
        <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div id= "includedContent"></div>
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
                            AlarmKlock <small>Trace History</small>
                        </h1>
                        <ol class="breadcrumb">
                            <li>
                                <i class="fa fa-dashboard"></i>  <a href="index.php?user=<?php echo $userName ?>">Home</a>
                            </li>
                            <li class="active">
                                <i class="fa fa-database"></i> Trace
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
										<a href="#" class="dropdown-toggle" data-toggle="dropdown"> Traces <b class="caret"></b></a>
										<ul class="dropdown-menu">
											<li>
												<a href="#">Ten newest traces</a>
											</li>
											<li>
												<a href="#">Ten oldest traces</a>
											</li>
											<li>
												<a href="#">Newest to Oldest</a>
											</li>
											<li>
												<a href="#">Oldest to Newest</a>
											</li>
										</ul>
									</div>
								</div>
							</h3>
						</div>
                        <div class="panel-body">
                            <div class="list-group" id="traceList"></div>
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
    <script>addTrace();</script>
</body>

</html>