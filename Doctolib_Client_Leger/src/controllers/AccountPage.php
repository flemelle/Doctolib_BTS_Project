<?php
namespace Application\Controllers\Account;
require_once('src/models/dataExtract.php');
require_once('src/models/dataUpdate.php');
require_once('src/lib/database.php');
use Application\Models\DataExtract\DataExtract;
use Application\Models\DataUpdate\UpdateItem;
use Application\Lib\Database\DatabaseConnection;
//echo 'Account process is working, ';
class Account{
        public $edition = false;
        public $editInput;
        public $submitHidden;
        public $mofidyButton;
        public $data;
    function dataLoading(){
        $this -> edition = false;
        $this -> editInput = "readonly";
        $this -> submitHidden = "hidden";
        $this -> mofidyButton = "visible";
        $title = 'Compte';
        $db = new DatabaseConnection();
        $rawData = (new DataExtract()) -> getRowWhere($db, "btsProject_User", ["idUser", $_SESSION['idUser']]);
        $data = $rawData[0];
        include 'template/AccountPageTemplate.php';
    }
    function editionLayout(){
        $title = 'Modification du compte';
        $db = new DatabaseConnection();
        $rawData = (new DataExtract()) -> getRowWhere($db, "btsProject_User", ["idUser", $_SESSION['idUser']]);
        $data = $rawData[0];
        $this -> edition = true;
        $this -> editInput = "";
        $this -> submitHidden = "visible";
        $this -> mofidyButton = "hidden";
        include 'template/AccountPageTemplate.php';
    }
    function updateAccount($postData){
        //echo 'test';
        $db = new DatabaseConnection();
        $array = array(
            array('firstName', $postData['firstName']),
            array('lastName', $postData['lastName']),
            array('age', $postData['age']),
            array('mail', $postData['mail']),
            array('address', $postData['address'])
        );
        (new UpdateItem()) -> updateItem($db, "btsProject_User", $postData['idUser'], 'idUser', $array);
        $this -> edition = false;
        //die('test');
        header("Refresh:0; url=index.php?page=account");
    }
}
?>