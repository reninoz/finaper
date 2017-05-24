app.service('CalculatorService', ['$http', '$log', function ($http, $log) {

    var REST_SERVICE_URI = 'http://localhost:8080/calculate/';

    var self = this;
    self.numberOfShare = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15];

    self.calculate = function (dto) {
        // var deferred = $q.defer();
        $log.log(dto);
        return $http.post(REST_SERVICE_URI + 'calculate', dto)
            .then(function (response) {
                return response;
            });
    };
}]);