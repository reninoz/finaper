app.controller('LoginCtrl', ['UserService', '$location', function (UserService, $location) {
    var self = this;
    self.user = {userName: '', password: ''};
    self.login = function () {
        UserService.login(self.user).then(function (success) {
            $location.path('/leases');
        }, function (error) {
            self.errorMessage = error.data.msg;
        })
    };
}])