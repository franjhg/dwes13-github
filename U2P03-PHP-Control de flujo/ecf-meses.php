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
        	Bisiesto: <input type="checkbox" value="bisiesto">
        	<input type="submit" name="Enviar">
        </form>
<?php
    }else {
        $mes=$_POST["mes"];
        $bis=$_POST
        
    }
?>
<a href="index.php">VOLVER</a>
</body>
</html>