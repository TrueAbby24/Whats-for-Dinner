<?php
    require("password.php");
    $con = mysqli_connect("https://infs3202-5eab4a09.uqcloud.net", "root", "f565593aad3897ad", "users");
    
    $email = $_POST["email"];
    $password = $_POST["password"];
    
    $statement = mysqli_prepare($con, "SELECT password FROM user WHERE email_address = ?");
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