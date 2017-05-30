app.controller('LeaseController', ['LeaseService', 'PagerService',
    function (LeaseService, PagerService) {
        var self = this;
        self.headingTitle = "Current Lease List";
        self.allLease = [];
        self.getAllLease = function () {
            console.log('get lease list');
            LeaseService.allLeases()
                .then(function (result) {
                    self.allLease = (result !== 'null') ? result.data : [];
                    console.log('data returned size ' + self.allLease.length);
                    self.totalItems = self.allLease.length;
                });
        }
        self.getAllLease();

        self.data = self.allLease;

        self.viewby = PagerService.viewby;
        console.log(self.allLease);
        self.totalItems = self.data.length;
        console.log('data.length: ' + self.totalItems);
        self.currentPage = PagerService.currentPage;
        self.itemsPerPage = self.viewby;
        self.maxSize = PagerService.maxSize; //Number of pager buttons to show

        self.setPage = function (pageNo) {
            self.currentPage = pageNo;
        };

        self.pageChanged = function () {
            console.log('Page changed to: ' + self.currentPage);
        };

        self.setItemsPerPage = function (num) {
            self.itemsPerPage = num;
            self.currentPage = 1; //reset to first paghe
        };
    }]);
