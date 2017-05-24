app.controller('PropertyController', ['PropertyService', function (PropertyService) {
    var self = this;
    self.headingTitle = "Property List";
    self.allProps = [];
    self.getAllProperties = function () {
        PropertyService.allProperties()
            .then(function (result) {
                self.allProps = (result !== 'null') ? result.data : [];
            });
    }
    self.getAllProperties();
}]);
