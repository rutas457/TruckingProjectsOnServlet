<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>Login</title>
    <link rel="stylesheet" href="/assets/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/assets/fonts/ionicons.min.css">
    <link rel="stylesheet" href="/assets/css/Login-Form-Dark.css">
    <link rel="stylesheet" href="/assets/css/styles.css">
</head>

<body>
<div class="login-dark">
    <form method="post" action="/api/login">
        <h2 class="sr-only">Login Form</h2>
        <div class="illustration"><i class="icon ion-ios-locked-outline"></i></div>
        <div class="form-group"><input class="form-control" type="email" name="email" placeholder="Email"></div>
        <div class="form-group"><input class="form-control" type="password" name="pass" placeholder="Password"></div>
        <div class="form-group">
            <button class="btn btn-primary btn-block" type="submit">Log In</button>
        </div>
        <a href="/api/register" class="forgot">Create an account</a></form>
</div>
<script src="/assets/js/jquery.min.js"></script>
<script src="/assets/bootstrap/js/bootstrap.min.js"></script>
</body>

</html>