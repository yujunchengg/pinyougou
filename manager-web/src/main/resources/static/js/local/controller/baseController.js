//baseController
app.controller('baseController',function ($scope) {
    //已认证的用户名
    $scope.authName='';
    $scope.reload=true;         //控制分页控件是否重新加载
    $scope.selectIds=[];        //用户选定的ID集合
    //分页配置
    $scope.paginationConf={
        currentPage:1,
        totalItems:10,
        itemsPerPage:10,
        perPageOptions:[10,20,30,40,50],
        onChange:function () {
            if(!$scope.reload){
                return;
            }
            $scope.reloadList();
            $scope.reload=false;
            setTimeout(function () {
                $scope.reload=true;
            },200);
        }
    }
    //更新ID集合
    $scope.updateSelection=function($event,id){
        //判断checkbox是选中还是未选中
        if($event.target.checked){
            $scope.selectIds.push(id);
        }else {
            //查找指定值的索引
            var index=$scope.selectIds.indexOf(id);
            //移除id
            $scope.selectIds.splice(index,1);
        }
    }
    //checkbox的全选与全不选
    $scope.checkAllOrNot=function ($event) {
        if($event.target.checked){
            $scope.checkOne=true;
        }else {
            $scope.checkOne=false;
        }
    }
});