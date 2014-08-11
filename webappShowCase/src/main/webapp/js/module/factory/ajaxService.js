/**
 * Service that contains all Ajax Requests
 */
angular.module("mainModule.factories").factory('ajaxService', function($http) {
  var getUserListUrl = "getUserList";
  var addUserUrl = "addUser";

  return{
    //get the userList from the webserver
    getUserList: function() {
      return $http.get(getUserListUrl);
    },
    
    //add User(json) to Database
    addUser: function(user) {
      $http({
        method: 'POST',
        url: addUserUrl,
        data: user,
        headers: {'Content-Type': 'application/x-www-form-urlencoded'}
      });
    }
  };
});
