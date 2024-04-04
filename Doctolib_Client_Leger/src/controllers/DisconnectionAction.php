<?php
namespace Application\Controllers\Disconnection;
//echo 'Disconnection process is working, ';
class Disconnection{
    function disconnect(){
        echo 'Disconnection.disconnect is running, ';
        session_destroy();
        header("Refresh:0");
    }
    function test(){
        echo 'test';
    }
}
?>