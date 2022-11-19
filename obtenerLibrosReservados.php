<?php
    include 'conexion.php';

    $usuario = $_GET["usuario"];
    $sentencia = $conexion -> prepare("(SELECT * FROM escobar_libros_cientificos WHERE id_libro = (SELECT id_libro FROM escobar_libros_reservados WHERE usuario = ?) AND (SELECT categoria FROM escobar_libros_reservados WHERE usuario = ?) = 3) UNION (SELECT * FROM escobar_libros_colecciones WHERE id_libro = (SELECT id_libro FROM escobar_libros_reservados WHERE usuario = ?) AND (SELECT categoria FROM escobar_libros_reservados WHERE usuario = ?) = 5) UNION (SELECT * FROM escobar_libros_ebook WHERE id_libro = (SELECT id_libro FROM escobar_libros_reservados WHERE usuario = ?) AND (SELECT categoria FROM escobar_libros_reservados WHERE usuario = ?) = 6) UNION (SELECT * FROM escobar_libros_infantiles WHERE id_libro = (SELECT id_libro FROM escobar_libros_reservados WHERE usuario = ?) AND (SELECT categoria FROM escobar_libros_reservados WHERE usuario = ?) = 1) UNION (SELECT * FROM escobar_libros_literatura WHERE id_libro = (SELECT id_libro FROM escobar_libros_reservados WHERE usuario = ?) AND (SELECT categoria FROM escobar_libros_reservados WHERE usuario = ?) = 4) UNION (SELECT * FROM escobar_libros_superacion_personal WHERE id_libro = (SELECT id_libro FROM escobar_libros_reservados WHERE usuario = ?) AND (SELECT categoria FROM escobar_libros_reservados WHERE usuario = ?) = 2)");
    $sentencia -> bind_param('ssssssssssss', $usuario, $usuario, $usuario, $usuario, $usuario, $usuario, $usuario, $usuario, $usuario, $usuario, $usuario, $usuario);
    $sentencia -> execute();
    
    header("Content-Type: application/json");
    $resultado = $sentencia -> get_result();
    $contador = 0;
    $arreglo_json = array();
    if ($resultado != null) {
        while($row = $resultado -> fetch_assoc()) {
            array_push($arreglo_json, $row);
            $contador = $contador + 1;
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