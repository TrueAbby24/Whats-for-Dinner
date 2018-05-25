<?php
    include("password.php");
    $dbhost = "localhost";
    $dbuser = "root";
    $dbpass = "f565593aad3897ad";
    $con = mysqli_connect($dbhost, $dbuser, $dbpass,'wfd_db');

    echo "string\n";
    $email = $_REQUEST["email"];
    $password = $_REQUEST["password"];
    // echo "password: ".$password;
    // echo "\nemail: ".$email."\n";

    // $sql = "INSERT INTO users (email_address, password) VALUES ('".$email."','".$password."')";
    // echo $sql."\n";
    // if(mysqli_query($con,$sql))
    //   echo "success";
    // else
    //   echo "fail";

    $statement = $mysqli->prepare($con, "SELECT * FROM user WHERE email_address = '?'");
    if ($statement == false)
      echo "false\n";
    else
      echo "true\n";
    mysqli_stmt_bind_param($statement, "s", $email);
    echo "2:".$statement."\n";
    mysqli_stmt_execute($statement);
    echo "3:".$statement."\n";
    mysqli_stmt_store_result($statement);
    echo "4:".$statement."\n";
    $count = mysqli_stmt_num_rows($statement);
    mysqli_stmt_close($statement);
    if ($count < 1){
        return true;
    }else {
        return false;
    }
    // function registerUser() {
    //     global $connect, $email, $password;
    //     $hashed_password = password_hash($password, PASSWORD_DEFAULT);
    //     $statement = mysqli_prepare($connect, "INSERT INTO users (email_address, password) VALUES (?, ?)");
    //     mysqli_stmt_bind_param($statement, "ss", $email, $hashed_password);
    //     mysqli_stmt_execute($statement);
    //     mysqli_stmt_close($statement);
    // }
    // function emailAvailable() {
    //     global $connect;//, $email;
    //     $connect = $con;
    //     $statement = mysqli_prepare($connect, "SELECT * FROM user WHERE email_address = ?");
    //     echo "1:".$statement."\n";
    //     mysqli_stmt_bind_param($statement, "s", $email);
    //     echo "2:".$statement."\n";
    //     mysqli_stmt_execute($statement);
    //     echo "3:".$statement."\n";
    //     mysqli_stmt_store_result($statement);
    //     echo "4:".$statement."\n";
    //     $count = mysqli_stmt_num_rows($statement);
    //     mysqli_stmt_close($statement);
    //     if ($count < 1){
    //         return true;
    //     }else {
    //         return false;
    //     }
    // }
    // $response = array();
    // $response["success"] = false;
    // if (emailAvailable()){
    //     registerUser();
    //     $response["success"] = true;
    // }

    // echo json_encode($response);
?>
