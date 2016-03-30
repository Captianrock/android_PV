<?php
require_once 'classes/membership.php';
require_once 'classes/methodExec.php';

$membership = New membership();

$membership->confirmMember();
?>

<?php include ('header.html'); ?>