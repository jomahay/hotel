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
	<title>Modifier une chambre</title>
	<link rel="stylesheet" href="<c:url value="/assets/back/css/mainback.css"/>">
	 
	<!--Custom Font-->
	<link href="https://fonts.googleapis.com/css?family=Montserrat:300,300i,400,400i,500,500i,600,600i,700,700i" rel="stylesheet">
	<!--[if lt IE 9]>
	<script src="js/html5shiv.js"></script>
	<script src="js/respond.min.js"></script>
	<![endif]-->
</head>
<body-->
	
		<%@include file="hafa/menuliste.jsp" %>
	<div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">
		<div class="row">
			<ol class="breadcrumb">
				<li><a href="#">
					<em class="fa fa-home"></em>
				</a></li>
				<li class="active">Modifier une chambre</li>
			</ol>
		</div><!--/.row-->
		
		<div class="row">
			<div class="col-lg-12">
				<h1 class="page-header">modifier une chambre</h1>
			</div>
		</div><!--/.row-->
				
		
		<div class="row">
			<div class="col-lg-12">
			
				
				
				<div class="panel panel-default">
					<div class="panel-heading">modifier une chambre</div>
					<div class="panel-body">
						
						<div class="col-md-6">
							<form action="${pageContext.request.contextPath }/backoffice/modificationChambre" method="post"  >
								
						     	<input type="hidden" name="id" value="${champ.id}" />
						     	<input type="hidden" name="idtype" value="${champ.idtype}" />
						     	<input type="hidden" name="imagechambre" value="${champ.imagechambre}" />
								<div class="form-group">
								<div class="form-group">
									<label>nomchambre</label>
									<input name="nomchambre" type="text" class="form-control"  value="${champ.nomchambre}">
								</div>
								<div class="form-group">
									<label>prix</label>
									<input name="prix" type="text" class="form-control" value="${champ.prix}">
								</div>
								<div class="form-group">
									<label>description</label>
									<textarea name="description"  cols="30" rows="7" class="form-control" value="${champ.description}"></textarea>
								</div>
								<div class="form-group">
									<label>nombre personne</label>
									<input name="nombrepersonne" type="text" class="form-control"  value="${champ.nombrepersonne}">
								</div>
								<input type="submit" class="btn btn-success "  value="modifier chambre" />
							</form>
						</div>
					</div>
				</div><!-- /.panel-->
			</div><!-- /.col-->

		</div><!-- /.row -->
	</div><!--/.main-->
	
<script src="back/js/jquery-1.11.1.min.js"></script>
	<script src="back/js/bootstrap.min.js"></script>
	<script src="back/js/chart.min.js"></script>
	<script src="back/js/chart-data.js"></script>
	<script src="back/js/easypiechart.js"></script>
	<script src="back/js/easypiechart-data.js"></script>
	<script src="back/js/bootstrap-datepicker.js"></script>
	<script src="back/js/custom.js"></script>
	
</body>
</html>
