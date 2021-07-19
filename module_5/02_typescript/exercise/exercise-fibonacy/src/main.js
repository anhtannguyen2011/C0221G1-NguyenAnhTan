function fibonacy(number) {
    if (number < 0) {
        return -1;
    }
    else if (number == 1 || number == 0) {
        return number;
    }
    else {
        return fibonacy(number - 1) + fibonacy(number - 2);
    }
}
console.log("10 số fibonacy đầu tiên : ");
var sum = 0;
for (var i = 0; i < 10; i++) {
    console.log(fibonacy(i) + "");
    sum += fibonacy(i);
}
console.log("T\u1ED5ng 10 s\u1ED1 fibonacy \u0111\u1EA7u ti\u00EAn " + sum);
