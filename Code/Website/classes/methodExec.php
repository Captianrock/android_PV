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
		$packageList = [];
		$timesList = [];
		$tablequery = "
		CREATE TEMPORARY TABLE temp_table_1 (
      	`package` varchar(500)
    	)
  		";  
  		$insertQuery = "INSERT INTO temp_table_1 (package)
  		VALUES ".$selection;

  		$selectQ = "SELECT * FROM temp_table_1";

		$query = "SELECT *
					FROM data
					WHERE traceId=? AND data.package in (SELECT package FROM temp_table_1)";

		if(!$result = $this->conn->query($tablequery)){
			trigger_error("Query Failed! SQL: $tablequery - Error: ".mysqli_error($this->conn), E_USER_ERROR);
		}

		if(!$test = $this->conn->query($insertQuery)){
			trigger_error("Query Failed! SQL: $insertQuery- Error: ".mysqli_error($this->conn), E_USER_ERROR);
		}

		if($result = $this->conn->prepare($query)){
			$result->bind_param('s',$time);
			$result->execute();
			$result->bind_result($id,$traceId,$name,$methodStart,$methodEnd,$package);
			while($result->fetch()){
				$timesList[] = array($traceId,$name,$methodStart,$methodEnd,$package);
			}
			$result->close();
		}
		else{
			trigger_error("Query Failed! SQL: $query- Error: ".mysqli_error($this->conn), E_USER_ERROR);
		}

   		$this->conn->close();

		//return $timesList;
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
			$result->bind_result($package);
			while($result->fetch()){
				$timesList[] = $package;
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
	function getMaxMethod($traceList){
		$resultList = [];
		$tablequery = "
		CREATE TEMPORARY TABLE temp_list (
      	`id` varchar(500)
    	)
  		";
  		
  		$insertQuery = "INSERT INTO temp_list (id)
  		VALUES ".$traceList;
		
		$query = "SELECT methodName, timeDiff
		FROM (SELECT methodName, SUM(timeEnd - timeStart) AS timeDiff
				FROM data
				WHERE traceId IN (SELECT id FROM temp_list)
				GROUP BY methodName) as times
        ORDER BY times.timeDiff DESC LIMIT 1
		";

		$dumb = "SELECT * FROM temp_list";

  		if(!$result = $this->conn->query($tablequery)){
			trigger_error("Query Failed! SQL: $tablequery - Error: ".mysqli_error($this->conn), E_USER_ERROR);
		}
		if(!$test = $this->conn->query($insertQuery)){
			trigger_error("Query Failed! SQL: $insertQuery- Error: ".mysqli_error($this->conn), E_USER_ERROR);
		}
		if($res = $this->conn->query($query)){
			while($save = $res->fetch_row()){
				$resultList[] = $save;
			}
		}
		else{
			trigger_error("Query Failed! SQL: $query- Error: ".mysqli_error($this->conn), E_USER_ERROR);
		} 

		return $resultList;

	}
}

$methodExecVar = new methodExec();
/*
CREATE TEMPORARY TABLE temp_list (
 `id` varchar(500)
);

INSERT INTO temp_list (id)
  		VALUES ('erinNPRNews28/04/16-16:41:58');

SELECT methodName, timeDiff
FROM (SELECT methodName, SUM(timeEnd - timeStart) AS timeDiff
		FROM data
		WHERE traceId IN (SELECT * FROM temp_list)
		GROUP BY methodName) as times
        ORDER BY times.timeDiff DESC LIMIT 1
*/
?>

<script type="text/javascript" src="js/main.js"></script>

