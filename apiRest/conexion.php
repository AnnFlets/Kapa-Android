<?php
    //Creacion de la base de datos remota
    //Variables para la conexion 
    $host = "40.71.8.203";
    $username = "kapaad2022@grupo-kapa-2022.mysql.database.azure.com";
    $password = "kapa2022$$";
    $db = "dbkapa";
    $connection = mysqli_init();

    //Realizar la conexion 
    mysqli_real_connect($connection, $host, $username, $password, $db);
    mysqli_set_charset($connection, "utf8");

    //Prueba de la conexion
    if($connection){
        //echo "Conexion exitosa.... <br>";
    }else{
        die("Error de conexion". mysqli_connect_error());
    }




?>