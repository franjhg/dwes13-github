<?php
session_name('idTest13');
session_start();

if(isset($_POST["Contestar3"])){
    $_SESSION["respuesta3"]=$_POST["libro"];
    if($_POST["libro"]=="correcto"){
        $_SESSION["acierto3"]=1;
    }else{
        $_SESSION["acierto3"]=0;
    }
    header("Location: resultados.php");
}
if( !$_SESSION["respuesta2"]){
    header("Location: test2.php");
}

if (!isset($_SESSION["usuario"])){
    header("Location: registro.php");
}else{
    
    
    ?>
	<div>
		<h3>¿Cuál no es un libro?</h3><br>
		<form action="<?php echo $_SERVER['PHP_SELF'];?>" method="post">
    		<input type="radio" name="libro" value="incorrecto">El Señor de los anillos<br>
    		<input type="radio" name="libro" value="incorrecto">La historia interminable<br>
    		<input type="radio" name="libro" value="correcto">El ojo<br>
    		<input type="submit" name="Contestar3">
        </form>
	</div>


<?php 

    }
?>
