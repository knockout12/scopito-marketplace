angular.module('scopito.marketplace', ['ngRoute'])
.config(['$routeProvider', function($routeProvider) {
	$routeProvider
		.otherwise({redirectTo:  '/'})
		.when('/', {templateUrl: 'templates/navigation.html', controller: 'DashboardPageCtrl', reloadOnSearch: false});
}])
.service('DashboardService', ['$http', function($http) {
    var service = {};

    service.list = function() {
        return $http.get('/service/dashboard');
    };

    return service;
}])
.controller('DashboardPageCtrl', ['$scope', 'DashboardService', function($scope, DashboardService) {
    $scope.items = [];

    $scope.refreshList = function() {
        DashboardService.list().then(function(response) {
            $scope.items = response.data;
        });
    };
}]);

