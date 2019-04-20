//controller
app.controller('brandController',function ($scope,$controller,$http,brandService) {
    //继承baseController
    $controller('baseController',{$scope:$scope});
    //定义搜索条件
    $scope.searchEntity={
        name:'',
        firstChar:''
    };
    $scope.entity={
        id:null,
        name:'',
        firstChar:''
    }
    //重置entity变量
    $scope.resetEntity=function(){
        $scope.entity={
            id:null,
            name:'',
            firstChar:''
        }
    }
    //查询所有
    $scope.findAll=function () {
        brandService.findAll().success(function (response) {
            //给列表变量赋值
            $scope.list=response.data;
        });
    }
    //刷新列表
    $scope.reloadList=function () {
        $scope.search($scope.paginationConf.currentPage,$scope.paginationConf.itemsPerPage)
    }
    //分页查询
    $scope.findPage=function (page,rows) {
        brandService.findPage(page,rows).success(function (response) {
            $scope.paginationConf.totalItems=response.data.total;  //总记录数
            $scope.list=response.data.records;                        //给列表变量赋值
        });
    }
    //单条查询
    $scope.findOne=function (id) {
        brandService.findOne(id).success(function (response) {
            $scope.entity=response.data;
        });
    }

    //增加
    $scope.save=function () {
        var ret=null;
        if($scope.entity.id!=null){
            ret=brandService.update($scope.entity);
        }else {
            ret=brandService.add($scope.entity);
        }
        ret.success(function (response) {
            if(response.code==512 || response.code==516){
                $scope.reloadList();  //刷新列表
            }else {
                alert(response.msg); //提示错误信息
            }
        });
    }
    //批量删除
    $scope.delete=function () {
        //todo  删除数据时的弹窗提示
        brandService.delete($scope.selectIds)
            .success(function (response) {
                if(response.code==514){
                    $scope.reloadList();  //刷新列表
                }else {
                    alert(response.msg); //提示错误信息
                }
                //重置ids容器
                $scope.selectIds=[];
            });
    }
    //条件查询
    $scope.search=function (page,rows) {
        brandService.search(page,rows,$scope.searchEntity)
            .success(function (response) {
                //总记录数
                $scope.paginationConf.totalItems=response.data.total;
                //列表数据
                $scope.list=response.data.records;
            });
    }
});