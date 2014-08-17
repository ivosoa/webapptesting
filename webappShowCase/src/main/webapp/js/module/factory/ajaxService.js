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
    addUser: function(user, callBack) {
      console.log("user; ", user);
      $http({
        method: 'POST',
        url: addUserUrl,
        data: user,
        headers: {'Content-Type': 'application/json'}
      }).success(function(data, status, headers, config) {
        callBack();
      });
    }
  };
});
