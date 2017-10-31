<!DOCTYPE html>

<html>
<head>
	<meta charset="UTF-8"/>
	
</head>
<body>

	<?php 
	include ("Rectangulo.php");
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
	       $r2=$r1;
	       echo "<p>El area de un rectangulo con base=".$_POST["base"]."
                 y altura=".$_POST["altura"]." es: ".$r1->calcularArea()."</p>";
	       echo "<p>El perímetro es: ".$r1->calcularPerimetro()."</p>";
	       echo "<h3>Su color es ".$r1->getColor()."</h3>";
	       echo $r1->imprimeForeach()."<br>";
	       echo $r2->imprimeForeach();
	      
	   }
	?>
</body>
</html>

