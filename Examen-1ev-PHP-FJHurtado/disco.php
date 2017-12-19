<?php
include('Conexion.php');
$ruta1="img/discografia";
?>
<html>
<head>
	<title></title>
	<meta charset="UTF-8"/>
</head>
<body>
	<h2>Info del Disco seleccionado</h2>
<?php       //RECOGEMOS EL IDENTIFICADOR DE LA OBRA


    if (isset($_REQUEST['NomDisc'])){
        $paramDisco=$_REQUEST['NomDisc'];
        
                //NOS CONECTAMOS A TRAVES DE UNA CONSULTA
       // $resultado=$conexion->query("SELECT * FROM obra, autor WHERE obra.IdDisco=".$paramDisco." AND obra.Autor=autor.IdAutor");
        $resultado = $conexion -> query("SELECT * from discos WHERE nombre='$paramDisco'");
    }else{
        echo "<h2>Error en la petición. Falta identificador></h2>";
    }
    if (isset($_REQUEST['NomDisc'])){
        $paramDisco=$_REQUEST['NomDisc'];
        $resulDisco = $conexion -> query("SELECT  discos.texto ,temas.numero, temas.nombre_i, temas.minutos, temas.segundos from discos, temas WHERE discos.id=temas.id_disco
        AND discos.nombre='$paramDisco'");
        $disco2 = $resulDisco->fetch_assoc();
        //  $a=$disco2[texto];
    }
?>
 <table style='border:0'>
    <tr style='background-color:lightblue'>
    <th>Titulo<a href="index.php?op=1"> &#9650 </a><a href="index.php?op=2">&#9660</a></th>
    <th>Discografica </th>
    <th>Año<a href="index.php?op=3"> &#9650 </a><a href="index.php?op=4">&#9660</a></th>
    <th>Soporte</th>
    <th>Imagen</th>
    </tr>
<?php 




if($resultado->num_rows === 0) {echo "<p>No hay resultados para esta consulta</p>";
}else{// $resul = $resultado->fetch_object('Obra');
    $disco = $resultado->fetch_assoc();

    echo "<tr bgcolor='lightgreen'>";
    echo "<td>$disco[nombre]</td>\n";
    echo "<td>$disco[discografica]</td>\n";
    echo "<td>$disco[year]</td>\n";
    echo "<td>$disco[soporte]</td>\n";
    echo "<td><a href='disco.php?NomDisc=$disco[nombre]'> $ruta1$disco[imagen] </a></td>";
  
    echo "</tr>";
    
}
 /*  else{           
 echo "<p>Parámetro no recibido</p>";
 }  */
?>
</table>

   
  <h2>Listado de canciones</h2>
    <table style='border:0'>
    <tr style='background-color:lightblue'>
    <th>Número</th>
    <th>Título </th>
    <th>Duración</th>
    </tr>
    <?php 

    while ($disco2 = $resulDisco->fetch_assoc()) {
        echo "<tr bgcolor='lightgreen'>";
        echo "<td>$disco2[numero]</td>\n";
        echo "<td>$disco2[nombre_i]</td>\n";
       // echo "<td>$disco2[minutos]</td>\n";
        echo "<td>$disco2[minutos]minutos y $disco2[segundos] segundos</td>\n";
    }
   


?>



<a href="index.php">Volver al Listado</a>
<?php 
mysqli_free_result($resultado); //Liberamos la variable $resultado 

mysqli_close($conexion);
?>
</body>
</html>