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

/**
 * @return Returns string with spaces replaces by dashes
 */
fun String.slugify(): String =
        toLowerCase().replace(" ", "-")

/**
 * Checks if the left element matches the given value if it doesn't concatenates it to the left
 */
fun String.ensureLeft(value: String): String =
        if(startsWith(value)) this else value + this

/**
 * Checks if the right element matches the given value if it doesn't concatenates it to the right
 */
fun String.ensureRight(value: String): String =
        if(endsWith(value)) this else this + value

val camelPartSeparators = arrayOf(" ", "-", "_", "|", "=", "+")

/**
 * Camelizes string, e.g. "Hello World" -> "helloWorld"
 */
fun String.camelize(): String =
        split(*camelPartSeparators)
                .mapIndexed { i, s -> (if(i == 0) s[0].toLowerCase() else s[0].toUpperCase()) + s.toLowerCase().substring(1) }.joinToString("")

/**
 * Returns initials of every word in string, e.g. "Hello World" -> "HW"
 */
fun String.initials(): String =
        if(this.contains(" ")) split(" ").map { if(it.isNotEmpty()) it[0] else "" } .joinToString("")
        else if(isNotEmpty()) this[0].toString() else ""

