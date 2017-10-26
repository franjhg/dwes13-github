<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8"/>
</head>
<body>
	<?php 
	$cont3=1;
	$cont5=1;
	for($i=1;$i<=1000;$i++){
	    if($i%3==0){
	        
	        echo $i." es múltiplo de 3";
	        echo "<br>";
	    }
	    if($i%5==0){
	        echo $i." es múltiplo de 5";
	        echo "<br>";
	    }
	}
	?>
	<h3>Los 20 primeros múltiplos de 3:</h3>
	<?php 
	$j=3;
	$k=5;
	while($cont3<=20){
	    if($j%3==0){    
	       $cont3++;
	       
	        echo $j." es múltiplo de 3";
	        echo "<br>";
	    }    
	        $j++;
	}
	?>
	<h3>Los 20 primeros múltiplos de 3:</h3>
	<?php 
	while($cont5<=20){
	    if($k%5==0){
	    $cont5++;	    
	    echo $k." es múltiplo de 5";
	    echo "<br>";
	    }
	    $k++;
	}
	 ?>
	    
<a href="index.php">VOLVER</a>
</body>
</html>


