<?php
    include_once("conexion.php");

    //Declaracion de variables para manipular los datos a insertar
    $numFac = $_GET['numero'];
    $serieFac = $_GET['serie'];
    $fechaFac = $_GET['fecha'];
    $fechaMask = date("Y/m/d",strtotime($fechaFac));
    $totalFac = $_GET['total'];
    $tipoFac = $_GET['tipoPago'];
    $estFac = $_GET['estado'];
    $idCliFac = $_GET['idCliente'];

    //Validar que las claves poseean sus valores respectivos
    if(isset($numFac) && isset($serieFac) 
    && isset($fechaFac) && isset($totalFac)
    && isset($tipoFac) && isset($estFac)
    && isset($idCliFac)){

    //Realizar la consulta para insertar los datos
    $consulta = "INSERT INTO factura (numero_factura, serie_factura, fecha_factura,
    total_factura, tipo_pago_factura, estado_factura, id_cliente_fk) VALUES ({$numFac}, '{$serieFac}', 
    '{$fechaMask}', {$totalFac}, '{$tipoFac}', '{$estFac}', {$idCliFac})";
        if(mysqli_query($connection, $consulta)){
            $retorno = array('resultado'=>'OK');
            echo json_encode($retorno);
            mysqli_close($connection);
        }
        else{
            mysqli_close($connection);
            die("Error en la Insercion " . mysqli_connect_error());
        }
  
    }
    else{
        mysqli_close($connection);
        die("Error en la obtencion de la informacion del ciente");
    }

?>