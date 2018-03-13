var __extends = (this && this.__extends) || (function () {
    var extendStatics = Object.setPrototypeOf ||
        ({ __proto__: [] } instanceof Array && function (d, b) { d.__proto__ = b; }) ||
        function (d, b) { for (var p in b) if (b.hasOwnProperty(p)) d[p] = b[p]; };
    return function (d, b) {
        extendStatics(d, b);
        function __() { this.constructor = d; }
        d.prototype = b === null ? Object.create(b) : (__.prototype = b.prototype, new __());
    };
})();
function printLabel(labelledObj) {
    console.log(labelledObj.label);
}
var myObj = { size: 10, label: "Size 10 Object" };
printLabel(myObj);
var mySearch = function (source, subString) {
    var result = source.search(subString);
    return result > -1;
};
console.log(mySearch("Hello", "o"));
var Fruit = (function () {
    function Fruit(color) {
        this.color = color;
    }
    Fruit.prototype.getColor = function () {
        return this.color;
    };
    Fruit.getType = function () {
        return "Fruit";
    };
    return Fruit;
}());
var myFruit = new Fruit("green");
console.log(myFruit.getColor());
console.log(Fruit.getType());
var Apple = (function (_super) {
    __extends(Apple, _super);
    function Apple() {
        return _super.call(this, "red") || this;
    }
    return Apple;
}(Fruit));
var myApple = new Apple();
console.log(myApple.getColor());
var list = ['4a', '5b', '6c'];
console.log(list);
