app.service('weatherService', function($http){

    var defaultLocation = 'Glasgow';

    //function to get date string from date time string
    this.getDate = function(input) {
        if(input == undefined)
            return;
        var parts = input.split(' ');
        return parts[0];
    };

    // function to get url based on location
    this.getUrl = function(location) {
        return "http://api.openweathermap.org/data/2.5/forecast?q=" + location + "&mode=json&appid=c5075e558efec609f928da0f3ceb005f";
    };
});