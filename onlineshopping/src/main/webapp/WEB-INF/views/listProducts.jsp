<div class="container">
	<div class="row">
	
	<!-- sidebar -->
		<div class="col-md-3">
			<%@include file="./shared/sidebar.jsp" %>
		
		</div>
	<!-- Product -->
	
		<div class="col-md-9">
			<div class="row">
			<!-- breadcrumb component -->
				<div class="col-lg-12">
				<c:if test="${userClickAllProducts==true}">
				<script>
					window.categoryId = '';
				</script>
					<ul class="breadcrumb">
						<li><a href="${contextRoot }/home">Home</a>
						<li class="active">All products</li>
					</ul>
				</c:if>
				
				<c:if test="${userClickCategoryProducts==true}">
				
				<script>
					window.categoryId = '${category.id}';
				</script>
					<ul class="breadcrumb">
						<li><a href="${contextRoot }/home">Home</a>
						<li class="active">Category</li>
						<li class="active">${category.name}</li>
					</ul>
				</c:if>
				</div>
			
			</div>
			
			<div class="row">
				<div class="col-xs-12">
				<table id="productListTable" class="table table-striped table-border">
					<thead>
						<tr>
							<th></th>
							<th>Name</th>
							<th>Brand</th>
							<th>Price</th>
							<th>Qty.Available</th>
							<th></th>
						</tr>
					
					
					</thead>
					<tfoot>
						<tr>
							<th></th>
							<th>Name</th>
							<th>Brand</th>
							<th>Price</th>
							<th>Qty.Available</th>
							<th></th>
						</tr>
					
					
					</tfoot>			
				
				</table>
				
				</div>
			</div>
		
		</div>
	</div>
</div>