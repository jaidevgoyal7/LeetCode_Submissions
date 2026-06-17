/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        Map<Node, Node> check = new HashMap<>();
        Node clonedNode = dfs(node, check);
        return clonedNode;
    }

    public Node dfs(Node node, Map<Node, Node> check){
        if(node == null){
            return null;
        }
        
        if(check.containsKey(node)){
            return check.get(node);
        }

        Node clonedNode = new Node(node.val);
        check.put(node, clonedNode);

        for(Node neighbour : node.neighbors){
            Node clonedNeighbour = dfs(neighbour, check);
            clonedNode.neighbors.add(clonedNeighbour);
        }
        return clonedNode;
    }
}