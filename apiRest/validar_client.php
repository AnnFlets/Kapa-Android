<?php

include_once("conexion.php");
$user=$_POST['usuario'];
$pass=$_POST['password'];

//$user="Karen";
//$pass="123";

$consulta = "SELECT * FROM cliente WHERE usuario_cliente='" . $user . "' AND contrasenia_cliente= '" . $pass . "'";
$resultado = mysqli_query($connection,$consulta);

if(mysqli_query($connection,$consulta))
{
    if(mysqli_num_rows(mysqli_query($connection,$consulta))>0)
    {
        
       echo "ok"; 
            mysqli_close($connection);

    }
    else 
        {
            
			echo "";
            mysqli_close($connection);
 
        }

}
else 
{
    mysqli_close($connection);
    die("Error en la consulta" . mysqli_connect_error());

}

?>