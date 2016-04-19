<?php

require_once 'includes/constants.php';

class Mysql {
	private $conn;

	function __construct(){
		$this->conn = new mysqli(DB_SERVER,DB_USER,DB_PASSWORD,DB_NAME) or 
				die('There was a problem with the database connection.');
	}

	function verifyUsernameandPass($un,$pwd){

		$query = "SELECT *
					FROM users
					WHERE username = ? AND password = ?
					LIMIT 1";

		if($stmt = $this->conn->prepare($query)){
			$stmt->bind_param('ss',$un,$pwd);
			$stmt->execute();

			if($stmt->fetch()){
				$stmt->close();
				return true;
			}
		}
	}

	function verifyUsername($un)
	{
		$query = "SELECT *
					FROM users
					WHERE username = ?
					LIMIT 1";

		if($stmt = $this->conn->prepare($query))
		{
			$stmt->bind_param('s',$un);
			$stmt->execute();

			if($stmt->fetch())
			{
				$stmt->close();
				return true;
			}
		}
	}

	function createUsernameandPass($un,$pwd){

		$sql = "INSERT INTO users (id, username, password) 
					VALUES ('0', '{$un}', '{$pwd}');";

		if($stmt = $this->conn->query($sql))
		{
			$this->conn->close();
			return true;
		}

		return false;
	}
}