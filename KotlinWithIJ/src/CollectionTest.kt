import java.lang.IndexOutOfBoundsException

data class Point(val x: Int, val y: Int)

operator fun Point.get(index: Int): Int{
    return when(index){
        0 -> x
        1 -> y
        else ->
            throw IndexOutOfBoundsException("Invaild coordinate $index")
    }
}

data class MutablePoint(var x: Int, var y: Int)

operator fun MutablePoint.set(index: Int, value: Int){
    return when(index){
        0 -> x = value
        1 -> y = value
        else ->
            throw IndexOutOfBoundsException("Invaild coordinate $index")
    }
}

fun main() {
//    val p = Point(10, 20)
//    println(p[1])
    val p = MutablePoint(10, 20)
    p[1] = 42
    println(p)
}


