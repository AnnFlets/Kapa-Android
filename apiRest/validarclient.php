<?php
include_once ("conexion.php";
//$user=$POST['usuario'];
//$pass=$POST['password'];

$user= "Pao";
$pass= "123456";

$validar=$conexion->prepare("SELECT * FROM cliente WHERE user=? AND pass=?");
$validar->bind_param('ss',$user,$pass);
$validar->execute();

$resultado=$validar->get_result();
if ($fila = $resultado->fetch_assoc()){
	echo json_encode ($fila,JSON_UNESCAPED_UNICODE);
}
$validar->close();
$conexion->close();
?>

