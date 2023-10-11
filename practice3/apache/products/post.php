<?php 
include("../config.php");

global $mysqli;

$product = json_decode(file_get_contents('php://input'), false);

$instruction = null;

if (isset($product->id)) {
    $instruction = "REPLACE INTO $entity (id, name, price) " .
        "VALUE ($product->id, '$product->name', $product->price)";
} else {
    $instruction = "INSERT INTO $entity (" .
        (isset($product->id) ? "id," : "") .
        "name, price) VALUES (" . 
        (isset($product->id) ? $product->id . ", " : "") .
        "'$product->name', $product->price)";
}

$query = $mysqli->query($instruction);

if ((int)$query == TRUE) {
    echo json_encode($mysqli->query("SELECT * FROM $entity WHERE id={$mysqli->insert_id}")->fetch_assoc());
} else {
    echo json_encode([
        "message" => "Something went wrong",
        "code" => "400 HTTP Bad Request"
    ]);
}

?>