<?php
require_once 'classes/membership.php';

$membership = new membership();

$membership->logUserOut();

if ($_POST && !empty($_POST['username']) && !empty($_POST['password']) && !empty($_POST['password2']))
{
	$username = $membership->checkUsername($_POST['username']);
	$userLen = 0;

	if (strlen($_POST['username']) < 8)
	{
		$userLen = 1;
	}
	else if (preg_match('/\s/', $_POST['username']))
	{
		$userLen = 2;
	}

	if (strlen($_POST['password']) < 8 || strlen($_POST['password2']) < 8)
	{
		$password = 1;
	}
	else if (strcmp(($_POST['password']), ($_POST['password2'])) != 0)
	{
		$password = 2;
	}
	else if (preg_match('/\s/', $_POST['password']) || preg_match('/\s/', $_POST['password2']))
	{
		$password = 3;
	}
	else
	{
		$password = 0;
		if ($username == 0 && $password == 0 && $userLen == 0)
		{
			$membership->createUser($_POST['username'], $_POST['password']);
		}
	}
}
?>

<!DOCTYPE html>
<html lang="en">

<head>
	<meta charset="utf-8">
	<title>Performance Visualization - Create Account</title>

	<!-- Google Fonts -->
	<link href='https://fonts.googleapis.com/css?family=Roboto+Slab:400,100,300,700|Lato:400,100,300,700,900' rel='stylesheet' type='text/css'>

	<link rel="stylesheet" href="css/animate.css">
	<!-- Custom Stylesheet -->
	<link rel="stylesheet" href="css/style.css">

	<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
</head>

<body>
<div id = "create">
	<form method="post" action ="">
		<div class="container">
			<div class="top">
				<h1 id="title" class="hidden"><span id="logo">Performance <span>Visualizer</span></span></h1>
			</div>
			<div class="login-box animated fadeInUp">
				<div class="box-header">
					<h2>Create Account</h2>
				</div>
				<label for="username">Username</label>
				<br/>
				<input type="text" maxlength="20" name="username" id="username">
				<br/>
				<label for="password">Password</label>
				<br/>
				<input type="password" maxlength="20" name="password" id="password">
				<br/>
				<label for="password2">Verify Password</label>
				<br/>
				<input type="password" maxlength="20" name="password2" id="password2">
				<br/>
				<button type="submit" id="submit" value="Finish">Create Account</button>
				<br/>
				<a href="login.php"><p class="small">Already have an account?</p></a>
			</div>
		</div>
	</form>

	<?php
	if (isset($username) && isset($password))
	{
		if ($username == 1)
		{
			echo '<script type="text/javascript">alert("That username is already taken, please enter another username.");</script>';
		}
		else if ($userLen == 1)
		{
			echo '<script type="text/javascript">alert("The username you have entered is not long enough, please enter a username with at least 8 characters.");</script>';
		}
		else if ($userLen == 2)
		{
			echo '<script type="text/javascript">alert("The username you have entered contains spaces, please enter a username without any whitespace.");</script>';
		}
		else if ($password == 1)
		{
			echo '<script type="text/javascript">alert("The password you have entered is not long enough, please enter a password with at least 8 characters.");</script>';
		}
		else if ($password == 2)
		{
			echo '<script type="text/javascript">alert("The passwords you have entered do not match, please enter the same password in both fields.");</script>';
		}
		else if ($password == 3)
		{
			echo '<script type="text/javascript">alert("The passwords you have entered contain spaces, please enter passwords without any whitespace.");</script>';
		}
	}
	else if (empty($_POST['username']) && empty($_POST['password']) && empty($_POST['password2']))
	{
		echo '<script type="text/javascript">alert("Please enter a username and password");</script>';
	}
	else if (empty($_POST['username']))
	{
		echo '<script type="text/javascript">alert("Please enter a username");</script>';
	}
	else if (empty($_POST['password']))
	{
		echo '<script type="text/javascript">alert("Please enter a password");</script>';
	}
	else if (empty($_POST['password2']))
	{
		echo '<script type="text/javascript">alert("Please verify your password");</script>';
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