<?php
$dbhost = "localhost";
$dbuser = "root";
$dbpass = "f565593aad3897ad";
$db = "wfd_db";
echo "ne\n";
$mysqli = new mysqli($dbhost, $dbuser, $dbpass, $db);

// check con
if (mysqli_connect_errno()) {
    printf("Connect failed: %s\n", mysqli_connect_error());
    exit();
}


$email = $_REQUEST["email"];
$password = $_REQUEST["password"];

// /* create a prepared statement */
// if ($stmt = $mysqli->prepare("SELECT * FROM user WHERE email_address = '?'")) {
//
//     /* bind parameters for markers */
//     $stmt->bind_param("s", $email);
//
//     /* execute query */
//     $stmt->execute();
//
//     /* bind result variables */
//     $stmt->store_result();
//
//     /* fetch value */
//     // $stmt->fetch();
//
//     // printf("%s 's password is %s\n", $email, $password);
//     $count = $stmt->num_rows();
//     echo "s".$count;
//     /* close statement */
//     $stmt->close();
// }

// /* close connection */
// $mysqli->close();
echo "1 \n";
$statement = mysqli_prepare($mysqli, "SELECT email_address, password FROM users WHERE email_address=?");

mysqli_stmt_bind_param($statement, "s", $email);
mysqli_stmt_execute($statement);
// mysqli_stmt_store_result($statement);
// $result = mysqli_stmt_result_metadata($statement);
/* bind result variables */
    mysqli_stmt_bind_result($statement, $name, $code);

    /* fetch values */
    $count = 0;
    while (mysqli_stmt_fetch($statement)) {
        printf ("%s (%s)\n", $name, $code);
        $count++;
    }
echo mysqli_num_rows($result)."\n";
// echo "res:".$result."\n";
if ($count > 0) {
  echo "found it";
  // $field = mysqli_fetch_field($result);
  // echo $field->name."\n";
  // $field = mysqli_fetch_field($result);
  // echo $field->name."\n";
  // $field = mysqli_fetch_field($result);
  // echo $field->name."\n";
  // $field = mysqli_fetch_field($result);
  // echo $field->name."\n";
    // while($row = mysqli_fetch_assoc($result)) {
    //    echo "Info: " . $row["email_address"]. "& ".$row['User_id']."\n";
    // }
 } else {
    echo "0 results";
 }



    // $statement = mysqli_prepare($mysqli, "SELECT * FROM users WHERE email_address = ?");
    // echo "1:".$statement."\n";
    // mysqli_stmt_bind_param($statement, "s", $email);
    // echo "2:".$statement."\n";
    // if (!mysqli_stmt_execute($statement))
    //   echo "no ";
    // echo "exec\n";
    // // echo "3:".$statement."\n";
    // mysqli_stmt_store_result($statement);
    // $result = mysqli_stmt_result_metadata();
    // echo "res: ".$result."\n";
    // // echo "4:".$statement."\n";
    //
    // if (mysqli_num_rows($result) > 0) {
    //     while($row = mysqli_fetch_assoc($result)) {
    //        echo "Name: " . $row["name"]. "<br>";
    //     }
    //  } else {
    //     echo "0 results";
    //  }
    //
    // $count = mysqli_stmt_num_rows($statement);
    // echo "count:".$count."\n";
    // mysqli_stmt_close($statement);
    // if ($count < 1){
      // insert
      // $hashed_password = password_hash($password, PASSWORD_BCRYPT);
      // echo $hashed_password."\n";
      // $statement = mysqli_prepare($mysqli, "INSERT INTO users (email_address, password) VALUES (?, ?)");
      // mysqli_stmt_bind_param($statement, "ss", $email, $hashed_password);
      // mysqli_stmt_execute($statement);
      // mysqli_stmt_close($statement);
    // } else {
    //   // dont insert
    //   echo "no";
    // }
?>
