myApp.controller('LoginController', function ($scope, $route, $location) {
    debugger;
    $scope.$route = $route;

    $scope.$login = {
        person: {}
    };
    // 登录者信息

    $scope.$login.loginBtn = function () {
        debugger;
        $.ajax({
            type: 'POST',
            url: 'findPersons',
            data: {
                'opcode': 'login',
                'name': $scope.$login.person.name,
                "password": $scope.$login.person.password
            },
            dataType: 'json',
            success: function (result) {
                debugger;
                if (result) {
                    if (result.msgCode == 200) {
                        $scope.$login.msg = result.msgDesc;
                        $location.path("/main");
                    }else if(result.msgCode == 500){
                        $scope.$login.msg = result.msgDesc;
                        delete $scope.$login.person.password;
                    }
                }

            },
            error: function (e) {
                debugger;
                console.log(e);
            }
        });
       
    }



});