<?php
require_once 'classes/membership.php';
require_once 'classes/methodExec.php';
$membership = new membership();

//If User clicks "Log Out"
if(isset($_GET['status']) && $_GET['status'] == 'loggedout'){
	$membership->logUserOut();
}

if($_POST && !empty($_POST['username']) && !empty($_POST['password'])){
	$response = $membership->validateUser($_POST['username'],$_POST['password']);
}
?>

<!DOCTYPE html>
<html lang="en">

<head>
	<meta charset="utf-8">
	<title>Software Engineering - Sign In</title>

	<!-- Google Fonts -->
	<link href='https://fonts.googleapis.com/css?family=Roboto+Slab:400,100,300,700|Lato:400,100,300,700,900' rel='stylesheet' type='text/css'>

	<link rel="stylesheet" href="css/animate.css">
	<!-- Custom Stylesheet -->
	<link rel="stylesheet" href="css/style.css">

	<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
</head>

<body>
<div id = "login">
	<form method="post" action ="">
		<div class="container">
			<div class="top">
				<h1 id="title" class="hidden"><span id="logo">Performance <span>Visualizer</span></span></h1>
			</div>
			<div class="login-box animated fadeInUp">
				<div class="box-header">
					<h2>Log In</h2>
				</div>
				<label for="username">Username</label>
				<br/>
				<input type="text" name="username" id="username">
				<br/>
				<label for="password">Password</label>
				<br/>
				<input type="password" name="password" id="password">
				<br/>
				<button type="submit" id="submit" value="Login">Sign In</button>
				<br/>
				<!-- <a href="#"><p class="small">Forgot your password?</p></a> -->
				<a href="create.php"><p class="small">Create account</p></a>
			</div>
		</div>
	</form>
	<?php if(isset($response)){
		 echo '<script type="text/javascript">alert("Please enter a valid username and password");</script>';
	}
	?>
</div>
</body>

<script>
	$(document).ready(function () {
    	$('#logo').addClass('animated fadeInDown');
    	$("input:text:visible:first").focus();
	});
	$('#username').focus(function() {
		$('label[for="username"]').addClass('selected');
	});
	$('#username').blur(function() {
		$('label[for="username"]').removeClass('selected');
	});
	$('#password').focus(function() {
		$('label[for="password"]').addClass('selected');
	});
	$('#password').blur(function() {
		$('label[for="password"]').removeClass('selected');
	});
</script>

</html>