if (process.argv.length > 2){
    console.log('세 번째 파라미터의 값 : %s', process.argv[2]);
}

process.argv.forEach(function(item, index){
    console.log(index + ' : ', item);
});