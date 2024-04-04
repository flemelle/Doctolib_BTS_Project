<?php 
namespace Application\Controllers\Home;
//echo 'Disconnection process is working';
class Home{
    function page(){
        $title = "Accueil";
        include 'template/HomePageTemplate.php';
    }
}
?>