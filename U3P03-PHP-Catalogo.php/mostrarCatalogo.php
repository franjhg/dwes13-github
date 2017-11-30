<?php 
include('Obra.php');
include('Conexion.php');
?>


<html>
<head>
	<title>Conexión a BBDD Catalogo13</title>
	<meta charset="UTF-8"/>
</head>
<body>
<h2>Pruebas con la base de datos de Catalogo13</h2>
<table style='border:0'>
<tr style='background-color:lightblue'>
<th>IdDisco</th>
<th>Titulo <a href="mostrarCatalogo.php?op=1"> &#9650 </a><a href="mostrarCatalogo.php?op=2">&#9660</a></th>
<th>Autor <a href="mostrarCatalogo.php?op=3"> &#9650 </a><a href="mostrarCatalogo.php?op=4">&#9660</a></th>
<th>Imagen</th>
</tr>
<?php 
$ruta1="img/";
$n="";
//Enlace a listado de obras por autor
if (isset($_REQUEST["NomAutor"])){
    $_REQUEST["NomAutor"]=$n;
    $resultado2 = $conexion-> query("SELECT * FROM obra, autor WHERE autor.IdAutor=obra.Autor
                 and autor.Nombre='.$n.'");
    //--------PRUEBA-----------
    if($resultado2->num_rows === 0) echo "<p>No hay obras en la base de datos</p>";
    while ($obraPORautor = $resultado2->fetch_object('Obra')) {
  /*   }else{
        $obraPORautor = $resultado2->fetch_object();*/
        echo "<p>'.$obraPORautor->getNombreAutor().'</p>";
        echo "<p>'.$obraPORautor->getTitulo().'</p>";
        
    } 
    //-------FIN PRUEBA-------
    
}

//ORDENACION
if(isset( $_REQUEST["op"]) && $_REQUEST["op"]==1){
    $resultado = $conexion -> query("SELECT * FROM obra,autor WHERE autor.IdAutor=obra.Autor ORDER BY Titulo");
}elseif (isset( $_REQUEST["op"]) && $_REQUEST["op"]==2){
    $resultado = $conexion -> query("SELECT * FROM obra,autor WHERE autor.IdAutor=obra.Autor ORDER BY Titulo DESC");
}elseif (isset( $_REQUEST["op"]) && $_REQUEST["op"]==3){
    $resultado = $conexion -> query("SELECT * FROM obra,autor WHERE autor.IdAutor=obra.Autor ORDER BY Autor");
}elseif ( isset( $_REQUEST["op"]) && $_REQUEST["op"]==4){
    $resultado = $conexion -> query("SELECT * FROM obra,autor WHERE autor.IdAutor=obra.Autor ORDER BY Autor DESC");

}else{


$resultado = $conexion -> query("SELECT * FROM obra,autor WHERE autor.IdAutor=obra.Autor ORDER BY IdDisco");
}
if($resultado->num_rows === 0) echo "<p>No hay obras en la base de datos</p>";
while ($obra = $resultado->fetch_object('Obra')) {
   

    echo "<tr bgcolor='lightgreen'>";
   // echo "<td>".$obra->getIdDisco()."</td>\n";
    echo "<td><a href='mostrarObra.php?IdDisco=".$obra->getIdDisco()."'>".$obra->getIdDisco()."</a></td>\n";
    echo "<td>".$obra->getTitulo()."</td>\n";
    echo "<td><a href='mostrarCatalogo.php?NomAutor=".$obra->getNombreAutor()."'>".$obra->getNombreAutor()."</a></td>\n";
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