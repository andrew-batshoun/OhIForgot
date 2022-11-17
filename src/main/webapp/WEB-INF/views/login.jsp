<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<!DOCTYPE html>
<html>
<head>
<tag:head/>
    <meta charset="UTF-8"/>
    <title>Log In</title>
    <style>


        .form-signin {
            width: 100%;
            max-width: 330px;
            padding: 15px;
            margin: 10em auto;
        }
        .form-signin .checkbox {
            font-weight: 400;
        }
        .form-signin .form-control {
            position: relative;
            box-sizing: border-box;
            height: auto;
            padding: 10px;
            font-size: 16px;
        }
        .form-signin .form-control:focus {
            z-index: 2;
        }
        .form-signin input[type="email"] {
            margin-bottom: -1px;
            border-bottom-right-radius: 0;
            border-bottom-left-radius: 0;
        }
        .form-signin input[type="password"] {
            margin-bottom: 10px;
            border-top-left-radius: 0;
            border-top-right-radius: 0;
        }

    </style>
</head>
<body>

<div class="text-center">
    <form class="form-signin" action="/" method="POST">
        <h1 class="h3 mb-3 font-weight-normal">Please sign in</h1>
        <label for="username" class="sr-only">Username</label>
        <input id="username" name="username" type="text" class="form-control" placeholder="Username" required autofocus/>
        <label for="password" class="sr-only">Password</label>
        <input id="password" name="password" type="password" class="form-control" placeholder="Password" required/>
        <button class="btn btn-lg btn-info btn-block" type="submit">Sign in</button>
        <div style="color: red">${error}</div>
    </form>
</div>


<tag:footer></tag:footer>
</body>
</html>