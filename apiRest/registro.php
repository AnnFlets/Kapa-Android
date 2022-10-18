<?php
    //Incluir la clase de conexion
    include_once("conexion.php");


    //Declaración de variables
    $usuCliente = $_GET['usuarioCliente'];
    $contraCliente = $_GET['contraseniaCliente'];
    $nomCliente = $_GET['nombreCliente'];
    $apeCliente = $_GET['apellidoCliente'];
    $nitCliente = $_GET['nitCliente'];
    $direcCliente = $_GET['direccionCliente'];
    $telCliente = $_GET['telefonoCliente'];
    $correoCliente = $_GET['correoCliente'];


    if(isset($usuCliente) && isset($contraCliente)
    && isset($nomCliente) && isset($apeCliente)
    && isset($nitCliente) && isset($direcCliente)
    && isset($telCliente) && isset($correoCliente)){

        //Consulta de inserción
        $consulta = "INSERT INTO cliente (usuario_cliente, contrasenia_cliente, nombre_cliente, 
        apellido_cliente, nit_cliente, direccion_cliente, telefono_cliente, correo_cliente) 
        VALUES ('{$usuCliente}', '{$contraCliente}', '{$nomCliente}', '{$apeCliente}', 
        '{$nitCliente}', '{$direcCliente}', '{$telCliente}', '{$correoCliente}')";

        if(mysqli_query($connection, $consulta)){
            mysqli_close($connection);
            die("Datos insertados correctamente");
            

        }else {
            die("Error en la insercion " . mysqli_connect_error());
            mysqli_close($connection);
        }



    }else{
        die("Error en la obtención de la informacion del cliente ");
        mysqli_close($connection);
    }



?>