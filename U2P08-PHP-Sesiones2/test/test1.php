<?php
    session_name('idTest13');
    session_start();

    if(isset($_POST["Contestar1"])){
        $_SESSION["respuesta1"]=$_POST["pelicula"];
        if($_POST["pelicula"]=="correcto"){
         $_SESSION["acierto1"]=1;
        }else{
            $_SESSION["acierto1"]=0;
        }
        header("Location: test2.php");
    }
    
    if (!isset($_SESSION["usuario"])){
        header("Location: registro.php");
    }else{
     
       
?>
	<div>
		<h3>¿Qué película es más antigua?</h3><br>
		<form action="<?php echo $_SERVER['PHP_SELF'];?>" method="post">
    		<input type="radio" name="pelicula" value="correcto">CasaBlanca<br>
    		<input type="radio" name="pelicula" value="incorrecto">Robocop<br>
    		<input type="radio" name="pelicula" value="incorrecto">Trainspotting<br>
    		<input type="submit" name="Contestar1">
        </form>
	</div>


<?php 

    }
?>
