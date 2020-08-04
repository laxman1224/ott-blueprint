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

<title>${movie.title}</title>

<link rel="canonical"
	href="https://getbootstrap.com/docs/4.0/examples/jumbotron/">

<!-- Bootstrap core CSS -->
<link
	href="https://getbootstrap.com/docs/4.0/dist/css/bootstrap.min.css"
	rel="stylesheet">

<!-- Custom styles for this template -->
<link
	href="https://getbootstrap.com/docs/4.0/examples/jumbotron/jumbotron.css"
	rel="stylesheet">



<style type="text/css">
body {
	padding-top: 0;
}

.jumbotron {
	position: relative;
	min-height: 550px;
	border-bottom: 1px solid rgba(21.57%, 12.55%, 26.86%, 1.00);
	background-position: right 0px top;
	background-size: contain;
	background-repeat: no-repeat;
	border-bottom: 1px solid rgba(21.57%, 12.55%, 26.86%, 1.00);
	background-position: right 0px top;
	background-size: contain;
}

div.custom_bg {
	background-image: linear-gradient(to right, rgba(11.76%, 20.39%, 25.88%, 1.00)
		150px, rgba(18.82%, 27.45%, 32.94%, 0.84) 100%);
}

.custom_bg>.container {
	margin-top: 132px;
	color: #fcfcfc;
	margin-left: 40%;
	width: 45%;
}

div.custom_bg {
	display: flex;
	justify-content: center;
	flex-wrap: wrap;
	position: absolute;
	top: 0;
	left: 0;
	width: 100%;
	height: 100%;
}

.card-image {
	z-index: 2;
	position: absolute;
	left: 23%;
	top: 95px;
}

.truncate-overflow {
	display: block;
	display: -webkit-box;
	max-width: 200px;
	-webkit-line-clamp: 4;
	-webkit-box-orient: vertical;
	overflow: hidden;
	text-overflow: ellipsis;
}
</style>
</head>

<body>

	<jsp:include page="nav.jsp" />
	<main role="main">

		<!-- Main jumbotron for a primary marketing message or call to action -->
		<div class="movie-details"></div>

		<div class="container">
			<!-- Example row of columns -->

			<h2>Recommendations</h2>
			<div class="row recommendation-list">
			
			</div>

			<hr>

		</div>
		<!-- /container -->

	</main>

	<footer class="container">
		<p>&copy; Company 2017-2018</p>
	</footer>
	
	<script id="movie-details-template" type="text/x-handlebars-template">
	<div class="jumbotron"
		style="background-image: url(https://image.tmdb.org/t/p/w1920_and_h800_multi_faces/{{backdrop_path}});">


		<div class="card-image">
			<img
				src="https://image.tmdb.org/t/p/w220_and_h330_face/{{poster_path}}"
				class="card-img-top" alt="...">
		</div>

		<div class="custom_bg">
			<div class="container">
				<h1 class="display-3">{{title}}</h1>
				<p>{{overview}}</p>
				<p>
					<a class="btn btn-primary btn-lg" href="#" role="button">Watch
						Now &raquo;</a>
				</p>
			</div>
		</div>
	</div>
	</script>
	
	
	<script id="recommendation-template" type="text/x-handlebars-template">
						{{#each this}}
						<div class="col-md-2">
						<div class="card">
							<a href="${pageContext.request.contextPath}/movies/{{id}}"><img
								class="card-img-top"
								src="https://image.tmdb.org/t/p/w220_and_h330_face/{{poster_path}}"
								alt="Card image cap"></a>
							<div class="card-body">
								<h6 class="card-title">{{title}}</h6>
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
		function loadData() {
			$('.loader-div').show();
			$.ajax({
				type : 'GET',
				url : 'http://localhost:8765/asset-ws/assets/${assetId}',
				headers : {
					"Authorization" : 'Bearer ' + localStorage.getItem('token')
				},
				success : function(data, status, req) {
					console.log(data);
					
					var theTemplateScript = $("#movie-details-template").html();
					var theTemplate = Handlebars.compile(theTemplateScript);
					$('.movie-details').html(theTemplate(data));
					
					theTemplateScript = $("#recommendation-template").html();
					theTemplate = Handlebars.compile(theTemplateScript);
					$('.recommendation-list').html(theTemplate(data.recommendations));
					
					$('.loader-div').hide();
				},
				error : function(req, status, error) {
					$('.loader-div').hide();
					console.log('status in error: ', status);
					console.log('error in error: ', error);
				}
			});
		}

		loadData();
	</script>

</body>
</html>
