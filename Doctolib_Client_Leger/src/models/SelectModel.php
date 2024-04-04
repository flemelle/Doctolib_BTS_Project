<?php
namespace Application\Models\SelectModel;
//echo 'SelectModel';
class SelectModel
{  
    function fetchDataItem($rqt){
        $rqt -> execute();
        $data = $rqt -> fetch();
        return $data;
    }
    function FetchDataList($rqt){
        $rqt -> execute();
        $data = $rqt -> fetchAll();
        return $data;
    }
    function sortBy($field){
        if ($field == null){
            return "";
        }
        else if ($field != null){
            $requestOrder = " ORDER BY " . $field;
            return $requestOrder;
        }
    }
}