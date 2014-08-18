angular.module("mainModule.controllers").controller("contentController", ["$scope", "ajaxService", "broadcastService",
  function($scope, ajaxService, broadcastService) {
    $scope.userForm = {};

    $scope.addUser = function() {
      ajaxService.addUser($scope.userForm, function(){
        broadcastService.updateUserList();
        $scope.userForm = {};
      });
    };  
  }]);

