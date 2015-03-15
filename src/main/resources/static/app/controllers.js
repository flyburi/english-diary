(function(angular) {
  var AppController = function($scope, Item) {
    Item.query(function(response) {
      $scope.items = response ? response : [];
    });
    
    $scope.addItem = function(description) {
      new Item({
        description: description,
        checked: false
      }).$save(function(item) {
        $scope.items.push(item);
      });
      $scope.newItem = "";
    };
    
    $scope.updateItem = function(item) {
      item.$update();
    };
    
    $scope.deleteItem = function(item) {
      item.$remove(function() {
        $scope.items.splice($scope.items.indexOf(item), 1);
      });
    };
  };
  
  AppController.$inject = ['$scope', 'Item'];
  angular.module("myApp.controllers").controller("AppController", AppController);


  var WordController = function($scope, Word) {
      Word.query(function(response) {
        $scope.words = response ? response : [];
    });

    $scope.addWord = function(en, ko) {
        new Word({
            en: en,
            ko: ko,
            memorized : false
        }).$save(function(word) {
                $scope.words.push(word);
        });
        $scope.en = "";
        $scope.ko = "";

    };

    $scope.updateWord = function(word) {
        word.$update();
    };

    $scope.deleteWord = function(word) {
        word.$remove(function() {
            $scope.words.splice($scope.words.indexOf(word), 1);
        });
    };
	};

  WordController.$inject = ['$scope', 'Word'];
  angular.module("myApp.controllers").controller("WordController", WordController);




	var QuizController = function($scope, Quiz) {

		Quiz.query(function(response) {
			$scope.quizlist = response ? response : [];
		});
	};

	QuizController.$inject = ['$scope', 'Quiz'];
	angular.module("myApp.controllers").controller("QuizController", QuizController);

	var HomeController = function($scope, Word) {

	};
	HomeController.$inject = ['$scope', 'Home'];
	angular.module("myApp.controllers").controller("HomeController", HomeController);

}(angular));