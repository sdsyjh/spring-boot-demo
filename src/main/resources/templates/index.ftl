<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="/order" method="post">
	<input type="text" name="id"/><br/>
	<input type="text" name="name"/><br/>
	<input type="text" name="lastOrder.id"/><br/>
	<input type="text" name="lastOrder.name"/><br/>
	<input type="text" name="lastOrder.address"/><br/>
	<input type="submit"/>
	<input type="reset"/><br/>
</form>
show:${message}
</body>
</html>