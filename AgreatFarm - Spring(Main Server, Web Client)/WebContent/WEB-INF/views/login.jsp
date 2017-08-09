<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
	<meta charset="UTF-8">
    <title>Agreat Farm</title>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/prefixfree/1.0.7/prefixfree.min.js"></script>
    <script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
    <link rel="stylesheet" type="text/css" href="resources/css/login_form_style.css">
  </head>

  <body>
    <div class="body"></div>
  		<div class="grad"></div>
  		<div class="header">
  			<div>Agreat<span>Farm</span></div>
  		</div>
  		<br>
  		<div class="login">
  			<form action='login' method='post'>	
				<input type="text" placeholder="username" name="username"><br>
				<input type="password" placeholder="password" name="password"><br>
				<input type="submit" value="Login">
			</form>
  		</div>
  </body>
</html>
