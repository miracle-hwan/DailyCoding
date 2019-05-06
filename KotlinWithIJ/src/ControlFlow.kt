fun main() {
//    val a = 3
//    val b = 5
//    val max = if (a > b){
//        println("choose a")
//        a
//    }else{
//        println("choose b")
//        b
//    }
//    println(max)

    loop@ for (i in 1..100){
        for (j in 1..100){
            if (j == 2) break@loop
            println(j)
        }
        println(i)
    }
}