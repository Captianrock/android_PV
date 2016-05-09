<?php
require_once 'classes/membership.php';
require_once 'classes/methodExec.php';

$membership->confirmMember();

$userName = $_SESSION['user'];

if (isset($_GET['user'])){
    $appList = $methodExecVar->getApplications($_GET['user']);
}

if($_GET['user'] != $_SESSION['user'])
{
    $redirect = 'location: index.php?user=' . $_SESSION['user'];
    header($redirect);
} 
?>
<script type="text/javascript">var apps = <?php echo json_encode($appList); ?>;</script> 

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
        <nav>
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
            <!-- Sidebar Menu Items - These collapse to the responsive navigation menu on small screens -->
            <div class="collapse navbar-collapse navbar-ex1-collapse">
                <ul class="nav navbar-nav side-nav">
                    <li class="active">
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
                            Home <small>Statistics Overview</small>
                        </h1>
                        <ol class="breadcrumb">
                            <li class="active">
                                <i class="fa fa-dashboard"></i> Home
                            </li>
                        </ol>
                    </div>
                </div>
                <div class="row">
                    <h2 class="animated fadeInUp editable" style="text-align: center">
                        Welcome!
                    </h2>
                    <h3 class="animated fadeInUp" style="text-align: center">
                    Welcome to the home page of the Android Performance Visualization! To view your data select the "View Details" button. If you would like to
                    rename your application. Just double click on the button!    
                    </h3>
                </div>
                <!-- /.row -->
                <div id="rowContainer">
					<!-- Dynamic loading here, do not remove -->
                </div>
                <!-- /.row -->

            </div>
            <!-- /.container-fluid -->

        </div>
        <!-- /#page-wrapper -->

    </div>
    <!-- /#wrapper -->

	<!-- Modal -->
	<div class="modal fade" id="renameModal" tabindex="-1" role="dialog" 
		 aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<!-- Modal Header -->
				<div class="modal-header">
					<button type="button" class="close" 
					   data-dismiss="modal">
						   <span aria-hidden="true">&times;</span>
						   <span class="sr-only">Close</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">
						Change App Name
					</h4>
				</div>
            
				<!-- Modal Body -->
				<div class="modal-body">
					<form role="form">
					  <div class="form-group">
						<label for="exampleInputEmail1">App Name</label>
						  <input type="appName" class="form-control" id="nameInput" placeholder="Enter New Name"/>
					  </div>
					</form>
				</div>
            
				<!-- Modal Footer -->
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
					<button type="button" class="btn btn-primary">Save changes</button>
				</div>
			</div>
		</div>
	</div>

    <!-- jQuery -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.2/jquery.min.js"></script>

    <script type="text/javascript">
    $('#rowContainer').on('dblclick', 'div', function(e) {
        $('#renameModal').modal('show');
    });
    </script>
    <!-- Bootstrap Core JavaScript -->
    <script src="js/bootstrap.min.js"></script>
    <script src="js/main.js"></script>
    <script src="//mrrio.github.io/jsPDF/dist/jspdf.debug.js"></script> 
    <script src="js/dynamicLoading.js"></script>
    <script>addApp();</script>
    <!--<script type="text/javascript">var jsArray = <?php echo json_encode($timesList); ?>;</script> -->

</body>

</html>