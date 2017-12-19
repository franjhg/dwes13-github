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
//5.Lee ahora carácter a carácter, detectando fin de línea
$archivo = fopen($rutaArchivo, "r") or die("Imposible abrir el archivo");
while(!feof($archivo)) {
    $c = fgetc($archivo);
    if (($c == "\n") or ($c == "\r\n")) echo "<br/>";
    else echo $c;
}
fclose($archivo);



?>
</body></html>
