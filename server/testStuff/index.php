<?php
echo "kom ons kyk </br>";
$output = "";
// echo phpinfo();
$json = json_encode('{"type" : "RecipeID", "data": "257193"}');
echo "json: $json \n";
echo "soo iets:".json_decode($json)."\n\n";
$args = '/opt/local/bin/java -cp .:./Main/json-simple-1.1.1.jar:./Main/jsoup-1.11.3.jar:./Main/unirest-java-1.4.9.jar \'-Dsun.security.pkcs11.enable-solaris=false\' Main/Server '.$json.' 2>&1';
echo "args: $args\n";
echo exec($args, $output);//, &$returnval);
echo "\n\nsize output: ".sizeof($output);
// echo "</br></br>---OUTPUT:";
// foreach ($output as $value) {
//   echo "$value</br>";
// }
// echo "</br>KLAAR"

// echo $_GET["info"];
?>
