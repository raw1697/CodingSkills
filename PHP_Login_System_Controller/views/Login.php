<html>
<head>
</head>
<body>

<?php if (isset($_SESSION['success'])) {?>
<div class="alret alret-success"> <?php echo $_SESSION['success']; ?></div>
<?php
}?>

<div class="container">
<div class="row">
<div class="col-md-4 col-md-offset-4 well">
<form role="form" action="doLogin" method="post" name="loginform">
<fieldset>
<legend>Login</legend>
<div class="form-group">
<label for="name">Username</label>
<input type="text" name="username" placeholder="Your Username" required class="form-control" />
</div>

<div class="form-group">
<label for="name">Password</label>
<input type="password" name="password" placeholder="Your Password" required class="form-control" />       
</div>

<div class="form-group">
<input type="submit" name="submit" value="Login" class="btn btn-primary" />
</div>
</fieldset>
</form>
<span class="text-danger"><?php if (isset($errormsg)) { echo $errormsg; } ?></span>
</div>
</div>
</body>
</html>
