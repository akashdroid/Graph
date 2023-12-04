package com.example.myapplication

fun getValue(nextNodes: List<Node>): String {
    val one: String = nextNodes[0].value
    val two: String = nextNodes[1].value
    return "[$one$two]"
}