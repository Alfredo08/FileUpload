<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Image Uploader</title>
		<link href="/css/style.css"  rel="stylesheet"/>
	</head>
	<body>
		<h1>
			Welcome to the image uploader app
		</h1>
		<form action="/images/new" method="POST" enctype="multipart/form-data"> 
			<label for="newImage"> Select your image: </label>
			<input type="file" id="newImage" name="newImage" accept="image/png, image/jpeg"/>
			<button type="submit">
				Add image
			</button>
		</form>
		<h2>
			Uploaded images so far
		</h2>
		<div>
			<c:forEach var="image" items="${imageList}">
				<div>
					<img src="<c:out value="${image.getImage_path()}"></c:out>" />
				</div>
			</c:forEach>
		</div>
	</body>
</html>