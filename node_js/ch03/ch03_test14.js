var Users = [{name:'소녀시대', age:20},
            {name:'걸스데이', age:22},
            {name:'티아라', age:24},
            {name:'애프터스쿨', age:26},]

console.log('배열 요소의 수 : %d', Users.length);
console.log('원본 Users');
console.dir(Users);

var Users2 = Users.slice(1, 3);

console.log('slice()로 잘라낸 후 users2');
console.dir(Users2);

var Users3 = Users2.slice(1);

console.log('slice()로 잘라낸 후 users3');
console.dir(Users3);