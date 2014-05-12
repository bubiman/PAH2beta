<?php

$anfrage = $_GET["anfrage"];

echo utf8_encode (file_get_contents("https://redmine.piratenfraktion-nrw.de/".$anfrage));
?>