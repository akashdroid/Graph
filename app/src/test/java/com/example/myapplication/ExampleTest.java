package com.example.myapplication;

import static com.example.myapplication.NodeValueKt.getValue;
import static org.junit.Assert.assertEquals;

import androidx.annotation.NonNull;

import org.junit.Test;

public class ExampleTest {

    @Test
    private void addition_isCorrect() {
        Node node0 = getNode();
        assertEquals(getValue(node0.nextNodes), "[1,2]");
    }





















    @NonNull
    private static Node getNode() {
        Node node1 = new Node(1);
        Node node0 = new Node(0);
        Node node2 = new Node(2);

        node0.add(node1);
        node0.add(node2);
        return node0;
    }
}
