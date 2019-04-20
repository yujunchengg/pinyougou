//service
app.service('indexService',function ($http) {

    this.getAuthName=function () {
        return $http.get('../index/authName');
    }
});