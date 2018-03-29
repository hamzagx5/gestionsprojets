$(document).ready( function () {
	var serverName = "http://localhost:8080" ;
	
	$.ajax({
	    url: serverName+"/api/projects/",
	    type: 'GET',
	    dataType: 'json',
	    success: function(data) {
	        console.log(data);
	        for (i = 0; i < data.length; i++) {
	        	
	        	$("#list_project_table").append("<tr>" +
	        			"<td>" +data[i]["id"]+"</td>"+
	        			"<td>"+data[i]["name"]+"</td>"+
	        			"<td>"+data[i]["description"]+"</td>"+
	        			"<td>"+data[i]["startDate"]+"</td>"+
	        			"<td>"+data[i]["endDate"]+"</td>"+
	        			"</tr>"
	        			)
	        }
	        $('#projectlist').DataTable({
	        	 "language": {
	                 "url": serverName+"/french_datatable.json"
	             }
	        });
	        
	    }
	});

	$.ajax({
	    url: serverName+"/api/users/",
	    type: 'GET',
	    dataType: 'json',
	    success: function(data) {
	        console.log(data);
	        for (i = 0; i < data.length; i++) {
	        	
	        	$("#list_user_table").append("<tr>" +
	        			"<td>" +data[i]["id"]+"</td>"+
	        			"<td>"+data[i]["firstName"]+"</td>"+
	        			"<td>"+data[i]["lastName"]+"</td>"+
	        			"</tr>"
	        			)
	        }
	        $('#userlist').DataTable({
	        	 "language": {
	                 "url": serverName+"/french_datatable.json"
	             }
	        });
	        
	    }
	});
	
	
	// get task list 
	$.ajax({
	    url: serverName+"/api/tasks/",
	    type: 'GET',
	    dataType: 'json',
	    success: function(data) {
	        console.log(data);
	        for (i = 0; i < data.length; i++) {
	        	
	        	$("#list_task_table").append("<tr>" +
	        			"<td>" +data[i]["id"]+"</td>"+
	        			"<td>"+data[i]["name"]+"</td>"+
	        			"<td>"+data[i]["description"]+"</td>"+
	        			"<td>"+data[i]["startDate"]+"</td>"+
	        			"<td>"+data[i]["dueDate"]+"</td>"+
	        			"<td><a class='btn btn-primary' href='"+serverName+"/tasks/show/"+data[i]["id"]+"'>Details</a></td>"+
	        			"<input type='submit' value='' name='' />"+
	        			"</tr>"
	        			)
	        }
	        $('#tasklist').DataTable({
	        	 "language": {
	                 "url": serverName+"/french_datatable.json"
	             }
	        });
	        
	    }
	});
	
});