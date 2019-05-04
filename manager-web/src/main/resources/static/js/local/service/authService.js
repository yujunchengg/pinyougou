//service
app.service('authService',function ($http) {

    this.getAuthName=function () {
        return $http.get('../auth/authName');
    }
});