<nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
	<a class="navbar-brand" href="#">CMS Portal</a>
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarsExampleDefault"
		aria-controls="navbarsExampleDefault" aria-expanded="false"
		aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>
	
	<% String requestURI = request.getAttribute("javax.servlet.forward.request_uri").toString(); %>

	<div class="collapse navbar-collapse" id="navbarsExampleDefault">
		<ul class="navbar-nav mr-auto">
			<li class="nav-item <%=requestURI.contains("movies") ? "active" : ""%>"><a class="nav-link" href="${pageContext.request.contextPath}/movies">Movies</a></li>
			<li class="nav-item <%=requestURI.contains("users") ? "active" : ""%>"><a class="nav-link" href="${pageContext.request.contextPath}/users">Users</a></li>
			<li class="nav-item <%=requestURI.contains("subscriptions") ? "active" : ""%>"><a class="nav-link" href="${pageContext.request.contextPath}/subscriptions">Subscriptions</a></li>
			<li class="nav-item <%=requestURI.contains("payments") ? "active" : ""%>"><a class="nav-link" href="${pageContext.request.contextPath}/payments">Payments</a></li>
		</ul>
		<form class="form-inline my-2 my-lg-0">
			<input class="form-control mr-sm-2" type="text" placeholder="Search"
				aria-label="Search">
			<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
		</form>
		<div><a style="display:inline; text-align: right;" class="nav-link" href="logout">Logout</a></div>
	</div>
</nav>

<div class="loader-div">
		<div class="loader"></div>
	</div>