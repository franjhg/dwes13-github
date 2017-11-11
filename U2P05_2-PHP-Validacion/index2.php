<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Formulario De Alumnos</title>
    <?php include ("validaciones.php") ?>
</head>
<body>
<div style="margin-left: 39%;">
    <?php
    if(isset($_POST["enviar"])) {
        $errorP = validarContraseña($_POST["pass"]);
        $errorF = validarFecha($_POST["fecha"]);
        $errorD = validarDir($_POST["dir"]);
        $errorT = validarTlf($_POST["tlf"]);
        $nombre=$_POST["nombre"];
        $apellidos=$_POST["apellidos"];
        $email=$_POST["email"];
    }else{
        $errorP = false;
        $errorF = false;
        $errorD = false;
        $errorT = false;
        $fecha="";
        $tlf="";
        $pass="";
        $email="";
        $nombre="";
        $apellidos="";
        $dir="";
    }
    if($errorF){
        $fecha=$_POST["fecha"];
    }else{
        $fecha="";
    }
    if($errorD){
        $dir=$_POST["dir"];
    }else{
        $dir="";
    }
    if($errorT){
        $tlf=$_POST["tlf"];
    }else{
        $tlf="";
    }
    if($errorP){
        $pass=$_POST["pass"];
    }else{
        $pass="";
    }
    if(!$errorF || !$errorP || !$errorD || !$errorT){
    ?>

    <div style="width: 294px;">
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

<?php }
    else{
    echo "<div><h1>Datos personales</h1></div>";
    echo "<h2> $nombre $apellidos;</h2>";
    ?>
    <ul>

        <li>Email <?php echo $email ?></li>
        <li>Fecha de nacimiento <?php echo $fecha ?></li>
        <li>Ciclo <?php echo $ciclo ?></li>

        <?php
        if ($errorT) {
            echo "<li>Telefono $tlf </li>";
        }
        if ($errorD) {
            echo " <li>Direccion $dir</li>";
        }
        }    ?>

</ul>
</body>

</html>
