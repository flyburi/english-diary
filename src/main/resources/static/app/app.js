(function(angular) {
  angular.module("myApp.controllers", []);
  angular.module("myApp.services", []);
  angular.module("myApp", ["ngResource", "myApp.controllers", "myApp.services", "ngRoute"]);
  //angular.module("myApp", ["ngResource", "myApp.controllers", "myApp.services","ui.router"]);
}(angular));