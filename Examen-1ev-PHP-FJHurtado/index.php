<?php
session_start ();
include('conexion.php');
$ruta1="../img/discografia";


if(isset( $_REQUEST["Cierra"]) && $_REQUEST["Cierra"]==Si){
    $_SESSION=array();
}
?>
<html>
<head>
<title>Indice</title>
<meta charset="UTF-8"/>
</head>
<body>
<h2>Indice</h2>


<form action="<?php echo htmlspecialchars($_SERVER['PHP_SELF'], ENT_QUOTES, "UTF-8"); ?> " method="post">
		Disco a buscar: <input type="text" name="buscaTipo">
		<input type="submit" name="enviar">
		</form>
    
    <table style='border:0'>
    <tr style='background-color:lightblue'>
    <th>Titulo<a href="index.php?op=1"> &#9650 </a><a href="index.php?op=2">&#9660</a></th>
    <th>Discografica </th>
    <th>Año<a href="index.php?op=3"> &#9650 </a><a href="index.php?op=4">&#9660</a></th>
    <th>Soporte</th>
    <th>Imagen</th>
    </tr>
     
<?php 


//--------------


 $resul = $conexion -> query( "SELECT DISTINCT tipo FROM discos");
if($resul->num_rows === 0) echo "<p>No hay discos en la base de datos</p>";
while ($disc = $resul->fetch_assoc()) {
/*?>

    <form action="<?php echo $_SERVER['PHP_SELF'];?>" method="post">
<p>$disc[tipo]</p>";



<input type='submit' Value='enviar' name='enviar'/>";

<input type="submit" name="enviar">
</form>
<?php 
}
if(isset($_POST["enviar"])){
    $tip=$_REQUEST["enviar"];
     
}else{
    $tip="Álbumes";*/
} 


//-----------------

    $resultado = $conexion -> query("SELECT * from discos WHERE tipo = 'Álbumes'");
if($resultado->num_rows === 0) echo "<p>No hay discos en la base de datos</p>";


if(isset( $_REQUEST["op"]) && $_REQUEST["op"]==1){
    $resultado = $conexion -> query("SELECT * from discos WHERE tipo = 'Álbumes' ORDER BY nombre");
}elseif (isset( $_REQUEST["op"]) && $_REQUEST["op"]==2){
    $resultado = $conexion -> query("SELECT * from discos WHERE tipo = 'Álbumes' ORDER BY nombre DESC");
}elseif (isset( $_REQUEST["op"]) && $_REQUEST["op"]==3){
    $resultado = $conexion -> query("SELECT * from discos WHERE tipo = 'Álbumes' ORDER BY year");
}elseif ( isset( $_REQUEST["op"]) && $_REQUEST["op"]==4){
    $resultado = $conexion -> query("SELECT * from discos WHERE tipo = 'Álbumes' ORDER BY year DESC");
    
}
elseif(isset($_POST["enviar"])){
    $busqueda=$_REQUEST["buscaTipo"];
    
    
    
    $resultado = $conexion-> query("SELECT * from discos WHERE tipo = 'Álbumes' AND nombre='$busqueda'");
}

if($resultado->num_rows === 0) echo "<p>No hay discos en la base de datos</p>";
while ($disco = $resultado->fetch_assoc()) {
    
    echo "<tr bgcolor='lightgreen'>";
    echo "<td>$disco[nombre]</td>\n";
    echo "<td>$disco[discografica]</td>\n";
    echo "<td>$disco[year]</td>\n";
    echo "<td>$disco[soporte]</td>\n";
    
    echo "<td><a href='disco.php?NomDisc=$disco[nombre]'>   <img src='$ruta1$disco[imagen]'> </a></td>";
   // echo "<td><img href='disco.php?NomDisc=$disco[nombre]'    src=$ruta1$disco[imagen]/> </td>"
    echo "</tr>";
   //----------------

   
    
} 
?>
</table>
<a href='admin-login.php'>LOGIN</a>

   