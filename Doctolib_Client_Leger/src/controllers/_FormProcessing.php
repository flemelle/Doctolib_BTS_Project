<?php
namespace Application\Controllers\FormProcessing;
session_start();
include('DisconnectionAction.php');
include('ErrorPage.php');
include('ConnectionPage.php');
include('AccountPage.php');
use Application\Controllers\Account\Account;
use Application\Controllers\Disconnection\Disconnection;
use Application\Controllers\Connection\Connection;
use Application\Controllers\Error\Error;
// echo var_dump($_POST);
//echo 'FormProcessing is working ';
switch ($_POST['formName']){
    case "Sauvegarder":
        //Saving of the new account's informations
        echo 'Sauvegarde, ';
        (new Account()) -> updateAccount($_POST);
        break;
    case "Se connecter":
        //Prescription giving
        echo 'Connexion, ';
        (new Connection())-> start($_POST);
        break; 
    case "Deconnexion":
        //Disconnection
        echo 'Disconnexion, ';
        (new Disconnection()) -> disconnect();
        break;
    case "Modifier":
        //Password's modification
        break;
    case "Confirmer":
        //Appointement taking
        break;  
    case "Valider":
        //Prescription giving
        break;    
    default:
        (new Error()) -> page('Erreur lors de la requête');
}
?>