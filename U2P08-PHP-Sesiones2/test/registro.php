<?php
    if(session_status()==PHP_SESSION_NONE){
        session_name('idTest13');
        session_start();
           
          
    }
    if(isset($_SESSION["usuario"])){
        header("Location:index.php");
    }
    if(isset($_POST["usuario"])){
        $_SESSION["usuario"]=$_POST["usuario"];
        header("Location:index.php");
    }else{
       
      
?>
  	<div>
  		<form action="<?php echo $_SERVER['PHP_SELF'];?>" method="post">
    		Usuario:<input type="text" name="usuario">
    		<input type="submit" name="enviar">
        </form>
  	</div>  
    
<?php     
    }
    
?>