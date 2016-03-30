<?php

require_once 'includes/constants.php';

class methodExec {
	private $conn;
	public $timesList;

	function __construct(){
		$this->conn = new mysqli(DB_SERVER,DB_USER,DB_PASSWORD, DB_TIMES) or 
				die('There was a problem with the database connection.');
	}

	function getTimes(){

		$timesList = [];
		$query = "SELECT *
					FROM times";
					
		$result = $this->conn->query($query);

		while ($row = $result->fetch_assoc()) {
			$timesList[] = $row;
		}

		$this->conn->close();

		return $timesList;
	}
}

$methodExecVar = new methodExec();
$timesList = $methodExecVar->getTimes();

?>


<script type="text/javascript" src="js/main.js"></script>