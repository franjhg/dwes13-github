<?php
class Rectangulo{

    public $base, $altura;
   
    function __construct($base, $altura){
        $this->altura=$_POST["altura"];
        $this->base=$_POST["base"];
       
    }
    
    public function calcularArea(){
        return $this->base * $this->altura;
    }
}
?>