<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8"/>
</head>
<body>
<?php 
    if(!isset($_POST['Enviar'])){
?>
        <form action="ecf-multiplicacion.php" method="post">
        	Numero: <input type="number" name="numero">
        	<input type="submit" name="Enviar">
        </form>
<?php
    }else {
        $n=$_POST["numero"];
        $r=0;
    
        
        for($i=1;$i<=10;$i++){
            $r=$i*$n;
            echo $n. "*".$i."=".$r;
            echo "<br>";
        } 
    }
?>
<a href="index.php">VOLVER</a>
</body>
</html>
