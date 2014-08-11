/**
 * Definition of listcontroller
 * $scope, ajaxService and docService are injected so they can be used by the controller
 * 
 * - ajaxService contains all ajax requests
 * - docService is used to inform other controllers that doc has changed
 * 
 */

angular.module("mainModule.controllers").controller("listController", ["$scope", "ajaxService"/*, "docService"*/,
  function($scope, ajaxService /*, docService*/) {

    //UserList initialization
    $scope.userList = [];

    $scope.getUserList = function() {
      ajaxService.getUserList().then(function(result) {
        $scope.userList = result.data;
      });
    };
    
    $scope.getUserList();
  }]);
    