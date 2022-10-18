<?php

    include_once("conexion.php");

    $idProducto = $_GET['idProducto'];
    $cantidad = $_GET['cantidadQuitar'];

    if(isset($idProducto))
    {
        

        $consulta = "UPDATE producto SET existencia_producto = (existencia_producto - $cantidad) WHERE id_producto= $idProducto";

        if(mysqli_query($connection,$consulta))
        {
            $retorno = array('resultado'=>'OK');
            echo json_encode($retorno);
            mysqli_close($connection);
        }
        else
        {
            mysqli_close($connection);
            die("Error en la actualizacion " . mysqli_connect_error());
        }

    }
    else
    {
        mysqli_close($connection);
        die("Error en la obtencion de la informacion del ciente");
    }

?>