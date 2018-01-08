angular.module('appModule')
.factory('eventListService', function($http){
	var service = {};
	
	const baseUrl = 'rest/payments';
	 
	service.index = function() {
			 	return $http({
			      method : 'GET',
			      url : baseUrl 
			    })
			  };
			  
			  service.create = function(payment) {
				  return $http({
				      method : 'POST',
				      url : baseUrl,
				      headers : {
				        'Content-Type' : 'application/json'
				      },
				      data : payment
				    })
			  };
		  
		  service.update = function(payment){
			  return $http({
			      method : 'PUT',
			      url : baseUrl + '/' + payment.id,
			      headers : {
			        'Content-Type' : 'application/json'
			      },
			      data : payment
			    })
	      
	      };
	      
	      service.destroy = function(id){
	    	  let durl = baseUrl+'/'+id;
	    	  return $http({
				      method : 'DELETE',
				      url : durl
				    })
	      };
		  
	return service;
})