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

        default:
           $aResult['error'] = 'Not found function '.$_POST['functionname'].'!';
           break;
    }
}
echo json_encode($aResult);

function deleteTrace($traceId){
    echo $traceId;
    global $conn;
    $query = "DELETE 
          FROM traces
          WHERE traceId = ?";
    if($result = $conn->prepare($query)){
      $result->bind_param('s',$traceId);
      $result->execute();
      $result->close();
    }
  $conn->close();
}
?>