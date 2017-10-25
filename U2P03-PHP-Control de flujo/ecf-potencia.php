<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8"/>
</head>
<body>
<?php 
if(!isset($_POST['Enviar'])){
    ?>
        <form action="ecf-potencia.php" method="post">
        	Base: <input type="number" name="base">
        	Exponente: <input type="number" name="exponente">
        	<input type="submit" name="Enviar">
        </form>
<?php
    }else {
        $e=$_POST["exponente"];
        $b=$_POST["base"];
        $r=1;
        
        for($i=1;$i<=$e;$i++){
            $r*=$b;
        }
        echo $r;
        
        
    }
?>
<a href="index.php">VOLVER</a>


</body>
</html>

