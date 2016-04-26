<?php

require_once 'includes/constants.php';

class methodExec {
	private $conn;
	public $timesList;

	function __construct(){
		$this->conn = new mysqli(DB_SERVER,DB_USER,DB_PASSWORD, DB_NAME) or
				die('There was a problem with the database connection.');
	}

	function getTimes($time){

		$timesList = [];
		$query = "SELECT *
					FROM data
					WHERE traceId=?";

		if($result = $this->conn->prepare($query)){
			$result->bind_param('s',$time);
			$result->execute();
			$result->bind_result($id,$traceId,$name,$methodStart,$methodEnd);
			while($result->fetch()){
				$timesList[] = array($traceId,$name,$methodStart,$methodEnd);
			}
			$result->close();
		}

   		$this->conn->close();

		return $timesList;
	}

	function getTraces($appName,$user){
		$traceList = [];
		$query = "SELECT *
					FROM traces
					WHERE application = ? AND username = ?";
		if($result = $this->conn->prepare($query)){
			$result->bind_param('ss',$appName,$user);
			$result->execute();
			$result->bind_result($id,$userName,$application,$traceId,$date);
			while($result->fetch()){
				$traceList[] = array($traceId,$date);
			}
			$result->close();
		}
   		$this->conn->close();
		return $traceList;
	}

	function getApplications($user){
		$traceList = [];
		$query = "SELECT *
					FROM applications
					WHERE username = ?";
		if($result = $this->conn->prepare($query)){
			$result->bind_param('s',$user);
			$result->execute();
			$result->bind_result($id,$userName,$application);
			while($result->fetch()){
				$traceList[] = array($application);
			}
			$result->close();
		}
   		$this->conn->close();
		return $traceList;
	}
}

$methodExecVar = new methodExec();
?>

<script type="text/javascript" src="js/main.js"></script>