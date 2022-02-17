<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>

<style>
	table {
		border: 1px solid #ccc;
		border-collapse: collapse;
		margin: 0;
		padding: 0;
		width: 100%;
		table-layout: auto;
	}
	
	table caption {
		font-size: 1.5em;
		margin: .5em 0 .75em;
	}
	
	table tr {
		background-color: #f8f8f8;
		border: 1px solid #ddd;
		padding: .35em;
	}
	
	table th, table td {
		padding: .625em;
		padding-left: 20px;
		text-align: left;
		font-family: bahnschrift;
		font-size: 16px;
		line-height: 25px;
	}
	
	table th {
		padding-top: 12px;
		padding-bottom: 12px;
		font-size: .85em;
		letter-spacing: .1em;
		text-transform: uppercase;
		background: #3b3b3b;
		color: white;
		font-family: bahnschrift !important;
	}
	
	@media screen and (max-width: 600px) {
	
		table {
	        border: 0;
	    }
	
	    table caption {
	        font-size: 1.3em;
	    }
	    
	    table thead {
	        border: none;
	        clip: rect(0 0 0 0);
	        height: 1px;
	        margin: -1px;
	        overflow: hidden;
	        padding: 0;
	        position: absolute;
	        width: 1px;
	    }
	    
	    table tr {
	        border-bottom: 3px solid #ddd;
	        display: block;
	        margin-bottom: .625em;
	    }
	    
	    table td {
	        border-bottom: 1px solid #ddd;
	        display: block;
	        font-size: .8em;
	        text-align: right !important;
	        font-family:bahnschrift;
	    }
	    
	    table td::before {
	        content: attr(data-label);
	        float: left;
	        font-weight: bold;
	        text-transform: uppercase;
	    }
	    
	    table td:last-child {
	        border-bottom: 0;
	    }
	}
</style>

<body>
	<h2>REQUESTS LIST</h2>
	<table>
		<thead>
			<tr>
				<th scope="col">Software Name</th>
				<th scope="col">Software Version</th>
				<th scope="col">Description</th>
				<th scope="col">Category</th>
				<th scope="col">Download Link</th>
			</tr>
		</thead>

		<tbody>
			<c:forEach items="${softwares}" var="item" varStatus="status">
				<tr>
					<td data-label="Software Name">${item.swName}</td>
					<td data-label="Software Version">${item.swVersion}</td>
					<td data-label="Description">${item.swDescription}</td>
					<td data-label="Category">${item.categoryID}</td>
					<td data-label="Download Link">
						<a href="data:application/zip;base64,${files[status.index]}" download = "${item.swName}.zip">Download link</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
		
	</table>

</body>
</html>