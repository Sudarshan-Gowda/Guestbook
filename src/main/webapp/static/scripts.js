
$('select').on('change', function() {
	var changeVal = this.value;
	if (changeVal == 'TEXT') {
		$("#image").hide();
		$("#postDescription").show();
		$("#imgStr").hide();
	} else {
		$("#image").show();
		$("#postDescription").hide();
	}

});

$(document).ready(function() {

	var postType = $("#postType").val();
	if (postType != null && postType == 'IMAGE') {
		$("#postDescription").hide();
	} else {
		$("#image").hide();
	}

	if (postType == null) {
		$("#image").hide();
	}
	$("#imgPreview").hide();

});


function readURL(input) {
	$("#imgPreview").show();
	if (input.files && input.files[0]) {
		var reader = new FileReader();

		reader.onload = function(e) {
			$('#imgPreview')
				.attr('src', e.target.result)
				.width(100)
				.height(100);
		};

		reader.readAsDataURL(input.files[0]);
	}
}


$('#image').on('change', function() {
	$("#imgStr").hide();
	$("#imgPreview").show();
});
