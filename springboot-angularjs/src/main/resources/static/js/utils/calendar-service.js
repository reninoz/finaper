app.service('CalendarService', [function () {
    var self = this;
    self.formats = ['dd-MMMM-yyyy', 'yyyy/MM/dd', 'dd.MM.yyyy', 'shortDate'];
    self.format = self.formats[0];
    self.altInputFormats = ['M!/d!/yyyy'];

    self.inlineOptions = {
        customClass: self.getDayClass,
        // minDate: new Date(),
        showWeeks: true
    };

    self.dateOptions = {
        dateDisabled: self.disabled,
        formatYear: 'yy',
        maxDate: new Date(2020, 5, 22),
        // minDate: new Date(),
        startingDay: 1
    };

// Disable weekend selection
    self.disabled = function (data) {
        var date = data.date,
            mode = data.mode;
        return mode === 'day' && (date.getDay() === 0 || date.getDay() === 6);
    }

    /*
     * var tomorrow = new Date(); tomorrow.setDate(tomorrow.getDate() + 1); var
     * afterTomorrow = new Date(); afterTomorrow.setDate(tomorrow.getDate() + 1);
     * self.events = [ { date: tomorrow, status: 'full' }, { date: afterTomorrow,
     * status: 'partially' } ];
     */
    self.getDayClass = function (data) {
        var date = data.date,
            mode = data.mode;
        if (mode === 'day') {
            var dayToCheck = new Date(date).setHours(0, 0, 0, 0);

            for (var i = 0; i < self.events.length; i++) {
                var currentDay = new Date(self.events[i].date).setHours(0, 0, 0, 0);

                if (dayToCheck === currentDay) {
                    return self.events[i].status;
                }
            }
        }

        return '';
    }
}]);
