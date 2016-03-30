<?php
require_once 'classes/membership.php';
$membership = New membership();

$membership->confirmMember();
?>

<?php include ('header.html'); ?>