<?php

namespace Application\Models\DataExtract;
require_once('SelectModel.php');
use Application\Models\SelectModel\SelectModel;

class DataExtract
{    
    function credentialVerification($tab, $db){
        $rqt = $db -> getConnection() -> prepare (
            "SELECT * FROM btsProject_User WHERE " . " mail = '" . $tab['mail']. "' and password = '" . $tab['password'] . "';");
        return (new SelectModel())->  FetchDataItem($rqt);
    }
    function getItemWhere($db, $item, $table, $where){
        $rqt = $db -> getConnection() -> prepare (
            "SELECT $item FROM $table WHERE " . $where[0] + " = " + $where[1] . ";");
        return (new SelectModel())-> FetchDataItem($rqt);
    }
    function getRowWhere($db, $table, $where){
        $rqt = $db -> getConnection() -> prepare (
            "SELECT * FROM $table WHERE " . $where[0] . " = " . $where[1] . ";");
        return (new SelectModel())-> FetchDataList($rqt);
    }
    function getList($db, $table, $field){
        $rqt = $db -> getConnection() -> prepare (
            "SELECT * FROM $table ". (new SelectModel())-> sortBy($field) .";");
        return (new SelectModel())-> FetchDataList($rqt);
    }
    function getListWhere($db, $table, $id, $idTitle, $field){
        $rqt = $db -> getConnection() -> prepare (
            "SELECT * FROM $table WHERE $idTitle" ." = ". $id . (new SelectModel())-> sortBy($field) .";");
            // echo (
            //     "SELECT * FROM $table WHERE $idTitle" ." = ". $id . (new SelectModel())-> sortBy($field) .";");
            //     die;
        return (new SelectModel())-> FetchDataList($rqt);
    }
}
?>