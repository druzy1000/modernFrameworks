var sOne = "1";
var iOne = 1;
if (sOne === iOne) {
    console.log("triple equals - does not print");
}
if (sOne == iOne) {
    console.log("double equals - prints");
}
var i = 0;
while (i < 2) {
    i++;
    console.log(i);
}
do {
    i--;
    console.log(i);
} while (i > 0);
var j = 300;
for (var j_1 = 0; j_1 < 2; j_1++) {
    console.log(j_1);
}
console.log(j);
var list = [4, 5, 6];
for (var i_1 in list) {
    console.log(i_1); // "0", "1", "2",
}
for (var _i = 0, list_1 = list; _i < list_1.length; _i++) {
    var i_2 = list_1[_i];
    console.log(i_2); // "4", "5", "6"
}
for (var item in Object) {
    console.log(item); // "a", "b", "c",
}
// for (let item of myObject) { // Nope!
//    console.log(item);
// }
