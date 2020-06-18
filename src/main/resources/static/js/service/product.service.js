product.factory('Product', [ '$resource', function($resource) {

	return $resource('product/:pid', {}, {

		query : {

			method : "get",
			params : {

				pid : 'all'

			},
			isArray : true
		},
		update : {

			method : 'PUT'
		},
		findByCategory : {

			method : "get",
			url : "/product/category/:pid",
			isArray : true

		}

	})

} ]);