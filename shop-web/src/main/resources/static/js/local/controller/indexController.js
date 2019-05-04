//controller
app.controller('indexController',function ($scope,$controller,$http,indexService,authService) {
    //继承baseController
    $controller('baseController',{$scope:$scope});

    $scope.getAuthName=function () {
        authService.getAuthName().success(function (response) {
            $scope.authName=response.data.authenticationName;
        })
    }
});