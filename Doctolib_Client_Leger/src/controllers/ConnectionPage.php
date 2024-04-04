<?php
namespace Application\Controllers\Connection;
require_once('src/models/dataExtract.php');
require_once('src/lib/database.php');
use Application\Models\DataExtract\DataExtract;
use Application\Lib\Database\DatabaseConnection;

//echo 'Connection process is working, ';
class Connection
{
    public function start($credentials)
    {    
        //echo 'Connection.start is running, ';
        $title = 'Connexion';
        $db = new DatabaseConnection();
        $data = new DataExtract();
        $accountInfo = $data -> credentialVerification($credentials, $db);
        if (!empty( $accountInfo)){
            $_SESSION['connected'] = 'on';
            $_SESSION['role'] = $accountInfo['role'];
            $_SESSION['firstName'] = $accountInfo['firstName'];
            $_SESSION['idUser'] = $accountInfo['idUser'];
            header("Refresh:0");
        }
        else{
            include ('template/ConnectionPageTemplate.php');
            echo('échec de connexion ');
        }
    }
    public function page(){
        require 'template/ConnectionPageTemplate.php';
    } 
}
//une option avec une entrée puis vérification des credentials
?>