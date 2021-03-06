<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>SB Admin 2 - Register</title>

    <!-- Custom fonts for this template-->
    <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link
        href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
        rel="stylesheet">

    <!-- Custom styles for this template-->
    <link href="css/sb-admin-2.min.css" rel="stylesheet">

	<style type="text/css">
		.flower-image {
		  background: url("/img/flower.jpg");
		  background-position: center;
		  background-size: cover;
		}
	</style>

</head>

<body class="bg-gradient-primary">

    <div class="container">

        <div class="card o-hidden border-0 shadow-lg my-5">
            <div class="card-body p-0">
                <!-- Nested Row within Card Body -->
                <div class="row">
                    <div class="col-lg-5 d-none d-lg-block flower-image"></div>
                    <div class="col-lg-7">
                        <div class="p-5">
                            <div class="text-center">
                                <h1 class="h4 text-gray-900 mb-4">Create an Account!</h1>
                            </div>
                            <form class="user">
                                <div class="form-group">
                                	<h6>아이디</h6>
                                    <div class="mb-3 mb-sm-0">
                                        <input type="text" class="form-control form-control-user" id="Id"
                                            placeholder="아이디 입력">
                                    </div>
                                    
                                    <h6 class="mt-2">비밀번호</h6>
                                    <div class="mb-3 mb-sm-0">
                                        <input type="password" class="form-control form-control-user" id="Password"
                                            placeholder="패스워드 입력">
                                    </div>
                                     <h6 class="mt-2">비밀번호 재확인</h6>
                                    <div class="mb-3 mb-sm-0">
                                        <input type="password" class="form-control form-control-user" id="Password2"
                                            placeholder="패스워드 재입력">
                                    </div>
                                </div>
                                <h6>이름</h6>
                                <div class="form-group">
                                    <input type="text" class="form-control form-control-user" id="Name"
                                        placeholder="이름">
                                </div>
                                <h6>생년월일</h6>
                                <div class="form-group">
                                    <input type="text" class="form-control form-control-user" id="Birth"
                                        placeholder="생년월일">
                                </div>
                                <h6>이메일</h6>
                                <div class="form-group">
                                    <input type="text" class="form-control form-control-user" id="Email"
                                        placeholder="이메일">
                                </div>
                            	<!-- 성별/주소 -->
                            	<h6>성별</h6>
                                <div class="form-check">
								  <input class="form-check-input" type="radio" name="flexRadioDefault" id="Man">
								  <label class="form-check-label" for="flexRadioDefault1">
								          남자
								  </label>
								</div>
								<div class="form-check">
								  <input class="form-check-input" type="radio" name="flexRadioDefault" id="Woman" checked>
								  <label class="form-check-label" for="flexRadioDefault2">
								   	 여자
								  </label>
								</div>
								<h6 class="mt-3">휴대전화</h6>
                                    <div class="mb-3 mb-sm-0">
                                        <input type="text" class="form-control form-control-user"
                                            id="Phone" placeholder="전화번호">
                                    </div>
                                </div>
                                <a href="login.html" class="btn btn-primary btn-user btn-block">
                                    Register Account
                                </a>
                                <hr>
                                <a href="index.html" class="btn btn-google btn-user btn-block">
                                    <i class="fab fa-google fa-fw"></i> Register with Google
                                </a>
                                <a href="index.html" class="btn btn-facebook btn-user btn-block">
                                    <i class="fab fa-facebook-f fa-fw"></i> Register with Facebook
                                </a>
                            </form>
                            <hr>
                            <div class="text-center">
                                <a class="small" href="forgot-password.html">Forgot Password?</a>
                            </div>
                            <div class="text-center">
                                <a class="small" href="login.html">Already have an account? Login!</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

    </div>

    <!-- Bootstrap core JavaScript-->
    <script src="vendor/jquery/jquery.min.js"></script>
    <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

    <!-- Core plugin JavaScript-->
    <script src="vendor/jquery-easing/jquery.easing.min.js"></script>

    <!-- Custom scripts for all pages-->
    <script src="js/sb-admin-2.min.js"></script>

</body>

</html>