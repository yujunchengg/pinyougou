//controller
app.controller('indexController',function ($scope,$controller,$http,indexService) {
    //继承baseController
    $controller('baseController',{$scope:$scope});
    //已认证的用户名
    $scope.authName='';

    $scope.getAuthName=function () {
        indexService.getAuthName().success(function (response) {
            $scope.authName=response.data.authenticationName;
        })
    }
});