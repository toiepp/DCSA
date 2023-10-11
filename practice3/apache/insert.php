<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>INSERT</title>
</head>
<body>
    <form method="POST">
        <input type="text" placeholder="NAME" required="true" name="name">
        <br>
        <input type="text" placeholder="PRICE" required="true" name="price">
        <br>
        <button type="submit" name="submit">Insert</button>
    </form>
<?php 
if(isset($_POST['submit'])) {
    $name=$_POST['name'];
    $price=$_POST['price'];

    $mysqli = new mysqli("db", "user", "password", "appDB");

    $query = $mysqli->query("INSERT INTO products(name, price) VALUES ('$name', $price)");

    if ($query) {
        echo "<script>alert('You have successfully inserted the data');</script>";
        echo "<script type='text/javascript'> document.location ='index.php'; </script>";
    } else {
        echo "<script>alert('Something Went Wrong. Please try again');</script>";
    }

    mysqli_close($mysqli);
}
?>
</body>
</html>