(function(angular) {
  angular.module("myApp.controllers", []);
  angular.module("myApp.services", []);
	angular.module("myApp.xeditable", []);
  angular.module("myApp", ["ngResource", "myApp.controllers", "myApp.services", "ngRoute","angularUtils.directives.dirPagination","ui.bootstrap","xeditable"]);
//	angular.module("myApp", ["ngResource", "myApp.controllers", "myApp.services", "ngRoute","angularUtils.directives.dirPagination","ui.bootstrap"]);
//angular.module('myApp', [ 'ngRoute' ]);
	angular.module("xeditable").run(function(editableOptions) {
		editableOptions.theme = 'bs3';
	});


//	var FancyDirective = function($compile, $http){
//		return {
//			restrict: 'A',
//
//			controller: function($scope) {
//				$scope.openFancybox = function (url) {
//					$http.get(url).then(function(response) {
//						if (response.status == 200) {
//
//							var template = angular.element(response.data);
//							var compiledTemplate = $compile(template);
//							compiledTemplate($scope);
//
//							$.fancybox.open({ content: template, type: 'html' });
//						}
//					});
//				};
//			}
//		};
//	};
//	angular.module("myApp").directive("fancybox", FancyDirective);

}(angular));