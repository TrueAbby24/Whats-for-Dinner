<?php
  $id = $_GET["id"];
  // $id = 257193;
  $output = "";
  $args = '/opt/local/bin/java -cp .:./Main/json-simple-1.1.1.jar:./Main/jsoup-1.11.3.jar:./Main/unirest-java-1.4.9.jar \'-Dsun.security.pkcs11.enable-solaris=false\' Main/RecipeServer '.$id.' 2>&1';
  // echo "args: $args\n";
  echo exec($args, $output);
  // echo "\n\nsize output: ".sizeof($output);
?>
