<?php

include('conexion.php');
   
   if(session_status()==PHP_SESSION_NONE){
       session_name('idSesion13');
       session_start ();
   }
   
   if(isset($_POST["enviar"])){
       $nombre=$_REQUEST["nombre"];
       $passw=$_REQUEST["passwd"];
   }
?>
	<div>
  		<form action="<?php echo $_SERVER['PHP_SELF'];?>" method="post">
		Nombre:<input type="text" name="nombre">
		Contraseña:<input type="text" name="passwd">
		<input type="submit" name="enviar">
	</form>
  	</div>     