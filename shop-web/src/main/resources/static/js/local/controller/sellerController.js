//controller
app.controller('sellerController',function ($scope,$controller,$http,sellerService) {
    //继承baseController
    $controller('baseController',{$scope:$scope});
    //声明变量entity
    $scope.entity={}

    //商家注册
    $scope.regist=function () {
        sellerService.add($scope.entity).success(function (response) {
            //跳转登录页
            if(response.code==512){
                window.location.href="login.html";
            }else {  //注册失败
                alert(response.msg);
            }
        });
    }
});