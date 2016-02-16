package ru.redenergy.string

fun String.between(left: String, right: String): String {
    val leftPos = indexOf(left) + left.length
    val rightPos = lastIndexOf(right)
    if(leftPos < 0 || rightPos < 0 || leftPos > rightPos) return ""
    return substring(leftPos, rightPos)
}