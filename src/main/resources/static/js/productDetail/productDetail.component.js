product.component('productDetail', {

	templateUrl : "/js/productDetail/productDetail.html",
	controller : [
			'$routeParams',
			'Product',
			'$scope',
			'$http',
			function productDetailsController($routeParams, Product, $scope,
					$http) {

				$scope.product = Product.get({
					pid : $routeParams.pid
				}, function(product) {

					console.log(product);

				});

			} ]

})