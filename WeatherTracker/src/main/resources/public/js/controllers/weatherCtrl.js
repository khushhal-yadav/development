app.controller('weatherController', function($scope, $http, weatherService){

    $scope.location = '';
    var defaultLocation = 'Glasgow';

    //function called at page loading
    $scope.initial = function(){
        fetchData(defaultLocation);
        //getCurrentPosition() and watchPosition() no longer work on insecure origins for some of the browsers (they require https connections). worked with firefox though.
        if (navigator.geolocation) {
            navigator.geolocation.getCurrentPosition(function(position){
                latitude = position.coords.latitude;
                longitude = position.coords.longitude;
                currentLocation = "lat="+ latitude+"&lon="+longitude;
                console.log("currentLocation : " + currentLocation);
                fetchData(currentLocation);
            });
        }
    };

    // function called after entering location and hit enter
    $scope.refresh = function(){
        fetchData($scope.location);
    };

    // function to fetch weather data from api call
    fetchData = function(location) {
        $('.loading').show();
        $('.error').hide();
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
