//controller
app.controller('typeTemplateController',function ($scope,$controller,$http,typeTemplateService,brandService,specificationService) {
    //继承baseController
    $controller('baseController',{$scope:$scope});
    //定义搜索条件
    $scope.searchEntity={
        name:''
    };
    $scope.entity={
        id:null,
        name:'',
        specIds:[],
        brandIds:[],
        customAttributeItems:[]
    };
    //品牌下拉列表数据
    $scope.brandList={
        data:[]
    }
    //规格下拉列表数据
    $scope.specList={
        data:[]
    }
    //空数组
    $scope.emptyArray=[];
    //初始化select2下拉列表的数据
    $scope.initSelect2List=function(){
        /*if(angular.equals($scope.brandList.data,$scope.emptyArray)){
            brandService.select2list().success(function (response) {
                $scope.brandList.data=response.data;
            });
        }
        if(angular.equals($scope.specList.data,$scope.emptyArray)){
            specificationService.select2list().success(function (response) {
                $scope.specList.data=response.data;
            });
        }*/
        brandService.select2list().success(function (response) {
            $scope.brandList.data=response.data;
        });
        specificationService.select2list().success(function (response) {
            $scope.specList.data=response.data;
        });
    }
    //重置entity变量
    $scope.resetEntity=function(){
        $scope.entity={
            id:null,
            name:'',
            specIds:[],
            brandIds:[],
            customAttributeItems:[]
        }
    }
    //新建事件处理
    $scope.newEntityHandler=function(){
        //重置entity变量
        $scope.resetEntity();
    }
    //查询所有
    $scope.findAll=function () {
        typeTemplateService.findAll().success(function (response) {
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
        typeTemplateService.findPage(page,rows).success(function (response) {
            $scope.paginationConf.totalItems=response.data.total;  //总记录数
            $scope.list=response.data.records;                        //给列表变量赋值
        });
    }
    //单条查询
    $scope.findOne=function (id) {
        typeTemplateService.findOne(id).success(function (response) {
            $scope.entity=response.data;
            if(response.data.specIds.length>0){
                $scope.entity.specIds=angular.fromJson(response.data.specIds);
            }else {
                $scope.entity.specIds=[];
            }
            if(response.data.brandIds.length>0){
                $scope.entity.brandIds=angular.fromJson(response.data.brandIds);
            }else {
                $scope.entity.brandIds=[];
            }
            if(response.data.customAttributeItems.length>0){
                $scope.entity.customAttributeItems=angular.fromJson(response.data.customAttributeItems);
            }else {
                $scope.entity.customAttributeItems=[];
            }
        });
    }
    //设置插入的entity
    $scope.setInsertEntity=function(){
        if($scope.entity.specIds.length>0){
            var specIds=angular.copy($scope.entity.specIds);
            $scope.entity.specIds=angular.toJson(specIds);
        }else {
            $scope.entity.specIds='';
        }
        if($scope.entity.brandIds.length>0){
            var barandIds=angular.copy($scope.entity.brandIds);
            $scope.entity.brandIds=angular.toJson(barandIds);
        }else {
            $scope.entity.brandIds='';
        }
        if($scope.entity.customAttributeItems.length>0){
            var customAttributeItems=angular.copy($scope.entity.customAttributeItems);
            $scope.entity.customAttributeItems=angular.toJson(customAttributeItems);
        }else {
            $scope.entity.customAttributeItems='';
        }
    }
    //增加
    $scope.save=function () {
        var ret=null;
        //设置要插入的实体
        $scope.setInsertEntity();
        if($scope.entity.id!=null){
            ret=typeTemplateService.update($scope.entity);
        }else {
            ret=typeTemplateService.add($scope.entity);
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
        typeTemplateService.delete($scope.selectIds)
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
        typeTemplateService.search(page,rows,$scope.searchEntity)
            .success(function (response) {
                //总记录数
                $scope.paginationConf.totalItems=response.data.total;
                //列表数据
                $scope.list=response.data.records;
                //处理表格中品牌，规格，关联属性的展示
                /*angular.forEach($scope.list,function (el) {
                    if(el.specIds.length>0){
                        var ar=angular.fromJson(el.specIds);
                        var strArr=[];
                        angular.forEach(ar,function (e) {
                            strArr.push(e.text);
                        });
                        el.specIds=strArr.join(',');
                    }
                    if(el.brandIds.length>0){
                        var ar=angular.fromJson(el.brandIds);
                        var strArr=[];
                        angular.forEach(ar,function (e) {
                            strArr.push(e.text);
                        });
                        el.brandIds=strArr.join(',');
                    }
                    if(el.customAttributeItems.length>0){
                        var ar=angular.fromJson(el.customAttributeItems);
                        var strArr=[];
                        angular.forEach(ar,function (e) {
                            strArr.push(e.text);
                        });
                        el.customAttributeItems=strArr.join(',');
                    }
                });*/
            });
    }
    //将json对象数组转为json串
    $scope.json2str=function(jsonStr,key){
        var str='';
        var tempArr=[];
        if(jsonStr.length>0){
            angular.forEach(angular.fromJson(jsonStr),function (e) {
                tempArr.push(e[key]);
            });
            str=tempArr.join(',');
        }
        return str;
    }
    //删除扩展行数据
    $scope.deleteCustomAttributeItem=function (index) {
        $scope.entity.customAttributeItems.splice(index,1);
    }
    //添加扩展行数据
    $scope.addCustomAttributeItem=function () {
        $scope.entity.customAttributeItems.push({text:''});
    }
});