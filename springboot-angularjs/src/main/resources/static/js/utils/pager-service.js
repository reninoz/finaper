app.service('PagerService', [ function () {
    var self = this;
    self.data = [];

    self.viewby = 5;
    self.totalItems = self.data.length;
    console.log('data.length: ' + self.totalItems);
    self.currentPage = 1;
    self.itemsPerPage = self.viewby;
    self.maxSize = 5; //Number of pager buttons to show
/*
    self.setPage = function (pageNo) {
        self.currentPage = pageNo;
    };

    self.pageChanged = function () {
        console.log('Page changed to: ' + self.currentPage);
    };

    self.setItemsPerPage = function (num) {
        self.itemsPerPage = num;
        self.currentPage = 1; //reset to first paghe
    };*/
}])