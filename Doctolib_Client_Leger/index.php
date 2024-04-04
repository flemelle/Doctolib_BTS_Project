<?php 
session_start();
require_once('src/controllers/ConnectionPage.php');
require_once('src/controllers/HomePage.php');
require_once('src/controllers/DoctorPage.php');
require_once('src/controllers/PatientPage.php');
require_once('src/controllers/AccountPage.php');
require_once('src/controllers/PrescriptionPage.php');
require_once('src/controllers/AppointmentPage.php');
require_once('src/controllers/ErrorPage.php');
require_once('src/controllers/DisconnectionAction.php');
require_once('src/controllers/UserProcessing.php');
use Application\Controllers\Connection\Connection;
use Application\Controllers\Home\Home;
use Application\Controllers\Doctors\Doctors;
use Application\Controllers\Patients\Patients;
use Application\Controllers\Account\Account;
use Application\Controllers\Prescription\Prescription;
use Application\Controllers\Appointement\Appointement;
use Application\Controllers\Error\Error;
use Application\Controllers\Disconnection\Disconnection;
use Application\Controllers\User\User;

try
{    
    if ((!isset($_SESSION['connected']))){
        if (isset($_POST['connection'])){
            (new Connection()) -> start($_POST);
        }else{
            (new Connection()) -> page();
        }
    }
    else if (($_SESSION['connected']) == 'on'){
        //echo 'session on, ';
        if (!empty($_GET)){
            //echo 'get';
            if (isset($_GET['page'])){
                switch ($_GET["page"]){
                    case "doctor":
                        if (isset($_GET['action'])){
                            switch ($_GET["action"]){
                                case "update":
                                    (new User()) -> editionLayout($_GET);
                                    break;
                                case "saveUpdates":
                                    echo 'saveUpdates';
                                    (new User()) -> updateUser($_GET);
                                    break;
                                case "delete":
                                    // echo var_dump($_GET);
                                    // die;
                                    (new User()) -> delete($_GET);
                                    break;
                                default :
                                    (new Doctors()) -> dataLoading("");
                                }
                            }
                        else if (isset ($_GET["sortBy"])){
                        (new Doctors()) -> dataLoading($_GET["sortBy"]);
                        }else {
                            (new Doctors()) -> dataLoading("");
                        }
                        break;
                    case "patient":
                        if (isset($_GET['action'])){
                            switch ($_GET["action"]){
                                case "update":
                                    (new User()) -> editionLayout($_GET);
                                    break;
                                case "saveUpdates":
                                    echo 'saveUpdates';
                                    (new User()) -> updateUser($_GET);
                                    break;
                                case "delete":
                                    (new User()) -> delete($_GET);
                                    break;
                                case "sortBy":
                                    (new Patients()) -> dataLoading($_GET["sortBy"]);
                                    break;
                                default :
                                    (new Patients()) -> dataLoading("");
                                }
                            break;
                        }
                        else if (isset ($_GET["sortBy"])){
                        (new Patients()) -> dataLoading($_GET["sortBy"]);}
                        else {
                            (new Patients()) -> dataLoading("");
                        }
                        break;
                    case "prescription":
                        (new Prescription()) -> page();
                        break;
                    case "account":
                        if (isset($_GET['action'])){
                            switch ($_GET["action"]){
                                case "update":
                                    (new Account()) -> editionLayout();
                                    break;
                                case "saveUpdates":
                                    echo 'saveUpdates';
                                    (new Account()) -> updateAccount($_POST);
                                    break;
                                default :
                                    (new Account()) -> dataLoading();
                            }
                        }else {
                            (new Account()) -> dataLoading();
                        }
                        break;
                    case "appointment":
                        if (isset($_GET['action'])){
                            switch ($_GET["action"]){
                                case "updateStatus":
                                    echo 'saveUpdates';
                                    (new Appointement()) -> updateStatus($_GET);
                                    break;
                                default :
                                (new Appointement()) -> page();
                                }
                            break;
                        } else {
                            (new Appointement()) -> page();
                        }
                        break;
                    case "homePage":
                        (new Home()) -> page();
                        break;
                    default :
                        (new Home()) -> page();
                }
            }
            else {
                (new Error()) -> page('Page non existante');
            }
        } 
        else if (!empty($_POST)){
            //echo'post, ';
            switch ($_POST['formName']){
                case "Sauvegarder":
                    //Saving of the new account's informations
                    //echo 'Sauvegarde, ';
                    (new Account()) -> updateAccount($_POST);
                    break;
                case "Deconnexion":
                    //Disconnection
                    //echo 'Disconnexion, ';
                    (new Disconnection()) -> disconnect();
                    break;
                case "Modifier":
                    //Password's modification
                    break;
                case "Confirmer":
                    //Appointement taking
                    (new Appointement()) -> create($_POST);
                    break;  
                case "Valider":
                    //Prescription giving
                    (new Prescription()) -> create($_POST);
                    break;    
                default:
                    (new Error()) -> page('Erreur lors de la requête');
                    echo var_dump($_POST);
            }
        } else {
            (new Home()) -> page();
        }
    }
    else {
        (new Error()) -> page('Sortie de la structure de la page');
    }
}
catch (Exception $e){
    echo $e -> getMessage();
}
?>
