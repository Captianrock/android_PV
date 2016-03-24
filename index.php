<?php
require_once 'classes/membership.php';
$membership = New membership();

$membership->confirmMember();
?>
<!DOCTYPE html>
<html lang="en">
<h1> HELLO WORLD </h1>
<a href="login.php?status=loggedout">Log Out </a>
</html>