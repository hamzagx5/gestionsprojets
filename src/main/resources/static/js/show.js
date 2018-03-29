$(document).ready( function () {
	
	var serverName = "http://localhost:8080" ;
	
	$("#getTaskById").click(function(){
		var taskId = $("#taskId").val();
		$.ajax({
		    url: serverName+"/api/tasks/"+taskId,
		    type: 'GET',
		    dataType: 'json',
		    success: function(data) {
		        	$("#list_task_table").html("<tr>" +
		        			"<td>" +data["id"]+"</td>"+
		        			"<td>"+data["name"]+"</td>"+
		        			"<td>"+data["description"]+"</td>"+
		        			"<td>"+data["startDate"]+"</td>"+
		        			"<td>"+data["dueDate"]+"</td>"+
		        			"<td>"+data["endDate"]+"</td>"+
		        			"</tr>"
		        			)
		       
		        /*
		        $('#tasklist').DataTable({
		        	 "language": {
		                 "url": serverName+"/french_datatable.json"
		             }
		        });
		        */
		    }
		});
		
	});
	
});