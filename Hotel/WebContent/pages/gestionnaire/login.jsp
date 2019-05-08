<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta name="description" content="">
	<meta name="keywords" content="">
	<title>Admininistrateur Login</title>
	
	<link rel="stylesheet" href="<c:url value="/assets/back/css/mainback.css"/>">
   
</head>
<body>
	<div class="row">
		<div class="col-xs-10 col-xs-offset-1 col-sm-8 col-sm-offset-2 col-md-4 col-md-offset-4">
			<div class="login-panel panel panel-default">
				<div class="panel-heading"><center>Administrateur</center></div>
				<div class="panel-body">
					<center>
				
				</center>
					<form action="${pageContext.request.contextPath }/backoffice/loginlog" method="post" >
						
							<div class="form-group">
								<input class="form-control" placeholder="login" name="login" type="text"  autofocus="">
							</dihv>
							<div class="form-group">
								<input class="form-control" placeholder="mot de passe" name="password" type="password" value="">
							</div>
							<center> <input class="btn btn-success btn-lg" type="submit"  value="Login" ></center>
							
					</form>
				</div>
			</div>
		</div><!-- /.col-->
	</div><!-- /.row -->	
	

<script src="back/js/jquery-1.11.1.min.js"></script>
	<script src="back/js/bootstrap.min.js"></script>
</body>
</html>
