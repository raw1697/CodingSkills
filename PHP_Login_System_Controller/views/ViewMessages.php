


<html>
<head>
	<style>
table { 
    display: table;
    border-collapse: separate;
    border-spacing: 1px;
    border-color: black;
    
}

body  {
    background-image: url("paper.gif");
    background-color: #cccccc;
}

</style>
       <center><title>MY MY MY</title></center> 
</head>
<body>
	<div id="container">
        <center><h1>Welcome its Romel!!!!</h1></center>
		<a href="<?php echo (site_url('user/login')); ?>">Logout</a>
		
		<?php foreach($results as $row)
		{ ?>
			
			<center><table border="1">
			<tr>
			<th><?php echo $row['id']; ?></th>
			<th><?php echo $row['user_username']; ?></th>
			<th><?php echo $row['text']; ?></th>
			<th><?php echo $row['posted_at']; ?></th>
			</tr>
			</table>
		<?php } ?>

</table>
</center>
</div>
</body>
</html>