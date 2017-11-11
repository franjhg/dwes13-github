<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Formulario De Alumnos</title>
</head>
<body>
<div style="margin-left: 39%;"></div>
<?php
    $telefono=false;
    $direccion=false;
    $enviado=false;
    $clave=false;
    $fechas=false;
    $errorP=true;
    $errorF=true;
if(isset($_POST["enviar"])) {
    $email=$_POST["email"];
    $fecha=$_POST["fecha"];
    $dia=(int)substr($fecha,0,2);
    $mes=(int)substr($fecha,3,2);
    $año=(int)substr($fecha,6, 4);
    switch($mes){
        case 1:
        case 3:
        case 5:
        case 7:
        case 8:
        case 10:
        case 12:
            if($dia>0 && $dia<=31){
                $fechas=true;
                $errorF=true;
            }else{
                $fecha="";
                $errorF=false;
                $fechas=false;
            }
            break;
        case 4:
        case 6:
        case 8:
        case 11:
        if($dia>0 && $dia<=30){
                 $fechas=true;
                $errorF=true;
        }else{
            $fecha="";
            $errorF=false;
            $fechas=false;
        }
        break;
        case 2:
            if ($dia <= 28 && $dia >= 1) {
                $fechas=true;
                $errorF=true;
            } else if (($dia == 29 && (($año % 4 == 0 && $año % 100 != 0) || $año % 400 == 0))) {
                $fechas=true;
                $errorF=true;
            } else {
                $fechas=false;
                $errorF=false;
                $fecha="";
            }
            break;
    }
    if(!empty($_POST["pass"])) {
        if (strlen($_POST["pass"]) >= 8 && strlen($_POST["pass"]) <= 12) {
            $clave = true;
            $errorP = true;
            $pass = $_POST["pass"];
        } else {
            $clave = false;
            $pass = $_POST["pass"];
            $errorP = false;
            $pass="";
        }
    }
    $nombre=$_POST["nombre"];
    $apellidos=$_POST["apellidos"];
    if(!empty($_POST["tlf"])) {
        $telefono=true;
        $tlf=$_POST["tlf"];
    }else{
        $tlf="";
    }
    if(!empty($_POST["dir"])) {
        $direccion=true;
        $dir=$_POST["dir"];
    }
    else{
        $dir="";
    }
    $ciclo=$_POST["ciclo"];
    $enviado=true;
}else {
    $email = "";
    $fecha = "";
    $pass = "";
    $nombre = "";
    $apellidos = "";
    $tlf = "";
    $dir = "";
    $ciclo = "";
}
if(!$enviado || !$clave ||!$fechas ){
?>

<div style="width: 294px;"></div>
<form action="<?php echo htmlspecialchars($_SERVER['PHP_SELF'], ENT_QUOTES, "UTF-8"); ?> " method="post">
    Email:<input type="email" name="email" pattern="^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\.[a-zA-Z0-9-]+)*$" required value="<?php echo $email ;?>" /><br>
    Fecha de nacimiento:<input type="date" name="fecha" value="<?php echo $fecha ;?>" pattern="(0[1-9]|1[0-9]|2[0-9]|3[01]).(0[1-9]|1[012]).[0-9]{4}" required / ><?php if(!$errorF){echo" <a style='color:red;'>La fecha tiene que tener un formato dd/mm/aaaa y tiene que ser valida</a>"; $errorF=true;}?><br>
    Contraseña:<input type="password" name="pass" pattern="[A-Za-z0-9!?-]{1,12}" value="<?php echo $pass ;?>" /><?php if(!$errorP){echo"<a style='color:red;'> La contraseña tiene que tener de 8 a 12 caracteres <a>"; $errorP=true;}?><br>
    Nombre:<input type="text" name="nombre" pattern="[a-zA-Z àáâäãåąčćęèéêëėįìíîïłńòóôöõøùúûüųūÿýżźñçčšžÀÁÂÄÃÅĄĆČĖĘÈÉÊËÌÍÎÏĮŁŃÒÓÔÖÕØÙÚÛÜŲŪŸÝŻŹÑßÇŒÆČŠŽ∂ð ,.'-]{2,48}" value="<?php echo $nombre ;?>" required /><br>
    Apellidos:<input type="text" name="apellidos" pattern="[a-zA-Z àáâäãåąčćęèéêëėįìíîïłńòóôöõøùúûüųūÿýżźñçčšžÀÁÂÄÃÅĄĆČĖĘÈÉÊËÌÍÎÏĮŁŃÒÓÔÖÕØÙÚÛÜŲŪŸÝŻŹÑßÇŒÆČŠŽ∂ð ,.'-]{2,48}"value="<?php echo $apellidos ;?>" required /><br>
    Teléfono:<input type="tel" name="tlf" pattern="[0-9]{9}" value="<?php echo $tlf ;?>" /><br>
    Dirección:<input type="text" name="dir" pattern="[a-zA-Z0-9- \àáâäãåąčćęèéêëėįìíîïłńòóôöõøùúûüųūÿýżźñçčšžÀÁÂÄÃÅĄĆČĖĘÈÉÊËÌÍÎÏĮŁŃÒÓÔÖÕØÙÚÛÜŲŪŸÝŻŹÑßÇŒÆČŠŽ∂ð ,.'-]{2,48}" value="<?php echo $dir ;?>" /><br>
    Ciclo Formativo:<select name="ciclo" >
                         <option value="DAW">DAW</option>
                         <option value="ASIR">ASIR</option>
                         <option value="DAM">DAM</option>
                    </select>
    <br> <input name="enviar" type="submit" >
</form>
</div>
</body>
<?php }
    else{
    ?>


<div><h1>Datos personales</h1></div>
        <h2><?php echo "$nombre $apellidos";?></h2>
    <ul>

        <li>Email <?php echo $email?></li>
        <li>Fecha de nacimiento <?php echo $fecha?></li>
        <li>Ciclo <?php echo $ciclo?></li>

        <?php
            if($telefono ){
            echo "<li>Telefono $tlf </li>";
        }
        if($direccion){
       echo" <li>Direccion $dir</li>";
            }
        ?>

    </ul>
</body>
<?php
}
?>

</body>
</html>
