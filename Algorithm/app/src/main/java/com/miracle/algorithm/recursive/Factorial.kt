package com.miracle.algorithm.recursive

class Factorial {

    fun factorial(n : Int) : Int{
        if (n > 0){
            return n * factorial(n -1)
        }else{
            return 1
        }
    }
}