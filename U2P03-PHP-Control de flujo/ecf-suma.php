<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8/">
</head>
<body>
<?php
    if(!isset($_POST['Enviar'])){
?>
        <form action="ecf-suma.php" method="post">
        	Numero: <input type="number" name="Numero">
        	<input type="submit" name="Enviar">
        </form>
<?php
    }else {
       $n=$_POST["Numero"];
       $acum=0;
	   for($i=1;$i<=$n;$i++){
	       $acum+=$i;
	   }
	   echo $acum;
    }

?>
  	<a href="index.php">VOLVER</a>  
</body>
</html>

