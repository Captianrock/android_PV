<?php

require 'Mysql.php';

class memberShip{
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
			header("location: index.php");
		}
		else{
			return "Please enter a correct username and password";
		}
	}
	function confirmMember(){
		session_start();
		if($_SESSION['status'] != 'authorized'){
			header("location: login.php");
		}
	}
}