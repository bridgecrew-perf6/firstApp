<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>SALES</title>

    <link rel="stylesheet" href="../../resources/css/bootstrap-4.3.1-dist/css/bootstrap.min.css"/>
</head>
<body  ng-app="myPredictor">
<div class="container" style="margin-top: 30px">
    <div class="row">
        <div class="col-md-12">
            <div class="tab-pane">
                <div class="card-header"><b>Sales Our Products</b></div>
                <div class="text-body">
                    <table class="table table-striped">
                        <th>
                        <table class="table table-striped" ng-controller="AqsiController">
                            <thead>
                            <tr>
                                <th>dishName</th>
                                <th>Tirage</th>
                                <th>Nautilus</th>
                                <th>HH cafe</th>
                            </tr>
                            </thead>
                            <tbody>
                            <tr ng-repeat="item in reciepes">
                                <td>{{item.dish_name}}</td>
                                <td>{{item.tirage_amount}}</td>
                                <td>{{item.naut_amount}}</td>
                                <td>{{item.hh_amount}}</td>
                            </tr>
                            </tbody>
                        </table>
                        </th>
                        <th>
                            <table class="table table-striped" ng-controller="QRController">
                                <thead>
                                <tr>
                                    <th>B1</th>
                                    <th>B2</th>
                                    <th>NRD</th>
                                    <th>HPE</th>
                                </tr>
                                </thead>
                                <tbody>
                                <tr ng-repeat="item in reciepesQR">
                                    <td>{{item.b1_amount}}</td>
                                    <td>{{item.b2_amount}}</td>
                                    <td>{{item.nrd_amount}}</td>
                                    <td>{{item.hpe_amount}}</td>
                                </tr>
                                </tbody>
                            </table>
                        </th>
                    </table>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.8.2/angular.min.js"></script>
<script type="text/javascript" src="../../resources/js/main.js"></script>
</body>
</html>