cart
	.component(
		'cartStatus',
		{

			template: "<a class='form-inline btn btn-info my-2 my-sm-0' href='/#!/'>Cart : {{cartCounter}}</a>",
			controller: function cartController($http, CartItem,
				$scope) {

				/*$http({
					method : "get",
					url : "/sc/count"
				}).then(function success(response) {

					CartItem = response.data;

				}, function error(response) {

				});*/

			}

		})