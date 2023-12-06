import junit.framework.TestCase
import org.junit.Test

class NodeTest {

    @Test
    fun testPrintNode(){
        val node1 = Node(1)
        val node2 = Node(2)
        node1.addNode(node2)
        node2.addNode(node1)

        System.out.println(node1)
    }
}