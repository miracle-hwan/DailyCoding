package classtest

fun main() {
    val testInitOrderDemo = InitOrderDemo("테스트")
}

class InitOrderDemo(name: String){
    val firstProperty = "First property: $name".also(::println)

    init {
        println("First initializer block that prints $name")
    }

    val secondProperty = "Second property: ${name.length}".also(::println)

    init {
        println("Second initializer block that prints ${name.length}")
    }
}