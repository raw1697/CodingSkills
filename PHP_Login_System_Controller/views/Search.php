<html>
<head>
<style>
</style>
</head>
<body>
<?php
if(!(isset($results))) {
	print('
<form action="http://raptor.kent.ac.uk/~ra466/ci/index.php/search/dosearch" method="get"> 
	<label>Messages:</label> <br/>
	<textarea type="text" name="text" placeholder="Search for Messages" ></textarea><br/>
	<button>Submit</button>
 </form>');
}
?>
 
</body>
</html>