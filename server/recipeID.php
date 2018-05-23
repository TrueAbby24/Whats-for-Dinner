<?php
  // $id = $_GET["data"];
  $id = 257193;
  $html = file_get_contents("https://www.allrecipes.com/recipe/".$id);
  echo $html;
?>
