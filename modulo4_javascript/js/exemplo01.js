console.log('rolou');

var somarArrowFunction = (a,b) => a + b
console.log("somarArrowFunction",somarArrowFunction(1,3));

var somar = function(){
  var a = arguments[0], b = arguments[1];
  return a + b;
}
