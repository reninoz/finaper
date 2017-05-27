app.controller('LeaseInfoController', ['LeaseService', '$routeParams', function (LeaseService, $routeParams) {
    var self = this;
    self.leaseDto = null;
    self.getLeaseAndRelatedRental = function () {
        console.log("LeaseInfoController for lease " + $routeParams.leaseId);
        LeaseService.leaseAndRelatedRental($routeParams.leaseId)
            .then(function (result) {
                console.log(result.data);
                self.leaseDto = result.data;
            });
    };
    self.getLeaseAndRelatedRental();
}]);
