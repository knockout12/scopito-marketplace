var app = angular.module('scopito.marketplace', ['ngRoute' , 'angular-lightbox' ,/* 'angularModalService'  , 'ngMaterial' , 'ngMessages' , 'material.svgAssetsCache' */ ]); /* Dependencies for fiddles */

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

/* Navbar highlight fiddling
app.directive('bsNavbar', function($location) {
  'use strict';

  return {
    restrict: 'A',
    link: function postLink(scope, element, attrs, controller) {
      // Watch for the $location
      scope.$watch(function() {
        return $location.path();
      }, function(newValue, oldValue) {

        $('li[data-match-route]', element).each(function(k, li) {
          var $li = angular.element(li),
            // data('match-rout') does not work with dynamic attributes
            pattern = $li.attr('data-match-route'),
            regexp = new RegExp('^' + pattern + '$', ['i']);

          if(regexp.test(newValue)) {
            $li.addClass('active');
          } else {
            $li.removeClass('active');
          }

        });
      });
    }
  };
});
*/




/** - Dialog code based on AngularJS Material demo
Copyright 2016 Google Inc. All Rights Reserved.
Use of this source code is governed by an MIT-style license that can be foundin the LICENSE file at http://material.angularjs.org/HEAD/license.
**/


app.controller('SearchCtrl', function ($scope , modalService/* , $mdDialog */) {
console.log("Search Controller reporting for duty.");
 //Loads grid view on startup AFTER the DOM is ready
 $scope.$on('$viewContentLoaded', function() {

    $scope.layout = "grid";

  });
    /* Modal fiddling #2
    ModalService.showModal({
        templateUrl: "partials/search-modal.html",
        controller: "ModalController"
      }).then(function(modal) {

        //it's a bootstrap element, use 'modal' to show it
        modal.element.modal();
        modal.close.then(function(result) {
          console.log(result);
        });
      });
      */
    /* Modal fiddling
    $scope.customFullscreen = false;

    $scope.showModal = function(ev) {
      // Appending dialog to document.body to cover sidenav in docs app
      var modal = $mdDialog.confirm({
        controller: ModalCtrl,
        templateUrl: 'partials/search-modal.html',
        parent: angular.element(document.body),
        clickOutsideToClose: false,
        fullscreen: $scope.customFullscreen
      })

      $mdDialog.show(modal);
    };

    function ModalCtrl($scope, $mdDialog) {
      $scope.hide = function() {
        $mdDialog.hide();
      };

      $scope.cancel = function() {
        $mdDialog.cancel();
      };

      $scope.answer = function(answer) {
        $mdDialog.hide(answer);
      };
    }
    */

});

/**
* Controls all other Pages
*/
app.controller('ProfileCtrl', function ($scope) {
console.log("Page Controller reporting for duty.");

    $scope.images = ['images/droneComp1.jpg', 'images/droneComp2.jpg', 'images/droneComp3.jpg', 'images/droneComp4.jpg'];

// Activates the Carousel
$('.carousel').carousel({
interval: 5000
});

// Activates Tooltips for Social Links
$('.tooltip-social').tooltip({
selector: "a[data-toggle=tooltip]"
})
});

/* Controls Modal Modal fiddling #2

app.controller('ModalController', function($scope, close) {

 $scope.close = function(result) {
 	close(result, 500); // close, but give 500ms for bootstrap to animate
 };
}); */





