<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="/docs/4.0/assets/img/favicons/favicon.ico">

<title>Users List</title>

<!-- Bootstrap core CSS -->
<link
	href="https://getbootstrap.com/docs/4.0/dist/css/bootstrap.min.css"
	rel="stylesheet">


</head>

<body>

	<jsp:include page="nav.jsp" />
	<main role="main">

		<div class="container" style="margin-top:100px">
			<table class="table">
				<thead>
					<tr>
						<th scope="col">#</th>
						<th scope="col">User ID</th>
						<th scope="col">Name</th>
						<th scope="col">Email</th>
						<th scope="col">Created At</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="user" items="${userList}" varStatus="loop">
					<tr>
						<th scope="row">${loop.index+1}</th>
						<td>${user.userId}</td>
						<td>${user.firstName} ${user.lastName}</td>
						<td>${user.email}</td>
						<td>${user.createdAt}</td>
					</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>

	</main>

	<footer class="container">
		<p>&copy; Company 2017-2018</p>
	</footer>

</body>
</html>
