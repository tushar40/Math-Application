package com.example.mathlibrary

/**
 * A class for handling mathematical operations
 */
class MathOps {

    /**
     * A function to add two Numbers a and b
     *
     * @param a Any Number
     * @param b Any Number
     * @returns a Number
     * @throws @exception the given parameters are not a number
     */
    fun add(a: Number, b: Number): Number {
        return when (a) {
            is Double -> a.toDouble() + b.toDouble()
            is Float  -> a.toFloat() + b.toFloat()
            is Long   -> a.toLong() + b.toLong()
            is Int    -> a.toInt()  + b.toInt()
            is Short  -> a.toShort() + b.toShort()
            is Byte   -> a.toByte() + b.toByte()
            else      -> throw RuntimeException("Unknown numeric type")
        }
    }

    /**
     * A function to subtract two Numbers a and b
     *
     * @param a Any Number
     * @param b Any Number
     * @returns a Number
     * @throws @exception the given parameters are not a number
     */
    fun subtract(a: Number, b: Number): Number {
        return when (a) {
            is Double -> a.toDouble() - b.toDouble()
            is Float  -> a.toFloat() - b.toFloat()
            is Long   -> a.toLong() - b.toLong()
            is Int    -> a.toInt()  - b.toInt()
            is Short  -> a.toShort() - b.toShort()
            is Byte   -> a.toByte() - b.toByte()
            else      -> throw RuntimeException("Unknown numeric type")
        }
    }
}