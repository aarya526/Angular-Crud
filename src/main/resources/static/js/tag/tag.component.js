tag.component('addTag', {

	templateUrl: "/js/tag/addTag.html",
	controller: function controller($scope) {


		$scope.tag = {};
		$scope.tags = [
			/*			{
			
						"name": "Abhishek Arya",
						"phone": "971711363",
						"subject": "Economics"
			
					}, {
			
						"name": "Abhishek Arya",
						"phone": "971711363",
						"subject": "Economics"
			
					}, {
			
						"name": "Abhishek Arya",
						"phone": "971711363",
						"subject": "Economics"
			
					}, {
			
						"name": "Abhishek Arya",
						"phone": "971711363",
						"subject": "Economics"
			
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

	}
})