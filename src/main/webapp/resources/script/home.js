$(document).ready(function() {
	/*Document ready start*/
	
	$('a#menuitem').click(function(e) {	
		$.ajax({
			url : "/inventory",
			type : "POST",
			cache : false,
			success : function(response) {
				$( "div#content" ).empty();
				$( "div#content" ).html($.parseHTML( response ));
				$.getScript("/resources/script/inventorymanagment.js");
			},
			error : function(xhr) {
				console.log('Not Ok');
			}
		})
		return false;
    });
	
});