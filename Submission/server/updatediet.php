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


$email = $_REQUEST["email"];
$str = $_REQUEST["diet"];

$statement = mysqli_prepare($mysqli, "SELECT User_id FROM users WHERE email_address = ?");
mysqli_stmt_bind_param($statement, "s", $email);
mysqli_stmt_execute($statement);
mysqli_stmt_bind_result($statement, $user_id);
mysqli_stmt_fetch($statement);
mysqli_stmt_close($statement);


$statement = mysqli_prepare($mysqli, "UPDATE users SET dietary_req = ? WHERE User_id = ".$user_id);
mysqli_stmt_bind_param($statement, "s", $str);
mysqli_stmt_execute($statement);
mysqli_stmt_close($statement);

$response["success"] = true;
echo json_encode($response);

?>