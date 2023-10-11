<?php 
include("config.php");

global $entity;

if (isset($_GET['id'])) {
    $id = intval($_GET['id']);

    $deleted_entity = $mysqli->query("SELECT * FROM $entity WHERE id=$id")->fetch_assoc();

    if (!$deleted_entity) {
        echo json_encode([
            'message' => 'Nothing had been deleted',
            'code' => '400 HTTP Bad Request'
        ]);
    } else {
        $query = $mysqli->query("DELETE FROM $entity WHERE id=$id");
        echo json_encode($deleted_entity);
    }

} else {
    echo json_encode([
        'message' => 'Nothing had been deleted',
        'code' => '400 HTTP Bad Request'
    ]);
}

$mysqli->close();
?>