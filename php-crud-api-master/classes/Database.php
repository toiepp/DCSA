<?php
class Database
{
    private $db_host = 'db';
    private $db_name = 'appDB';
    private $db_username = 'user';
    private $db_password = 'password';
    function __construct()
    {
        try {
            $db_connection = new mysqli($this->db_host, $this->db_username, $this->db_password, $this->db_password);
            return $db_connection;
        } catch (PDOException $e) {
            echo "Connection error " . $e->getMessage();
            exit;
        }
    }
}