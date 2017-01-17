app.controller('weatherController', function($scope, $http, weatherService){

    $scope.location = '';
    var defaultLocation = 'Glasgow';

    $scope.initial = function(){
        //TODO: show weather as per current location
        /*if (navigator.geolocation) {
            navigator.geolocation.getCurrentPosition(function(position){
                latitude = position.coords.latitude;
                longitude = position.coords.longitude;
                currentLocation = "lat="+ latitude+"&lon="+longitude;
                console.log("currentLocation : " + currentLocation);
                fetchData(currentLocation);
            });
        } else {*/
            fetchData(defaultLocation);
        /*}*/
    };

    $scope.refresh = function(){
        fetchData($scope.location);
    };

    fetchData = function(location) {
        $('.loading').show();
            url = weatherService.getUrl(location);
            $http.get(url).
                success(function(data){
                    $scope.weatherData = data;
                    angular.forEach($scope.weatherData.list, function(value1, i) {
                        $scope.weatherData.list[i].date = weatherService.getDate(value1.dt_txt);
                    });
                $('.loading').hide();
            	}).
                error(function(){
                     $('.loading').hide();
                     $('.error').show().html("Some error occured while fetching weather details from API");
                });

    }

    $scope.formatDate = function(date){
        var dateOut = new Date(date);
        return dateOut;
    };

    $scope.initial();
});
