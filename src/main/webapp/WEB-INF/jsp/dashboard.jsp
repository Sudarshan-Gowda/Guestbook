<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<div class="container">

	<div class="panel panel-primary">
		<div class="panel-heading">Home Page</div>
		<div class="panel-body">
			Welcome ${principal.userName}!!

			<c:if test="${fn:contains(principal.getRoles(), 'USER')}">
				<a href="/createPost">Click here</a>
						to add new entry to guest book
			</c:if>

		</div>
	</div>


	<div class="panel panel-primary">
		<div class="panel-heading">List of Book Entry's</div>
		<div class="panel-body">
			<!-- 			<table class="table table-striped" id="example-table"> -->
			<table class="table table-striped table-bordered table-hover"
				id="example-table">
				<thead>
					<tr class="table_header">
						<th width="10%">Sl No.</th>
						<th width="40%">Description/Image</th>
						<th width="20%">Status</th>
						<c:if test="${fn:contains(principal.getRoles(), 'ADMIN')}">
							<th width="40%">Actions</th>
						</c:if>
					</tr>
				</thead>


				<c:if test="${fn:length(posts) > 0}">
					<tbody>
						<c:forEach items="${posts}" var="post" varStatus="count">
							<tr>
								<td>${count.count}</td>
								<td><c:choose>
										<c:when test="${post.postType == 'IMAGE'}">
											<img src="data:image/jpg;base64,${post.imageBytesInstr}"
												width="100" height="100" />
										</c:when>
										<c:otherwise>
											${post.postDescription}
										</c:otherwise>
									</c:choose></td>
								<td><c:choose>
										<c:when test="${post.isApproved}">
											<span class="alert-success" role="alert">Approved</span>
										</c:when>
										<c:otherwise>
											<span class="alert-warning" role="alert">Not Approved</span>
										</c:otherwise>
									</c:choose></td>

								<c:if test="${fn:contains(principal.getRoles(), 'ADMIN')}">
									<td><a type="button" class="btn btn-warning"
										href="/viewPost?id=${post.postId}">View</a> <a type="button"
										class="btn btn-success" href="/updatePost?id=${post.postId}">Update</a>
										<a type="button" class="btn btn-danger"
										href="deletePost?id=${post.postId}">Delete</a> <c:if
											test="${post.isApproved == false}">
											<a type="button" class="btn btn-primary"
												href="/approvePost?id=${post.postId}">Approve</a>
										</c:if></td>
								</c:if>

							</tr>
						</c:forEach>
					</tbody>
				</c:if>

			</table>
			<c:if test="${fn:length(posts) < 1}">
				<div style="text-align: center;">No record found!!</div>
			</c:if>
		</div>
	</div>


</div>




<%@ include file="common/footer.jspf"%>



<c:choose>
	<c:when test="${fn:contains(principal.getRoles(), 'ADMIN')}">
		<script type="text/javascript">
        $(function() {
            $('#example-table').DataTable({
                pageLength: 2,
                "columns": [
                	{ "orderable": true },
                    { "data": "test1" },
                    { "data": "test2" },
                    { "data": "test3" }
                ]
            });
        })
    </script>
	</c:when>
	<c:otherwise>
		<script type="text/javascript">
        $(function() {
            $('#example-table').DataTable({
                pageLength: 2,
                "columns": [
                	{ "orderable": true },
                    { "data": "test1" },
                    { "data": "test2" }
                ]
            });
        })
    </script>
	</c:otherwise>
</c:choose>


<script src="/datatables.min.js"></script>

