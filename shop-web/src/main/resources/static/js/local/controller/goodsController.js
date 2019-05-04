//controller
app.controller('goodsController',function ($scope,$controller,$http,goodsService) {
    //继承baseController
    $controller('baseController',{$scope:$scope});
    //声明变量entity
    $scope.entity={}
    //select2的模型数据
    $scope.select2Vo={
        level1List:{data:null},
        level2List:{data:null},
        level3List:{data:null},
        tempList:{data:null},
        brandList:{data:null}
    }
    //重置变量
    $scope.resetEntity=function(){
        $scope.entity={};
    }

    //商品添加
    $scope.add=function () {
        console.log('保存的实体: '+angular.toJson($scope.entity));
        //商品介绍
        $scope.entity.goodsDesc.introduction=editor.html();
        goodsService.add($scope.entity).success(function (response) {
            //商品添加成功
            if(response.code==512){
                $scope.resetEntity();
                //清空富文本的内容
                editor.html('');
                alert("商品添加成功!");
            }else {  //注册失败
                console.log(response.msg);
                alert("商品添加失败!");
            }
        });
    }
    //初始化所有下拉列表
    $scope.initSelect2=function (lv,parentId) {
        goodsService.select2List(lv,parentId).success(function (response) {
            if(lv==1){
                //一级分类
                $scope.select2Vo.level1List.data=response.data.level1List;
                //模板下拉列表
                $scope.select2Vo.tempList.data=response.data.tempList;
                //品牌下拉列表
                $scope.select2Vo.brandList.data=response.data.brandList;
            }
            if(lv==2){
                $scope.select2Vo.level2List.data=response.data.level2List;

                //赋值其它为空
                $scope.select2Vo.level3List.data=null;
            }
            if(lv==3){
                $scope.select2Vo.level3List.data=response.data.level3List;
            }
        });
    }
});