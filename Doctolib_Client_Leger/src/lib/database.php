<?php

namespace Application\Lib\Database;

//echo 'database.php is running ';
class DatabaseConnection {
    public ?\PDO $database = null;
    public function getConnection(): \PDO
    {
        //echo 'DatabaseConnection\getConnection is running, ';
        if ($this -> database === null)
        {
            $this -> database = new \PDO('mysql:host=korradr1.mysql.db;dbname=korradr1;charset=utf8', 'korradr1', 'oP9x8DFTGff36B55hTKD');
        }
        return $this -> database;
    }
}
?>
