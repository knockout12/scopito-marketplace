var app = angular.module('scopito.marketplace', ['ngRoute']);

app.config(['$routeProvider', function ($routeProvider) {
$routeProvider
// Home
.when("/", {templateUrl: "partials/search-page.html" , controller: 'SearchCtrl' , reloadOnSearch: false})
// Pages
.when("/about", {templateUrl: "partials/about-page.html"})
.when("/profile", {templateUrl: "partials/profile-page.html", controller: 'ProfileCtrl' , reloadOnSearch: false})
/* etc… routes to other pages… */
// Blog
.when("/blog", {templateUrl: "partials/blog.html"})
.when("/blog/post", {templateUrl: "partials/blog_item.html"})
// else 404
.otherwise("/404", {templateUrl: "partials/404.html"});
}]);

/**
* Controls the Blog
*/
app.controller('BlogCtrl', function (/* $scope, $location, $http */) {
console.log("Blog Controller reporting for duty.");
});

/**
* Controls all other Pages
*/
app.controller('PageCtrl', function (/* $scope, $location, $http */) {
console.log("Page Controller reporting for duty.");

// Activates the Carousel
$('.carousel').carousel({
interval: 5000
});

// Activates Tooltips for Social Links
$('.tooltip-social').tooltip({
selector: "a[data-toggle=tooltip]"
})
});



