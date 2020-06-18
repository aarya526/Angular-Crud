var crudApp = angular.module('crudApp', [ 'product', 'cartItem', 'ngRoute' ]);

crudApp.directive('header', function() {
	return {
		restrict : 'A', // This menas that it will be used as an attribute and
		// NOT as an element. I don't like creating custom HTML
		// elements
		replace : true,
		templateUrl : "/js/directives/header.html",
		controller : [ '$scope', '$filter', '$http',
				function($scope, $filter, $http) {

					$http({

						method : "get",
						url : "/product/categories"

					}).then(function success(response) {

						$scope.categories = response.data;

					}, function error(response) {

					});

				} ]
	}
});
crudApp.controller("cartController", function controller($http, $scope) {

	$scope.addToCart = function(pid) {

		$http({

			method : "post",
			url : "/sc/addToCart",
			params : {

				id : pid

			}

		}).then(function success(response) {

			console.log(response.data);

		}, function error() {

		});

	}

});