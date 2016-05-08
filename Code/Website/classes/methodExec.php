<?php

require_once 'includes/constants.php';

class methodExec {
	private $conn;
	public $timesList;

	function __construct(){
		$this->conn = new mysqli(DB_SERVER,DB_USER,DB_PASSWORD, DB_NAME) or
				die('There was a problem with the database connection.');
	}

	function getTimes($time,$selection){

		$timesList = [];

		$example = '(com.package),(alton.kim1)';
		$tablequery = "DECLARE @listOfIDs table (package varchar(500));
		INSERT @listOfIDs(id) values ?";  
		if($create = $this->conn->prepare($tablequery)){
			$result->bind_param('s',$example);
			$result->execute();
			$result->close();	
		}
		if($test = $this->conn->query("SELECT * FROM @listOfIDs")){
			echo($test);
		}
		/*$query = "SELECT *
					FROM data
					WHERE traceId=? AND data.package in (SELECT id FROM @listofIDs";

		if($result = $this->conn->prepare($query)){
			$result->bind_param('s',$time);
			$result->execute();
			$result->bind_result($id,$traceId,$name,$methodStart,$methodEnd,$package);
			while($result->fetch()){
				$timesList[] = array($traceId,$name,$methodStart,$methodEnd,$package);
			}
			$result->close();
		}*/

   		$this->conn->close();

		return $timesList;
	}
	function getPackage($time){

		$timesList = [];
		$query = "SELECT DISTINCT package
					FROM data
					WHERE traceId=?";

		if($result = $this->conn->prepare($query)){
			$result->bind_param('s',$time);
			$result->execute();
			$result->bind_result($id,$traceId,$name,$methodStart,$methodEnd,$package);
			while($result->fetch()){
				$timesList[] = array($traceId,$name,$methodStart,$methodEnd,$package);
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