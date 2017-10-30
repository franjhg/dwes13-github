<!DOCTYPE html>

<html>
<head>
	<meta charset="UTF-8"/>
	
</head>
<body>

	<?php 
	#include ("Rectangulo.php");
	   if(!isset($_POST["enviar"])){
	?>
		<form action="formulario.php" method="post">
		Base: <input type="number" name="base">
		Altura: <input type="number" name="altura">
		<input type="submit" name="enviar">
		</form>
	<?php 
	   }else{
	       $r1=new Rectangulo($_POST["base"], $_POST["altura"]);
	       echo "<p>".$r1->calcularArea()."</p>";
	   }
	?>
</body>
</html>

