(function(angular) {
  angular.module("myApp.controllers", []);
  angular.module("myApp.services", []);
	angular.module("myApp.xeditable", []);
  angular.module("myApp", ["ngResource", "myApp.controllers", "myApp.services", "ngRoute","angularUtils.directives.dirPagination","ui.bootstrap","xeditable"]);


	angular.module("xeditable").run(function(editableOptions) {
		editableOptions.theme = 'bs3';
	});

}(angular));