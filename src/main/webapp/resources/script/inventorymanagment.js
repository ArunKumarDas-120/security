$(document).ready(function() {
	/* Document ready start */
	
	/* Action Menu and tab */	
$('button.menu').click( function() {
	var menuid = $(this).attr('id');
	toggleActive($('button.menu') , menuid ,'active' , 'passive');
	toggleActive($('div.menu-tabcontent')  , menuid ,'open' , 'close');
});

	$('button.action').click( function(){
		var actionid  = $(this).attr('id');
		var parent  = $($(this).parent('div')).parent('div');
		var actionContent = $(parent).children('div.action-menu-tabcontent');
		toggleActive( $($(this).parent('div')).children('button.action') ,actionid,'active' , 'passive');
		toggleActive(actionContent , actionid ,'open' , 'close');
	});
	
	function toggleActive(ele , id, activeClass , passiveClass){
		$.each($(ele) , (index, element) => {
			if($(element).attr('id') == id && $(element).hasClass(passiveClass)){
			$(element).removeClass(passiveClass);
			$(element).addClass(activeClass);
		}else if($(element).hasClass(activeClass) && $(element).attr('id') != id){
			$(element).removeClass(activeClass);
			$(element).addClass(passiveClass);
		}
		});
	}
	/* Action Menu and tab End */	
	$('.open-button').click(function (){
		$($(this).parent().children('div.search-wizard')).css('display', 'block');
	});
	$('.close-search').click(function (){
		$($(this).parent()).parent('div.search-wizard').css('display', 'none');
	});
	
	/* Document ready end */
});

function changeAction(ele){
	if($(ele).hasClass('edit'))
		$('div.flip-card-inner').addClass('revolve');
	else
		$('div.flip-card-inner').removeClass('revolve');
}

/* Search Action*/
function search(searchFormid,resultlocation){
	var searchForm  = $(searchFormid);

$.ajax({
		url : $(searchForm).attr('action'),
		data : searchForm.serialize(),
		type : $(searchForm).attr('method'),
		 dataType : 'html',
		cache : false,
		success : function(response) {
			html  = $.parseHTML(response);
			table = $(html).find('table')
			if($(table).find('tr').length > 1)
				$(resultlocation).html(table);
			else
				popSnackBar('No result found.Please try different keyword.' ,'Green');
		},
		error : function(jqXHR, textStatus, errorThrown) {
			  popSnackBar(jqXHR.status + ' : ' + errorThrown ,'Red');
		}
	});

}
/*Add Action*/
function add(formId){
	var addForm  = $(formId);
	$.ajax({
		url : $(addForm).attr('action'),
		data : addForm.serialize(),
		type : $(addForm).attr('method'),
		cache : false,
		success : function(response) {
			popSnackBar(response.hasOwnProperty('Error')?response.Error:response.Success,
					response.hasOwnProperty('Error')?'Red':'Green');
		},
		error : function(jqXHR, textStatus, errorThrown) {
			popSnackBar(jqXHR.status + ' : ' + textStatus ,'Red');
		}
	})
}
