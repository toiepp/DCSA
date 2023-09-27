<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>READ</title>
</head>
<body>
<form method="POST">
        <input type="text" placeholder="ID" required="false" name="id">
        <br>
        <button type="submit" name="submit">FIND</button>
    </form>
    <br><br>
<?php 
if(isset($_POST['submit'])) {
    $id=$_POST['id'];

    $mysqli = new mysqli("db", "user", "password", "appDB");

    $query = $mysqli->query("SELECT * FROM products WHERE id=$id");

    foreach ($query as $row) {
        echo "<tr>
        <td>ID:    {$row['id']},</td>
        <td>Name:  {$row['name']},</td>
        <td>Price: {$row['price']}</td>
        </tr>";
    }
    mysqli_close($mysqli);
}
?>
</body>
</html>