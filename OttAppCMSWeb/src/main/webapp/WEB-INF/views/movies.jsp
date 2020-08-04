<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>CMS OTT Movies List</title>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!-- Font Icon -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">

<link
	href="https://fonts.googleapis.com/css2?family=Roboto:wght@100;300,400&display=swap"
	rel="stylesheet">

<!-- Main css -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css">

<style type="text/css">
.movies {
	padding: 30px;
}

.container {
	width: auto;
}

.main {
	padding-top: 90px;
}
</style>
</head>
<body>
	<jsp:include page="nav.jsp" />
	<div class="main">
		<div class="container">
			<section class="movies">
				<div class="row" style="display: flow-root; margin-right: 0">
					<div class="float-right">
						<nav aria-label="Page navigation example">
							<ul class="pagination">
								<li class="page-item"><a class="page-link" href="#"
									aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
										<span class="sr-only">Previous</span>
								</a></li>
								<li class="page-item active"><a class="page-link" data-page="1"
									href="${pageContext.request.contextPath}/movies/pages/1">1</a></li>
								<li class="page-item"><a class="page-link" data-page="2"
									href="${pageContext.request.contextPath}/movies/pages/2">2</a></li>
								<li class="page-item"><a class="page-link" data-page="3"
									href="${pageContext.request.contextPath}/movies/pages/3">3</a></li>
								<li class="page-item"><a class="page-link" data-page="4"
									href="${pageContext.request.contextPath}/movies/pages/4">4</a></li>
								<li class="page-item"><a class="page-link" href="#"
									aria-label="Next"> <span aria-hidden="true">&raquo;</span>
										<span class="sr-only">Next</span>
								</a></li>
							</ul>
						</nav>
					</div>
				</div>
				<div class="row movie-list">
				</div>


				<div class="row" style="display: flow-root; margin-right: 0">
					<div class="float-right">
						<nav aria-label="Page navigation example">
							<ul class="pagination">
								<li class="page-item"><a class="page-link" href="#"
									aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
										<span class="sr-only">Previous</span>
								</a></li>
								<li class="page-item active"><a class="page-link" data-page="1"
									href="${pageContext.request.contextPath}/movies/pages/1">1</a></li>
								<li class="page-item"><a class="page-link" data-page="2"
									href="${pageContext.request.contextPath}/movies/pages/2">2</a></li>
								<li class="page-item"><a class="page-link" data-page="3"
									href="${pageContext.request.contextPath}/movies/pages/3">3</a></li>
								<li class="page-item"><a class="page-link" data-page="4"
									href="${pageContext.request.contextPath}/movies/pages/4">4</a></li>
								<li class="page-item"><a class="page-link" href="#"
									aria-label="Next"> <span aria-hidden="true">&raquo;</span>
										<span class="sr-only">Next</span>
								</a></li>
							</ul>
						</nav>
					</div>
				</div>

			</section>
		</div>



	</div>

	<script id="movie-template" type="text/x-handlebars-template">
						{{#each this}}
						<div class="col-md-3">
							<div class="card">
								<a href="${pageContext.request.contextPath}/movies/{{id}}"><img class="card-img-top"
									src="https://image.tmdb.org/t/p/w220_and_h330_face{{poster_path}}"
									alt="Card image cap"></a>
								<div class="card-body">
									<h5 class="card-title">{{title}}</h5>
									<p class="card-text truncate-overflow">{{overview}}</p>
									<span class="badge badge-pill badge-secondary">{{media_type}}</span>
								</div>
							</div>
						</div>
						{{/each}}
					</script>

	<!-- JS -->
	<script
		src="https://colorlib.com/etc/regform/colorlib-regform-7/vendor/jquery/jquery.min.js"></script>

	<script
		src="https://cdn.jsdelivr.net/npm/handlebars@latest/dist/handlebars.js"></script>

	<script>
		function loadData(page) {
			$('.loader-div').show();
			$.ajax({
				type : 'GET',
				url : 'http://localhost:8765/asset-ws/assets/pages/'+page,
				headers : {
					"Authorization" : 'Bearer ' + localStorage.getItem('token')
				},
				success : function(data, status, req) {
					var theTemplateScript = $("#movie-template").html();
					var theTemplate = Handlebars.compile(theTemplateScript);
					var theCompiledHtml = theTemplate(data);
					$('.movie-list').html(theCompiledHtml);
					$('html, body').animate({
						scrollTop: 0
					}, 1000);	
					$('.loader-div').hide();
				},
				error : function(req, status, error) {
					$('.loader-div').hide();
					console.log('status in error: ', status);
					console.log('error in error: ', error);
				}
			});
		}
		
		$('.pagination li a').on('click', function(e) {
			e.preventDefault();
			$('.pagination li').removeClass('active');
			loadData($(this).data('page'));
			$(this).parents('li').addClass('active');
		});

		loadData(1);
	</script>

</body>
</html>