//service
app.service('sellerService',function ($http) {

    this.add=function (entity) {
        return $http.post('/seller/add',entity);
    }
});