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
        "O notfound".between("O", "O") `should equal` ""
    }

    @Test
    fun testCount(){
        "ho ho oh ho ho".count("ho") `should equal` 4
        "hi hi ho hey hihey".count("hi") `should equal` 3
        "()(())((()(())".count(")") `should equal` 6
        "jjjjjah".count("1") `should equal` 0
    }
}