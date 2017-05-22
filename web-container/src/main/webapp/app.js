angular.module('scopito.marketplace', ['ngRoute'])
.config(['$routeProvider', function($routeProvider) {
	$routeProvider
		.otherwise({redirectTo:  '/'})
		.when('/', {templateUrl: 'templates/navigation.html', controller: 'DashboardPageCtrl', reloadOnSearch: false});
}])
.service('DashboardService', ['$http', function($http) {
    var service = {};

    service.list = function() {
        return $http.get('/service/profile');
    };

    return service;
}])
.service('ProfileService', ['$http', function($http) {
    var whatever = {};

    whatever.listAll = function() {
        return $http.get('/service/profile/list');
    };

    whatever.get = function(scopitoID) {
        return $http.get('/service/profile/'+scopitoID);
    };

    return whatever;
}])


.controller('ProfilePageCtrl', ['$scope', 'ProfileService', function($scope, ProfileService) {
    $scope.items = [];

    $scope.refreshList = function() {
        ProfileService.list().then(function(response) {
            $scope.items = response.data;
        });
    };
}]);

.controller('DashboardPageCtrl', ['$scope', 'DashboardService', function($scope, DashboardService) {
    $scope.items = [];

    $scope.refreshList = function() {
        DashboardService.list().then(function(response) {
            $scope.items = response.data;
        });
    };
}]);

