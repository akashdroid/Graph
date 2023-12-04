import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public final class CoursePrerequisites {
    // todo: 3
    // Variable numCourses

    static final class Graph {
        // todo : 2 This is a graph, what is a numCourses in a Graph? What is prerequisites?
        // numcourses are the courses which has to be taken , prerequisites are courses to take array compulsory
        private final int numCourses;
        private final int[][] prerequisites;
        private  Node[] nodes;

        public Graph(int _numCourses, int[][] _prerequisites) {
            numCourses = _numCourses;
            prerequisites = _prerequisites;
            nodes = new Node[numCourses];
        }

        public void createNodes() {
            initialiseNodes();
            for (int[] n : prerequisites) {
                nodes[n[0]].nextNodes.add(nodes[n[1]]);
            }
        }

        private void initialiseNodes() {
            for (int i = 0; i < numCourses; i++) {
                nodes[i] = new Node(i);
            }
        }

        public Node[] getNodes() {
            return nodes;
        }

        public Node getNodeAt(int i) {
            return nodes[i];
        }

        // todo : 1 -  function to add new edges
        public void addNodes(int morenumCourses, int[][] moreprerequisites){
            int originalLength = nodes.length;
            Node[] newNodes = new Node[originalLength + morenumCourses];

            // Copy existing nodes to the new array
            System.arraycopy(nodes, 0, newNodes, 0, originalLength);

            for (int i = originalLength; i < originalLength + morenumCourses; i++) {
                newNodes[i] = new Node(i);
            }

            // Update the nodes reference to the new array
            nodes = newNodes;

            for (int[] n : moreprerequisites) {
                nodes[n[0]].nextNodes.add(nodes[n[1]]);
            }
        }
    }

    static class Node {
        int value;
        List<Node> nextNodes = new ArrayList<>();

        public Node(int _value) {
            value = _value;
        }

        // returns in the format of [1,2]
        public String getValue(List<Node> nextNodes) {
            for (int i = 0; i < nextNodes.size(); i++) {
                return nextNodes.get(i).toString();
            }
            return "";
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    ", nextNodes=" + getValue(nextNodes) +
                    '}';
        }
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        Node[] nodes = createNodes(numCourses, prerequisites);

        for (Node node : nodes) {
            HashSet<Integer> hs = new HashSet<>();
            Queue<Node> q = new LinkedList<Node>();
            q.offer(node);
            while (!q.isEmpty()) {

                Node m = q.poll();
                assert m != null;
                if (hs.contains(m.value)) {
                    return false;
                }
                hs.add(m.value);
                List<Node> nextnode = m.nextNodes;
                for (int j = 0; j < nextnode.size(); j++) {
                    q.offer(nextnode.get(j));
                }
            }

        }
        return true;
    }

    public Node[] createNodes(int numCourses, int[][] prerequisites) {
        Node[] nodes = new Node[numCourses];
        for (int i = 0; i < numCourses; i++) {
            nodes = new Node[i];
        }
        for (int[] n : prerequisites) {
            nodes[n[0]].nextNodes.add(nodes[n[1]]);
        }
        return nodes;
    }

    public static void main(String[] arr) {
        CoursePrerequisites cs = new CoursePrerequisites();
        Graph graphs = new Graph(2, new int[][]{new int[]{1, 0}, new int[]{0, 1}});
        graphs.createNodes();
        // cs.createNodes(2, new int[][]{new int[]{1, 0}, new int[]{0, 1}});
    }
}
