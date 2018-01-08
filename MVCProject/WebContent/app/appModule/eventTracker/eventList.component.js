angular.module('appModule')
.component('eventList',{
	templateUrl:'app/appModule/eventTracker/eventList.component.html',
	
	controller: function(eventListService){
	const vm = this;
	


	vm.payments = [];
	
	var reload = function() {
		eventListService.index()
		.then(function(response) {
		vm.payments = response.data;
		console.log('in reload method');
		});
	}
	
	reload();
	

vm.getNumPayments = function() {
	return vm.payments.length;
    };
    
vm.getTotalGallons = function(){
	let total = 0;
	vm.payments.forEach( function(ele,idx,arr){
		total +=ele.gallon;
	});
		return total;
	};

vm.getTotalPayments = function(){
	let totalpay = 0;
	vm.payments.forEach( function (ele,idx,arr) { 
		 totalpay += ele.totalPrice;
	});
	return totalpay;
};
   
vm.getAveragePricePerGallon = function (){
	let average = (vm.getTotalPayments())/(vm.getTotalGallons());
	return average;
}

vm.addPayment = function(payment) {
    eventListService.create(payment).
then(reload);
}
      
      vm.selected= null;
      vm.editPayment= null;
      
      vm.displayPayment = function(payment){
    	  	vm.selected = payment;
    	  
      };
      
     vm.displayTable = function(){
   	  	vm.selected = null;
  	  
     };
   
      vm.setEditPayment = function(){
    	  		let copy = angular.copy(vm.selected);
    	  		
    	  		vm.editPayment = copy;	
      };
      
      vm.updatePayment = function(payment) {
    	  eventListService.update(payment)
    	  .then(reload);
    	  vm.selected = payment;
  	  
      };
      
      vm.deletePayment = function(id) {
    	  eventListService.destroy(id)
    	  .then(reload);
      };
      
	},
	controllerAs:'vm'
})