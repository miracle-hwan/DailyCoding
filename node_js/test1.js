var result = 0;

console.time('duration_sum');

for (var i=1; i <=1000; i++){
    result += 1;
}

console.timeEnd('duration_sum');
console.log('1부터 1000까지 더한 결과물 : %d', result);

console.log('현재 실행한 파일의 이름 : %s', __filename);
console.log('현재 실행한 파일의 경로 : %s', __dirname);

var person = {name:'소녀시대', age:20};
console.dir(person);