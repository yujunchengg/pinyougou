//service
app.service('itemCatService',function ($http) {
    this.findPage=function (page,rows,parentId,name) {
        if(typeof name=="undefined" || name==null || name.length<=0) {
            return $http.get('../itemCat/findPage?parentId=' + parentId + '&page=' + page + '&rows=' + rows);
        }else {
            return $http.get('../itemCat/findPage?parentId=' + parentId + '&sk=' + name + '&page=' + page + '&rows=' + rows);
        }
    }
    this.findOne=function (id) {
        return $http.get('../itemCat/findOne?id='+id);
    }
    this.add=function (entity) {
        return $http.post('../itemCat/add',entity);
    }
    this.update=function (entity) {
        return $http.post('../itemCat/update',entity);
    }
    this.delete=function (ids) {
        return $http.get('../itemCat/delete?ids='+ids);
    }
    this.search=function (page,rows,parentId,name) {
        if(typeof name=="undefined" || name==null || name.length<=0){
            return $http.get('../itemCat/search?parentId='+parentId+'&page='+page+'&rows='+rows);
        }else {
            return $http.get('../itemCat/search?parentId='+parentId+'&sk='+name+'&page='+page+'&rows='+rows);
        }
    }
    this.select2list=function () {
        return $http.get('../itemCat/select2list');
    }
});