<?php
    include 'conexion.php';

    $usuario = $_GET["usuario"];
    $contrasena = $_GET["contrasena"];

    $sentencia = $conexion -> prepare("SELECT * FROM escobar_usuarios WHERE usuario = ? AND contrasena = ?");
    $sentencia -> bind_param('ss', $usuario, $contrasena);
    $sentencia -> execute();

    header("Content-Type: application/json");

    $resultado = $sentencia -> get_result();
    if ($fila = $resultado -> fetch_assoc()) {
        echo json_encode($fila, JSON_UNESCAPED_UNICODE);
    } else {
        echo json_encode(false);
    }

    $sentencia -> close();
    $conexion -> close();
?>