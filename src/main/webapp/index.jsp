<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="Register" method="post">
		
		<table>
			<tr>
				<td><p>Name : </p></td>
				<td><input type="text" name="name" /></td>
			</tr>
			
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
				<td><input type="submit" value="Register" /></td>
			</tr>			
		</table>
	
	</form>
</body>
</html>