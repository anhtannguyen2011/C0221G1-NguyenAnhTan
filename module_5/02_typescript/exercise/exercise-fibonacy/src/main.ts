function fibonacy(number:number): number {
    if(number < 0){
        return -1;
    }else if(number == 1 || number == 0){
        return number
    }else {
        return fibonacy(number-1) + fibonacy(number - 2);
    }
}
console.log("10 số fibonacy đầu tiên : ");
let sum: number = 0;
for(let i = 0 ; i < 10; i++){
    console.log(fibonacy(i) + "");
    sum += fibonacy(i);
}

console.log(`Tổng 10 số fibonacy đầu tiên ${sum}`);
