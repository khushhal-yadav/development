describe("weather service", function () {
  var weatherService;

  beforeEach(module("weatherApp"));

  beforeEach(inject(function (_weatherService_, $httpBackend) {
    weatherService = _weatherService_;
  }));

  it('returns the correct value in camel case for a provide string', function() {
      var capitalize = $filter('capitalize');
      expect(capitalize('low rain')).toEqual('Low Rain');
    });


  it("should return date part from dateTime", function () {
    weatherService.getDate("2017-01-17 06:00:00").then(function(date) {
      expect(date).toEqual("2017-01-17");
    });
  });

  it("should return url for the location provided", function () {
      weatherService.getUrl("Glasgow").then(function(url) {
        expect(url).toEqual("http://api.openweathermap.org/data/2.5/forecast?q=Glasgow&mode=json&appid=c5075e558efec609f928da0f3ceb005f");
      });
    });

});