## 참고사이트

#### https://mindorks.com/course/learn-rxjava

#### 개인의 경험에 대한 기록이기 때문에 틀린 부분이 있을 수 도 있습니다.
```
고민중인 부분
 1. 람다를 얼마나 적용해야 할지... 
  -> 가독성은 좋아지나 한번에 타입을 알기가 어려움, 그렇다고 람다를 안쓰면 보일러플레이트 코드가 너무 많아져서 소스가 너무 길어짐
 2. 여러 오퍼레이터를 사용할 때 함수로 나눠서 호출하는게 맞는건지... 한번에 호출하는게 맞는건지.... 
  -> 여러 git소스 확인해보기
```

```
Operator
 - 같은 오퍼레이터 여러번 사용 가능
  ex) map().map().map()

1. map : observable item을 function을 이용해서 return
 -> ex) List<a>를 넣어서 List<b> 리턴 가능하며 일반 함수라고 생각하면 됌

2. zip : observable item 2개를 function 파라미터로 받아서 데이터 가공 후 원하는 타입으로 리턴
 # 파라미터로 두개 다 들어올 때 리턴한다고 함 ( 아직 테스트 X )
  -> 현재는 로컬데이터로만 테스트함. 네트웍 연동해서 쓸 때 해보고 확실하게 써보고 업데이트 할 예정

3. flatMap :  observable item list를 받아서 하나씩 흘려보내줌(리턴)

4. flatMap with filter, zip : 여러번 해봐야 익숙해 질듯
```

```
Subject

1. PublishSubject : 구독한 시점 이후로 오는 데이터만 받음

2. ReplaySubject : 구독한 시점 이전의 모든데이터를 받음

3. BehaviorSubject : 구독한 시점 이전의 최신데이터를 받음 -> livedata랑 비슷함

4. AsyncSubject : 구독시점과 상관없이 onComplete()가 호출되었을 때 최신데이터를받음.
  -> onComplete()가 호출되지 않았다면 데이터를 하나도 받을 수 없음
```

```
CompositeDisposable : 메모리 릭을 방지하기 위한 구독해제

 1. clear() : add로 추가한 옵저버블을 모두 구독해제, 새로 추가 가능
 2. dispose() : add로 추가한 옵저버블을 모두 구독해제, 새로 추가 불가능

 #single의 경우 자동으로 dispose됌. retrofit api에서 사용하였음
```

```
Backpressure

Backpressure : 2.x부터는 Observable 말고 Flowable 사용해야 함.
 -> 많은 양의 데이터(1만or10만)를 흘려보낼 때 사용함
 # 앱개발하면서 배압이 필요할 상황이 있을까 의문... 어차피 안써보면 까먹으니 나중에 필요한 상황이 오면 연습해서 적용할 예정
```