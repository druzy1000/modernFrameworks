let sOne: any = "1";
let iOne: any = 1;
if (sOne === iOne) {
   console.log("triple equals - does not print");
}

if (sOne == iOne) {
   console.log("double equals - prints");
}


let i = 0;
while(i < 2) {
   i++;
   console.log(i);
}

do {
   i--;
   console.log(i);
} while (i > 0);


let j = 300;
for (let j = 0; j < 2; j++) {
   console.log(j);
}
console.log(j);

let list = [4, 5, 6];

for (let i in list) {
  console.log(i); // "0", "1", "2",
}

for (let i of list) {
  console.log(i); // "4", "5", "6"
}

for (let item in Object) {
  console.log(item); // "a", "b", "c",
}

// for (let item of myObject) { // Nope!
//    console.log(item);
// }
