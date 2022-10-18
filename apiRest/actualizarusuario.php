<?php

    include_once("conexion.php");

    $idCliente = $_GET['idCliente'];

    if(isset($idCliente))
    {
        $direccionCliente = $_GET['direccionCliente'];
        $telefonoCliente = $_GET['telefonoCliente'];
        $correoCliente = $_GET['correoCliente'];

        $consulta = "UPDATE cliente SET direccion_cliente='$direccionCliente', telefono_cliente='$telefonoCliente', 
        correo_cliente='$correoCliente' WHERE id_cliente=$idCliente";

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