<?php
$terms = json_encode($_GET["terms"]);
// echo "terms: $terms</br>".is_null($terms)."</br>";

// if (is_null($terms)) {
// if ($terms === null) {
//   echo "NO SEARCH TERMS GIVEN";
// } else {
  $args = '/opt/local/bin/java -cp .:./Main/json-simple-1.1.1.jar:./Main/jsoup-1.11.3.jar:./Main/unirest-java-1.4.9.jar \'-Dsun.security.pkcs11.enable-solaris=false\' Main/SearchServer '.$terms.' 2>&1';
  $output = "";
  echo exec($args, $output);
  // echo "</br></br>---OUTPUT:";
  // foreach ($output as $value) {
  //   echo "$value</br>";
  // }
// }
?>
