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

$statement = mysqli_prepare($mysqli, "SELECT email_address, password FROM users WHERE email_address=?");
mysqli_stmt_bind_param($statement, "s", $email);
mysqli_stmt_execute($statement);
mysqli_stmt_bind_result($statement, $name, $code);

$count = 0;
while (mysqli_stmt_fetch($statement)) {
    printf ("%s (%s)\n", $name, $code);
    $count++;
}
echo "stupid count ".mysqli_num_rows($result)."\n";
mysqli_stmt_close($statement);
// echo "res:".$result."\n";
if ($count > 0) {
  echo json_encode($response);
  exit();
 } else {
    $hashed_password = password_hash($password, PASSWORD_BCRYPT);
    echo $hashed_password."\n";
    $statement = mysqli_prepare($mysqli, "INSERT INTO users (email_address, password) VALUES (?, ?)");
    mysqli_stmt_bind_param($statement, "ss", $email, $hashed_password);
    mysqli_stmt_execute($statement);
    mysqli_stmt_close($statement);
 }
 $response["success"] = true;
 echo json_encode($response);


?>
