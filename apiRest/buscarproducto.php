<?php
include_once("conexion.php");

$idProducto = $_GET["id_producto"];
if(isset($idProducto)) {



}
else{
        mysqli_close($conexion);
        die("Error en la obtención de la información del producto");
}


?>