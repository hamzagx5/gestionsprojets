$(document).ready(function(){
	
	var serverName = "http://localhost:8080" ;
	
	var pathname = window.location.pathname ;
	var splitedPathname = pathname.split("/");
	var id = splitedPathname[splitedPathname.length - 1] ;
	console.log(splitedPathname.length);
	console.log(id);
	
	$('#addtaskform').submit(function(event){
		event.preventDefault();
		
		var data = {
		            'name'    : $('input[name=name]').val(),
		            'description'    : $('input[name=description]').val(),
		            'startDate'    : $('input[name=startDate]').val(),
		            'dueDate'    : $('input[name=dueDate]').val(),
		            'assignedUser'    : {
		            	'id' : $('select[name=assignedUser]').val()
		            },
		            'project'    : {
		            	'id' : $('select[name=project]').val()
		            },
		            'status'    : {
		            	'id': $('select[name=status]').val()
		            }
				
		} ;
		
		console.log(data);
		
		$.ajax({
		    url: serverName+"/api/users/edit/"+id,
		    type: 'PUT',
		    data: JSON.stringify(data) ,
		    contentType: 'application/json',
		    dataType: 'json',
		    success: function(data) {
		        
		    }
		});
		
		
	});
	
});