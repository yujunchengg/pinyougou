//service
app.service('goodsService',function ($http) {

    this.add=function (entity) {
        return $http.post('/goods/add',entity);
    }

    this.select2List=function (lv,parentId) {
        return $http.get('/goods/select2?lv='+lv+'&parentId='+parentId);
    }
});