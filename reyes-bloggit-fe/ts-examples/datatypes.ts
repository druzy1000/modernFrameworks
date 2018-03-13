let isDone: boolean = false;
let integer: number = 6;
let decimal: number = 3.14;
let color: string = "blue";

console.log("isDone: " + isDone);
console.log("integer: " + integer);
console.log("decimal: " + decimal);
console.log("color: " + color);

console.log(`
   isDone: ${isDone} 
   integer: ${integer}
   decimal: ${decimal}
   color: ${color}
`);


let list1: number[] = [1, 2, 3];
let list2: Array<string> = ['4a', '5b', '6c'];

console.log(list1);
console.log(list2);

let myObj: object = { a: 1, b: "Hi!"}

console.log(myObj);

let list3: any[] = [1, true, "free"];
list3[1] = 100; // No Error
console.log(list3);
