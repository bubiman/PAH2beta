<?php

$anfrage = $_GET["anfrage"];

echo $anfrage."/nl";

echo utf8_encode (file_get_contents($anfrage));
?>