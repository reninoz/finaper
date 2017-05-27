app.service('LeaseService', ['$http', function ($http) {
        var self = this;

        self.allLeases = function () {
            console.log('get lease list');
            return $http.get('/lease/all')
                .then(function (response) {
                    return response;
                });
        };

        self.leaseAndRelatedRental = function (leaseId) {
            console.log('get lease and rental');
            return $http.get('/lease/' + leaseId)
                    then(function (response) {
                        return response;
                    });
        };

    }
    ]
);