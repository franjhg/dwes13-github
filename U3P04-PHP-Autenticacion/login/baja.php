<?php
include('conexion.php');

session_name('idSesion13');
session_start ();

if(isset($_POST["enviar"])){
    $_SESSION["nombre"]=$_POST["nombre"];
    $_SESSION["contraseña"]=$_POST["contraseña"];
       
    $nombre=$_SESSION["nombre"];
    $contraseña=$_SESSION["contraseña"];
   // $nombreCompleto=$_SESSION["nomCompleto"];
    
    $resultado = $conexion -> query("SELECT * from usuario WHERE login='$nombre'");
    if($resultado->num_rows === 0 ){
        echo  "<p>No esta</p>";
    }else{
        //-------------PERMISO PARA BAJA-->SOLO ADMIN
        $usu = $resultado->fetch_assoc();
        if($usu["admin"]==0){
            echo  "<p>Este usuario no es administrador</p><br>";
            echo "<a href='indice.php'>Volver</a>";
        }else{
        
        //----------------
        $servidor = "localhost";
        $usuario = "alumno_rw";
        $clave = "dwes";
        $conexion = new mysqli($servidor,$usuario,$clave,"catalogo13");
        $conexion->query("SET NAMES 'UTF8'");
        if ($conexion->connect_errno) {
            echo "<p>Error al establecer la conexión (" . $conexion->connect_errno . ") " . $conexion->connect_error . "</p>";
        }
        
       
        $conexion->query("DELETE FROM usuario WHERE login='$nombre'");
        
        
        
        header('location:logout.php');
    }
    }
    
}else{
    
    
    ?>

<html>
<head>
	<title>Baja</title>
	<meta charset="UTF-8"/>
</head>
<body>
	<h3>Va a proceder a da de baja a:</h3>
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
