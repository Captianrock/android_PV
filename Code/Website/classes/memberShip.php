<?php
session_start();
require 'Mysql.php';

class membership{
	function logUserOut(){
		if(isset($_SESSION['status'])){
			unset($_SESSION['status']);

			if(isset($_COOKIE[session_name()])){
				setcookie(session_name(),'',time()-1000);
				session_destroy();
			}
		}
	}
	function validateUser($un,$pwd){
		$mysql = New Mysql();
		$ensureCredentials = $mysql->verifyUsernameandPass($un,md5($pwd));
		if($ensureCredentials){
			$_SESSION['status'] = 'authorized';
			$_SESSION['user'] = $un;
			$address = 'location: index.php?user=' . $_SESSION['user'];
			echo($address);
			header($address);
		}
		else{
			return "Please enter a correct username and password";
		}
	}
	function confirmMember(){
		if($_SESSION['status'] != 'authorized'){
			header("location: login.php");
		}
	}
	function checkUsername($un)
	{
		$mysql = New Mysql();
		$ensureCredentials = $mysql->verifyUsername($un);
		if($ensureCredentials){
			return 1;
		}
		else{
			return 0;
		}
	}
	function createUser($un, $pwd)
	{
		$mysql = New Mysql();
		$createCredentials = $mysql->createUsernameandPass($un,md5($pwd));
		if($createCredentials){
			header("location: login.php");
		}
		else{
			return 1;
		}
	}
}

$membership = new membership();