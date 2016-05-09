<?php
require_once '../includes/constants.php';

$conn = new mysqli(DB_SERVER,DB_USER,DB_PASSWORD, DB_NAME) or
    die('There was a problem with the database connection.');

header('Content-Type: application/json');
$aResult = array();
if( !isset($_POST['functionname']) ) { $aResult['error'] = 'No function name!'; }

if( !isset($_POST['arguments']) ) { $aResult['error'] = 'No function arguments!'; }

if( !isset($aResult['error']) ) {

    switch($_POST['functionname']) {
        case 'deleteTrace':
           if( !is_string($_POST['arguments']) ) {
               $aResult['error'] = 'Error in arguments!';
           }
           else {
              $aResult['result'] = deleteTrace($_POST['arguments']);
           }
           break;
        case 'updateAppName':
           if( !is_array($_POST['arguments']) ) {
               $aResult['error'] = 'Error in arguments!';
           }
           else {
              $aResult['result'] = updateAppName($_POST['arguments']);
           }
           break;

        default:
           $aResult['error'] = 'Not found function '.$_POST['functionname'].'!';
           break;
    }
}
echo json_encode($aResult);

function deleteTrace($traceId){
    global $conn;
    $query = "DELETE 
          FROM traces
          WHERE traceId = ?";
    if($result = $conn->prepare($query)){
      $result->bind_param('s',$traceId);
      $result->execute();
      $result->close();
    }
    else{
      trigger_error("Query Failed! SQL: $query - Error: ".mysqli_error($conn), E_USER_ERROR);
    }
  $conn->close();
}


function updateAppName($arguments){

    global $conn;
    $query = "UPDATE applications 
          SET application = REPLACE(application,?,?) 
          WHERE username = ?";
    if($result = $conn->prepare($query)){
      $result->bind_param('sss',$arguments[1],$arguments[2],$arguments[0]);
      $result->execute();
      $result->close();
    }
    else{
      trigger_error("Query Failed! SQL: $query - Error: ".mysqli_error($conn), E_USER_ERROR);
    }
    $query = "UPDATE traces 
      SET application = REPLACE(application,?,?)
      WHERE username = ?";
    if($result = $conn->prepare($query)){
      $result->bind_param('sss',$arguments[1],$arguments[2],$arguments[0]);
      $result->execute();
      $result->close();
    }
    else{
      trigger_error("Query Failed! SQL: $query - Error: ".mysqli_error($conn), E_USER_ERROR);
    }
   
  $conn->close();
}

?>