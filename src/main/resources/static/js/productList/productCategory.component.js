productList.component('productCategory', {


	templateUrl: "/js/productList/productList.html",
	controller: ['Product',
		'$scope',
		'$http',
		'$location',
		'$routeParams', function (Product, $scope, $http, $location, $routeParams) {


			$scope.fetchProductByCategory = function () {

				$scope.products = Product.findByCategory({

					pid: $routeParams.pid

				}, function (product) {

					console.log(product);
				}, function () {

				});
			}
			$scope.fetchProductByCategory();
			$scope.remove = function (id) {

				Product.remove({
					pid: id
				}, function () {


					$scope.fetchProductByCategory();

				});
			}

		}]


})