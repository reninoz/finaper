app.controller('LeaseInfoController', ['LeaseService', '$routeParams', function (LeaseService, $routeParams) {
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


    self.formats = ['dd-MMMM-yyyy', 'yyyy/MM/dd', 'dd.MM.yyyy', 'shortDate'];
    self.format = self.formats[0];
    self.altInputFormats = ['M!/d!/yyyy'];

    self.dateOptions = {
        // dateDisabled: disabled,
        formatYear: 'yy',
        maxDate: new Date(2020, 5, 22),
//        minDate: new Date(),
        startingDay: 1
    };

    self.newRentalDatePaidPopup = {
        opened: false
    };

    self.openNewRentalDatePaid = function() {
        self.newRentalDatePaidPopup.opened = true;
    };
}]);
