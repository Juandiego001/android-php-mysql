<?php
    $hostname = "localhost";
    $database = "biblioteca_escobar";
    $username = "root";
    $password = "root";

    $conexion = new mysqli($hostname, $username, $password, $database);

    if ($conexion -> connect_errno) {
        echo "El sitio web está experimientando problemas";
    }

?>