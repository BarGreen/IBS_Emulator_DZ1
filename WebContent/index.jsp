<%@page import="ru.appline.logic.Model" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Title</title>
</head>
<body>
	<h1>Домашняя страница</h1>
	Введите ID пользователя(0 - для вывода всего списка)
	<br>
	Доступно: <% Model model = Model.getInstance();
		out.print(model.getFromList().size()); 
		%>
	<form method="get" action="get">
		<label>ID:
			<input type="text" name="id"><br>
		</label>
		<button type="submit">Поиск</button>
	</form>
	<a href="addUser.html">Создать нового пользователя</a><br>
	<a href="putUser.html">Обновить данные пользователя</a><br>
	<a href="delUser.html">Удалить пользователя</a>
</body>
</html>