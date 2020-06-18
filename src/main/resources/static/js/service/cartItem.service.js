cart.factory('CartItem', [ '$resource', function($resource) {

	return $resource('/sc/:pid', {}, {

		query : {

			params : {

				pid : "all"

			}

		}

	})

} ])