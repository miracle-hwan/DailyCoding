var express = require('express');
var http = require('http');
var path = require('path');

var bodyPasrser = require('body-parser');
var static = require('serve-static');

var app = express();

var router = express.Router();

app.set('port', process.env.PORT || 3000);

app.use(bodyPasrser.urlencoded({ extended : false}));

app.use(bodyPasrser.json());

app.use(static(path.join(__dirname, 'public')));

router.route('/process/login').post(function(req, res, next){
    console.log('첫 번째 미들웨어에서 요청을 처리함.');

    var paramId = req.body.id || req.query.id;
    var paramPassword = req.body.password || req.query.password;

    res.writeHead('200', {'Content-Type':'text/html;charset=utf8'});
    res.write('Express 서버에서 응답한 결과입니다.<br>');
    res.write('Param id : ' + paramId);
    res.write('Param password : ' + paramPassword);
    res.end();
});

app.use('/', router);

http.createServer(app).listen(3000, function(){
    console.log('Express 서버가 3000번 포트에서 시작됌.');
});