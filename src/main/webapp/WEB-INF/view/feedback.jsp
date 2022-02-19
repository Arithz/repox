<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Document</title>

<style><%@include file ="/WEB-INF/css/main.css"%></style>
</head>

<style>
body {
	background-color: rgb(238, 238, 238);
}

textarea {
	appearance: none;
	border: none;
	resize: vertical;
	outline: none;
	white-space: normal;
	-moz-text-align-last: center; /* Firefox 12+ */
	text-align-last: center;
}
</style>

<body>

	<div class="createfeedback">
		<form method="POST" action="saveFeedback">
			<textarea rows="3">Write your feedback for the system...</textarea>
			<input type = "submit" id = "btnsubmit">
		</form>
	</div>
	<div class="feedback-container">

		<c:forEach items="${listfeedback}" var="item" varStatus="status">
			<div class="feedback">
				<div class="header">Username: ${listusername[status.index]}</div>
				<div>
					<p>${item.feedbackDetails}</p>
				</div>
			</div>
		</c:forEach>
	</div>
</body>
</html>