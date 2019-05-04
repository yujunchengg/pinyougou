//controller
app.controller('itemCatController',function ($scope,$controller,$http,itemCatService) {
    //继承baseController
    $controller('baseController',{$scope:$scope});
    $scope.entity={}
    //父级Id
    $scope.parentId=0;
    //查询字段的值
    $scope.sk='';
    //层级
    $scope.level=1;

    //模板下拉框数据
    $scope.tempList={
        data:[]
    }

    $scope.setLevel=function(level){
        $scope.level=level;
    }

    //重置entity变量
    $scope.resetEntity=function(){
        $scope.entity={};
    }
    //刷新列表
    $scope.reloadList=function () {
        $scope.search($scope.paginationConf.currentPage,$scope.paginationConf.itemsPerPage)
    }
    //分页查询
    $scope.findPage=function (page,rows) {
        itemCatService.findPage(page,rows).success(function (response) {
            $scope.paginationConf.totalItems=response.data.total;  //总记录数
            $scope.list=response.data.records;                        //给列表变量赋值
        });
    }
    //单条查询
    $scope.findOne=function (id) {
        itemCatService.findOne(id).success(function (response) {
            $scope.entity=response.data;
        });
    }
    //查询下级
    $scope.findByParentId=function(entity){
        if($scope.level==1){
            $scope.entity_1=null;
            $scope.entity_2=null;
        }
        if($scope.level==2){
            $scope.entity_1=entity;
            $scope.entity_2=null;
        }
        if($scope.level==3){
            $scope.entity_2=entity;
        }

        $scope.parentId=entity.id;
        $scope.reloadList();
    }

    //增加
    $scope.save=function () {
        var ret=null;
        //赋值父级Id
        $scope.entity.parentId=$scope.parentId;
        if($scope.entity.id!=null){
            ret=itemCatService.update($scope.entity);
        }else {
            ret=itemCatService.add($scope.entity);
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
        itemCatService.delete($scope.selectIds)
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
        itemCatService.search(page,rows,$scope.parentId,$scope.sk)
            .success(function (response) {
                //总记录数
                $scope.paginationConf.totalItems=response.data.total;
                //列表数据
                $scope.list=response.data.records;
            });
    }

    //初始化下拉框的数据
    $scope.initSelect2List=function () {
        itemCatService.select2list().success(function (response) {
            $scope.tempList.data=response.data;
        });
    }
});