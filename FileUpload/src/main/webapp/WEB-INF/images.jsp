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
			<input type="file" id="newImage" name="newImage" accept="image/png, image/jpeg" />
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
					<button id="${image.getImage_id()}" class="deleteImage" >
						Delete
					</button>
				</div>
			</c:forEach>
		</div>
		<div class="modalContainer hidden">
			<div class="modal">
				<form method="POST" action="/images/delete">
					<h2 class="modalHeading"> You are about to delete the following image: </h2>
					<img class="modalImage" src=""/>
					<input type="hidden" name="_method" value="delete">
					<input type="hidden" name="imageId" id="imageId"/>
					<input type="hidden" name="imageName" id="imageName"/>
					<div>
						<button class="modalSubmit" type="submit">
							Delete
						</button>
						<button class="modalCancel" type="button">
							Cancel
						</button>
					</div>
				</form>
			</div>
		</div>
		<script type="text/javascript" src="/js/images.js"></script>
	</body>
</html>