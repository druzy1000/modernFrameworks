function sum(x, y) {
   return x + y;
}

let mySum = function(x, y) { 
   return x + y; 
};

console.log(sum(1, 1));
console.log(mySum(3, 3));

function formatter(x: string) {
   return "x: " + x;
}

console.log(formatter("3"));
// console.log(formatter(3)); // Error

function adder(x: number, y: number): number {
   return x + y;
}

console.log(adder(1, 2) + 1);

function concatter(last: string, first?: string) {
   return last + (first ? ", " + first : "");
}
console.log(concatter("Walters"));
console.log(concatter("Walters", "Brian"));

function friender(last: string, first = "X") {
   return last + (first ? ", " + first : "");
}

console.log(friender("Walters"));
console.log(friender("Walters", "Brian"));

function caller(func: Function) {
   console.log(func());
}

function called() {
   return "Hello!";
}

caller(called);

caller(() => {return "Hello Again"});