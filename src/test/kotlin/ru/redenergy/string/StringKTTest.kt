package ru.redenergy.string

import org.amshove.kluent.`should equal`
import org.junit.Test

class StringKTTest {

    @Test
    fun testBetween(){
        "(hidden)".between("(", ")") `should equal` "hidden"
        "<a>data</a>".between("<a>", "</a>") `should equal` "data"
        "] valid [".between("[", "]")  `should equal` ""
        "==complex==".between("=", "=") `should equal` "=complex="
        "^^".between("^", "^") `should equal` ""
        "follow ] the [rabbit]".between("[", "]") `should equal` "rabbit"
    }
}