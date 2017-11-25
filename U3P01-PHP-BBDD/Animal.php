<?php
class Animal{
    
    private $chip, $nombre, $tipo, $imagen;
    /**
     * @return the $chip
     */
    public function getChip()
    {
        return $this->chip;
    }

    /**
     * @return the $nombre
     */
    public function getNombre()
    {
        return $this->nombre;
    }

    /**
     * @return the $especie
     */
    public function getEspecie()
    {
        return $this->tipo;
    }

    /**
     * @return the $imagen
     */
    public function getImagen()
    {
        return $this->imagen;
    }

    /**
     * @param field_type $chip
     */
    public function setChip($chip)
    {
        $this->chip = $chip;
    }

    /**
     * @param field_type $nombre
     */
    public function setNombre($nombre)
    {
        $this->nombre = $nombre;
    }

    /**
     * @param field_type $especie
     */
    public function setEspecie($tipo)
    {
        $this->tipo = $tipo;
    }

    /**
     * @param field_type $imagen
     */
    public function setImagen($imagen)
    {
        $this->imagen = $imagen;
    }

    public function __toString(){
        return Animal::getNombre()." ".Animal::getChip()." ".Animal::getEspecie()." ".Animal::getImagen();
    }
    
    
}