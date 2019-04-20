//controller
app.controller('specificationController',function ($scope,$controller,$http,specificationService) {
    //继承baseController
    $controller('baseController',{$scope:$scope});
    //定义搜索条件
    $scope.searchEntity={
        specName:''
    };
    $scope.entity={
        id:null,
        specName:''
    }
    $scope.entityVo={
        spec:{        //规格
            id:null,
            specName:''
        },
        specOps:[]   //规格详情
    }
    //重置entity变量
    $scope.resetEntity=function(){
        $scope.entity={
            id:null,
            specName:''
        }
    }
    //重置vo
    $scope.resetEntityVo=function(){
        $scope.entityVo={
            spec:{        //规格
                id:null,
                specName:''
            },
            specOps:[]   //规格详情
        }
    }
    //查询所有
    $scope.findAll=function () {
        specificationService.findAll().success(function (response) {
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
        specificationService.findPage(page,rows).success(function (response) {
            $scope.paginationConf.totalItems=response.data.total;  //总记录数
            $scope.list=response.data.records;                        //给列表变量赋值
        });
    }
    //单条查询
    $scope.findOne=function (id) {
        specificationService.findOne(id).success(function (response) {
            //重置vo实体
            $scope.resetEntityVo();
            //组装实体
            $scope.entityVo.spec=response.data.spec;
            $scope.entityVo.specOps=response.data.specOps;
        });
    }

    //增加
    $scope.save=function () {
        var ret=null;
        if($scope.entityVo.spec.id!=null){
            ret=specificationService.update($scope.entityVo);
        }else {
            ret=specificationService.add($scope.entityVo);
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
        specificationService.delete($scope.selectIds)
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
    //删除一个规格详情
    $scope.deleteOps=function(index){
        //删除
        $scope.entityVo.specOps.splice(index,1);
    }
    //新建一个规格详情
    $scope.addOps=function(){
        var op={
            id:null,
            optionName:'',
            specId:$scope.entityVo.spec.id,
            orders:null
        }
        $scope.entityVo.specOps.push(op);
    }
    //条件查询
    $scope.search=function (page,rows) {
        specificationService.search(page,rows,$scope.searchEntity)
            .success(function (response) {
                //总记录数
                $scope.paginationConf.totalItems=response.data.total;
                //列表数据
                $scope.list=response.data.records;
            });
    }
});