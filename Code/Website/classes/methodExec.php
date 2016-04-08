<?php

require_once 'includes/constants.php';

class methodExec {
	private $conn;
	public $timesList;

	function __construct(){
		$this->conn = new mysqli(DB_SERVER,DB_USER,DB_PASSWORD, DB_NAME) or
				die('There was a problem with the database connection.');
	}

	function getTimes(){// ($trace)

		$timesList = [];
		$query = "SELECT *
					FROM data
					WHERE traceId = 'altonKimAlarmKlock2'";// = '$trace'";
					
		$result = $this->conn->query($query);

		while ($row = $result->fetch_assoc()) {
			$timesList[] = $row;
		}

		$this->conn->close();

		return $timesList;
	}
}

//function startUp($trace)
//{
$methodExecVar = new methodExec();
$timesList = $methodExecVar->getTimes();// ($trace)
//}

?>

<script type="text/javascript" src="js/main.js"></script>