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
	        			"<td>" +
	        			"<a class='btn btn-primary' href='"+serverName+"/projects/show/"+data[i]["id"]+"'>Details</a>&nbsp;" +
	        			"<button class='btn btn-danger' id='btnDeleteProject' data-id="+data[i]['id']+">Delete</button>" +
	        			"</td>"+
	        			"</tr>"
	        			)
	        	//$("button").click({projectId:data[i]["id"]},deleteProjectById);
	        	 
	        }///////sla 
	        $('#projectlist').DataTable({
	        	 "language": {
	                 "url": serverName+"/french_datatable.json"
	             }
	        }); 
	        $("button").click(function(){
	        	console.log($(this).attr("data-id"));
	        	deleteProjectById($(this).attr("data-id"));
	      
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
	        			"<td><a class='btn btn-primary' href='"+serverName+"/tasks/show/"+data[i]["id"]+"'>Details</a>&nbsp;"+
	        			"<button class='btn btn-danger' id='btnDeleteUser' data-id="+data[i]['id']+">Delete</button>" +
	        			"</td>"+
	        			"</tr>"
	        			)
	        }
	        $('#userlist').DataTable({
	        	 "language": {
	                 "url": serverName+"/french_datatable.json"
	             }
	        });
	        $("button").click(function(){
	        	console.log($(this).attr("data-id"));
	        	deleteUserById($(this).attr("data-id"));
	      
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
	        			"<td><a class='btn btn-primary' href='"+serverName+"/tasks/show/"+data[i]["id"]+"'>Details</a>&nbsp;"+
	        			"<button class='btn btn-danger' id='btnDeleteTask' data-id="+data[i]['id']+">Delete</button>" +
	        			"</td>"+
	        			"</tr>"
	        			)
	        }
	        
	        $('#tasklist').DataTable({
	        	 "language": {
	                 "url": serverName+"/french_datatable.json"
	             }
	        });
	        $("button").click(function(){
	        	console.log($(this).attr("data-id"));
	        	deleteTaskById($(this).attr("data-id"));
	      
	        });
	    }
	});
	
	function deleteProjectById(id){
		$.ajax({
    	    url: serverName+"/api/projects/"+id,
    	    type: 'DELETE',
    	    dataType: 'json',
    	    success: function(data) {
    	        console.log("record deleteed");
    	    }
    	});
		window.location.reload();
	}
	function deleteUserById(id){
		$.ajax({
    	    url: serverName+"/api/users/"+id,
    	    type: 'DELETE',
    	    dataType: 'json',
    	    success: function(data) {
    	        console.log("record deleteed");
    	    }
    	});
		window.location.reload();
	}
	function deleteTaskById(id){
		$.ajax({
    	    url: serverName+"/api/tasks/"+id,
    	    type: 'DELETE',
    	    dataType: 'json',
    	    success: function(data) {
    	        console.log("record deleteed");
    	    }
    	});
		window.location.reload();
	}
	
});