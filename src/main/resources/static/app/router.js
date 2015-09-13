(function(angular) {
    angular.module("myApp").config(['$routeProvider', '$httpProvider',
        function($routeProvider, $httpProvider) {
            $routeProvider.
                when('/', {
                    templateUrl: 'views/home.html',
//										templateUrl: 'home.html',
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
								when('/settings', {
									templateUrl: 'views/settings.html',
									controller: 'SettingsController'
								}).
								when('/login', {
									templateUrl: 'views/login.html',
									controller: 'LoginController'
								}).
                otherwise({
                    redirectTo: '/'
				});
				$httpProvider.defaults.headers.common["X-Requested-With"] = 'XMLHttpRequest';
		}]);
}(angular));
