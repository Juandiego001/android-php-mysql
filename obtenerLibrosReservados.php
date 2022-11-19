<?php
    include 'conexion.php';

    $usuario = $_GET["usuario"];
    
    header("Content-Type: application/json");
    $arreglo_json = array();

    $sentencia = $conexion -> prepare("SELECT ell.nombre, ell.autor, ell.resumen FROM escobar_libros_reservados AS elr JOIN escobar_libros_infantiles AS ell ON elr.id_libro = ell.id_libro WHERE elr.categoria = 1 AND elr.usuario = ?");
    $sentencia -> bind_param('s', $usuario);
    $sentencia -> execute();
    $resultado = $sentencia -> get_result();
    if ($resultado != null) {
        while($row = $resultado -> fetch_assoc()) {
            array_push($arreglo_json, $row);
        }    
    }

    $sentencia = $conexion -> prepare("SELECT ell.nombre, ell.autor, ell.resumen FROM escobar_libros_reservados AS elr JOIN escobar_libros_superacion_personal AS ell ON elr.id_libro = ell.id_libro WHERE elr.categoria = 2 AND elr.usuario = ?");
    $sentencia -> bind_param('s', $usuario);
    $sentencia -> execute();
    $resultado = $sentencia -> get_result();
    if ($resultado != null) {
        while($row = $resultado -> fetch_assoc()) {
            array_push($arreglo_json, $row);
        }    
    }

    $sentencia = $conexion -> prepare("SELECT ell.nombre, ell.autor, ell.resumen FROM escobar_libros_reservados AS elr JOIN escobar_libros_cientificos AS ell ON elr.id_libro = ell.id_libro WHERE elr.categoria = 3 AND elr.usuario = ?");
    $sentencia -> bind_param('s', $usuario);
    $sentencia -> execute();
    $resultado = $sentencia -> get_result();
    if ($resultado != null) {
        while($row = $resultado -> fetch_assoc()) {
            array_push($arreglo_json, $row);
        }    
    }

    $sentencia = $conexion -> prepare("SELECT ell.nombre, ell.autor, ell.resumen FROM escobar_libros_reservados AS elr JOIN escobar_libros_literatura AS ell ON elr.id_libro = ell.id_libro WHERE elr.categoria = 4 AND elr.usuario = ?");
    $sentencia -> bind_param('s', $usuario);
    $sentencia -> execute();
    $resultado = $sentencia -> get_result();
    if ($resultado != null) {
        while($row = $resultado -> fetch_assoc()) {
            array_push($arreglo_json, $row);
        }    
    }

    $sentencia = $conexion -> prepare("SELECT ell.nombre, ell.autor, ell.resumen FROM escobar_libros_reservados AS elr JOIN escobar_libros_colecciones AS ell ON elr.id_libro = ell.id_libro WHERE elr.categoria = 5 AND elr.usuario = ?");
    $sentencia -> bind_param('s', $usuario);
    $sentencia -> execute();
    $resultado = $sentencia -> get_result();
    if ($resultado != null) {
        while($row = $resultado -> fetch_assoc()) {
            array_push($arreglo_json, $row);
        }    
    }

    $sentencia = $conexion -> prepare("SELECT ell.nombre, ell.autor, ell.resumen FROM escobar_libros_reservados AS elr JOIN escobar_libros_ebook AS ell ON elr.id_libro = ell.id_libro WHERE elr.categoria = 6 AND elr.usuario = ?");
    $sentencia -> bind_param('s', $usuario);
    $sentencia -> execute();
    $resultado = $sentencia -> get_result();
    if ($resultado != null) {
        while($row = $resultado -> fetch_assoc()) {
            array_push($arreglo_json, $row);
        }    
    }
    
    echo json_encode(array(
        "code" => 200,
        "message" => sprintf("Libros del usuario %s obtenidos con exito", $usuario),
        "data" => $arreglo_json
        )
    );

    $sentencia -> close();
    $conexion -> close();
?>