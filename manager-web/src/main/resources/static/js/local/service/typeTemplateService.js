//service
app.service('typeTemplateService',function ($http) {
    this.findAll=function () {
        return $http.get('../typeTemplate/findAll');
    }
    this.findPage=function (page,rows) {
        return $http.get('../typeTemplate/findPage?page='+page+'&rows='+rows);
    }
    this.findOne=function (id) {
        return $http.get('../typeTemplate/findOne?id='+id);
    }
    this.add=function (entity) {
        return $http.post('../typeTemplate/add',entity);
    }
    this.update=function (entity) {
        return $http.post('../typeTemplate/update',entity);
    }
    this.delete=function (ids) {
        return $http.get('../typeTemplate/delete?ids='+ids);
    }
    this.search=function (page,rows,searchEntity) {
        return $http.post('../typeTemplate/search?page='+page+'&rows='+rows,searchEntity);
    }
});