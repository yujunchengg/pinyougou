//service
app.service('specificationService',function ($http) {
    this.findAll=function () {
        return $http.get('../specification/findAll');
    }
    this.findPage=function (page,rows) {
        return $http.get('../specification/findPage?page='+page+'&rows='+rows);
    }
    this.findOne=function (id) {
        return $http.get('../specification/findOne?id='+id);
    }
    this.add=function (entity) {
        return $http.post('../specification/add',entity);
    }
    this.update=function (entity) {
        return $http.post('../specification/update',entity);
    }
    this.delete=function (ids) {
        return $http.get('../specification/delete?ids='+ids);
    }
    this.search=function (page,rows,searchEntity) {
        return $http.post('../specification/search?page='+page+'&rows='+rows,searchEntity);
    }
    this.select2list=function () {
        return $http.get('../specification/select2list');
    }
});