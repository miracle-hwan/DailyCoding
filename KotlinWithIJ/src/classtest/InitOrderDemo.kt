package classtest

import java.lang.IllegalStateException

fun main() {
//    val testInitOrderDemo = InitOrderDemo("테스트")
//    run {
//        val a = 1
//        val b = 4
//        if (a>b){
//            a
//        }else{
//            b
//        }
//    }.also { print(it) }
    val list = listOf(1, 2, 3, 4)
    println(list.filter { it % 2 == 0 })

    val number = mapOf(0 to "zero", 1 to "one")
    println(number.mapValues { it.value.toUpperCase() })

    var strings = listOf("abc", "def")
    println(strings.flatMap { it.toList() })

    val books = listOf(
        Book("Thursday Next", listOf("Jasper Fforde")),
        Book("Mort", listOf("Terry Pratchett")),
        Book("Good Omens", listOf("Terry Pratchett", "Neil Gaiman"))
    )
    println(books.flatMap { it.authors }.toSet())

    listOf(1, 2, 3, 4).asSequence()
        .map { print("map($it) "); it * it }
        .filter { print("filter($it) "); it % 2 == 0 }
        .toList()
        .also { println(it) }

//    fail("Error occurred")
}

fun fail(message: String): Nothing{
    throw IllegalStateException(message)
}

class Book(val title: String, val authors: List<String>)

class InitOrderDemo(name: String) {
    val firstProperty = "First property: $name".also(::println)

    init {
        println("First initializer block that prints $name")
    }

    val secondProperty = "Second property: ${name.length}".also(::println)

    init {
        println("Second initializer block that prints ${name.length}")
    }
}