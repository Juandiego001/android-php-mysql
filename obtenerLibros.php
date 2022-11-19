<?php
    include 'conexion.php';

    $tipo = $_GET["tipo"];
    $sentencia = $conexion -> prepare(sprintf("SELECT * FROM escobar_libros_%s", $tipo));
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
        "message" => sprintf("Libros de la tabla %s obtenidos con exito", $tipo),
        "data" => $arreglo_json
        )
    );


    $sentencia -> close();
    $conexion -> close();
?>