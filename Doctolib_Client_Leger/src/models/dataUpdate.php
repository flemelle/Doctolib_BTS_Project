<?php
namespace Application\Models\DataUpdate;

class UpdateItem
{    
    function updateItem($db, $table, $id, $idTitle, $tab){
        try {
            $values = "";
            for ($i = 0; $i < count($tab); $i++){
                //echo count($tab);
                if ($i < count($tab)-1){
                    $values .= $tab[$i][0].' = "'.$tab[$i][1].'", ';
                }
                else {
                    $values .= $tab[$i][0].' = "'.$tab[$i][1].'"';
                }
            }
            $rqt = $db -> getConnection() -> prepare("UPDATE $table SET $values WHERE $idTitle = $id;");
            for ($i = 0; $i < count($tab); $i++){
                //$rqt -> bindparam($tab[$i][0], $tab[$i][1], \PDO::PARAM_STR);
            }
            //var_dump($rqt);
            //die();
            $rqt -> execute();
        } catch(\PDOException $e) {
            echo $e->getMessage();
        }
    }
    
}