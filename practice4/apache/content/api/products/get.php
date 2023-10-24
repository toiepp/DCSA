<?php 
include("../config.php");

global $entity;

$id = isset($_GET["id"]) ? intval($_GET["id"]) : 0;

$result = null;

if ($id == 0) {
    $request = $mysqli->query("SELECT * FROM $entity WHERE id");
    $result = $request->fetch_all(MYSQLI_ASSOC);
} else {
    $request = $mysqli->query("SELECT * FROM $entity WHERE id=$id");
    $result = $request->fetch_assoc();
}

echo json_encode($result);

?>