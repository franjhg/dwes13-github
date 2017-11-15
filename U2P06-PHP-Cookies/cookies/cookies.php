<?php

    if(isset($_POST["enviar"])) {
    	setcookie("visitante", $_POST["nombre"], time() + (86400 * 15), "/"); // 86400 = segundos en 1 día
    	header("Location: ".$_SERVER['PHP_SELF']);
    }
    if(isset($_REQUEST["eliminarCookie"])){
        setcookie("visitante",null, time() -1, "/");
    }
    
    if(isset($_COOKIE["visitante"])) {
    	echo "<h2>Damos la bienvenida a $_COOKIE[visitante]</h2>";
    }
    else
    { // solicitar nombre al usuario
        
       
?>
<html>
<head>
<title>Cookies</title>
<meta charset="UTF-8"/>
</head>
<body>

    <form action="<?php echo $_SERVER['PHP_SELF']?>" method="post">
        <label>Escribe tu nombre para dirigirnos a ti:</label>
        <input type="text" name="nombre"><br/>
        <input type="submit" value="Enviar" name="enviar"><br>
        <input type="submit" value="EliminarCookie" name="eliminarCookie">
    </form>
<?php
    }
?>
<p><a href="<?php echo $_SERVER['PHP_SELF']?>">Enlace a esta misma página</a></p>
</body>
</html>
