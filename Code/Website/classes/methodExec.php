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
		#$time = 'altonKimAlarmKlock1';
		$timesList = [];
		$query = "SELECT *
					FROM data
					WHERE traceId=?";// = '$trace'";
		
		#$result = $this->conn->query($query);
		#echo $time;
		if($result = $this->conn->prepare($query)){
			$result->bind_param('s',$time);
			$result->execute();
			$result->bind_result($id,$traceId,$name,$methodStart,$methodEnd);
			while($result->fetch()){
				$timesList[] = array($traceId,$name,$methodStart,$methodEnd);
			}
			$result->close();
		}
		#while ($row = $result->fetch_assoc()) {
		#	$timesList[] = $row;
		#}
		#$result = $this->conn->query($query);
		#$result->bind_result($id,$traceId,$name,$methodStart,$methodEnd);
      	#echo "HELLO\n";
      	#echo var_dump($id);
   		$this->conn->close();
		#echo var_dump($timesList);
		return $timesList;
	}
}
?>

<script type="text/javascript" src="js/main.js"></script>