<html lang="en">
<head>
<title>Practice 3</title>
    <link rel="stylesheet" href="style.css" type="text/css"/>
</head>
<body>
<h1>Table of products</h1>
<table>
    <tr><th>ID</th><th>Names</th><th>Prices</th></tr>

    <a href="/insert.php">CREATE</a>
    <br>
    <a href="/read.php">READ</a>
    <br>
    <a href="/update.php">UPDATE</a>
    <br>
    <a href="/delete.php">DELETE</a>
<?php
$mysqli = new mysqli("db", 'user', "password", "appDB");

$result = $mysqli->query("SELECT * FROM products");

foreach ($result as $row) {
    echo "<tr>
        <td>{$row['id']}</td>
        <td>{$row['name']}</td>
        <td>{$row['price']}</td>
        </tr>";
}

$result2 = $mysqli->query("SELECT * FROM reviews");

foreach ($result2 as $row) {
    echo "<tr>
    <td>{$row['id']}</td>
    <td>{$row['author']}</td>
    <td>{$row['content']}</td>
    <td>{$row['product_id']}</td>
    </tr>";
}

$mysqli->close();
?>
</table>
</body>
</html>