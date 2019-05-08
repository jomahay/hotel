<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
  <head>
    <title>Liste des chambres par type dans jonatanaHotel</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="jonatanaHotel
	propose des chambres avec des differentes categories et
	avec un decor spectaculaire authentique et des touches modernes.">
	<meta name="keywords" content="Chambres jonatanaHotel,prix,nuit, Chambres a jonatanaHotel">
    <link href="https://fonts.googleapis.com/css?family=Rubik:300,400,500" rel="stylesheet">
  	 <link rel="stylesheet" href="<c:url value="/assets/css/rehetrabe.css"/>">
	<link rel="stylesheet" href="<c:url value="/assets/css/colorback.css"/>">
  </head>
  
  <body>
    
  <%@include file="go/nav.jsp" %>
  
  <div class="site-section bg-light">
      <div class="container">
		<div class="row">
			 <c:forEach items="${listechambreparnom}" var="item">
          <div class="col-lg-4 mb-5">
            <div class="block-34">
              <div class="image">
               <img src="<c:url value="/assets/images/${item.imagechambre}"/>" alt="Image placeholder"></a>
              </div>
              <div class="text">
                <h1 class="heading">${item.nomchambre}</h1>
				
                <center><p><a href="${pageContext.request.contextPath }/typechambre/${item.nomtype}/${item.nomchambre}" class="btn btn-danger py-3 px-5">voir detail</a></p></center>
              </div>
            </div>
          </div>
			 </c:forEach>
          </div>
      </div>
	 
    </div>
	


               
              


  <%@include file="go/foot.jsp" %>

  <!-- loader -->
  <!--<div id="ftco-loader" class="show fullscreen"><svg class="circular" width="48px" height="48px"><circle class="path-bg" cx="24" cy="24" r="22" fill="none" stroke-width="4" stroke="#eeeeee"/><circle class="path" cx="24" cy="24" r="22" fill="none" stroke-width="4" stroke-miterlimit="10" stroke="#F96D00"/></svg></div>  -->

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