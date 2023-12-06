package com.example.myapplication

fun getValue(nextNodes: List<Node>): String {
    val one: String = nextNodes[0].value.toString()
    val two: String = nextNodes[1].value.toString()
    return "[$one$two]"
}