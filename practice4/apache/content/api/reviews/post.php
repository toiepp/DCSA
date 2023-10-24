<?php 
include("../config.php");

global $mysqli;

$review = json_decode(file_get_contents('php://input'), false);

$instruction = null;

if (isset($review->id)) {

    $persisted_review = $mysqli->query("SELECT * FROM reviews WHERE id={$review->id}")->fetch_assoc();

    $instruction = "REPLACE INTO reviews (id, author, content, product_id)
            VALUE ({$persisted_review['id']},
            '{$persisted_review['author']}',
            '{$review->content}',
            {$persisted_review['product_id']})";

} else { // if you want to insert new entity =====OK=====
    $instruction = "INSERT INTO reviews (" .
        (isset($review->id) ? "id," : "") .
        "author, content, product_id) VALUES (" . 
        (isset($review->id) ? $review->id . ", " : "") .
        "'$review->author', '$review->content', $review->product_id)";
}

$query = $mysqli->query($instruction);

if ((int)$query == TRUE) {
    echo json_encode($mysqli->query("SELECT * FROM reviews WHERE id={$mysqli->insert_id}")->fetch_assoc());
} else {
    echo json_encode([
        "message" => "Something went wrong",
        "code" => "400 HTTP Bad Request"
    ]);
}

?>