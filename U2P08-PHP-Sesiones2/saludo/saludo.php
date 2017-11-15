<?php
    if(session_status() == PHP_SESSION_NONE){
        session_name('idSaludo13');
        session_start ();
       
        if(isset($_POST['enviar'])){
            $_SESSION["nom"]=$_POST['nombre'];
        }
        $mensaje="Damos la bienvenida a ".$_SESSION["nom"];
    }
    
     if(!session_status() == PHP_SESSION_NONE){
        $_SESSION["nom"]="Antiguo";
        $mensaje="Damos la bienvenida a ".$_SESSION["nom"];
    } 
    
    
        
  
   
    
?>       
  	<div>
  		<form action="<?php echo $_SERVER['PHP_SELF'];?>" method="post">
		Nombre:<input type="text" name="nombre">
		<input type="submit" name="enviar">
	</form>
  	</div>      

	<html>
    <head>
    	<title>Sesiones</title>
    	<meta charset="UTF-8"/>
    </head>
    <body>
    	<h3><?php echo $mensaje;?></h3>
	</body>
	</html>
