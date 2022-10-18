<?php

include_once("conexion.php");

$consulta = "SELECT * FROM factura";
$resultado = mysqli_query($connection,$consulta);

if(mysqli_query($connection,$consulta))
{
    if(mysqli_num_rows(mysqli_query($connection,$consulta))>0)
    {
        
        while ($registros = mysqli_fetch_array($resultado))
        {
            $retorno["factura"][] = $registros;
        }
        
        echo json_encode($retorno);
        mysqli_close($connection);

    }
    else 
        {
            $retornoVacio = array("factura"=>[["error"=>"0"]]);
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