<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <title>Description du chambre</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="Decouvrez les details des chambres uniques 
	que nous proposons dans notre hotel de Nosy be par categorie.
	Vous serez ravi qu'il s'agisse d'un endroit unique en son genre.">
	<meta name="keywords" content="Chambres jonatanaHotel d'hotel uniques,
	des lieux de sejour uniques, Chambres jonatanaHotel d'hotel speciales par categorie ">
    <link href="https://fonts.googleapis.com/css?family=Rubik:300,400,500" rel="stylesheet">
	 <link rel="stylesheet" href="<c:url value="/assets/css/rehetrabe.css"/>">
	<link rel="stylesheet" href="<c:url value="/assets/css/colorback.css"/>">
	<style>
			
	
	
	</style>
  </head>
  <body>
   
  <%@include file="go/nav.jsp" %>

  
  

 


  <div id="blog" class="site-section">
    <div class="container">
            
            <div class="row">

              <div class="col-md-8">
                <h1 class="mb-3">${descriptionzay.nomchambre }</h1>

                <p><img src="<c:url value="/assets/images/${descriptionzay.imagechambre}"/>" alt="" width="600" height="80" class="img-fluid"></p>
				<h2>Type du chambre</h2>
				<p>${descriptionzay.nomtype}</p>
				<h2 >Prix</h2>
                <p>${descriptionzay.prix} Ar</p>
				<h2 >Personnes</h2>
                <p>cette chambre peut heberger ${descriptionzay.nombrepersonne}  personnes.</p>
				<h2 >Description de la chambre</h2>
				<p>${descriptionzay.description}</p>
				<h2>Equipements</h2>
				
				<!--<c:forEach items="${descriptionzay}" var="item">
						<p>${item.nomequipement}</p>
				 </c:forEach>-->
				
				
                
                
                
                
                


               

              </div> <!-- .col-md-8 -->

            </div>

            
          </div>
  </div>
  
  <%@include file="go/foot.jsp" %>
  

	

 <script src="<c:url value="/assets/js/jquery.min.js"/>"> </script>
  <script src="<c:url value="/assets/js/jquery-migrate-3.0.1.min.js"/>"> </script>
  <script src="<c:url value="/assets/js/popper.min.js"/>"></script>
  <script src="<c:url value="/assets/js/bootstrap.min.js"/>"></script>
  <script src="<c:url value="/assets/js/jquery.easing.1.3.js"/>"></script>
  <script src="<c:url value="/assets/js/jquery.waypoints.min.js"/>"></script>
  <script src="<c:url value="/assets/js/jquery.stellar.min.js"/>"></script>
  <script src="<c:url value="/assets/js/owl.carousel.min.js"/>"></script>
  <script src="<c:url value="/assets/js/jquery.magnific-popup.min.js"/>"></script>
  <script src="<c:url value="/assets/js/bootstrap-datepicker.js"/>"></script>
  
  <script src="<c:url value="/assets/js/aos.js"/>"></script>
  <script src="<c:url value="/assets/js/jquery.animateNumber.min.js"/>"></script>
  <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBVWaKrjvy3MaE7SQ74_uJiULgl1JY0H2s&sensor=false"></script>
 <script src="<c:url value="/assets/js/google-map.js"/>"></script>
<script src="<c:url value="/assets/js/main.js"/>"></script>  
    
  </body>
</html>