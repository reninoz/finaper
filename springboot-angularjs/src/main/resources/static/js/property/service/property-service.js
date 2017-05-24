app.service('PropertyService', ['$http',function ($http) {
    var self = this;

    self.allProperties = function () {
        return $http.get('/property/all')
            .then(function (response) {
                return response;
            });
    };

}
]
);