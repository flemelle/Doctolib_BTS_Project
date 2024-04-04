<?php
namespace Application\Controllers\User;
require_once('src/models/dataExtract.php');
require_once('src/models/dataUpdate.php');
require_once('src/models/dataDelete.php');
require_once('src/lib/database.php');
use Application\Models\DataExtract\DataExtract;
use Application\Models\DataUpdate\UpdateItem;
use Application\Lib\Database\DatabaseConnection;
use Application\Models\DataDelete\DeleteItem;

class User{
    public $edition = false;
    public $editInput;
    public $submitHidden;
    public $mofidyButton;
    public $data;
    public $page;
    function editionLayout($info){
        $title = 'Modification de l\'utilisateur';
        $db = new DatabaseConnection();
        $rawData = (new DataExtract()) -> getRowWhere($db, "btsProject_User", ["idUser", $info['idUser']], "");
        $data = $rawData[0];
        $this -> edition = true;
        $this -> editInput = "";
        $this -> submitHidden = "visible";
        $this -> mofidyButton = "hidden";
        $this -> page = $info['page'];
        include 'template/UserPageTemplate.php';
    }
    function updateUser($postData){
        //echo 'test';
        $db = new DatabaseConnection();
        $array = array(
            array('firstName', $postData['firstName']),
            array('lastName', $postData['lastName']),
            array('age', $postData['age']),
            array('mail', $postData['mail']),
            array('address', $postData['address']),
            array('role', $postData['role'])
        );

        $this -> page = $postData['page'];
        (new UpdateItem()) -> updateItem($db, "btsProject_User", $postData['idUser'], 'idUser', $array);
        $this -> edition = false;
        echo  $postData['page'];
        //die('test');
        header("Refresh:0; url=index.php?page=".$postData['page']);
    }
    function delete($postData){
        //echo 'test';
        $db = new DatabaseConnection();
        $array = array('idUser', $postData['idUser']);
        // echo var_dump($postData);
        // echo var_dump($array);
        (new DeleteItem()) -> deleteItemWhere($db, "btsProject_User", $array[1], $array[0]);
        //die('test');
        header("Refresh:0; url=index.php?page=".$postData['page']);
    }
    function sortBy($postData){
        //echo 'test';
        $db = new DatabaseConnection();
        $this -> page = $postData['page'];
        $rawData = (new DataExtract()) -> getRowWhere($db, "btsProject_User", ["idUser", $postData['idUser']], $postData['sortField']);
        $this -> edition = false;
        echo  $postData['page'];
        //die('test');
        header("Refresh:0; url=index.php?page=".$postData['page']);
    }
}

?>