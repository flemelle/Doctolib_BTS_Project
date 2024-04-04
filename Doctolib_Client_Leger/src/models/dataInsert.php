<?php
namespace Application\Models\DataInsert;

class DataInsert
{    
    function insertInTable($db, $table, $tab){
        try {
            $valuesField = "";
            for ($i = 0; $i < count($tab); $i++){
                //echo count($tab);
                if ($i < count($tab)-1){
                    $valuesField .= ''.$tab[$i][0].', ';
                }
                else {
                    $valuesField .= ''.$tab[$i][0];
                }
            }
            $values = "";
            for ($i = 0; $i < count($tab); $i++){
                //echo count($tab);
                if ($i < count($tab)-1){
                    $values .= '"'.$tab[$i][1].'", ';
                }
                else {
                    $values .= '"'.$tab[$i][1].'"';
                }
            }
            //echo $values;
            $rqt = $db -> getConnection()-> prepare("INSERT INTO $table ($valuesField) VALUES ($values);");
            for ($i = 0; $i < count($tab); $i++){
                //$rqt -> bindparam($tab[$i][0], $tab[$i][1]);
            }
            //var_dump($rqt);
            //die();
            $rqt -> execute();
        } catch(\PDOException $e) {
            echo $e->getMessage();
        }        
    }
}