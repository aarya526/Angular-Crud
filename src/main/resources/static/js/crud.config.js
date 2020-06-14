crudApp.config(['$routeProvider', '$locationProvider', function ($routeProvider, $locationProvider) {

	// $locationProvider.html5Mode({

	// 	enabled : true,
	// 	requireBase : false

	// });
	$routeProvider.when('/', {

		template: "<product-list></product-list>"

	}).when('/addProduct', {

		template: "<product-add></product-add>"

	}).when('/updateProduct/:pid', {

		template: "<product-add></product-add>"

	}).when('/product-details/:pid', {

		template: '<product-detail></product-detail>'

	}).when('/findByCategory/:pid', {

		template: '<product-category></product-category>'

	})
		// .when('/login', {
		// 	template: '<login-controller></login-controller>'
		// })
		.otherwise('/');

}])
// .run(['$rootScope', '$location', '$cookies', '$http',
//     function ($rootScope, $location, $cookies, $http) {
//         // keep user logged in after page refresh
//         $rootScope.globals = $cookies.get('globals') || {};
//         if ($rootScope.globals.currentUser) {
//             $http.defaults.headers.common['Authorization'] = 'Basic ' + $rootScope.globals.currentUser.authdata; // jshint ignore:line
//         }

//         $rootScope.$on('$locationChangeStart', function (event, next, current) {
//             // redirect to login page if not logged in
//             if ($location.path() !== '/login' && !$rootScope.globals.currentUser) {
//                 $location.path('/login');
//             }
//         });
//     }]);

