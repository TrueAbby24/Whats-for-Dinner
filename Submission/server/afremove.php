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
$str = $_REQUEST["af_str"];
$type = $_REQUEST["type"];


$statement = mysqli_prepare($mysqli, "SELECT User_id FROM users WHERE email_address = ?");
mysqli_stmt_bind_param($statement, "s", $email);
mysqli_stmt_execute($statement);
mysqli_stmt_bind_result($statement, $user_id);
mysqli_stmt_fetch($statement);
mysqli_stmt_close($statement);

if($type=="allergies"){
	$statement = mysqli_prepare($mysqli, "DELETE FROM allergies WHERE User_id = ? AND allergen = ?");
}
else if($type =="fav_recipes"){
	$statement = mysqli_prepare($mysqli, "DELETE FROM fav_recipes WHERE User_id = ? AND recipe_id = ?");
}
else {
	$response["success"]=false;
	echo json_encode($response);
	exit();
}

mysqli_stmt_bind_param($statement, "is", $user_id, $str);
mysqli_stmt_execute($statement);
mysqli_stmt_close($statement);


$response["success"]=true;
echo json_encode($response);
?>
