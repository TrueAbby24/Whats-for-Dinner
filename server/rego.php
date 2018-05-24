<?php
$dbhost = "localhost";
$dbuser = "root";
$dbpass = "f565593aad3897ad";
$db = "wfd_db";
$mysqli = new mysqli($dbhost, $dbuser, $dbpass, $db);

$response = array();
$response["success"] = false;

// check con
if (mysqli_connect_errno()) {
    echo json_encode($response);
    exit();
}
$email = $_POST["email"];
$password = $_POST["password"];
$diet = $_POST["diet"];

$statement = mysqli_prepare($mysqli, "SELECT email_address, password FROM users WHERE email_address=?");
mysqli_stmt_bind_param($statement, "s", $email);
mysqli_stmt_execute($statement);
// mysqli_stmt_bind_result($statement, $name, $code);

$count = 0;
while (mysqli_stmt_fetch($statement)) {
    $count++;
}
mysqli_stmt_close($statement);
if ($count > 0) {
  echo json_encode($response);
  exit();
 } else {
    $hashed_password = password_hash($password, PASSWORD_BCRYPT);
    $statement = mysqli_prepare($mysqli, "INSERT INTO users (email_address, password, dietary_req) VALUES (?, ?, ?)");
    mysqli_stmt_bind_param($statement, "sss", $email, $hashed_password, $diet);
    mysqli_stmt_execute($statement);	
    mysqli_stmt_close($statement);
	
	$statement = mysqli_prepare($mysqli, "SELECT User_id, email_address FROM users WHERE email_address = ?");
	mysqli_stmt_bind_param($statement, "s", $email);
	mysqli_stmt_execute($statement);
	mysqli_stmt_bind_result($statement, $user_id, $email_address);
	mysqli_stmt_fetch($statement);
/* 	echo $email_address."  ".$user_id."\n"; */
	
	$verification_email_body = "Here's your verification code: ".$user_id;
/* 	echo $verification_email_body."\n"; */
	mail($email_address,"Verification",$verification_email_body);
	
	
 }
 $response["success"] = true;
 echo json_encode($response);
?>
