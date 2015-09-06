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

	angular.module("myApp").directive(function(){
		return {
			restrict: 'A',
			link: function(scope, element, attrs) {
				$(element).toolbar(scope.$eval(attrs.toolbarTip));
			}
		};
	});


  var WordController = function($scope,  Word, sharedService, $modal, $log, $http) {
		Word.query(function(response) {
			$scope.words = response ? response : [];
		});

//		$scope.items = ['item1', 'item2', 'item3'];
//		$scope.animationsEnabled = true;
//		$scope.open = function () {
//			var modalInstance = $modal.open({
//				animation: $scope.animationsEnabled,
//				templateUrl: 'myModalContent.html',
//				controller: 'ModalInstanceCtrl',
//				size: size,
//				resolve: {
//					items: function () {
//						return $scope.items;
//					}
//				}
//			});
//			modalInstance.result.then(function (selectedItem) {
//				$scope.selected = selectedItem;
//			}, function () {
//				$log.info('Modal dismissed at: ' + new Date());
//			});
//		};

		$scope.$on('handleBroadcast', function() {
			$scope.wordGroup = sharedService.wordGroup;
		});

		$scope.addWord = function(wordGroup, en, ko) {
        new Word({
						wordGroupId: wordGroup,
            en: en,
            ko: ko,
            memorized : false
        }).$save(function(word) {
                $scope.words.push(word);
        });
				$scope.wordGroup = "";
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

  WordController.$inject = ['$scope', 'Word', 'WordAndWordGroupSharedService'];
  angular.module("myApp.controllers").controller("WordController", WordController);


	var QuizController = function($scope, Quiz, element, attrs) {

		Quiz.query(function(response) {
			$scope.quizlist = response ? response : [];
		});

	};


	QuizController.$inject = ['$scope', 'Quiz'];
	angular.module("myApp.controllers").controller("QuizController", QuizController);

	var FancyDirective = function($compile, $http){
		return {
			restrict: 'A',

			controller: function($scope) {
				$scope.openFancybox = function (url) {
					$http.get(url).then(function(response) {
						if (response.status == 200) {

							var template = angular.element(response.data);
							var compiledTemplate = $compile(template);
							compiledTemplate($scope);

							$.fancybox.open({ content: template, type: 'html' });
						}
					});
				};
			}
		};
	};
	angular.module("myApp").directive("fancybox", FancyDirective);

	var WordGroupController = function($scope, WordGroup, sharedService) {
		WordGroup.query(function(response) {
			$scope.wordGroups = response ? response : [];
		});

		//test
		$scope.test = function(){
			console.log("WordGroupController :test");
		}
		$scope.selectedGroup = "";


		//
		$scope.handleClick = function(msg) {
			sharedService.prepForBroadcast(msg);
		};

		$scope.$on('handleBroadcast', function() {
			$scope.wordGroup = sharedService.wordGroup;
		});


		$scope.addWordGroup = function(name, description) {
			new WordGroup({
				name: name,
				description: description
			}).$save(function(wordGroup) {
					$scope.wordGroups.push(wordGroup);
				});
			$scope.name = "";
			$scope.description = "";

		};

		$scope.updateWordGroup = function(wordGroup) {
			wordGroup.$update();
		};

		$scope.deleteWordGroup = function(wordGroup) {
			wordGroup.$remove(function() {
				$scope.wordGroups.splice($scope.wordGroups.indexOf(wordGroup), 1);
			});
		};
	};

	WordGroupController.$inject = ['$scope', 'WordGroup', 'WordAndWordGroupSharedService'];
	angular.module("myApp.controllers").controller("WordGroupController", WordGroupController);


	var HomeController = function($scope, Word) {
		//test
		$scope.user = {
			name: 'awesome user'
		};


		$scope.users = [
			{id: 1, name: 'awesome user1', status: 2, group: 4, groupName: 'admin'},
			{id: 2, name: 'awesome user2', status: undefined, group: 3, groupName: 'vip'},
			{id: 3, name: 'awesome user3', status: 2, group: null}
		];

//

		$scope.saveUser = function(data, id) {
			//$scope.user not updated yet
			angular.extend(data, {id: id});
			return $http.post('/saveUser', data);
		};

		// remove user
		$scope.removeUser = function(index) {
			$scope.users.splice(index, 1);
		};

		// add user
		$scope.addUser = function() {
			$scope.inserted = {
				id: $scope.users.length+1,
				name: '',
				status: null,
				group: null
			};
			$scope.users.push($scope.inserted);
		};

	};
	HomeController.$inject = ['$scope', 'Home'];
	angular.module("myApp.controllers").controller("HomeController", HomeController);


}(angular));