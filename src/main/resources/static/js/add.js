
$.ajax({
    url: "http://localhost:8080/api/users/",
    type: 'GET',
    dataType: 'json',
    success: function(data) {
    	console.log(data);
    	for (i = 0; i < data.length; i++) {
        	$("#user_list_select").append("<option value='"+data[i]["id"]+"'>"+data[i]["firstName"]+" "+data[i]["lastName"]+"</option>");

        }
    	
    	
        
    }
});

$.ajax({
    url: "http://localhost:8080/api/statuses/",
    type: 'GET',
    dataType: 'json',
    success: function(data) {
    	console.log(data);
    	for (i = 0; i < data.length; i++) {
    		
        	$("#status_list_select").append("<option value='"+data[i]["id"]+"'>"+data[i]["name"]+"</option>");
        	//$("#status_list_select_projet").append("<option value='"+data[i]["id"]+"'>"+data[i]["name"]+"</option>");

        }
    	
    	
        
    }
});


$.ajax({
    url: "http://localhost:8080/api/projects/",
    type: 'GET',
    dataType: 'json',
    success: function(data) {
    	console.log(data);
    	for (i = 0; i < data.length; i++) {
        	$("#project_list_select").append("<option value='"+data[i]["id"]+"'>"+data[i]["name"]+"</option>");

        }
    	
    	
        
    }
});

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
	    url: "http://localhost:8080/api/tasks/",
	    type: 'POST',
	    data: JSON.stringify(data) ,
	    contentType: 'application/json',
	    dataType: 'json',
	    success: function(data) {
	        
	    }
	});
	
	
	
	
});

$('#addprojectform').submit(function(event){
	event.preventDefault();
	
	var data = {
	            'name'    : $('input[name=name]').val(),
	            'description'    : $('input[name=description]').val(),
	            'startDate'    : $('input[name=startDate]').val(),
	            'owner'    : {
	            	'id' : $('select[name=owner]').val()
	            },
	            'status'    : {
	            	'id': $('select[name=status]').val()
	            }
			
	} ;
	
	console.log(data);
	

	
	
	
	$.ajax({
	    url: "http://localhost:8080/api/projects/",
	    type: 'POST',
	    data: JSON.stringify(data) ,
	    contentType: 'application/json',
	    dataType: 'json',
	    success: function(data) {
	        
	    }
	});
	
	
	
	
});

$("#user_list_select,#project_list_select,#status_list_select").select2();
$("#startDate,#dueDate").flatpickr();
