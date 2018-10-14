var fs = require('fs');

fs.writeFile('./output.text', 'Hello World!', function(err){
    if(err){
        console.log('Error : ' + err);
    }

    console.log('output.text. 파일에 데이터 쓰기 완료');
})