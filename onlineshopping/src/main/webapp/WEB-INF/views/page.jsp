<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<c:set var="contextRoot" value = "${pageContext.request.contextPath}" />
<spring:url var="css" value="/resources/css"/>
<spring:url var="js" value="/resources/js"/>
<spring:url var="images" value="/resources/images"/>

<!DOCTYPE html>
<html lang="en">

  <head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <meta name="_csrf" content="${_csrf.token }">
    <meta name="_csrf_header" content="${_csrf.headerName}">

    <title>Online shopping - ${title}</title>
    
    <script type="text/javascript">
    window.menu='${title}';
    window.contextRoot='${contextRoot}'
    </script>
	<!-- Bootstrap Core CSS -->
	<link href="${css}/bootstrap.min.css" rel="stylesheet">
    <!-- Bootstrap Template CSS -->
    <link href="${css }/bootstrap-readable-theme.css" rel="stylesheet">


	<!-- Bootstrap DataTables -->
	<link href="${css}/dataTables.bootstrap.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="${css }/myapp.css" rel="stylesheet">

  </head>

  <body>

    <!-- Navigation -->
	<%@include file="./shared/navbar.jsp" %>

    <!-- Page Content -->
    
    
    <c:if test="${userClickHome==true }">
  	<%@include file="home.jsp" %>
	</c:if>
	
	<!-- Load only user click about -->
	 <c:if test="${userClickAbout==true }">
  	<%@include file="about.jsp" %>
	</c:if>
	
	<!-- Load only user click contact -->
	 <c:if test="${userClickContact==true }">
  	<%@include file="contact.jsp" %>
	</c:if>
	
	<c:if test="${userClickAllProducts==true or userClickCategoryProducts==true}">
  	<%@include file="listProducts.jsp" %>
	</c:if>
	
	<!-- Load only when user click show product -->
	<c:if test="${userClickShowProduct==true}">
  	<%@include file="singleProduct.jsp" %>
	</c:if>
	
	<!-- Load only when user click manage product -->
	<c:if test="${userClickManageProducts==true}">
  	<%@include file="manageProducts.jsp" %>
	</c:if>
	
	<!-- Load only when user click show cart -->
	<c:if test="${userClickShowCart==true}">
  	<%@include file="cart.jsp" %>
	</c:if>
	
	
    <!-- Footer -->
    <%@include file="./shared/footer.jsp" %>

		<!-- jQuery -->
		<script src="${js}/jquery.js"></script>

		<script src="${js}/jquery.validate.js"></script>

		<!-- Bootstrap Core JavaScript -->
		<script src="${js}/bootstrap.min.js"></script>
		
		<!-- DataTable Plugin -->
		<script src="${js}/jquery.dataTables.js"></script>
		
		<!-- DataTable Bootstrap Script -->
		<script src="${js}/dataTables.bootstrap.js"></script>
		
		<!-- bootbox  -->
		<script src="${js}/bootbox.min.js"></script>
		
		<!-- Self coded javascript -->
		<script src="${js}/myapp.js"></script>

  </body>

</html>
