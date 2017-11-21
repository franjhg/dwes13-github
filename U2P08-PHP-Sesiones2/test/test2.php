<?php
    session_name('idTest13');
    session_start();

    if(isset($_POST["Contestar2"])){
        $_SESSION["respuesta2"]=$_POST["disco"];
        if($_POST["disco"]=="correcto"){
            $_SESSION["acierto2"]=1;
        }else{
            $_SESSION["acierto2"]=0;
            }
        header("Location: test3.php");
    }
    if(!$_SESSION["respuesta1"]){
        header("Location: test1.php");
    }
    if (!isset($_SESSION["usuario"])){
        header("Location: registro.php");
    }else{
     
       
?>
	<div>
		<h3>¿Qué grupo ha vendido mas discos??</h3><br>
		<form action="<?php echo $_SERVER['PHP_SELF'];?>" method="post">
    		<input type="radio" name="disco" value="correcto">Ramones<br>
    		<input type="radio" name="disco" value="incorrecto">Los Lobos<br>
    		<input type="radio" name="disco" value="incorrecto">Marea<br>
    		<input type="submit" name="Contestar2">
        </form>
	</div>


<?php 

    }
?>
