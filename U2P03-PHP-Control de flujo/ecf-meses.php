<html>
<head>
	<meta charset="UTF-8"/>
</head>
<body>
<?php 
    if(!isset($_POST['Enviar'])){
?>
        <form action="ecf-meses.php" method="post">
        	Mes: <input type="text" name="mes">
        	Bisiesto: <input type="radio" name="bisiesto" value="bisiesto" > 
        	No Bisiesto: <input type="radio" name="bisiesto" value="no bisiesto" checked>
        	<input type="submit" name="Enviar">
        </form>
<?php
    }else {
        $mes=$_POST["mes"];
        $bis=$_POST["bisiesto"]; 
        $arraymes31=array("1","enero","3","marzo","5","mayo","7"."julio","8",
            "agosto","10","octubre","12","diciembre");
        $arraymes30=array("4","abril","6","junio","9","septiembre","11","noviembre");
        $sw31=false;
        $sw30=false;
        
        
        
        
        if(strcasecmp($bis, "bisiesto")==0 && (strcasecmp($mes, "2")==0||strcasecmp($mes, "febrero")==0)){
            echo "El mes ".$mes." tiene 29 dias";
        }
        if(strcasecmp($bis, "no bisiesto")==0 && (strcasecmp($mes, "2")!=0||strcasecmp($mes, "febrero")!=0)){
            echo "El mes ".$mes." tiene 28dias";
        }  
        for($i=0;$i<=sizeof($arraymes31)-1;$i++){
            if(strcasecmp($mes, $arraymes31[$i])==0){
                $sw31=true;
            }
        }
        for($i=0;$i<=sizeof($arraymes30)-1;$i++){
            if(strcasecmp($mes, $arraymes30[$i])==0){
                $sw30=true;
            }
        }
        
        if($sw31==true){
            echo "El mes ".$mes." tiene 31 dias";
        }
        if($sw30==true){
            echo "El mes ".$mes." tiene 30 dias";
        }
       
    }
?>
<a href="index.php">VOLVER</a>
</body>
</html>