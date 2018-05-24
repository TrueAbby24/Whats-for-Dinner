<?php
$dbhost = "localhost";
$dbuser = "root";
$dbpass = "f565593aad3897ad";
$db = "wfd_db";
$mysqli = new mysqli($dbhost, $dbuser, $dbpass, $db);

$response = array();
$response["success"] = false;
$email = $_REQUEST["email"];
$recipeID = $_REQUEST["recipeID"];
$statement = mysqli_prepare($mysqli, "SELECT User_id FROM users WHERE email_address=?");
mysqli_stmt_bind_param($statement, "s", $email);
mysqli_stmt_execute($statement);
mysqli_stmt_bind_result($statement, $userID);
while (mysqli_stmt_fetch($statement))
  $userID;
mysqli_stmt_close($statement);
$statement = mysqli_prepare($mysqli, "INSERT INTO fav_recipes (User_id, recipe_id) VALUES ('".$userID."', '".$recipeID."')");
mysqli_stmt_execute($statement);

mysqli_stmt_close($statement);
mysqli_close($mysqli);

$response["success"] = true;
echo "$response";
?>
