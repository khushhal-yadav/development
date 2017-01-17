describe('celsius filter', function() {

  var $filter;

  beforeEach(module("weatherApp"));

  beforeEach(inject(function(_$filter_){
    $filter = _$filter_;
  }));

  it('returns the correct temperature in celsius when give with temp in Kelvin ', function() {
    var celsius = $filter('celsius');
    expect(celsius(280.15)).toEqual(7);
  });
});

describe('capitalize filter', function() {

  var $filter;

  beforeEach(module("weatherApp"));

  beforeEach(inject(function(_$filter_){
    $filter = _$filter_;
  }));

  it('returns the correct value in camel case for a provide string', function() {
    var capitalize = $filter('capitalize');
    expect(capitalize('low rain')).toEqual('Low Rain');
  });
});