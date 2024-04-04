<?php 
namespace Application\Controllers\Appointement;
require_once ('src/models/dataExtract.php');
require_once ('src/models/dataInsert.php');
require_once('src/models/dataUpdate.php');
require_once('src/lib/database.php');
use Application\Models\DataUpdate\UpdateItem;
use Application\Models\DataExtract\DataExtract;
use Application\Models\DataInsert\DataInsert;
use Application\Lib\Database\DatabaseConnection;

class Appointement{
    public $patientLayout;
    public $doctorLayout;
    function page(){
        $db = new DatabaseConnection();
        $title = 'Rendez-vous';
        if ($_SESSION['role'] == 'admin'){
            $doctorLayout = '';
            $patientLayout = 'hidden';
            $data = (new DataExtract()) -> getList($db, 'btsProject_Appointment', "");
        
        }
        else {
            if ($_SESSION['role'] == 'patient'){
                $idUserType = 'idPatient';
                $doctorLayout = 'hidden';
                $patientLayout = '';
            } else if ($_SESSION['role'] == 'doctor'){
                $idUserType = 'idDoctor';
                $patientLayout = 'hidden';
                $doctorLayout = '';
            }
            $data = (new DataExtract()) -> getListWhere($db, 'btsProject_Appointment', $_SESSION['idUser'], $idUserType, "");
            // if ($_SESSION['role'] == 'patient'){
            //     $doctor = (new DataExtract()) -> getRowWhere($db, 'btsProject_User', ['idUser', $data['idDoctor']], "");
            // } else if ($_SESSION['role'] == 'doctor'){
            //     $patient = (new DataExtract()) -> getRowWhere($db, 'btsProject_User', ['idUser', $data['idPatient']], "");
            // }
        }
        include 'template/AppointmentPageTemplate.php';
    }
    function create($postData){
        $db = new DatabaseConnection();
        $array = array(
            array('idDoctor', $postData['idDoctor']),
            array('idPatient', $postData['idPatient']),
            array('dateAppointment', $postData['dateAppointment']),
            array('timeAppointment', $postData['timeAppointment']),
            array('reason', $postData['reason']) 
        );
        //echo var_dump($array);
        //die();
        (new DataInsert()) -> insertInTable($db, 'btsProject_Appointment', $array);
        header('Refresh:0; url=index.php?page=appointment');
    }
    function updateStatus($postData){
        //echo 'test';
        $db = new DatabaseConnection();
        $array = array(
            array('status', $postData['status'])
        );
        (new UpdateItem()) -> updateItem($db, "btsProject_Appointment", $postData['idAppointment'], 'idAppointment', $array);
        //die('test');
        header("Refresh:0; url=index.php?page=appointment");
    }
}

?>