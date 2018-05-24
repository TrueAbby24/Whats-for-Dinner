<?php
    require("password.php");
    $connect = mysqli_connect("https://infs3202-5eab4a09.uqcloud.net", "root", "f565593aad3897ad", "users");
    
    $email = $_POST["email"];
    $password = $_POST["password"];
     function registerUser() {
        global $connect, $email, $password;
        $hashed_password = password_hash($password, PASSWORD_DEFAULT);
        $statement = mysqli_prepare($connect, "INSERT INTO users (email_address, password) VALUES (?, ?)");
        mysqli_stmt_bind_param($statement, "ss", $email, $hashed_password);
        mysqli_stmt_execute($statement);
        mysqli_stmt_close($statement);     
    }
    function emailAvailable() {
        global $connect, $email;
        $statement = mysqli_prepare($connect, "SELECT * FROM user WHERE email_address = ?"); 
        mysqli_stmt_bind_param($statement, "s", $email);
        mysqli_stmt_execute($statement);
        mysqli_stmt_store_result($statement);
        $count = mysqli_stmt_num_rows($statement);
        mysqli_stmt_close($statement); 
        if ($count < 1){
            return true; 
        }else {
            return false; 
        }
    }
    $response = array();
    $response["success"] = false;  
    if (emailAvailable()){
        registerUser();
        $response["success"] = true;  
    }
    
    echo json_encode($response);
?>