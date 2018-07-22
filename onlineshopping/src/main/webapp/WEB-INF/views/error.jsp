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

    <title>Online shopping - ${title}</title>
    
    <script type="text/javascript">
    window.menu='${title}';
    </script>
	<!-- Bootstrap Core CSS -->
	<link href="${css}/bootstrap.min.css" rel="stylesheet">
    <!-- Bootstrap Template CSS -->
    <link href="${css }/bootstrap-litera-theme.css" rel="stylesheet">



    <!-- Custom styles for this template -->
    <link href="${css }/myapp.css" rel="stylesheet">

  </head>

  <body>
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
        <a class="navbar-brand" href="${contextRoot}/home">Online Shopping</a>
    </nav>
			<div class="container">
				<div class="row">
					<div class="col-xs-12">
						
						
						<div class="jumbotro">
							
							<h1>${errorTitle }</h1>
							<hr/>
							<blockquote style="word-wrap:break-word">
								${errorDescription }
							</blockquote>
							
							
						
						</div>
						
					</div>
				
				
				</div>
			
			
			</div>
		
		
	 <%@include file="./shared/footer.jsp" %>
  </body>

</html>
