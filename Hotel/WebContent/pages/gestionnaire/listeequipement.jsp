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
	<title>liste des equipements </title>
	<link rel="stylesheet" href="<c:url value="/assets/back/css/mainback.css"/>">
	
	
	 
	<!--Custom Font-->
	<link href="https://fonts.googleapis.com/css?family=Montserrat:300,300i,400,400i,500,500i,600,600i,700,700i" rel="stylesheet">
</head>
<body>
	
		<%@include file="hafa/menuliste.jsp" %>
	<div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">
		<div class="row">
			<ol class="breadcrumb">
				<li><a href="#">
					<em class="fa fa-home"></em>
				</a></li>
				<li class="active">Liste des equipements</li>
			</ol>
		</div><!--/.row-->
		
		<div class="row">
			<div class="col-lg-12">
				<h1 class="page-header">Liste des equipements</h1>
			</div>
		</div><!--/.row-->
				
		
	<table class="table table-striped">
  <thead>
    <tr>
      <th scope="col">idEquipement</th>
      <th scope="col">nom equipement </th>
	 
      
	  
    </tr>
  </thead>
  <tbody >
    <c:forEach items="${listeequipement }" var="item">
	<tr >
            <td>${item.id}</td>
            <td>${item.nomequipement}</td>
			<td>
			<a href="/backoffice/equipement-modifier/${item.id}"><span class="ti ti-slice" title="Modifier"/>modifier</a></td>
			<td><a href="/backoffice/equipement-supprimer/${item.id}"><span class="ti ti-close" title="Supprimer" onclick="return confirm('Voulez-vous vraiment effectuer cette suppression?')"/>supprimer</a>
			</td>
           
			
 </tr>
 </c:forEach>
   
  </tbody>
</table>
			
			
			<div class="col-sm-12">
				<p class="back-link">Lumino Theme by <a href="https://www.medialoot.com">Medialoot</a></p>
			</div>
		</div><!--/.row-->
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
