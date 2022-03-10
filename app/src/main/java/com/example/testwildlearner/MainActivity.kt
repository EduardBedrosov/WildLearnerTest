package com.example.testwildlearner

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }


    override fun onStart() {
        super.onStart()

        val randomString1 = "1sdds12"
        val randomString2 = "a14asabasa41a"
        val randomSnakedString = "_a14aSaa_56aa_sa41_"
        val randomNumber = 6
        val randomArray = arrayOf(4,4,3,163,1,-11,4,1,1,-44,144,144,-44,144)

        val isPalindrome = checkPalindrome(randomString1)
        val isPalindrome2 = checkPalindrome(randomString2)
        val sumOfMaxMin = sumOfMaxMin(randomArray)
        val sumOfMaxMinShort = sumOfMaxMinShort(randomArray)
        val uniqueArrayOfN = uniqueArrayOfN(randomNumber)
        val uniqueArrayOfNShort = uniqueArrayOfNShort(randomNumber)
        val snakedString = snakeToCamelCase(randomSnakedString)

        Log.d("TestWL_Palindrome", isPalindrome.toString())
        Log.d("TestWL_Palindrome", isPalindrome2.toString())
        Log.d("TestWL_SumOfMaxMin", sumOfMaxMin.toString())
        Log.d("TestWL_SumOfMaxMinShort", sumOfMaxMinShort.toString())
        Log.d("TestWL_SnakedString", snakedString.toString())

        for (i in uniqueArrayOfN.indices) {
            Log.d("TestWL_UniqueArrayOfN", uniqueArrayOfN[i].toString())
        }
        for (i in uniqueArrayOfN.indices) {
            Log.d("TestWL_UniqueArrShort", uniqueArrayOfNShort[i].toString())
        }
    }

}

private fun checkPalindrome(word: String): Boolean {
    val wordLength = word.length - 1
    val halfLength = wordLength / 2
    for ((k, i) in (wordLength downTo halfLength).withIndex()) {
        if (word[i] != word[k]) {
            return false
        }
    }
    return true
}

private fun sumOfMaxMin(array: Array<Int>): Int {
    var min = 0
    var max = 0
    for (i in array.indices) {
        if (array[i] > max) {
            max = array[i]
        }
        if (array[i] < min) {
            min = array[i]
        }
    }
    return max + min
}


private fun sumOfMaxMinShort(array: Array<Int>): Int {
    val tempArray = array.distinct()
    val max = tempArray.maxOrNull() ?: 0
    val min = tempArray.minOrNull() ?: 0
    return max + min
}

private fun uniqueArrayOfNShort(num: Int): IntArray {
    return (1..num).toList().toIntArray()
}

private fun uniqueArrayOfN(num: Int): IntArray {
    val array = IntArray(num)
    for (i in 0 until num) {
        array[i] = i + 1
    }
    return array
}

private fun snakeToCamelCase(snakeString: String): String {
    var tempString = ""
    var k = 0
    for (i in snakeString.indices) {
        if (i + k == snakeString.length) {
            return tempString
        }
        if (snakeString[i + k].toString() == "_") {
            if (i + k == snakeString.length - 1) {
                return tempString
            }
            tempString += snakeString[i + 1 + k].uppercaseChar()
            k++
        } else {
            if (i == 0) {
                tempString += snakeString[i].uppercaseChar()
            } else {
                tempString += snakeString[i + k]
            }
        }
    }
    return tempString
}

