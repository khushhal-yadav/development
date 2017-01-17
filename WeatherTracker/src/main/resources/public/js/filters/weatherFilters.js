app.filter('celsius', function() {
    return function(temp) {
        var temp = Math.round(temp - 273.15)
        return temp;
    }
});

app.filter('capitalize', function() {
    return function(input) {
        return (!!input) ? input.charAt(0).toUpperCase() + input.substr(1).toLowerCase() : '';
    }
});