<?php
include ("datos.php");
 /* $error=false;
 $pass=false;
 $tel=false;
 $fecha=false;
 $mail=false; */ 


/*  if (isset($_POST['enviar']) && !validar_tel($_POST["telefono"])){
    $error=true;
    $tel=true;
 }else{
     $error=false;
     $tel=false;
} */


if (isset($_POST['enviar']) && !validar_pass($_POST["pass"])){
    $pass=true;
    $error=true;
}else{
    $error=false;
    $pass=false;
    
}


if (isset($_POST['enviar']) && !validar_fecha($_POST["fecha"])){
    $fecha=true;
    $error=true;
}else{
    $error=false;
    $fecha=false;
}
if (isset($_POST['enviar']) && !validar_email($_POST["email"])){
    $mail=true;
    $error=true;
}else{
    $error=false;
    $mail=false;
}
if(isset($_POST['enviar']) && !validar_tel($_POST["telefono"])){
    $tel=true;
    $error=true;
}else{
    $error=false;
    $tel=false;
}





if(!isset($_POST['enviar']) || $error==true){
    ?>
<div id="cuerpo">

<form action="<?php echo $_SERVER['PHP_SELF'];?>" method="post">
Nombre: <input type="text" name="nombre" value="nombre" required>
Apellidos: <input type="text" name="apellidos" value="apellidos" required> 
Contraseña: <input type="password" name="pass" value="contraseña" required>
		<?php 
		if( $pass){echo "la contraseña debe tener entre 7 y 15 caracteres alfanumericos,
        incluyendo una mayuscula";}
        ?>
Email: <input type="text" name="email" value="email" required>
	<?php 
	if($mail){echo "Ese campo no corresponde con un email";}
        ?>
Fecha: <input type="date" name="fecha" required>
	<?php 
	if($fecha){echo "Ese campo no corresponde con una fecha";}
        ?>

Direccion: <input type="text" name="direccion" value="direccion" required>
Telefono: <input type="text" name="telefono" value="telefono" required>
	<?php 
	if($tel){echo "Ese campo no corresponde con un telefono";}
        ?>
Ciclo: <select id="ciclos">
	<option value="ASIR" selected="selected">ASIR </option>
	<option value="DAW"> DAW </option>
	<option value="DAM"> DAM </option>
</select> 
<input type="submit" name="enviar">
</form>

</div>

<?php 


}else{
   


    if(!$error && isset($_POST["enviar"])){
        echo "Formulario enviado";
    }
}
   ?> 
          
    
