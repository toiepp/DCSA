<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Document</title>
</head>
<body>
<?php 
//Database Connection
if(isset($_POST['submit'])) {
    $id=$_GET['id'];

    $name=$_POST['name'];
    $price=$_POST['price'];
    
    $con = new mysqli("db", 'user', "password", "appDB");
    $query=mysqli_query($con, "update products set name='$name', price='$price' where id='$id'");
}
?>
<form  method="POST">
<?php
$id=$_GET['id'];
$con = new mysqli("db", 'user', "password", "appDB");
$ret=mysqli_query($con,"select * from products where id='$id'");
while ($row=mysqli_fetch_array($ret)) {
?>
    <input type="text" name="name" value="<?php  echo $row['name'];?>" required="true">
    <input type="text" name="price" value="<?php  echo $row['price'];?>" required="true">
<?php 
}
mysqli_close($con);
?>
<button type="submit" name="submit">UPDATE</button>
</body>
</html>