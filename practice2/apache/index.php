<html lang="en">
<head>
<title>Practice 2</title>
    <link rel="stylesheet" href="style.css" type="text/css"/>
</head>
<body>
<h1>Table of products</h1>
<table>
    <tr><th>ID</th><th>Name</th><th>Price</th></tr>
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
mysqli_close($mysqli);
?>
</table>
<?php
phpinfo();
?>
</body>
</html>
