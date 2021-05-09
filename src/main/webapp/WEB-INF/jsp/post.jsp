<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>

<div class="container">
	<div class="row">
		<div class="col-md-6 col-md-offset-3 ">
			<div class="panel panel-primary">


				<div class="panel-heading">

					<c:choose>
						<c:when test="${actionType!=null && actionType == 'UPDATE' }">Update Posts
						</c:when>
						<c:when test="${actionType!=null && actionType == 'VIEW' }">View Posts
						</c:when>
						<c:otherwise>Add Posts
						</c:otherwise>
					</c:choose>

				</div>

				<div class="panel-body">

					<form:form method="post" modelAttribute="post"
						enctype="multipart/form-data">
						<form:hidden path="postId" />

						<fieldset class="form-group">
							<form:label path="postType">Post Type</form:label>
							<form:select path="postType" class="form-control"
								required="required" disabled="${disable}">
								<form:option value="TEXT"></form:option>
								<form:option value="IMAGE"></form:option>
							</form:select>
							<form:errors path="postType" cssClass="text-warning" />
						</fieldset>

						<fieldset class="form-group" id="postDescription">
							<form:label path="postDescription">Post Description</form:label>
							<form:input path="postDescription" type="text"
								class="form-control" disabled="${disable}" />
							<form:errors path="postDescription" cssClass="text-warning" />
						</fieldset>

						<fieldset class="form-group" id="image">
							<form:label path="image">Image</form:label>
							<form:input path="image" type="file" class="form-control"
								accept="image/*" onchange="readURL(this);" disabled="${disable}" />
							<form:errors path="image" cssClass="text-warning" />
						</fieldset>

						<div style="margin-bottom: 20px;">
							<c:if test="${post.imageBytesInstr != null}">
								<img src="data:image/jpg;base64,${post.imageBytesInstr}"
									width="100" height="100" id="imgStr" />
							</c:if>
							<img id="imgPreview" src="#" />
						</div>


						<c:if test="${actionType != 'VIEW'}">
							<button type="submit" class="btn btn-success">
								<c:choose>
									<c:when test="${actionType!=null && actionType == 'UPDATE' }">
												Update
								</c:when>
									<c:otherwise>
											Save
								</c:otherwise>
								</c:choose>
							</button>
						</c:if>


						<a href="/dashboard" class="btn btn-warning"> Back</a>
					</form:form>

				</div>
			</div>
		</div>
	</div>
</div>

<%@ include file="common/footer.jspf"%>

<script src="/scripts.js"></script>