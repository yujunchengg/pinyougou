//service
app.service('brandService',function ($http) {
    this.findAll=function () {
        return $http.get('../brand/findAll');
    }
    this.findPage=function (page,rows) {
        return $http.get('../brand/findPage?page='+page+'&rows='+rows);
    }
    this.findOne=function (id) {
        return $http.get('../brand/findOne?id='+id);
    }
    this.add=function (entity) {
        return $http.post('../brand/add',entity);
    }
    this.update=function (entity) {
        return $http.post('../brand/update',entity);
    }
    this.delete=function (ids) {
        return $http.get('../brand/delete?ids='+ids);
    }
    this.search=function (page,rows,searchEntity) {
        return $http.post('../brand/search?page='+page+'&rows='+rows,searchEntity);
    }
    this.select2list=function () {
        return $http.get('../brand/select2list');
    }
});