import java.awt.Rectangle

fun main() {
//    println(sum(3, 9))
//    println(sumWithoutReturnType(3, 9))
//    printSum(3, 9)
//    printSumWithoutReturnType(3, 9)
//    definVariables()
//    stringTemplates()
//    println(maxOf(10, 5))
//    println(maxOfWithoutReturnType(10, 25))
//    nullCheckAndTypeCast("1", "asdf")
//    println(getStringLength(""))
//    forLoopItems()
//    forLoopIndexOfItems()
//    whileLoop()
//    println(describe("Hello2"))
//    rangeCheck()
//    rangeCheck2()
//    rangeCheck3()
//    collection()
}

fun collection() {
    val list = listOf("apple", "orange", "mango", "kiwi", "avocado")

    //todo::test1
    for (item in list){
        println(item)
    }

    //todo::test2
//    when{
//        "orange!" in list -> println("has orange")
//        "apple" in list  -> println("has apple")
//    }

    //todo::test3
//    list
//        .filter { it.startsWith("a") }
//        .sortedBy { it }
//        .map { it.toUpperCase() }
//        .forEach { (println(it)) }
}

fun rangeCheck() {
    val x = 10
    val y = 9
    if (x in 1..y + 1) {
        println("fits in range")
    }
}

fun rangeCheck2() {
    val list = listOf("a", "b", "c")

    if (-1 !in 0..list.lastIndex) {
        println("-1 is out of range")
    }
    if (list.size !in list.indices) {
        println("list size is out of valid list indices range, too")
    }
}

fun rangeCheck3() {
    for (x in 1..5) {
        print(x)
    }
    println()
    for (x in 1..10 step 2) {
        print(x)
    }
    println()
    for (x in 9 downTo 0 step 3) {
        print(x)
    }
}

fun sum(num1: Int, num2: Int): Int {
    return num1 + num2;
}

fun sumWithoutReturnType(num1: Int, num2: Int) = num1 + num2

fun printSum(num1: Int, num2: Int): Unit {
    println("sum of $num1 and $num2 is ${num1 + num2}")
}

fun printSumWithoutReturnType(num1: Int, num2: Int) {
    println("sum of $num1 and $num2 is ${num1 + num2}")
}

fun definVariables() {
    val a: Int = 1
    println("a is $a")

    val b = 2
    println("b is $b")

    val c: Int
    c = 3
    println("c is $c")


    var d = 5
    println("d is $d")
    println("sum of $d and 1 is ${++d}")
}

// This is an end-of-line comment

/* This is a block comment
   on multiple lines. */

fun stringTemplates() {
    var a = 1
    var s1 = "a is $a"
    a = 2
    val s2 = "${s1.replace("is", "was")}. but now is $a"
    println(s2)
}

fun maxOf(a: Int, b: Int): Int {
    if (a > b) {
        return a
    } else {
        return b
    }
}

fun maxOfWithoutReturnType(a: Int, b: Int) = if (a > b) a else b

fun nullCheckAndTypeCast(arg1: String, arg2: String) {
    val x = arg1.toIntOrNull()
    val y = arg2.toIntOrNull()

    if (x != null && y != null) {
        println(x * y)
    } else {
        println("either '$arg1' or '$arg2' is not a number")
    }
}

fun getStringLength(obj: Any): Int? {
    if (obj !is String) {
        return null
    }

    if (obj.length <= 0) {
        return null
    }

    return obj.length
}

fun forLoopItems() {
    val items = listOf("apple", "banana", "mango")
    for (item in items) {
        println(item)
    }
}

fun forLoopIndexOfItems() {
    val items = listOf("apple", "banana", "mango")
    for (index in items.indices) {
        println("item at $index is ${items[index]}")
    }
}

fun whileLoop() {
    val items = listOf("apple", "banana", "mango")
    var index = 0
    while (index < items.size) {
        println("item at $index is ${items[index]}")
        index++
    }
}

fun describe(obj: Any): String =
    when (obj) {
        1 -> "One"
        "Hello" -> "Greeting"
        is Long -> "Long"
        !is String -> "Not a String"
        else -> "Unknown"
    }