<?php
include('conexion.php');


/*  session_name('idSesion13');
 session_start (); */
  
 if(session_status()==PHP_SESSION_NONE){
    session_name('idSesion13');
    session_start ();
}else{
    header("location:indice.php");
}

 if(isset($_POST["enviar"])){
     $_SESSION["nombre"]=$_POST["nombre"];
     $_SESSION["contraseña"]=$_POST["contraseña"];
     $nombre=$_SESSION["nombre"];
     $contraseña=$_SESSION["contraseña"];

        $resultado = $conexion -> query("SELECT * from usuario WHERE login='$nombre'");
        if($resultado->num_rows === 0) echo "<p>No existe el usuario o la contraseña en la base de datos</p>";
        while ($usu = $resultado->fetch_assoc()) {
            
            if($usu["login"]==$contraseña){
                header("Location: indice.php");
            }
        }  
    mysqli_free_result($resultado);
}else{
?>

<html>
<head>
	<title>Login</title>
	<meta charset="UTF-8"/>
</head>
<body>
	<div>
  		<form action="<?php echo $_SERVER['PHP_SELF'];?>" method="post">
		Nombre:<input type="text" name="nombre">
		Contraseña:<input type="text" name="contraseña">
		<input type="submit" name="enviar">
		</form>
  	</div>  
</body>
</html>
<?php 
}
?>