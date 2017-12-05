<?php
include('conexion.php');

session_name('idSesion13');
session_start ();
if(isset($_SESSION["nombre"])){
    header("location:indice.php");
}
 if(isset($_POST["enviar"])){
     $_SESSION["nombre"]=$_POST["nombre"];
     $_SESSION["contraseña"]=$_POST["contraseña"];
     $nombre=$_SESSION["nombre"];
     $contraseña=$_SESSION["contraseña"];

        $resultado = $conexion -> query("SELECT * from usuario WHERE login='$nombre'");
        if($resultado->num_rows === 0){ 
            echo "<p>No existe el usuario o la contraseña en la base de datos</p>";
            echo "<a href='login.php'>Volver a intentar</a>";
        }
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
  	<a href="alta.php">Dar de alta como usuario nuevo</a>
</body>
</html>
<?php 
}
?>