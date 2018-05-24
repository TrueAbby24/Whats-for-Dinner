<?php
$dbhost = "localhost";
$dbuser = "root";
$dbpass = "f565593aad3897ad";
$db = "wfd_db";
$mysqli = new mysqli($dbhost, $dbuser, $dbpass, $db);

$response = array();
$response["success"] = false;

if (mysqli_connect_errno()) {
    echo json_encode($response);
    exit();
}

$email = $_POST["email"];

$statement = mysqli_prepare($mysqli, "SELECT User_id FROM users WHERE email_address = ?");
mysqli_stmt_bind_param($statement, "s", $email);
mysqli_stmt_execute($statement);
mysqli_stmt_bind_result($statement, $user_id);
mysqli_stmt_fetch($statement);
$userid = $user_id;

foreach($allergen as $allergen)
{
	$sql = "INSERT INTO allergies (User_id, allergen) values (".$userid .",".$allergen.")";
	if(!$mysqli->query($sql);){
		echo json_encode($response);
	}
	
}






?>