<?php

    if(isset($_POST["enviar"])) {
        //--------"nombre_cookie"-"valor"-----------------"1dia*15"----"disponible para las aplicaciones de:"
    	setcookie("visitante", $_POST["nombre"], time() + (86400 * 15), "/U2P06-PHP-Cookies/cookies/"); // 86400 = segundos en 1 día
    	header("Location: ".$_SERVER['PHP_SELF']);//Recarga la pagina
    }                                       //   "/" Disponible para todas las aplicaciones
    if(isset($_REQUEST["eliminarCookie"])){
        setcookie("visitante",null, time() -1, "/");
    }
    
    setcookie("test", "test", time() + 3600, '/');
    if(count($_COOKIE) ==0) echo "<h3>Advertencia: tu navegador tiene las cookies deshabilitadas. Esta aplicación no funcionará</h3>";
    
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
