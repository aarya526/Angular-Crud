productList.component('productList',
	{

		templateUrl: "/js/productList/productList.html",
		controller: [
			'Product',
			'$scope',
			'$http',
			'$routeParams',
			function productListController(Product, $scope, $http,
				$routeParams) {

				$scope.products = [];

				$scope.fetchAllProducts = function () {

					$scope.products = Product.query();
					console.log($scope.products);

				}

				$scope.fetchAllProducts();

				$scope.remove = function (id) {

					Product.remove({
						pid: id
					}, function () {

						$scope.fetchAllProducts();

					});
				}


			}]
	});