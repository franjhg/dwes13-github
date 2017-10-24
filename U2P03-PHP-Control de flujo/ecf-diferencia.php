<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8"/>
	
</head>
<body>
<?php
    if(!isset($_POST['Enviar'])){
?>
        <form action="ecf-diferencia.php" method="post">
        	Numero 1: <input type="number" name="Numero1">
        	Numero 2: <input type="number" name="Numero2">
        	<input type="submit" name="Enviar">
        </form>
<?php
    }else {
        if($_POST["Numero1"]<1||$_POST["Numero1"]>10||$_POST["Numero2"]<1||$_POST["Numero2"]>10){
            echo"Los valores deben estar comprendidos entre 1 y 10";
            die;
        }
        
       if($_POST["Numero1"]>$_POST["Numero2"]){
           $n1=$_POST["Numero1"];
           $n2=$_POST["Numero2"];
        }else{
           $n1=$_POST["Numero2"];
           $n2=$_POST["Numero1"];
       }
       $v=$n1-$n2;
       
       while($n1>$n2){
           echo"*";
          
           $n1--;
       }
       echo "<br>";
       for($i=1; $i<=$v;$i++){
           echo "#";
       }
       echo "<br>";
       
       
    }


    



?>
<a href="index.php">VOLVER</a>
</body>
</html>

