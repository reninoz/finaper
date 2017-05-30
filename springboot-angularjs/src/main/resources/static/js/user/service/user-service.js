app.factory('UserService', ['$http', function ($http) {
    var service = {
        isLoggedIn: false,
        session: function () {
            return $http.get('/user/session').then(function (response) {
                service.isLoggedIn = true;
                return response;
            });
        },
        login: function (user) {
            return $http.post('/user/login', user).then(function (response) {
                service.isLoggedIn = true;
                return response;
            });
        }
    };
    return service;
}]);