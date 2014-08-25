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
    $scope.selected;

    $scope.getUserList = function() {
      ajaxService.getUserList().then(function(result) {
        $scope.userList = result.data;
      });
    };

    $scope.selectUser = function(elem) {
      //select 
      if ($scope.selected !== elem.id) {
        $scope.selected = elem.id;
      }
      //deselect
      else{
        $scope.selected = '';
      }
    };

    $scope.delete = function(id) {
      ajaxService.deleteUser(id, function() {
        $scope.getUserList();
      });
    };

    //used by the list for styling
    $scope.isSelected = function(id) {
      return $scope.selected === id;
    };


    //catch event and update the List accordingly
    $scope.$on('Form.UserAdded', function(event) {
      //update the list
      $scope.getUserList();
    });

    $scope.getUserList();
  }]);
    