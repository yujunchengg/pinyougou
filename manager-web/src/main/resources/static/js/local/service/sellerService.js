//service
app.service('sellerService',function ($http) {
    this.findPage=function (page,rows,status) {
        return $http.get('../seller/findPage?page='+page+'&rows='+rows+'&status='+status);
    }
    this.findOne=function (id) {
        return $http.get('../seller/findOne?id='+id);
    }
    this.update=function (entity) {
        return $http.post('../seller/update',entity);
    }
    this.delete=function (ids) {
        return $http.get('../seller/delete?ids='+ids);
    }
    this.search=function (page,rows,status,searchEntity) {
        return $http.post('../seller/search?page='+page+'&rows='+rows+'&status='+status,searchEntity);
    }
    this.check=function (id, status) {
        return $http.get('../seller/check?id='+id+"&status="+status);
    }
});