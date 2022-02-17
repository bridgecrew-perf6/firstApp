var app = angular.module("myPredictor", []);

app.controller("AqsiController", function($scope, $http) {

    $scope.reciepes = [];

    $scope.reciepesQR = [];

    $http.get("http://localhost:8080/aqsi/sales").then(function(response) {
        var data = response.data;

        $scope.reciepes = data
    });
});

app.controller("QRController", function($scope, $http) {

    $http.get("http://localhost:8080/qr/sales").then(function (response) {
        var dataQR = response.data;

        $scope.reciepesQR = dataQR;
    })
});
