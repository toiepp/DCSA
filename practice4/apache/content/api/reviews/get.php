<?php 
include("../config.php");

$id = isset($_GET["id"]) ? intval($_GET["id"]) : 0;

$result = [];

if ($id == 0) {
    $request = $mysqli->query("SELECT * FROM `reviews`");

    foreach ($request as $row) {
        $join_request = $mysqli->query("SELECT * FROM products WHERE id={$row['product_id']}");

        $prod = $join_request->fetch_assoc();

        unset($row['product_id']);

        $row["product"] = $prod;

        array_push($result, $row);
    }

} else {
    $request = $mysqli->query("SELECT * FROM `reviews` WHERE id=$id");
    $result = $request->fetch_assoc();

    $join_request = $mysqli->query("SELECT * FROM products WHERE id={$result['product_id']}")->fetch_assoc();
    
    unset($result['product_id']);

    $result["product"] = $join_request;
}

echo json_encode($result);

?>