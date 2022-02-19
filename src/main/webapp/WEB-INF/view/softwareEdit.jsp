<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<title>Update Book</title>
<body>
    <div class="form">
	<h1>Update Book</h1>
	<form method="POST" name="update" action="updatesw">
		<table>
			<input name="swID" type = "hidden" value="${softwares.swID}"/> 
			<tr>
				<td>Software Name:</td>
				<td><input name="swName" value="${softwares.swName}" type="text" /></td>
			</tr>
			<tr>
				<td>Software Version:</td>
				<td><input name="swVersion" step="0.01" min="0.1" value="${softwares.swVersion}" type="number" /></td>
			</tr>
			<tr>
				<td>Software Description</td>
				<td><textarea name="swDescription" rows="4" cols="50">${softwares.swDescription}</textarea></td>
			</tr>
			<tr>
				<td></td>
				<td><input class="button" value="Update" type="submit" /></td>
			</tr>
		</table>
	</form>
	</div>
</body>

<style>

	body{
	   background-size: cover;
    	height: 100vh;
    	font-size: 15px;
   		font-family: 'Roboto', sans-serif;
	}
	
	h1{
	    color: black;
	    font-size: 30px;
		font-weight: normal;
	}

	.form{
		position: absolute;
		top: 45%;
		transform: translate(0, -50%);
		width: 500px;  
		overflow: hidden;  
		margin: auto;  
		margin: 20 0 0 450px;  
		padding: 30px;  
		background: #A1867F;  
		border-radius: 15px;
		color: black;
		opacity: 0.9;
		 
	}
	
	input{
		width: 300px;
		padding: 10px;
	}
	
	.button{
		text-align: center;
		width: 100px;
		height: 40px;
		border-radius: 8px;
		display: inline;
		border: 0;
		background: #E9190F;
		color: white;
	}
	
	.button:hover{
	    background: #FF5A5F;
	    color: white;
	}
</style>

</html>