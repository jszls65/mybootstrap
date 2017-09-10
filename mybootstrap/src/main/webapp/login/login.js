myApp.controller('LoginController', function($scope, $route, $location) {
    debugger;
    $scope.$route = $route;

    $scope.$login = {
        person: {}
    };
    // 登录者信息

    $scope.$login.loginBtn = function() {
        debugger;
        if ($scope.$login.person.name && $scope.$login.person.password) {

        } else {
            return;
        }
        $.ajax({
            type: 'POST',
            url: 'findPersons',
            async: false,
            data: {
                'opcode': 'login',
                'name': $scope.$login.person.name,
                "password": $scope.$login.person.password
            },
            dataType: 'json',
            success: function(result) {
                debugger;
                if (result) {
                    if (result.msgCode == 200) {
                        $scope.$login.msg = "result.msgDesc";
                        $location.path("/main");
                    } else {
                        $scope.$login.msg = result.msgDesc;
                    }
                }

            },
            error: function(e) {
                debugger;
                console.log(e);
            }
        });

    }



});