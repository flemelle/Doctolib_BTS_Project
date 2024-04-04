<?php
namespace Application\Controllers\Doctors;
require_once('src/models/dataExtract.php');
require_once('src/models/dataUpdate.php');
require_once('src/models/dataDelete.php');
require_once('src/lib/database.php');
use Application\Models\DataExtract\DataExtract;
use Application\Models\DataUpdate\UpdateItem;
use Application\Lib\Database\DatabaseConnection;
use Application\Models\DataDelete\DeleteItem;

class Doctors{
    function dataLoading($sortBy){
        if ($_SESSION['role'] == 'admin'){
            $title = 'Médecins';
            $db = new DatabaseConnection();
            $doctorList = (new DataExtract()) -> getList($db, "btsProject_User_Doctor",$sortBy);
            //echo var_dump($doctorList);
            include 'template/DoctorsPageTemplate.php';
        } else {
            header('Refresh:0; url=index.php?page=homePage');
        }
    }
}

?>