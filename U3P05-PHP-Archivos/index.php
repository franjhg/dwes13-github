<!DOCTYPE html>
<html><head><meta charset='UTF-8'/></head>
<body>
<?php
$rutaArchivo = "files/modulos.txt";
// Pruebas
/* //1.Prueba la forma más rápida y sencilla de leer un archivo:
//volcaremos el resultado en pantalla.
echo readfile($rutaArchivo); */
/* //2.Lee ahora las líneas del archivo a un array:
$lineasArchivo = file($rutaArchivo);
print_r($lineasArchivo);
 */
/* //3.Muestra todo el archivo sin separación de líneas
$archivo = fopen($rutaArchivo, "r") or die("Imposible abrir el archivo");
echo fread($archivo,filesize($rutaArchivo));
fclose($archivo); */
/* //4.Muestra todas las líneas del archivo
$archivo = fopen($rutaArchivo, "r") or die("Imposible abrir el archivo");
while(!feof($archivo)) {
    echo fgets($archivo) . "<br/>";
}
fclose($archivo); */
/* //5.Lee ahora carácter a carácter, detectando fin de línea
$archivo = fopen($rutaArchivo, "r") or die("Imposible abrir el archivo");
while(!feof($archivo)) {
    $c = fgetc($archivo);
    if (($c == "\n") or ($c == "\r\n")) echo "<br/>";
    else echo $c;
}
fclose($archivo); */
 
//6.Abre el archivo para escritura, y escribe el nombre 
//de dos módulos de primero:
function mostrarArchivo( $rutaArchivo){
    $archivo = fopen($rutaArchivo, "r") or die("Imposible abrir el archivo");
    while(!feof($archivo)) {
        echo fgets($archivo) . "<br/>";
    }
}    
    
/* $archivo = fopen($rutaArchivo, "w") or die("Imposible  abrir el archivo para escritura");
fwrite($archivo,"Programación\n");
fwrite($archivo,"Entornos de desarrollo\n");
fclose($archivo); 

mostrarArchivo( $rutaArchivo);*/

//7.Recupera el contenido original del archivo modulos.txt, y repite la ejecución
//del código anterior 
//sustituyendo "w" por "a" (append). Comprueba que ahora sale bien
/* $archivo = fopen($rutaArchivo, "r+") or die("Imposible  abrir el archivo para escritura");
fwrite($archivo,"Programación\n");
fwrite($archivo,"Entornos de desarrollo\n");
fclose($archivo);

mostrarArchivo( $rutaArchivo); */

//8.y repite la ejecución del código anterior 
//sustituyendo "w" por "a" (append). 

/* $archivo = fopen($rutaArchivo, "a") or die("Imposible  abrir el archivo para escritura");
fwrite($archivo,"Programación");
fwrite($archivo,"\n Entornos de desarrollo");
fclose($archivo);

mostrarArchivo( $rutaArchivo); */

//9.Codifica un ejemplo en el que se escriban datos en un archivo nuevo.txt que previamente
//no existía.
$ruta="files/nuevos.txt";
$res= file($ruta);

unlink($ruta);
$archivo = fopen($ruta, "a") or die("Imposible  abrir el archivo para escritura");
fwrite($archivo,"Nueva mLínea 1\n");
fwrite($archivo,"Nueva Línea 2\n");
foreach ($res as $aux){
    fwrite($archivo, $aux);
}
fclose($archivo);

$res= file($ruta);
natcasesort($res);

mostrarArchivo( $ruta);
?>
</body></html>
