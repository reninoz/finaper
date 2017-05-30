app.controller('CalculatorCtrl', ['$log', 'CalculatorService', 'LeaseService', 'CalendarService',
    function ($log, CalculatorService, LeaseService, CalendarService) {
        var self = this;

        self.allLeases = [];
        self.getAllLeases = function () {
            LeaseService.allLeases()
                .then(function (result) {
                    self.allLeases = (result !== 'null') ? result.data : [];
                });
        }
        self.getAllLeases();

        self.calculate = function () {
            // $log.log(self.dto);
            CalculatorService.calculate(self.dto).then(function (response) {
                self.dto = response.data;
            })
        }

        self.numberOfShare = CalculatorService.numberOfShare;

        self.init = function () {
            self.dto = {};
            // self.dto.payFor = 'Dickson';
            // self.dto.payer = 'Someone';
            self.dto.numberOfPersonShareForWater = 5;
            self.dto.numberOfPersonShareForElectrical = 5;
            self.dto.numberOfPersonShareForGas = 5;
            self.dto.electricalSupplyStartDate = new Date();
            ;
            self.dto.electricalSupplyEndDate = new Date();
            ;
            self.dto.electricalConsumStartDate = new Date();
            self.dto.electricalConsumEndDate = new Date();
            self.dto.waterConsumStartDate = new Date();
            self.dto.waterConsumEndDate = new Date();
            self.dto.waterSupplyAmount = 200;
            self.dto.waterConsumAmount = 200;
            self.dto.gasSupplyStartDate = new Date();
            self.dto.gasSupplyEndDate = new Date();
            self.dto.gasConsumStartDate = new Date();
            self.dto.gasConsumEndDate = new Date();
            self.dto.gasSupplyAmount = 200;
            self.dto.gasConsumAmount = 200;
            self.dto.supplyStartDateAbsent = new Date();
            self.dto.supplyEndDateAbsent = new Date();
            self.dto.consumStartDateAbsent = new Date();
            self.dto.consumEndDateAbsent = new Date();
            self.dto.waterSupplyStartDate = new Date();
            self.dto.waterSupplyEndDate = new Date();
            self.dto.electricalSupplyAmount = 200;
            self.dto.electricalConsumAmount = 300;
        };
        self.init();

        self.clear = function () {

            self.dto.waterSupplyStartDate = null;

        };




        self.openElectricalSupplyStartDate = function () {
            self.electricalSupplyStartDatePopup.opened = true;
        };

        self.openElectricalSupplyEndDate = function () {
            self.electricalSupplyEndDatePopup.opened = true;
        };

        self.openElectricalConsumStartDate = function () {
            self.electricalConsumStartDatePopup.opened = true;
        };

        self.openElectricalConsumEndDate = function () {
            self.electricalConsumEndDatePopup.opened = true;
        };

        self.openWaterSupplyStartDate = function () {
            self.waterSupplyStartDatePopup.opened = true;
        };

        self.openWaterSupplyEndDate = function () {
            self.waterSupplyEndDatePopup.opened = true;
        };

        self.openWaterConsumStartDate = function () {
            self.waterConsumStartDatePopup.opened = true;
        };

        self.openWaterConsumEndDate = function () {
            self.waterConsumEndDatePopup.opened = true;
        };

        self.openGasSupplyStartDate = function () {
            self.gasSupplyStartDatePopup.opened = true;
        };

        self.openGasSupplyEndDate = function () {
            self.gasSupplyEndDatePopup.opened = true;
        };

        self.openGasConsumStartDate = function () {
            self.gasConsumStartDatePopup.opened = true;
        };

        self.openGasConsumEndDate = function () {
            self.gasConsumEndDatePopup.opened = true;
        };

        self.openConsumStartDateAbsent = function () {
            self.consumStartDateAbsentPopup.opened = true;
        };

        self.openConsumEndDateAbsent = function () {
            self.consumEndDateAbsentPopup.opened = true;
        };

        self.openSupplyStartDateAbsent = function () {
            self.supplyStartDateAbsentPopup.opened = true;
        };

        self.openSupplyEndDateAbsent = function () {
            self.supplyEndDateAbsentPopup.opened = true;
        };

        self.setDate = function (year, month, day) {
            self.dto.waterSupplyStartDate = new Date(year, month, day);
        };


        self.electricalSupplyStartDatePopup = {
            opened: false
        };

        self.electricalSupplyEndDatePopup = {
            opened: false
        };

        self.electricalConsumStartDatePopup = {
            opened: false
        };

        self.electricalConsumEndDatePopup = {
            opened: false
        };

        self.waterSupplyStartDatePopup = {
            opened: false
        };

        self.waterSupplyEndDatePopup = {
            opened: false
        };

        self.waterConsumStartDatePopup = {
            opened: false
        };

        self.waterConsumEndDatePopup = {
            opened: false
        };


        self.gasSupplyStartDatePopup = {
            opened: false
        };

        self.gasSupplyEndDatePopup = {
            opened: false
        };

        self.gasConsumStartDatePopup = {
            opened: false
        };

        self.gasConsumEndDatePopup = {
            opened: false
        };


        self.consumStartDateAbsentPopup = {
            opened: false
        };

        self.consumEndDateAbsentPopup = {
            opened: false
        };

        self.supplyStartDateAbsentPopup = {
            opened: false
        };

        self.supplyEndDateAbsentPopup = {
            opened: false
        };

        self.formats = CalendarService.formats;
        self.format = self.formats[0];
        self.altInputFormats = CalendarService.altInputFormats;

        self.inlineOptions = CalendarService.inlineOptions;

        self.dateOptions = CalendarService.dateOptions;

        /*// Disable weekend selection
         function disabled(data) {
         var date = data.date,
         mode = data.mode;
         return mode === 'day' && (date.getDay() === 0 || date.getDay() === 6);
         }*/

        self.toggleMin = function () {
            self.inlineOptions.minDate = self.inlineOptions.minDate ? null : new Date();
            self.dateOptions.minDate = self.inlineOptions.minDate;
        };
        //
        self.toggleMin();

    }]);