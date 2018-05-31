<?php
$dbhost = "localhost";
$dbuser = "root";
$dbpass = "f565593aad3897ad";
$db = "wfd_db";
$mysqli = new mysqli($dbhost, $dbuser, $dbpass, $db);
if (mysqli_connect_errno()) {
  echo "[]";
  exit();
}

$email = $_REQUEST["email"];
$af_table = $_REQUEST["type"];

$statement = mysqli_prepare($mysqli, "SELECT User_id FROM users WHERE email_address=?");
mysqli_stmt_bind_param($statement, "s", $email);
mysqli_stmt_execute($statement);
mysqli_stmt_bind_result($statement, $userID);
while (mysqli_stmt_fetch($statement))
  $userID;
mysqli_stmt_close($statement);
if ($af_table == "fav_recipes") {
  $statement = mysqli_prepare($mysqli, "SELECT recipe_id FROM fav_recipes WHERE User_id='".$userID."'");
} else if ($af_table == "allergies") {
  $statement = mysqli_prepare($mysqli, "SELECT allergen FROM allergies WHERE User_id='".$userID."'");
} else {
  echo "[]";
  exit();
}

mysqli_stmt_execute($statement);
$result = "";
$count = 0;
mysqli_stmt_bind_result($statement, $data);
while (mysqli_stmt_fetch($statement)) {
  if ($count == 0)
    $result = "\"".$data."\"";
  else
    $result = $result.",\"".$data."\"";
  $count++;
}

echo "[".$result."]";
mysqli_stmt_close($statement);
mysqli_close($mysqli);
?>
