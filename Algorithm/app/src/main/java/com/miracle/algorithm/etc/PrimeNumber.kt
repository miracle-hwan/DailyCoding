package com.miracle.algorithm.etc

class PrimeNumber {

    /**
     * 입력받은 최대값을 기준으로 소수 리스트 객체 리턴
     *
     * [input]      소수 체크할 최대값
     * [return]     소수 리스트 갯수
     */
    fun getPrimeNumberListBtwZeroToInputNumber(input: Int): List<Int> {
        val primeNumberList = mutableListOf<Int>(2, 3)
        for (num in 5..input step 2) {
            var isPrime = true
            for (checkNum in 0..num) {
                if (checkNum >= primeNumberList.size) {
                    break
                }
                if (primeNumberList[checkNum] * primeNumberList[checkNum] > num) {
                    break
                }
                if (num % primeNumberList[checkNum] == 0) {
                    isPrime = false
                    break;
                }
            }
            if (isPrime){
                primeNumberList.add(num)
            }
        }
        return primeNumberList
    }
}
