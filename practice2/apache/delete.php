<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>DELETE</title>
</head>
<body>
<?php 
if (isset($_GET['id'])) {
    $mysqli = new mysqli("db", 'user', "password", "appDB");

    $id = intval($_GET['id']);

    $query_code = "DELETE FROM products WHERE id=$id";

    echo "<pre>$query_code</pre>";
    
    $query = $mysqli->query($query_code);
    mysqli_close($mysqli);
}
?>
</body>
</html>