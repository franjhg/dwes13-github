<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8"/>
</head>
<body>
	<?php 
if(!isset($_POST['Enviar'])){
    ?>
        <form action="ecf-factorial.php" method="post">
        	Numero: <input type="number" name="numero">
        	<input type="submit" name="Enviar">
        </form>
<?php
    }else {
        $res=1;
        $n=$_POST["numero"];
        for($i=$n;$i>=2;$i--){
            $res*=$i;
        }
        echo $res;
    }
?>
<a href="index.php">VOLVER</a>
</body>

</html>

