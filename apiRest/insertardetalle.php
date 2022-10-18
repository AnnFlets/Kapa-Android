<?php
    include_once("conexion.php");
    include_once("conexion1.php");
    //Declaracion de variables para manipular los datos a insertar
  
    $cantDeta = $_GET['cantidad'];
    $subDeta = $_GET['subtotal'];
    
    $idPro = $_GET['idProducto'];
    $consulta2 = "SELECT id_factura FROM factura ORDER BY id_factura DESC LIMIT 1";
    if(mysqli_query($connection1,$consulta2)){
        $idFac = mysqli_fetch_array(mysqli_query($connection1,$consulta2));
        mysqli_close($connection1);
        echo $idFac[0];
    }else{
        die("Error en el id " . mysqli_connect_error());
        mysqli_close($connection1);
    }

    //Validar que las claves poseean sus valores respectivos
    if(isset($cantDeta) && isset($subDeta) 
    && isset($idFac) && isset($idPro)){

    //Realizar la consulta para insertar los datos
    
    
    $consulta = "INSERT INTO detalle_factura (cantidad_detalle_factura, subtotal_detalle_factura, 
    id_factura_fk, id_producto_fk) VALUES ({$cantDeta}, {$subDeta}, 
    {$idFac[0]}, {$idPro})";

        if(mysqli_query($connection, $consulta)){
            $retorno = array('resultado'=>'OK');
            echo json_encode($retorno);
            mysqli_close($connection);
        }
        else{
            
            die("Error en la insercion " . mysqli_connect_error());
            mysqli_close($connection);
        }
  
    }
    else{
        mysqli_close($connection);
        die("Error en la obtencion de la informacion del ciente");
    }

?>