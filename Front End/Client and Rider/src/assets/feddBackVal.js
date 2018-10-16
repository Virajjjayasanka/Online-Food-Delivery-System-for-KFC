$(document).ready(function(){
  $('#characterLeft').text('100 characters left');
  $('#message').keydown(function () {
    var max = 100;
    var len = $(this).val().length;
    if (len >= max) {
      $('#characterLeft').text('You have reached the limit');
      $('#characterLeft').addClass('red');
      $('#btnSubmit').addClass('disabled');
    }
    else {
      var ch = max - len;
      $('#characterLeft').text(ch + ' characters left');
      $('#btnSubmit').removeClass('disabled');
      $('#characterLeft').removeClass('red');
    }
  });
});

// var a = 0;
// $(window).scroll(function() {

//   var oTop = $('.mu-counter-nav').offset().top - window.innerHeight;
//   if (a == 0 && $(window).scrollTop() > oTop) {
//     $('.counter-value').each(function() {
//       var $this = $(this),
//         countTo = $this.attr('data-count');
//       $({
//         countNum: $this.text()
//       }).animate({
//           countNum: countTo
//         },

//         {

//           duration: 2000,
//           easing: 'swing',
//           step: function() {
//             $this.text(Math.floor(this.countNum));
//           },
//           complete: function() {
//             $this.text(this.countNum);
//             //alert('finished');
//           }

//         });
//     });
//     a = 1;
//   }

// });




 

// var myApp = angular.module('app', ['ngCookies']);
// myApp.controller('CookiesController', ['$scope', '$cookies', '$cookieStore', function($scope, $cookies, $cookieStore) {
//   $scope.writeCookie = function() {  
//     $cookieStore.put('yourCookies', $scope.cookieName);
//   }      
//   $scope.readCookie = function() {     
//     $scope.cookie = $cookieStore.get('yourCookies');      
//   }     
//   $scope.removeCookie = function() {  
//     $cookieStore.remove('yourCookies');   
//   }     
// }]);

