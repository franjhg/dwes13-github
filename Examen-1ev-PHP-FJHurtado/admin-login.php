<?php
session_start ();


if(isset($_POST["enviar"])){
    $_SESSION["nombre"]=$_POST["nombre"];
    $nombre=$_POST["nombre"];
    $contraseña=$_POST["contraseña"];

    if($nombre=='admin' && $contraseña=='secreto'){
       echo "<p>Bienvenido a la sección de administración $nombre</p><br>";
       echo "<a href='admin-baja.php'>Dar de de baja temas</a><br>";
       echo "<a href='index.php?Cierra=Si'>Cerrar sesion</a><br>";
    } 
    
}else{
    echo "<a href='index.php?'>Cerrar sesion</a><br>";
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
  	
</body>
</html>
<?php 
}
//}
?>
