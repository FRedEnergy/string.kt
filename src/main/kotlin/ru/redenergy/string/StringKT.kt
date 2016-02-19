package ru.redenergy.string

/**
 * @param left - left part from which string would be taken
 * @param right - right part to which string would be taken
 * @return Returns text between left and right element or empty string if nothing is found
 */
fun String.between(left: String, right: String): String {
    val leftPos = indexOf(left) + left.length
    val rightPos = lastIndexOf(right)
    if(leftPos < 0 || rightPos < 0 || leftPos > rightPos) return ""
    return substring(leftPos, rightPos)
}

/**
 * @param needle - element of string which would be counted
 * @return Amount of elements encountered
 */
fun String.count(needle: String): Int =
        split(needle).count() - 1


fun String.slugify(): String =
        toLowerCase().replace(" ", "-")

fun String.ensureLeft(value: String): String =
        if(startsWith(value)) this else value + this

fun String.ensureRight(value: String): String =
        if(endsWith(value)) this else this + value

val camelPartSeparators = arrayOf(" ", "-", "_")

fun String.camelize(): String =
        split(*camelPartSeparators)
                .mapIndexed { i, s -> (if(i == 0) s[0].toLowerCase() else s[0].toUpperCase()) + s.toLowerCase().substring(1) }.joinToString("")

