tag.component('addTag', {

	templateUrl: "/js/tag/addTag.html",
	controller: function controller($scope) {


		$scope.tag = {};
		$scope.tags = [
			/*{

				"name": "Abhishek Arya",
				"phone": "971711363",
				"subject": "A"

			}, {

				"name": "Abhishek Arya",
				"phone": "971711363",
				"subject": "B"

			}, {

				"name": "Abhishek Arya",
				"phone": "971711363",
				"subject": "C"

			}, {

				"name": "Abhishek Arya",
				"phone": "971711363",
				"subject": "D"

			}*/
		];

		$scope.submitTag = function() {

			$scope.tags.push($scope.tag);
			$scope.clear();
			$('#myModal').modal("hide");

		}

		$scope.clear = function() {

			$scope.tag = {};

		}

		$scope.delete = function(tag) {

			var removeIndex = $scope.tags.indexOf(tag);
			if (removeIndex != -1) {
				console.log($scope.tags[removeIndex]);
				$scope.tags.splice(removeIndex, 1);
			}
		}

	}
})