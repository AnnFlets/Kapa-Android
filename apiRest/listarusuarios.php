<?php

include_once("conexion.php");

$consulta = "SELECT id_cliente, usuario_cliente, contrasenia_cliente  FROM cliente";
$resultado = mysqli_query($connection,$consulta);

if(mysqli_query($connection,$consulta))
{
    if(mysqli_num_rows(mysqli_query($connection,$consulta))>0)
    {
        
        while ($registros = mysqli_fetch_array($resultado))
        {
            $retorno["cliente"][] = $registros;
        }
        
        echo json_encode($retorno);
        mysqli_close($connection);

    }
    else 
        {
            $retornoVacio = array("cliente"=>[["error"=>"0"]]);
            echo json_encode($retornoVacio);
            mysqli_close($connection);
 
        }

}
else 
{
    mysqli_close($connection);
    die("Error en la consulta" . mysqli_connect_error());

}

?>