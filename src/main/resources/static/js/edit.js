$(document).ready(function(){
	
	var serverName = "http://localhost:8080" ;
	
	var pathname = window.location.pathname ;
	var splitedPathname = pathname.split("/");
	var id = splitedPathname[splitedPathname.length - 1] ;
	console.log(splitedPathname.length);
	console.log(id);
	
	$.ajax({
	    url: serverName+"/api/users/"+id,
	    type: 'GET',
	    dataType: 'json',
	    success: function(data) {
	    	console.log(data);
			$('input[name=id]').val(data['id']);
			$('input[name=username]').val(data['username']);
			$('input[name=password]').val(data['password']);
			$('input[name=firstName]').val(data['firstName']);
			$('input[name=lastName]').val(data['lastName']);
	    }
	});
	
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
	
	$.ajax({
	    url: "http://localhost:8080/api/statuses/",
	    type: 'GET',
	    dataType: 'json',
	    success: function(data) {
	    	console.log(data);
	    	for (i = 0; i < data.length; i++) {
	    		
	        	$("#status_list_select").append("<option value='"+data[i]["id"]+"'>"+data[i]["name"]+"</option>");
	        	
	        }
	    }
	});
	
	
	
	$.ajax({
	    url: serverName+"/api/tasks/"+id,
	    type: 'GET',
	    dataType: 'json',
	    success: function(data) {
	    	console.log(data);
			$('input[name=id]').val(data['id']);
			$('input[name=name]').val(data['name']);
			$('input[name=description]').val(data['description']);
			$('input[name=startDate]').val(data['startDate']);
			$('input[name=dueDate]').val(data['dueDate']);
	    }
	});
	
	$.ajax({
	    url: serverName+"/api/projects/"+id,
	    type: 'GET',
	    dataType: 'json',
	    success: function(data) {
	    	console.log(data);
	    	$('input[name=id]').val(data['id']);
			$('input[name=name]').val(data['name']);
			$('input[name=description]').val(data['description']);
			$('input[name=startDate]').val(data['startDate']);
	    }
	});
	
	
	$('#edituserform').submit(function(event){
		event.preventDefault();
		
		var data = {
			'id'    : $('input[name=id]').val(),
            'username'    : $('input[name=username]').val(),
            'password'    : $('input[name=password]').val(),
            'firstName'    : $('input[name=firstName]').val(),
            'lastName'    : $('input[name=lastName]').val()		
		} ;
		
		$.ajax({
		    url: "http://localhost:8080/api/users/",
		    type: 'PUT',
		    data: JSON.stringify(data) ,
		    contentType: 'application/json',
		    dataType: 'json',
		    success: function(data) {
		        
		    }
		});
		
		
	});
	
	$("#user_list_select,#project_list_select,#status_list_select").select2();
	$("#startDate,#dueDate").flatpickr();
});