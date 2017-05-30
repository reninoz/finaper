app.controller('LeaseInfoController', [ '$routeParams','LeaseService','CalendarService',
    function ($routeParams,LeaseService, CalendarService ) {
    var self = this;

    self.showNewRental = false;

    self.toggleNewRentalPanel = function () {
        console.log('toggleNewRentalPanel .......showNewRental = ' + self.showNewRental)
        self.showNewRental = !self.showNewRental;
        if(self.showNewRental) {
            self.setNewRetalDefaultValues();
        }
    }

    //set default values for new rental payment
    self.setNewRetalDefaultValues = function() {
        self.leaseDto.newRental = {};
        self.leaseDto.newRental.title = 'Rental';
        self.leaseDto.newRental.description = 'Fully Paid';
        self.leaseDto.newRental.amount = self.leaseDto.lease.monthlyRent;
    }

    self.getLeaseAndRelatedRental = function () {
        console.log("LeaseInfoController for lease " + $routeParams.leaseId);
        LeaseService.leaseAndRelatedRental($routeParams.leaseId)
            .then(function (result) {
                console.log(result.data);
                self.leaseDto = result.data;
            });
    };
    self.getLeaseAndRelatedRental();

    self.addNewRentalPayment = function () {
        console.log("add new rental paymnet");
        LeaseService.addNewRentalPayment(self.leaseDto)
            .then(function (result) {
                self.leaseDto = result.data;
                self.showNewRental = false;
            })
    }


        self.inlineOptions = CalendarService.inlineOptions;

        self.dateOptions = CalendarService.dateOptions;

        self.formats = CalendarService.formats;
        self.format = CalendarService.format;
        self.altInputFormats = CalendarService.altInputFormats;

        self.dateOptions = CalendarService.dateOptions;

    self.newRentalDatePaidPopup = {
        opened: false
    };

    self.openNewRentalDatePaid = function() {
        self.newRentalDatePaidPopup.opened = true;
    };
}]);
