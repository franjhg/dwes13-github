<?php 
include('Obra.php');
include('Conexion.php');
$ruta="img/";
?>
<html>
<head>
	<title>Conexión a BBDD Catalogo13</title>
	<meta charset="UTF-8"/>
</head>
<body>

<?php       //RECOGEMOS EL IDENTIFICADOR DE LA OBRA
    if (isset($_REQUEST['IdDisco'])){
        $paramDisco=$_REQUEST['IdDisco'];
                //NOS CONECTAMOS A TRAVES DE UNA CONSULTA
        $resultado=$conexion->query("SELECT * FROM obra, autor WHERE obra.IdDisco=".$paramDisco." AND obra.Autor=autor.IdAutor");
    }else{
        echo "<h2>Error en la petición. Falta identificador></h2>";
    }
?>
<table style='border:0'>
<tr style='background-color:lightblue'>
<th>IdDisco</th>
<th>Titulo</th>
<th>Autor</th>
<th>Imagen</th>
</tr>
<?php 




if($resultado->num_rows === 0) {echo "<p>No hay resultados para esta consulta</p>";
}else{// $resul = $resultado->fetch_object('Obra');
    $resul = $resultado->fetch_assoc();

echo "<tr bgcolor='lightgreen'>";
echo "<td>$resul[IdDisco]</td>\n";
echo "<td>$resul[Titulo]</td>\n";

 /*    $resultado2 = $conexion -> query("SELECT Nombre FROM autor where IdAutor = ".$resul->getAutor());
    if($resultado2->num_rows === 0){
        echo "<p>No hay nombres en la base de datos</p>";
    }else{
        $resul2=$resultado2->fetch_assoc();
        
    } 
 */
echo "<td>$resul[Nombre]</td>\n";
echo "<td><img src='$ruta$resul[imagen]'></td>\n";
    
echo "</tr>";
    
}
 /*  else{           
 echo "<p>Parámetro no recibido</p>";
 }  */
?>
</table>
<a href="mostrarCatalogoFinal.php">Volver al Catalogo</a>
<?php 
mysqli_free_result($resultado); //Liberamos la variable $resultado 
echo "<h3>Desconectando...</h3>";
mysqli_close($conexion);
?>
</body>
</html>
