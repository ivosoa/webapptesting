/**
 * 
 * Service that broadcasts events
 * 
 */
angular.module("mainModule.factories").service('broadcastService',["$rootScope", function($rootScope){
    return{
      //every webapp has one $rootscope 
      //every scope is a descendant of rootscope
      //$broadcast dispatchs events downwards to all child scopes
      //$emit dispatchs events upwards
      updateUserList: function(){
        $rootScope.$broadcast("Form.UserAdded");
      },
      
      onUserAdded: function($scope, callback){
        $scope.$on("Form.UserAdded", function(event){
          return callback();
        });
      }     
    }
}])

