

<html>
<head>
	<style>
table { 
    display: table;
    border-collapse: separate;
    border-spacing: 5px;
    border-color: red;
    
}

body {
	background-image: url("https://www.thinkinglifter.com/wp-content/uploads/2014/11/worldwide-connection-background-ipad-wacom-abstract-images-cool-white-background.jpg");
	position: fixed;
}
div#container {
	border-color: black;
	background-color: white;
	position: fixed;
	width: 500px;
	height: 200px;
	top: 50%;
	left: 50%;
	margin-top: -100px; /* Negative half of height. */
	margin-left: -250px; /* Negative half of width. */
}

</style>
       <center><title>MY MY MY</title></center> 
</head>
<body>
	<div id="container">
        <center><h1>Welcome its Romel!!!!</h1></center>

<center><table border="1">
		<tr>
			<th>ID</th>
			<th>Username</th>
			<th>Post</th>
		</tr>
		

				<tr>
				<td><?php echo $row->id; ?></td>
				<td><?php echo $row->user_username; ?></td>
				<td><?php echo $row->text; ?></td>
			</tr> 

</table>
</center>
</div>
</body>
</html>