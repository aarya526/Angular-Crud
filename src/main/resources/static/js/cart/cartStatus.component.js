cart
		.component(
				'cartStatus',
				{

					template : "<a class='form-inline btn btn-info my-2 my-sm-0' href='/#!/'>Cart : {{cartCounter}}</a>",
					controller : function cartController($http, $scope) {

						$http({
							method : "get",
							url : "/sc/count"
						}).then(function success(response) {

							$scope.cartCounter = response.data;

						}, function error(response) {

						});

					}

				})