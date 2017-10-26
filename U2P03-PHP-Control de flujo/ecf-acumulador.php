<!DOCTYPE html>
<html>
<head>
	<meta charset=UTF-8/>
</head>
<body>
<?php 
$acum=0;
if(!isset($_POST["Enviar"])){ 
      
    ?>
        <form action="ecf-acumulador.php" method="post">
        	Numero: <input type="number" name="numero">
        	<input type="hidden" name="oculto" value=<?php echo $acum; ?> >
        	<input type="submit" name="Enviar">
        </form>
        
<?php
  


    }else {
        $acum=$_POST["oculto"]+$_POST["numero"];
        if($acum<50){
        ?>
        <form action="ecf-acumulador.php" method="post">
        	Numero: <input type="number" name="numero">
        	 <?php 
        	$acum=$_POST["numero"]+$_POST["oculto"];
        	?> 
        	<input type="hidden" name="oculto" value=<?php echo $acum; ?> >
        	<input type="submit" name="Enviar">
        </form>
        
<?php
/*  echo $acum;
 echo "<br>";
 echo $_POST["oculto"];  */
    }else{
        echo "PASADO";
        }
    }
?>
	<a href="index.php">VOLVER</a>
</body>
</html>