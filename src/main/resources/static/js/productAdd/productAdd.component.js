productAdd.component('productAdd', {

	templateUrl: "/js/productAdd/addProduct.html",
	controller: [
		'Product',
		'$scope',
		'$http',
		'$routeParams',
		'$window',
		function productController(Product, $scope, $http, $routeParams,
			$window) {


			$scope.categories = ["Smartphones", "Laptops", "Tablets", "Accessories"];

			if ($routeParams.pid != null) {

				$scope.state = 1;
				$scope.product = Product.get({
					pid: $routeParams.pid
				}, function (product) {

					console.log(product);

				});
			} else {

				$scope.state = 0;
				$scope.product = new Product();
			}


			// $http({
			// 	method: "Get",
			// 	url: "/product/categories"
			// }).then(function success(response) {
			// 	$scope.categories = response.data;

			// }, function error(response) {
			// 	alert(response.data);
			// });


			$scope.save = function () {

				var product = $scope.product;
				Product.save(product, function successResponse() {

					console.log('\nProduct Inserted!');
					$scope.reset();
					$window.location.href = "/#!/products";

				}, function errorResponse(response) {

					console.log(response.data);
					$scope.errors = response.data;

				});

			}

			$scope.update = function () {

				$scope.state = 1;
				var product = $scope.product;

				Product.update(product, function successResponse() {
					console.log('\nProduct Updated!');
					$scope.reset();
					$window.location.href = "/#!/products";
				}, function errorResponse(response) {

					console.log(response.data);
					$scope.errors = response.data;

				});

			}

			$scope.submit = function () {

				if ($scope.product.id == null) {

					$scope.save();

				} else {

					$scope.update();
				}
			}

			$scope.reset = function () {

				$scope.product = {};
				$scope.errors = {};
			}

		}]

});