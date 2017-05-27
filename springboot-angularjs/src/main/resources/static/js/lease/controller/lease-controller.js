app.controller('LeaseController', ['LeaseService', function (LeaseService) {
    var self = this;
    self.headingTitle = "Current Lease List";
    self.allLease = [];
    self.getAllLease = function () {
        console.log('get lease list');
        LeaseService.allLeases()
            .then(function (result) {
                self.allLease = (result !== 'null') ? result.data : [];
            });
    }
    self.getAllLease();

}]);
