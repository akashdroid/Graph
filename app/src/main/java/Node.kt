import java.util.LinkedList

class Node<T>(
    /**
     * This is the int value of the new Node
     */
    val value: T
) {
    /**
     * NextNodes is a collection of connecting Nodes
     * LinkedList is used to save time complexity of addition of new Node
     * ArrayList has time complexity of O(N) for adding a new Node but LinkedList has time complexity of O(1) for adding a new Node
     */
    private val _nextNodes : MutableList<Node<T>> = LinkedList()
    val nextNodes:List<Node<T>> get() = _nextNodes

    /**
     * Function to add @param node to next nodes
     */
    fun addNode(node: Node<T>) {
        _nextNodes.add(node)
    }

    override fun toString(): String {
        return "Node{" +
                "value=" + value +
                ", nextNodes=" + nextNodes.map { it.value }.joinToString(",") +
                '}'
    }
}