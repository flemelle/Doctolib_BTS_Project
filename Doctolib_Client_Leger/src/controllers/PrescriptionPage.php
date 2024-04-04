<?php 
namespace Application\Controllers\Prescription;
require_once ('src/models/dataExtract.php');
require_once ('src/models/dataInsert.php');
require_once('src/lib/database.php');
use Application\Models\DataExtract\DataExtract;
use Application\Models\DataInsert\DataInsert;
use Application\Lib\Database\DatabaseConnection;

class Prescription{
    public $patientLayout;
    public $doctorLayout;
    function page(){
        $title = 'Ordonnances';
        $db = new DatabaseConnection();
        if ($_SESSION['role'] == 'admin'){
            $doctorLayout = 'hidden';
            $patientLayout = '';
            $data = (new DataExtract()) -> getList($db, 'btsProject_Prescription', "");
        
        }else {
            if ($_SESSION['role'] == 'patient'){
                $patientLayout = '';
                $doctorLayout = 'hidden';
                $idUserType = 'idPatient';
            } else if ($_SESSION['role'] == 'doctor'){
                $patientLayout = 'hidden';
                $doctorLayout ='';
                $idUserType = 'idDoctor';
            }
            $data = (new DataExtract()) -> getListWhere($db, 'btsProject_Prescription', $_SESSION['idUser'], $idUserType, "");
        }
        include 'template/PrescriptionPageTemplate.php';
    }
    function create($postData){
        $db = new DatabaseConnection();
        $array = array(
            array('idDoctor', $postData['idDoctor']),
            array('idPatient', $postData['idPatient']),
            array('datePrescription', $postData['datePrescription']),
            array('content', $postData['content'])
        );
        (new DataInsert()) -> insertInTable($db, 'btsProject_Prescription', $array);
        header('Refresh:0; url=index.php?page=prescription');
    }
}

?>