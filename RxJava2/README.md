## 참고사이트

#### https://mindorks.com/course/learn-rxjava

#### 개인의 경험에 대한 기록이기 때문에 틀린 부분이 있을 수 도 있습니다.
```
operator

1. map : observable item을 function을 이용해서 return
 -> ex) List<a>를 넣어서 List<b> 리턴 가능하며 일반 함수라고 생각하면 됌

2. zip : observable item 2개를 function 파라미터로 받아서 데이터 가공 후 원하는 타입으로 리턴
 # 파라미터로 두개 다 들어올 때 리턴한다고 함 ( 아직 테스트 X )
  -> 현재는 로컬데이터로만 테스트함. 네트웍 연동해서 쓸 때 해보고 확실하게 써보고 업데이트 할 예정

3. flatMap :  observable item list를 받아서 하나씩 흘려보내줌(리턴)

4. flatMap with filter, zip : 여러번 해봐야 익숙해 질듯


- 고민중인 부분
 -> 람다를 얼마나 적용해야 할지... 가독성은 좋아지나 한번에 타입을 알기가 어려움, 그렇다고 람다를 안쓰면 보일러플레이트 코드가 너무 많아져서 소스가 너무 길어짐
 -> 여러 오퍼레이터를 사용할 때 함수로 나눠서 호출하는게 맞는건지... 한번에 호출하는게 맞는건지.... -> 여러 git소스 확인해보기
```