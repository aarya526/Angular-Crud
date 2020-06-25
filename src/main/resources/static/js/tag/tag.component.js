tag.component('addTag', {

	templateUrl: "/js/tag/addTag.html",
	controller: function controller($scope) {


		$scope.tag = {};
		$scope.tags = [];

		$scope.submitTag = function() {

			$scope.tags.push($scope.tag);
			$scope.clear();

		}

		$scope.clear = function() {

			$scope.tag = {};

		}

	}
})