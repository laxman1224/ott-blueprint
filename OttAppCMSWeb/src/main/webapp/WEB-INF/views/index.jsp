<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>CMS OTT application</title>

<!-- Font Icon -->
<link rel="stylesheet"
	href="https://colorlib.com/etc/regform/colorlib-regform-7/fonts/material-icon/css/material-design-iconic-font.min.css">

<link
	href="https://fonts.googleapis.com/css2?family=Roboto:wght@100;300,400&display=swap"
	rel="stylesheet">

<!-- Main css -->
<link rel="stylesheet" href="resources/css/style.css">
</head>
<body>

	<div class="loader-div">
		<div class="loader"></div>
	</div>

	<div class="main">

		<!-- Sign up form -->
		<section class="signup" style="display: none">
			<div class="container">
				<div class="signup-content">
					<div class="signup-form">
						<h2 class="form-title">Sign up</h2>
						<form method="POST" class="register-form" id="register-form"
							autocomplete="off">
							<div class="form-group">
								<label for="firstname"><i
									class="zmdi zmdi-account material-icons-name"></i></label> <input
									type="text" name="firstName" id="firstname"
									placeholder="First Name" />
							</div>
							<div class="form-group">
								<label for="lastname"><i
									class="zmdi zmdi-account material-icons-name"></i></label> <input
									type="text" name="lastName" id="lastname"
									placeholder="Last Name" />
							</div>
							<div class="form-group">
								<label for="email"><i class="zmdi zmdi-email"></i></label> <input
									type="email" name="email" id="email" placeholder="Your Email" />
							</div>
							<div class="form-group">
								<label for="pass"><i class="zmdi zmdi-lock"></i></label> <input
									type="password" name="password" id="pass"
									placeholder="Password" />
							</div>
							<div class="form-group">
								<label for="re-pass"><i class="zmdi zmdi-lock-outline"></i></label>
								<input type="password" name="re_pass" id="re_pass"
									placeholder="Repeat your password" />
							</div>
							<div class="form-group">
								<input type="checkbox" name="agree-term" id="agree-term"
									class="agree-term" /> <label for="agree-term"
									class="label-agree-term"><span><span></span></span>I
									agree all statements in <a href="#" class="term-service">Terms
										of service</a></label>
							</div>
							<div class="form-group form-button">
								<input type="submit" name="signup" id="signup"
									class="form-submit" value="Register" />
							</div>
						</form>
					</div>
					<div class="signup-image">
						<figure>
							<img src="resources/images/signup-image.jpg" alt="sing up image">
						</figure>
						<a href="#" class="signup-image-link signin-link">I am already
							member</a>
					</div>
				</div>
			</div>
		</section>

		<!-- Sing in  Form -->
		<section class="sign-in">
			<div class="container">
				<div class="signin-content">
					<div class="signin-image">
						<figure>
							<img src="resources/images/signin-image.jpg" alt="sing up image">
						</figure>
						<a href="#" class="signup-image-link signup-link">Create an
							account</a>
					</div>

					<div class="signin-form">
						<h2 class="form-title">Sign up</h2>
						<form method="POST" class="register-form" id="login-form"
							autocomplete="off" action="login">
							<div class="form-group">
								<label for="your_name"><i
									class="zmdi zmdi-account material-icons-name"></i></label> <input
									type="text" name="email" id="your_name" placeholder="Email" />
							</div>
							<div class="form-group">
								<label for="your_pass"><i class="zmdi zmdi-lock"></i></label> <input
									type="password" name="password" id="your_pass"
									placeholder="Password" />
							</div>
							<div class="form-group">
								<input type="checkbox" name="remember-me" id="remember-me"
									class="agree-term" /> <label for="remember-me"
									class="label-agree-term"><span><span></span></span>Remember
									me</label>
							</div>
							<div class="form-group form-button">
								<input type="submit" name="signin" id="signin"
									class="form-submit" value="Log in" />
							</div>
						</form>
						<div class="social-login">
							<span class="social-label">Or login with</span>
							<ul class="socials">
								<li><a href="#"><i
										class="display-flex-center zmdi zmdi-facebook"></i></a></li>
								<li><a href="#"><i
										class="display-flex-center zmdi zmdi-twitter"></i></a></li>
								<li><a href="#"><i
										class="display-flex-center zmdi zmdi-google"></i></a></li>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</section>

	</div>

	<!-- JS -->
	<script
		src="https://colorlib.com/etc/regform/colorlib-regform-7/vendor/jquery/jquery.min.js"></script>
	<script src="resources/js/jquery.serializejson.min.js"></script>
	<script src="resources/js/main.js"></script>

	<script type="text/javascript">
		var apiGateway = "http://localhost:8082/ott-cms/api/";

		$("#register-form").submit(
				function(e) {
					$('.loader-div').show();
					e.preventDefault(); // avoid to execute the actual submit of the form.

					var form = $(this);
					var url = apiGateway + "register";

					$.ajax({
						type : 'POST',
						url : url,
						data : form.serialize(),
						success : function(data, status, req) {
							console.log('status: ', status);
							if (status === 'success') {
								localStorage.setItem("token", req
										.getResponseHeader('token'))
								window.location.href = "movies";
							} else {
								alert("Something went wrong")
							}

						},
						error : function(req, status, error) {
							$('.loader-div').hide();
							console.log('status in error: ', status);
							console.log('error in error: ', error);
						}
					});
				});

		$("#login-form").submit(function(e) {
			$('.loader-div').show();
			e.preventDefault(); // avoid to execute the actual submit of the form.

			//var url = apiGateway + "login";
			var url = "http://localhost:8765/users-ws/login";
			var form = $(this);

			$.ajax({
				type : 'POST',
				url : url,
				data : JSON.stringify(form.serializeJSON()),
				dataType : 'json',
				contentType : 'application/json;charset=UTF-8',
				statusCode : {
					200 : function(responseObject, textStatus, xhr) {
						localStorage.setItem("token", responseObject.getResponseHeader('token'))
                        window.location.href="movies";
					},
					401 : function(xhr) {
						alert("Invalid credentials entered");
					}
				}
			})
			.done(function(data){
			    alert(data);
			})
			.fail(function(jqXHR, textStatus){
			    
			})
			.always(function(jqXHR, textStatus) {
				$('.loader-div').hide();
			});;
		});

		$('.signin-link').on('click', function(e) {
			e.preventDefault();
			$('.signup').hide();
			$('.sign-in').fadeIn();
		})

		$('.signup-link').on('click', function(e) {
			e.preventDefault();
			$('.sign-in').hide();
			$('.signup').fadeIn();
		})
	</script>
</body>
</html>