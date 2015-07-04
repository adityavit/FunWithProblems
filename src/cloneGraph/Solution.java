package cloneGraph;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by adib on 7/4/15.
 */
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node == null)
            return null;
        Map<Integer,UndirectedGraphNode> visitedNodes = new HashMap<Integer, UndirectedGraphNode>();
        return cloneGraphHelper(node, visitedNodes);
    }

    private UndirectedGraphNode cloneGraphHelper(UndirectedGraphNode node, Map<Integer, UndirectedGraphNode> visitedNodes) {
        UndirectedGraphNode visitedNode = visitedNodes.get(node.label);
        if(visitedNode != null)
            return visitedNode;
        UndirectedGraphNode clonedGraph = new UndirectedGraphNode(node.label);
        //Put the node in the visitedNodes map with the key as the label.
        visitedNodes.put(node.label, clonedGraph);
        //DFS on the neighbours of the node by iterating on each node and calling the method recursively.
        for(UndirectedGraphNode neighbor: node.neighbors) {
            UndirectedGraphNode clonedNeighbor;
            clonedNeighbor = cloneGraphHelper(neighbor, visitedNodes);
            clonedGraph.neighbors.add(clonedNeighbor);
        }
        //remove the visitedNode after the recursive path is done. This is not to be done here. See in the README why.
        //visitedNodes.remove(node.label);
        return clonedGraph;
    }

}
