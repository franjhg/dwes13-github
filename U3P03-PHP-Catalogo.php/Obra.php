<?php
class Obra{
    
       private $IdDisco, $Titulo, $Autor, $imagen, $Nombre; //HAY QUE PONER LOS MISMOS CAMPOS QUE EN LA TABLA
    /**
     * @return the $nombreAutor
     */
       public function getNombreAutor()
    {
        return $this->Nombre;
    }

    /**
     * @param field_type $nombreAutor
     */
    public function setNombreAutor($Nombre)
    {
        $this->Nombre = $Nombre;
    }

    /**
     * @return the $IdDisco
     */
    public function getIdDisco()
    {
        return $this->IdDisco;
    }

    /**
     * @return the $Titulo
     */
    public function getTitulo()
    {
        return $this->Titulo;
    }

    /**
     * @return the $Autor
     */
    public function getAutor()
    {
        return $this->Autor;
    }

    /**
     * @return the $imagen
     */
    public function getImagen()
    {
        return $this->imagen;
    }

    /**
     * @param field_type $IdDisco
     */
    public function setIdDisco($IdDisco)
    {
        $this->IdDisco = $IdDisco;
    }

    /**
     * @param field_type $Titulo
     */
    public function setTitulo($Titulo)
    {
        $this->Titulo = $Titulo;
    }

    /**
     * @param field_type $Autor
     */
    public function setAutor($Autor)
    {
        $this->Autor = $Autor;
    }

    /**
     * @param field_type $imagen
     */
    public function setImagen($imagen)
    {
        $this->imagen = $imagen;
    }

    public function __toString(){
        return "";
    }
       
    
}
?>