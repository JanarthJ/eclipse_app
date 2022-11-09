<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ page import = "java.util.*" %>
<meta charset="UTF-8">
<title>Dashboard</title>
<style>
.mainDiv{
	display: grid !important;
    grid-template-columns: 5fr 5fr;
    grid-gap: 20px;
}
</style>
<script>
	function idSetter(id){
		alert("function called",id);
		console.log(id);		
	}
</script>
</head>
<body>
	<div class="mainDiv">
    	<table class="tb-regist" id="eeMsg">
        <thead>
            <tr>
            	<th>Name</th>
                <th>Username</th>
                <th>Unit</th>
                <th>DueDate</th>
                <th>Amount</th>
                <th></th>
            </tr>
        </thead>
        <tbody>
        	<% ArrayList arr = (ArrayList) session.getAttribute("UserDetails");
        		System.out.println("jsp");
				for(int i = 0; i < arr.size(); i++)
				{
					ArrayList arrs = (ArrayList)arr.get(i);
					System.out.println(arr.get(i));
				
				%>
	        	<tr>
	
	            <% for (int j = 0; j < arrs.size(); j++) {
	               // This RHS made up due to not knowing the class of objects
	               // in your map, use something equivalent
	               Object cell = arrs.get(j); 
	            %>
	            <td>
	                <center id="val">
	                   <%=cell.toString()%>
	                </center>
	            </td>
	            <% } %>	            
       		 </tr>
        	<% } %>
        </tbody>
    	</table>
    	<form action="Landing" method="post">
			<h1>Update Bill</h1>
			<table>
				
				<tr>
					<td><p>Username : </p></td>
					<td><input id="uid" type="text" name="username" placeholder="Enter username"/></td>
				</tr>
				
				<tr>
					<td><p>Unit : </p></td>
					<td><input id="unit" type="text" name="unit" placeholder="100"/></td>
				</tr>			
				<tr>
					<td><p>DueDate : </p></td>
					<td>
					<input  type="text" name="duedate" placeholder="12/11/2022" />
					</td>
				</tr>
				
				<tr>
					<td></td>
					<td><input type="submit" value="Update" /></td>
				</tr>			
			</table>
	
		</form>
	   
</div>
</body>
</html>