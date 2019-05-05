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

let actionPerformed  = [];
let oldValues = [];
function changeAction(currentElement,rowNumber,formAction){
	var invokedAction = {'RowNumber':rowNumber , 'ActionFor': formAction};
	if($(currentElement).hasClass('edit')){
		if(actionPerformed.findIndex(currentElement => (currentElement.RowNumber != invokedAction.RowNumber) 
				&& (currentElement.ActionFor == invokedAction.ActionFor)) == -1){
			$($($(currentElement).closest('td')).children('div.flip-card')).children('div.flip-card-inner').addClass('revolve');
			oldValues.push({'Key': invokedAction , 'OldValue':$($(currentElement).closest('td')).closest('tr').html()});
			actionPerformed.push(invokedAction);
			$(currentElement).closest('tr').find('td.editable').each((index, element) =>$(element).find(':disabled').removeAttr('disabled'));
		}else{
			 popSnackBar('Single Edit allowed at a time','Red');
		}
	}
	else{
		if($(currentElement).hasClass('cancel')){	
			let index = oldValues.findIndex(currentElement => (currentElement.Key.RowNumber == invokedAction.RowNumber) 
					&& (currentElement.Key.ActionFor == invokedAction.ActionFor));
			let latestRow = $($(currentElement).closest('td')).closest('tr');
			$(latestRow).empty();
			$(latestRow).append($.parseHTML(oldValues[index].OldValue));
			$(latestRow).find('div.flip-card-inner').removeClass('revolve');
			actionPerformed.splice(actionPerformed.findIndex(currentElement => (currentElement.RowNumber == invokedAction.RowNumber) 
					&& (currentElement.ActionFor == invokedAction.ActionFor)),1);
			oldValues.splice(index,1);
		}else if($(currentElement).hasClass('save')){
			let updateForm  = $(formAction);
			$.ajax({
				url : $(updateForm).attr('action'),
				data : updateForm.serialize(),
				type : $(updateForm).attr('method'),
				dataType : 'html',
				cache : false,
				success : function(response) {
					html  = $.parseHTML(response);
					result  = $(html).find('#responseMessage');
					popSnackBar(result.val(),result.hasClass('Success')?'Green':'Red');
					if(result.hasClass('Success')){
						actionPerformed.splice(actionPerformed.findIndex(currentElement => (currentElement.RowNumber == invokedAction.RowNumber) 
								&& (currentElement.ActionFor == invokedAction.ActionFor)),1);
						oldValues.splice(oldValues.findIndex(currentElement => (currentElement.Key.RowNumber == invokedAction.RowNumber) 
								&& (currentElement.Key.ActionFor == invokedAction.ActionFor)),1);
						$($($(currentElement).closest('td')).children('div.flip-card')).children('div.flip-card-inner').removeClass('revolve');
					}
				},
				error : function(jqXHR, textStatus, errorThrown) {
					  popSnackBar(jqXHR.status + ' : ' + errorThrown ,'Red');
				}
			});
		}
		
	}
}

/* Search Action */
function search(searchFormid,resultlocation){
	let searchForm  = $(searchFormid);
	let formId = '';
$.ajax({
		url : $(searchForm).attr('action'),
		data : searchForm.serialize(),
		type : $(searchForm).attr('method'),
		dataType : 'html',
		cache : false,
		success : function(response) {
			html  = $.parseHTML(response);
			table = $(html).find('table')
			if($(table).find('tr').length > 1){
				let htmlData = $(html).find('form')
				$(resultlocation).html(htmlData);
				formId  = '#' + $(htmlData).attr('id');
			}
			else
				popSnackBar('No result found.Please try different keyword' ,'Green');
			actionPerformed =  actionPerformed.filter(actions => actions.ActionFor != formId);
			oldValues = oldValues.filter(actions => actions.Key.ActionFor != formId);
		},
		error : function(jqXHR, textStatus, errorThrown) {
			  popSnackBar(jqXHR.status + ' : ' + errorThrown ,'Red');
		}
	});

}
/* Add Action */
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
