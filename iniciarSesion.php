<?php
    include 'conexion.php';

    $data = array("a" => "Apple", "b" => "Ball", "c" => "Cat");

    $sentencia = $conexion -> prepare("SELECT * FROM escobar_usuarios");
    $sentencia -> execute();

    $resultado = $sentencia -> get_result();
    if ($fila = $resultado -> fetch_assoc()) {
        echo json_encode($fila, JSON_UNESCAPED_UNICODE);
    }

    $sentencia -> close();
    $conexion -> close();

    header("Content-Type: application/json");
    echo json_encode($data);
?>