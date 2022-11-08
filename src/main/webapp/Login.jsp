<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="Login" method="post">
		<h1>Login</h1>
		<table>
			
			<tr>
				<td><p>Username : </p></td>
				<td><input type="text" name="username" /></td>
			</tr>
			
			<tr>
				<td><p>Password : </p></td>
				<td><input type="text" name="password" /></td>
			</tr>			
			<tr>
				<td><p>UserType : </p></td>
				<td>
				<select name="usertype">
					<option value="admin">Admin</option>
					<option value="consumer">Consumer</option>
				</select>
				</td>
			</tr>
			
			<tr>
				<td></td>
				<td><input type="submit" value="Login" /></td>
			</tr>			
		</table>
	
	</form>
</body>
</html>