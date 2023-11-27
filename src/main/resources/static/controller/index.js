var myApp = angular.module("myApp", ["ngRoute"]);
myApp.config(function ($routeProvider, $locationProvider,$httpProvider) {
    $httpProvider.interceptors.push('responseObserver');
    $locationProvider.hashPrefix("");
    $routeProvider
        // .when("/", {
        //   templateUrl: "page/trangchu.html",
        // })
        .when("/", {
            templateUrl: "page/trangchu.html",
            controller :"homeCtrl"
        })
        .when("/about", {
            templateUrl: "page/about-us.html",
        })
        .when("/contact", {
            templateUrl: "page/contact-us.html",
        })
        .when("/blog", {
            templateUrl: "page/blog.html",
        })
        .when("/sanpham", {
            templateUrl: "page/shop-gird.html",
            controller: "SanPhamController"
        })
        .when("/chitietsanpham/:idSp", {
            templateUrl: "page/single-product.html",
            controller: "TrangChiTietSanPhamController"
        })
        .otherwise({
            redirectTo: "/",
        });
});

// .run(function ($rootScope, $http, $location) {
//   // Keep user logged in after page refresh
//   let user = localStorage.getItem("currentUser");
//   console.log(user)
//  let currentUser = user ? JSON.parse(user) : {};
//   if (currentUser) {
//     $rootScope.currentUser = currentUser;
//     $http.defaults.headers.common.Authorization = "Bearer " + currentUser.token;
//   }
//   $rootScope.$on("$locationChangeStart", function(event, next, current) {
//     var publicPages = ["#"];
//     var restrictPage = publicPages.indexOf($location.path()) === -1;
//     if(restrictPage && !currentUser) {
//       $location.path("/login");
//     }
//   });
// });



myApp.factory('responseObserver', function responseObserver($q, $window) {
    return {
        'responseError': function(errorResponse) {
            switch (errorResponse.status) {
                case 403:
                    $window.localStorage.removeItem('currentUser');
                    // $http.defaults.headers.common.Authorization = "";
                    $window.location.reload();
                    break;
                // case 500:
                //   $window.location.href = '/login';
                //   break;
            }
            return $q.reject(errorResponse);
        }
    };
});


myApp.controller("indexCtrl", function ($rootScope,$scope, $http,$window, $location){
    let currentUser = localStorage.getItem("currentUser");
    if(currentUser){
        $scope.currentUser = currentUser ? JSON.parse(currentUser) : {};
        $rootScope.currentUser =$scope.currentUser;
        $window.localStorage.setItem('currentUser', JSON.stringify($scope.currentUser));
        $http.defaults.headers.common.Authorization = "Bearer " + $scope.currentUser.token;
    }
    else{
        $rootScope.currentUser ="";
        $http.defaults.headers.common.Authorization = "";
    }

    $rootScope.logouts = function (){
        $window.localStorage.removeItem('currentUser');
        $http.defaults.headers.common.Authorization = "";
        Swal.fire({
            icon: "warning",
            title: "Đã đăng xuất!",
            text: "Bạn hãy đăng nhập để tiếp tục mua hàng nhé!",
            showConfirmButton: true,
            closeOnClickOutside: false,
            allowOutsideClick: false,
            timer: 1600,
        });
        setTimeout(function (){
            $location.path("/login")
            $window.location.reload();
        },2000)

    }
})