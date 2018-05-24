<?php
  // echo "123456";
  // echo $_REQUEST["test"];
  $dbhost = "localhost";
  $dbuser = "root";
  $dbpass = "f565593aad3897ad";
  $con = mysqli_connect($dbhost, $dbuser, $dbpass);
  if(!$con) {
    die ('Could not connect: '.mysqli_connect_error());
  }
  mysqli_select_db($con,'test');
  $email = $_REQUEST['email'];
  $name = $_REQUEST['name'];
  $diet = $_REQUEST['dietReq'];

  echo "diet:(".$diet.")\n";
  $sql = "INSERT INTO users (email, name, dietReq) VALUES ('".$name."','".$email."','".$diet."')";
  echo $sql."\n";
  if(mysqli_query($con,$sql))
    echo "success";
  else
    echo "fail";
?>
