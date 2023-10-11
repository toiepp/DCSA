<?php 
include("../config.php");

global $entity;

$get_all_option = 0;
$id = isset($_GET["id"]) ? intval($_GET["id"]) : $get_all_option;

$result = null;

if ($id == $get_all_option) {
    $request = $mysqli->query("SELECT * FROM $entity WHERE id");
    $result = $request->fetch_all(MYSQLI_ASSOC);
} else {
    $request = $mysqli->query("SELECT * FROM $entity WHERE id=$id");
    $result = $request->fetch_assoc();
}

echo json_encode($result);

?>