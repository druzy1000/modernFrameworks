interface LabelledValue {
   label: string;
}

function printLabel(labelledObj: LabelledValue) {
   console.log(labelledObj.label);
}

let myObj = {size: 10, label: "Size 10 Object"};
printLabel(myObj);

interface SearchFunc {
   (str: string, sub: string): boolean;
}

let mySearch: SearchFunc = function(source: string, subString: string) {
   let result = source.search(subString);
   return result > -1;
}

console.log(mySearch("Hello", "o"));

class Fruit {
   private color: string;
   
   constructor(color: string) {
       this.color = color;
   }

   public getColor(): string {
       return this.color;
   }

   public static getType(): string {
       return "Fruit";
   }
}

let myFruit: Fruit = new Fruit("green")
console.log(myFruit.getColor());
console.log(Fruit.getType());

class Apple extends Fruit {
   constructor() {
       super("red");
   }
}

let myApple: Apple = new Apple();
console.log(myApple.getColor());

let list: Array<string> = ['4a', '5b', '6c'];

console.log(list);