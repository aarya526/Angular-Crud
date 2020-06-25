crudApp.config(['$routeProvider', '$locationProvider', function($routeProvider, $locationProvider) {

	// $locationProvider.html5Mode({

	// 	enabled : true,
	// 	requireBase : false

	// });
	$routeProvider.when('/', {

		template: "<app-home></app-home>"

	}).when('/productList', {

		template: '<product-list></product-list>'

	}).when('/addProduct', {

		template: "<product-add></product-add>"

	}).when('/updateProduct/:pid', {

		template: "<product-add></product-add>"

	}).when('/product-details/:pid', {

		template: '<product-detail></product-detail>'

	}).when('/findByCategory/:pid', {

		template: '<product-category></product-category>'

	}).when('/addTag', {

		template: "<add-tag></add-tag>"
	}).otherwise('/');

}])