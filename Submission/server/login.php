<?php
    include("password.php");
    $dbhost = "localhost";
    $dbuser = "root";
    $dbpass = "f565593aad3897ad";
    $db = "wfd_db";
    $con = new mysqli($dbhost, $dbuser, $dbpass, $db);

    $email = $_POST["email"];
    $password = $_POST["password"];

    $statement = mysqli_prepare($con, "SELECT password FROM users WHERE email_address = ?");
    mysqli_stmt_bind_param($statement, "s", $email);
    mysqli_stmt_execute($statement);
    mysqli_stmt_store_result($statement);
    mysqli_stmt_bind_result($statement,$colPassword);

    $response = array();
    $response["success"] = false;

    while(mysqli_stmt_fetch($statement)){
        if (password_verify($password, $colPassword)) {
            $response["success"] = true;
        }
    }
    echo json_encode($response);
?>
