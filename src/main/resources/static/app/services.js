(function(angular) {
  var ItemFactory = function($resource) {
    return $resource('/items/:id', {
      id: '@id'
    }, {
      update: {
        method: "PUT"
      },
      remove: {
        method: "DELETE"
      }
    });
  };
  
  ItemFactory.$inject = ['$resource'];
  angular.module("myApp.services").factory("Item", ItemFactory);

  var WordFactory = function($resource) {
        return $resource('/words/:id', {
            id: '@id'
        }, {
            update: {
                method: "PUT"
            },
            remove: {
                method: "DELETE"
            }
        });
	};

	WordFactory.$inject = ['$resource'];
	angular.module("myApp.services").factory("Word", WordFactory);

	//
	var WordGroupFactory = function($resource) {
		return $resource('/wordGroups/:id', {
			id: '@id'
		}, {
			update: {
				method: "PUT"
			},
			remove: {
				method: "DELETE"
			}
		});
	};

	WordGroupFactory.$inject = ['$resource'];
	angular.module("myApp.services").factory("WordGroup", WordGroupFactory);
	//

	var QuizFactory = function($resource) {
			return $resource('/quiz/:id', {
					id: '@id'
			}, {
					update: {
						method: "PUT"
					},
					remove: {
							method: "DELETE"
					}
			});
    };

	QuizFactory.$inject = ['$resource'];
	angular.module("myApp.services").factory("Quiz", QuizFactory);

	var HomeFactory = function($resource) {
			return $resource('/home/:id', {
					id: '@id'
			}, {
					update: {
							method: "PUT"
					},
					remove: {
							method: "DELETE"
					}
			});
	};

	HomeFactory.$inject = ['$resource'];
	angular.module("myApp.services").factory("Home", HomeFactory);


	var WordAndWordGroupSharedFactory = function($rootScope){
		var sharedService = {};

		sharedService.wordGroup = '';

		sharedService.prepForBroadcast = function(msg) {
			this.wordGroup = msg;
			this.broadcastItem();
		};

		sharedService.broadcastItem = function() {
			$rootScope.$broadcast('handleBroadcast');
		};

		return sharedService;
	};

	angular.module("myApp.services").factory('WordAndWordGroupSharedService', WordAndWordGroupSharedFactory);

}(angular));