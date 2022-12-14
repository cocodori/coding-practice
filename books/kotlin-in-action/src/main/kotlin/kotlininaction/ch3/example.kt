package kotlininaction.ch3

/*
    확장 프로퍼티를 사용하면 기존 클래스 객체에 대한 프로퍼티 형식의 구문으로 사용할 수 있는 API를 추가할 수 있다.
    프로퍼티라는 이름으로 불리기는 하지만, 상태를 저장할 적절한 방법이 없기 때문에(기존 클래스의 인스턴스 객체에 필드를 추가할 방법은 없다)
    실제로 확장 프로퍼티는 아무 상태도 가질 수 없다.
    하지만 프로퍼티 문법으로 더 짧게 코드를 작성할 수 있어서 편한 경우가 있다.
 */

/**
 * 3.7 확장 프로퍼티 선언하기
 */
val String.lastChar: Char
    get() = get(length-1) // 또는 get(length-1)

/*
    확장 함수의 경우와 마찬가지로 확장 프로퍼티도 일반적인 프로퍼티와 같다.
    단지 수신 객체 클래스가 추가됐을 뿐이다. 뒷받침하는 필드가 없어서 기본 게터 구현을 제공할 수 없으므로 최소한 게터는 꼭 정의해야 한다.
    마찬가지로 초기화 코드에서 계산한 값을 담을 장소가 없으므로 초기화 코드도 쓸 수 없다.

    StringBuilder에 같은 프로퍼티를 정의한다면 StringBuilder의 맨 마지막 문자는 변경 가능하므로 프로퍼티를 var로 만들 수 있다.
 */
var StringBuilder.lastChar: Char
    get() = get(length-1)
    set(value: Char) = this.setCharAt(length-1, value)

fun main() {
    println("Kotlin".lastChar)
    val sb = StringBuilder("Kotlin?")
    sb.lastChar = '!'
    println(sb)
}

