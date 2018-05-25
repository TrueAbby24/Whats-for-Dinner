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
$af_table = $_REQUEST["af_table"];


$statement = mysqli_prepare($mysqli, "SELECT User_id FROM users WHERE email_address = ?");
mysqli_stmt_bind_param($statement, "s", $email);
mysqli_stmt_execute($statement);
mysqli_stmt_bind_result($statement, $user_id);
mysqli_stmt_fetch($statement);

mysqli_stmt_close($statement);

if($af_table=="allergies"){
	$statement = mysqli_prepare($mysqli, "INSERT INTO allergies( User_id, allergen ) values( $user_id, ?)");
}
else if($af_table =="fav_recipes"){
	$statement = mysqli_prepare($mysqli, "INSERT INTO fav_recipes( User_id, recipe_id ) values( $user_id, ?)");
}
else {
	$response["success"]=false;
	echo json_encode($response);
}

$af_arr = explode(",",$str);

foreach($af_arr as $af_value){
	if(!$statement){
		echo json_encode($response);
		exit();
	}
	else{
		mysqli_stmt_bind_param($statement, "s", $af_value);
		mysqli_stmt_execute($statement);
	}
}

$response["success"]=true;
echo json_encode($response);
 






?>