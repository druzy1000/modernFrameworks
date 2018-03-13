var a: number = 1;
let b: number = 1;
const c: number = 1;

a = 5;
b = 2;
// a = "Four";  // Error, unlike javascript.
// b = "Four";  // Error
// c = 3; // Error

console.log (`
   a: ${a}
   b: ${b}
   c: ${c}
`);
	

let input = [1, 2];
let [first, second] = input;
console.log("first: " + first);
console.log("second: " + second);

let alpha = 'a';
let beta = 'b';
[beta, alpha] = [alpha, beta];
console.log("alpha: " + alpha);
console.log("beta: " + beta);

let obj = {
   red: "foo",
   blue: 12,
   green: "bar"
};
let { red, green } = obj;
console.log("red: " + red);
console.log("green: " + green);
