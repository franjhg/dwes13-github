<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8"/>
</head>
<body>
<?php 
    if(!isset($_POST['Enviar'])){
?>
        <form action="ecf-recorte.php" method="post">
        	Cadena: <input type="text" name="cadena">
        	<input type="submit" name="Enviar">
        </form>
<?php
    }else {
        $cad=$_POST["cadena"];
        
        for($i=strlen($cad)-1;$i>=0;$i--){
            for($j=0;$j<=$i;$j++){
                echo $cad[$j];
            }
            echo "<br>";
        }
        
        
       /*  for($i=strlen($cad);$i>=0;$i--){
            echo substr($cad,0, $i);
            echo "<br>";
        } */
        
    }
?>
<a href="index.php">VOLVER</a>
</body>
</html>