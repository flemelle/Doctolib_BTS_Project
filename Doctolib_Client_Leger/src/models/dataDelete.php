<?php
namespace Application\Models\DataDelete;

//echo 'DataExtraction is running ';
class DeleteItem
{    
    public function deleteItemWhere($db, $table, $id, $idTitle){
        try {
            $rqt = $db -> getConnection() -> prepare("DELETE FROM $table WHERE $idTitle = $id");
            // echo var_dump($rqt);
            // die();
            $rqt -> execute();
        } catch(\PDOException $e) {
            echo $e->getMessage();
        }
    }
}