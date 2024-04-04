<?php 
namespace Application\Controllers\Error;
class Error
{
    public function page($errorType)
    {    
        $title = 'Erreur';
        include 'template/ErrorPageTemplate.php';
    }
}
?>