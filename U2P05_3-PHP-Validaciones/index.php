<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8"/>
	<title>Validación de formulario</title>
	<?php include ("validaciones.php");?>
</head>
<body>
<?php 

    if(isset($_POST["enviar"])){
//  PASAMOS LOS DATOS RECOGIDOS EN EL FORMULARIO A VARIABLES
        $email=$_POST["email"];
        $fecha=$_POST["fecha"];
        $password=$_POST["password"];
        $nombre=$_POST["nombre"];
        $apellidos=$_POST["apellidos"];
        $telefono=$_POST["telefono"];
        $direccion=$_POST["direccion"];
        $ciclo=$_POST["ciclo"];

//EJECUTAMOS LAS FUNCIONES
        $errEmail=validarEmail($email);
        $errFecha=validarFecha($fecha);
        $errPass=validarContraseña($password);
        $errNombre=validarNombre($nombre);
        $errApellido=validarApellidos($apellidos);
        $errTel=validarTelefono($telefono);
        $errDireccion=validarDireccion($direccion);
    }else{
        $errEmail=false;
        $errFecha=false;
        $errPass=false;
        $errNombre=false;
        $errApellido=false;
        $errTel=false;
        $errDireccion=false;
        
        $email="";
        $fecha="";
        $password="";
        $nombre="";
        $apellidos="";
        $telefono="";
        $direccion="";
        $ciclo="";
    }
    
    
    if(!isset($_POST["enviar"]) || $errEmail ||$errFecha  || $errPass || $errNombre ||$errApellido || $errTel || $errDireccion){
?>
	<div>
		<form action="<?php echo $_SERVER['PHP_SELF'];?>" method="post">
			Email:<input type="text" name="email" value="<?php echo $email?>"><?php if($errEmail){echo "email no correcto";}?><br>
			Fecha de nacimiento: <input type="text" name="fecha" value="<?php echo $fecha?>"><?php if($errFecha){echo "email no correcto";}?><br>
			Contraseña: <input type="password" name="password" value="<?php echo $password?>"><?php if($errPass){echo "email no correcto";}?><br>
			Nombre: <input type="text" name="nombre" value="<?php echo $nombre?>"><?php if($errNombre){echo "email no correcto";}?><br>
			Apellidos: <input type="text" name="apellidos" value="<?php echo $apellidos?>"><?php if($errApellido){echo "email no correcto";}?><br>
			Telefono: <input type="number" name="telefono" value="<?php echo $telefono?>"><?php if($errTel){echo "email no correcto";}?><br>
			Dirección: <input type="text" name="direccion" value="<?php echo $direccion?>"><?php if($errDireccion){echo "email no correcto";}?><br>
			Ciclo:<select name="ciclo" >
                        <option value="DAW">DAW</option>
                        <option value="ASIR">ASIR</option>
                        <option value="DAM">DAM</option>
                   </select>
            <input type="submit" name="enviar">
		</form>
	</div>

<?php 
    }else{
        
        echo "Formulario enviado";
        
    }
?>



</body>
</html>
