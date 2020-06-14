var crudApp = angular.module('crudApp', ['productAdd', 'productDetail',
	'productList', 'ngRoute']);

crudApp.directive('header', function () {
	return {
		restrict: 'A', //This menas that it will be used as an attribute and NOT as an element. I don't like creating custom HTML elements
		replace: true,
		templateUrl: "/js/directives/header.html",
		controller: ['$scope', '$filter', '$http', 'Product', function ($scope, $filter, $http, Product) {


			// $http({

			// 	method: "get",
			// 	url: "/product/categories"

			// }).then(function success(response) {

			// 	$scope.categories = response.data;

			// }, function error(response) {

			// 	alert(response.data);

			// });

			$scope.categories = ["Smartphones", "Laptops", "Tablets", "Accessories"];

		}]
	}
});