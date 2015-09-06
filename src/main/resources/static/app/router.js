(function(angular) {
    angular.module("myApp").config(['$routeProvider',
        function($routeProvider) {
            $routeProvider.
                when('/', {
                    templateUrl: 'views/home.html',
                    controller: 'HomeController'
                }).
                when('/word', {
                    templateUrl: 'views/word.html',
                    controller: 'WordController'
                }).
								when('/wordGroup', {
									templateUrl: 'views/word-group.html',
									controller: 'WordGroupController'
								}).
                when('/quiz', {
                    templateUrl: 'views/quiz.html',
                    controller: 'QuizController'
                }).
                otherwise({
                    redirectTo: '/'
				});
		}]);
}(angular));
