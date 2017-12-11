<?php
include('conexion.php');

session_name('idSesion13');
session_start ();
if(isset($_SESSION["log"]) && $_SESSION["log"]==1){

    header("location:indice.php");
}
//if( $_SESSION["log"]==0){
 if(isset($_POST["enviar"])){
    // $_SESSION["nombre"]=$_POST["nombre"];
    // $_SESSION["contraseña"]=$_POST["contraseña"];
     $nombre=$_POST["nombre"];
     $contraseña=$_POST["contraseña"];
    // $contraEncript=password_hash($contraseña, PASSWORD_DEFAULT);
     //$resultado = $conexion -> query("SELECT * from usuario WHERE login='$nombre' AND password='$contraEncript'");
     $resultado = $conexion -> query("SELECT * from usuario WHERE login='$nombre'");
        if($resultado->num_rows === 0){ 
            echo "<p>No existe $nombre en la base de datos o no coincide la contraseña</p>";
            echo "<a href='login.php'>Volver a intentar o dar de alta nuevo usuario</a>";
           $_SESSION["log"]=0;
           //$_SESSION=array();
          
           
        }
        while ($usu = $resultado->fetch_assoc()) {
            
            /*if($usu["login"]==$nombre && $usu["password"]==$contraseña){*/
            $contraseñaEncriptada=$usu["password"];
            if($usu["login"]==$nombre && (password_verify($contraseña,$contraseñaEncriptada))){
                $_SESSION["log"]=1;
                $_SESSION["nombre"]=$nombre;
                $_SESSION["contraseña"]=$contraseña;
                $_SESSION["nombreCompleto"]=$usu[nombre];
                header("Location: indice.php");
            }//BORRAR LA VARIABLE $_SESSION
        }  
    mysqli_free_result($resultado);
   
}else{
?>

<html>
<head>
	<title>Login</title>
	<meta charset="UTF-8"/>
	<link rel="stylesheet" type="text/css" href="../css/estilos.css">
</head>
<body>
	<h3>Identificate para acceder</h3>
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
//}
?>