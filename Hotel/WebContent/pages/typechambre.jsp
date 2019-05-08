<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
  <head>
    <title>Liste des types de chambre dans jonatanaHotel</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="jonatanaHotel
	propose des chambres avec des differentes types de chambres pour vous satisfaire.">
	<meta name="keywords" content="type de chambre , categories de chambre ">
    <link href="https://fonts.googleapis.com/css?family=Rubik:300,400,500" rel="stylesheet">
     <link rel="stylesheet" href="<c:url value="/assets/css/rehetrabe.css"/>">
	<link rel="stylesheet" href="<c:url value="/assets/css/colorback.css"/>">
  </head>
  
  <body>
    
  <%@include file="go/nav.jsp" %>
  
  <div class="site-section bg-light">
      <div class="container">
		<div class="row">
         

          
			<c:forEach items="${listechambrefront }" var="item">
          <div class="col-lg-4 mb-5">
            <div class="block-34">
              <div class="image">
               <img src="<c:url value="/assets/images/${item.imagetype}"/>" alt="Image placeholder"></a>
			</div>
              <div class="text">
              	<h1 class="heading">${item.nomtype}</h1>
				
                <center><p><a href="${pageContext.request.contextPath }/typechambre/${item.nomtype}" class="btn btn-danger py-3 px-5">voir les chambres</a></p></center>
              </div>
			  
				
            </div>
			
          </div>
           </c:forEach>

          

          

          


          

          
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