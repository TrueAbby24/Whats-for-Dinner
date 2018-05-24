<?php
include 'error.php';
echo "yes bra </br>";
// $con = mysqli_connect("infs3202-5eab4a09.uqcloud.net","root","f565593aad3897ad");
$dbhost = "localhost";
$dbuser = "root";
$dbpass = "f565593aad3897ad";
$con = mysqli_connect($dbhost, $dbuser, $dbpass);
if(!$con) {
  die ('Could not connect: '.mysqli_connect_error());
}
echo "Connected successfully!</br>";

// Connect to db
mysqli_select_db($con,'test');

// fetching data
$sql = "SELECT email FROM users WHERE `name`='test'";
$result = mysqli_query($con, $sql);
if (mysqli_num_rows($result) > 0) {
  // while ($row = mysqli_fetch_assoc($result)){

    // echo "Email: ".$row["email"]."<br>";
  // }
  $email = mysqli_fetch_assoc($result)["email"];
} else {
  echo "0 results";
}

// the message
$msg = "First line of text\nSecond line of text";

// use wordwrap() if lines are longer than 70 characters
$msg = wordwrap($msg,70);
$headers = "From: a.breytenbach@uq.net.au";
// send email
if (mail("a.breytenbach@uq.net.au","My subject",$msg,$headers) ){
  echo "msg accepted :)";
} else {
  echo "error: msg !accepted";
}

mysqli_close($con);
 ?>
