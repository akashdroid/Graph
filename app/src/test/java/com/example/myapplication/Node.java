package com.example.myapplication;

import java.util.ArrayList;
import java.util.List;

public class Node {
    int value;
    List<Node> nextNodes = new ArrayList<>();

    public Node(int _value) {
        value = _value;
    }

    public void add(Node node) {
        nextNodes.add(node);
    }

    //Node{value=1, nextNodes=}
    // Expected result =
    //[1,2]
}
