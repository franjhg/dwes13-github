<html>
<head>
	<title>Conexión a BBDD Catalogo13</title>
	<meta charset="UTF-8"/>
</head>
<body>
<h2>Pruebas con la base de datos de Catalogo13</h2>
<?php
include('Obra.php');


$servidor = "localhost";
$usuario = "alumno";
$clave = "alumno";

$conexion = new mysqli($servidor,$usuario,$clave,"catalogo13");
$conexion->query("SET NAMES 'UTF8'");
$ruta1="img/";


if ($conexion->connect_errno) {
    echo "<p>Error al establecer la conexión (" . $conexion->connect_errno . ") " . $conexion->connect_error . "</p>";
}
?>
<table style='border:0'>
<tr style='background-color:lightblue'>
<th>IdDisco</th>
<th>Titulo <a href="mostrarCatalogo.php?op=1"> &#9650 </a><a href="mostrarCatalogo.php?op=2">&#9660</a></th>
<th>Autor <a href="mostrarCatalogo.php?op=3"> &#9650 </a><a href="mostrarCatalogo.php?op=4">&#9660</a></th>
<th>Imagen</th>
</tr>
<?php 

//ORDENACION
if(isset( $_REQUEST["op"]) && $_REQUEST["op"]==1){
    $resultado = $conexion -> query("SELECT * FROM obra ORDER BY Titulo");
}elseif (isset( $_REQUEST["op"]) && $_REQUEST["op"]==2){
    $resultado = $conexion -> query("SELECT * FROM obra ORDER BY Titulo DESC");
}elseif (isset( $_REQUEST["op"]) && $_REQUEST["op"]==3){
    $resultado = $conexion -> query("SELECT * FROM obra ORDER BY Autor");
}elseif ( isset( $_REQUEST["op"]) && $_REQUEST["op"]==4){
    $resultado = $conexion -> query("SELECT * FROM obra ORDER BY Autor DESC");
}
//Enlace a listado de obras por autor
    elseif (isset($_REQUEST["NomAutor"])){
    $_REQUEST["NomAutor"]=$n;
    $resultado = $conexion-> query("SELECT autor.IdAutor,autor.Nombre,autor.Imagen,
                 obra.IdDisco,obra.Titulo, obra.imagen from obra, autor where autor.IdAutor=obra.Autor
                 and autor.IdAutor=$n");
}else{



$resultado = $conexion -> query("SELECT * FROM obra ORDER BY IdDisco");
}
if($resultado->num_rows === 0) echo "<p>No hay obras en la base de datos</p>";
while ($obra = $resultado->fetch_object('Obra')) {
   
    
    $resultado2 = $conexion -> query("SELECT Nombre FROM autor where IdAutor = ".$obra->getAutor());
    if($resultado2->num_rows === 0){
        echo "<p>No hay nombres en la base de datos</p>";
    }else{
        $resFinal=$resultado2->fetch_assoc();
       
    } 

    echo "<tr bgcolor='lightgreen'>";
   // echo "<td>".$obra->getIdDisco()."</td>\n";
    echo "<td><a href='mostrarObra.php?IdDisco=".$obra->getIdDisco()."'>".$obra->getIdDisco()."</a></td>\n";
    echo "<td>".$obra->getTitulo()."</td>\n";
    echo "<td><a href='mostrarCatalogo.php?NomAutor=$resFinal[Nombre]'>".$resFinal[Nombre]."</a></td>\n";
    echo "<td><img src='".$ruta1.$obra->getImagen()."'></td>\n";
    echo "</tr>";
    //mysqli_free_result($resultado2);
 
}
?>
</table>

<?php 

mysqli_free_result($resultado); //Liberamos la variable $resultado
echo "<h3>Desconectando...</h3>";
mysqli_close($conexion);
?>
</body>
</html>