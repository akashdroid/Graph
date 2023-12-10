final class Graph {
    /**
     *
     * todo : 2 This is a graph, what is a numCourses in a Graph? What is prerequisites?
     *   numcourses are the courses which has to be taken , prerequisites are courses to take array compulsory
     * numcourses are the courses that has to be done
     * prerequisites are the requirements without which a subject cannot be attended
     */
    private final int numCourses;
    private final int[][] prerequisites;
    private Node[] nodes;

    public Graph(int _numCourses, int[][] _prerequisites) {
        numCourses = _numCourses;
        prerequisites = _prerequisites;
        nodes = new Node[numCourses];
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
    public void addNodes(int morenumCourses, int[][] moreprerequisites) {
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
           // nodes[n[0]].nextNodes.add(nodes[n[1]]);
        }
    }
}
