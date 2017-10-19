<html>
<body></body>
<?php
$nombre="Franfran";
define("CIUDAD", "Madrid");
$a=2;
$b=3;
$c="cadena";
$suma=$a+$b;
$resta=$a-$b;
$mult=$a*$b;
$div=$a/$b;
$concat=$a.$b;


echo "<h1>Funciona</h1>\n";
echo "<h3>La variable es $nombre</h3>\n";
echo 'La variable es '.$nombre.'....';
echo "Estamos en ".CIUDAD; 
echo "a+b= ".$a+=$b;
echo "\n";
echo "<p>La suma es $suma\n</p>";
echo "<p>La resta es $resta\n</p>";
echo "<p>La multiplicacion es $mult\n</p>";
echo "<p>La division es $div\n</p>";
echo "<p>La concatenacion es $concat\n</p>";
$a=1;
    if ($a>$b){
        echo  "<p>a=$a es mayor que b=$b</p>\n";
    }else{
        echo  "<p>a=$a es menor que b=$b</p>\n";
    }

for($i=0;$i<20;$i+=2){
    echo $i;
}
    
echo "<p>La cadena '$nombre' contiene ".strlen($nombre)." carateres</p>\n";
echo $nombre[1].$nombre[strlen($nombre)-1]."<p>\n</p>";
echo str_shuffle($nombre)."<p>\n</p>";
echo str_replace("r", "p", $nombre)."<p>\n</p>";

$ar1=array("azul","rojo","negro");
$ar2=array(0=>"cero", 2=>"dos", 5=>"cinco");
$ar3[1]="coche";
$ar3[3]="bici";
$ar3[6]="moto";

echo "<p>El tamaño de ar1 es: ".sizeof($ar1)."</p>\n";
echo "<p>El tamaño de ar2 es: ".sizeof($ar2)."</p>\n";
echo "<p>El tamaño de ar3 es: ".sizeof($ar3)."</p>\n";
echo $ar3[3]."</p>\n";


for($i=0;$i<sizeof($ar1);$i++){
    echo $ar1[$i]."</p>\n";
    


}

 /* $cont=0;
while($cont!=sizeof($ar3)){
    if(isset($ar3[$i])){
        echo $ar3[$i]."--";
        $cont++;
    }
    $i++;
    
}  */

echo "<h3>var_dump  &  print_r</h3>";

var_dump($ar1);
echo "<br/>";
print_r($ar1);
echo "<br/>";
var_dump($ar3);
echo "<br/>";
print_r($ar3);


echo "<h3>foreach</h3>";
echo "<ul>";
foreach ($ar1 as $i){
    echo "<li>$i</li>\n";
}
echo "</ul>";
echo "</br>";
echo "<h3>Array Asociativo</h3>";
$arAsoc=array("España"=>"Madrid", "Inglaterra"=>"Londres", "Francia"=>"Paris");

print_r($arAsoc);
echo "</br>";
var_dump($arAsoc);
echo "</br>";
echo "<ul>";
foreach ($arAsoc as $valor){
    echo "<li>$valor</li>\n";
}
echo "</ul>";

echo "<h3>Array Asociativo mostrando el indice</h3>";

echo "</br>";
echo "<ul>";
foreach ($arAsoc as $valor => $indice){
    echo "<li>La capital de $indice(indice) es $valor(valor)</li>\n";
}
echo "</ul>";

echo "<h3>Ordenacion arrays asociativos</h3>";

asort($arAsoc);
echo "<ul>";
foreach ($arAsoc as $valor => $indice){
    echo "<li>La capital de $indice(indice) es $valor(valor)</li>\n";
}
echo "</ul>";

arsort($arAsoc);
echo "<ul>";
foreach ($arAsoc as $valor => $indice){
    echo "<li>La capital de $indice(indice) es $valor(valor)</li>\n";
}
echo "</ul>";

ksort($arAsoc);
echo "<ul>";
foreach ($arAsoc as $valor => $indice){
    echo "<li>La capital de $indice(indice) es $valor(valor)</li>\n";
}
echo "</ul>";

krsort($arAsoc);
echo "<ul>";
foreach ($arAsoc as $valor => $indice){
    echo "<li>La capital de $indice(indice) es $valor(valor)</li>\n";
}
echo "</ul>";

sort($arAsoc);
echo "<ul>";
foreach ($arAsoc as $valor => $indice){
    echo "<li>La capital de $indice(indice) es $valor(valor)</li>\n";
}
echo "</ul>";



?>


</body>
</html>
