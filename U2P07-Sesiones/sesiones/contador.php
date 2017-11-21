<?php

//U2P07_2.4

if (session_status () == PHP_SESSION_NONE){
    session_name('idSesion13');
    session_start ();
    if (isset($_REQUEST["reiniciarContador"])) {
        unset($_SESSION["contador"]);
    }
    if (isset ( $_SESSION ['contador'] ))
        $_SESSION ['contador'] += 1;
        else
            $_SESSION ['contador'] = 1;
            $mensaje = "Has visitado esta página " . $_SESSION ['contador'] . " veces en esta sesión.";
}
?>
<html>
<head>
<title>Sesiones</title>
<meta charset="UTF-8"/>
</head>
<body>
<h3><?php echo $mensaje;?></h3>
<p><a href="<?php echo $_SERVER['PHP_SELF']?>">Recargar la página</a></p>

	<p><a href="<?php echo $_SERVER['PHP_SELF']."?reiniciarContador=true"?>">Reiniciar contador</a></p>

</body>
</html>
