<?php 
include('Obra.php');
include('Conexion.php');

?>

<?php 
$ruta1="img/";

?>    
    <html>
    <head>
    <title>Conexión a BBDD Catalogo13</title>
    <meta charset="UTF-8"/>
    </head>
    <body>
    <h2>Pruebas con la base de datos de Catalogo13</h2>
    
   		<form action="<?php echo htmlspecialchars($_SERVER['PHP_SELF'], ENT_QUOTES, "UTF-8"); ?> " method="post">
		Autor a buscar: <input type="text" name="buscaObras">
		<input type="submit" name="enviar">
		</form>
    
    <table style='border:0'>
    <tr style='background-color:lightblue'>
    <th>IdDisco</th>
    <th>Titulo <a href="mostrarCatalogo.php?op=1"> &#9650 </a><a href="mostrarCatalogo.php?op=2">&#9660</a></th>
    <th>Autor <a href="mostrarCatalogo.php?op=3"> &#9650 </a><a href="mostrarCatalogo.php?op=4">&#9660</a></th>
    <th>Imagen</th>
    </tr>
<?php 
if(isset($_POST["enviar"])){
    $busqueda=$_REQUEST["buscaObras"];
    $resultado = $conexion-> query("SELECT * FROM obra, autor WHERE autor.IdAutor=obra.Autor
                 and autor.Nombre='$busqueda'");
}


elseif (isset($_REQUEST["NomAutor"])){
    $n=$_REQUEST["NomAutor"];
    $resultado = $conexion-> query("SELECT * FROM obra, autor WHERE autor.IdAutor=obra.Autor
                 and autor.Nombre='$n'");
}elseif//SI RECIBE LA ID DEL AUTOR
    (isset($_REQUEST["NomAutor2"])){
        $n=$_REQUEST["NomAutor2"];
        $resultado = $conexion-> query("SELECT * FROM obra, autor WHERE autor.IdAutor=obra.Autor
                 and autor.IdAutor='$n'");
}
//ORDENACION
elseif(isset( $_REQUEST["op"]) && $_REQUEST["op"]==1){
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
while ($obra = $resultado->fetch_assoc()) {
   

    echo "<tr bgcolor='lightgreen'>";
   // echo "<td>".$obra->getIdDisco()."</td>\n";
    echo "<td><a href='mostrarObra.php?IdDisco=$obra[IdDisco]'>$obra[IdDisco]</a></td>";
    echo "<td>$obra[Titulo]</td>";
    echo "<td><a href='mostrarCatalogo.php?NomAutor=$obra[Nombre]'>$obra[Nombre]</a></td>";
            //PASANDO LA ID DEL AUTOR
            //echo "<td><a href='mostrarCatalogo.php?NomAutor2=$obra[IdAutor]'>$obra[Nombre] por Id</a></td>";
    echo "<td><img src='$ruta1$obra[imagen]'></td>";
    echo "</tr>";
    
   
}

//mysqli_free_result($resultado); //Liberamos la variable $resultado
?>
</table>
<a href="mostrarCatalogo.php">Eliminar Filtros</a>
<?php 


echo "<h3>Desconectando...</h3>";
mysqli_close($conexion);
?>
</body>
</html>