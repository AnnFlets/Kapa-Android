<?php

    include_once("conexion.php");

    $idCliente = $_GET['idCliente'];

    if(isset($idCliente)){
        $consulta = "SELECT * FROM cliente WHERE id_cliente = $idCliente";
        if(mysqli_query($connection,$consulta)){
            if(mysqli_num_rows(mysqli_query($connection,$consulta)) > 0){
            
                $registros = mysqli_fetch_array(mysqli_query($connection,$consulta));
                $retorno = array("cliente" => [$registros]);
                echo json_encode($retorno);
                mysqli_close($connection);
            }
            else{
                $retornoVacio = array("cliente"=>[["error"=>"0"]]);
                echo json_encode($retornoVacio);
                mysqli_close($connection);
            }
        }
        else{
            mysqli_close($connection);
            die("Error la consulta " . mysqli_connect_error());
        }
    }
    else{
        mysqli_close($connection);
        die("Error en la obtencion de la informacion del cliente");
    }

?>