var http = require('http');
var fs = require('fs');

var server = http.createServer();
var port = 3000;

server.listen(port, function(){
    console.log('서버시작');
});

server.on('request', function(req, res){
    console.log('클라이언트 요청이 들어왔습니다');

    var filename = './ch05/baseball.jpg';
    var infile = fs.createReadStream(filename, {flags : 'r'});
    
    infile.pipe(res);
});