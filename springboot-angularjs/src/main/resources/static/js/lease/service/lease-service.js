app.service('LeaseService', ['$http',function ($http) {
        var self = this;

        self.allLeases = function () {
            console.log('get lease list');
            return $http.get('/lease/all')
                .then(function (response) {
                    return response;
                });
        };

    }
    ]
);