angular.module('scopito.marketplace', ['ngRoute'])
.config(['$routeProvider', function($routeProvider) {
	$routeProvider
		.otherwise({redirectTo:  '/'})
		.when('/', {templateUrl: 'Profilepage.html', controller: 'ProfilepageCtrl', reloadOnSearch: false});
}])
.service('ProfileService', ['$http', function($http) {
    var service = {};

    service.list = function() {
        return $http.get('/service/profilepage');
    };

    return service;
}])
.controller('ProfilepageCtrl', ['$scope', 'ProfileService', function($scope, SearchService) {
    $scope.items = [];

    $scope.refreshList = function() {
        DashboardService.list().then(function(response) {
            $scope.items = response.data;
        });
    };
}]);