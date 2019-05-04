//controller
app.controller('sellerController',function ($scope,$controller,$http,sellerService) {
    //继承baseController
    $controller('baseController',{$scope:$scope});
    //定义搜索条件
    $scope.searchEntity={
        name:'',
        nickName:''
    };
    //默认查询未审核的数据
    $scope.status='0';

    $scope.entity={}
    //重置entity变量
    $scope.resetEntity=function(){
        $scope.entity={}
    }
    //刷新列表
    $scope.reloadList=function () {
        $scope.search($scope.paginationConf.currentPage,$scope.paginationConf.itemsPerPage,$scope.status);
    }
    //分页查询
    $scope.findPage=function (page,rows,status) {
        sellerService.findPage(page,rows,status).success(function (response) {
            $scope.paginationConf.totalItems=response.data.total;  //总记录数
            $scope.list=response.data.records;                        //给列表变量赋值
        });
    }
    //单条查询
    $scope.findOne=function (id) {
        sellerService.findOne(id).success(function (response) {
            $scope.entity=response.data;
        });
    }

    //批量删除
    $scope.delete=function () {
        //todo  删除数据时的弹窗提示
        sellerService.delete($scope.selectIds)
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
    $scope.search=function (page,rows,status) {
        sellerService.search(page,rows,status,$scope.searchEntity)
            .success(function (response) {
                //总记录数
                $scope.paginationConf.totalItems=response.data.total;
                //列表数据
                $scope.list=response.data.records;
            });
    }
    /**
     * 查看商家详情
     * @param entity
     */
    $scope.lookSeller=function (entity) {
        $scope.entity=entity;
    }
    /**
     * 商家审核
     * @param status
     */
    $scope.check=function (status) {
        sellerService.check($scope.entity.sellerId,status).success(function (response) {
            //刷新列表
            $scope.reloadList();
        });
    }
    /**
     * 展示状态
     * @param status
     * @returns {string}
     */
    $scope.showStatus=function (status) {
        switch (status) {
            case '0': return '未审核';
            case '1': return '已审核';
            case '2': return '审核未通过';
            case '3': return '关闭';
            default:return '未审核';
        }
    }
});