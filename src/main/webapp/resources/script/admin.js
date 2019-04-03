$(document).ready(function() {
	/*Document ready start*/
	$(".edit-user").click(function() {
		var id = $(this).attr('id');
		$.ajax({
			url : "/admin/search/user",
			data : {
				criteria : id
			},
			type : "GET",
			cache : false,
			success : function(response) {
				console.log('Ok');
			},
			error : function(xhr) {
				console.log('Not Ok');
			}
		})
	});

	/*Document ready end*/

});
