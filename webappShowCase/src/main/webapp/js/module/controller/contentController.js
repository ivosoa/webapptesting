angular.module("mainModule.controllers").controller("contentController", ["$scope", "ajaxService"/*, "docService"*/,
  function($scope, ajaxService/*, docService*/) {
    $scope.userForm = {};

    $scope.addUser = function() {
      ajaxService.addUser($scope.userForm);
    };  
  }]);

