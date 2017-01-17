app.service('weatherService', function($http){

    var defaultLocation = 'Glasgow';

    this.getDate = function(input) {
        if(input == undefined)
            return;
        var parts = input.split(' ');
        return parts[0];
    };

    this.getUrl = function(location) {
        return "http://api.openweathermap.org/data/2.5/forecast?q=" + location + "&mode=json&appid=c5075e558efec609f928da0f3ceb005f";
    };
});