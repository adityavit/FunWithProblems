package cloneGraph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

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

    //DFS Implementation.
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

    //BFS Implementation.
    public UndirectedGraphNode cloneGraphBFS(UndirectedGraphNode node) {
        if(node == null)
            return null;
        Map<Integer, UndirectedGraphNode> visitedNodes = new HashMap<Integer, UndirectedGraphNode>();
        Queue<UndirectedGraphNode> BFSQueue = new LinkedList<UndirectedGraphNode>();
        UndirectedGraphNode clonedGraph = new UndirectedGraphNode(node.label);
        visitedNodes.put(clonedGraph.label, clonedGraph);
        BFSQueue.add(node);
        while(!BFSQueue.isEmpty()){
            UndirectedGraphNode queueFirstElement = BFSQueue.poll();
            UndirectedGraphNode headNode = visitedNodes.get(queueFirstElement.label);
            for(UndirectedGraphNode queueFirstElementNeighbor: queueFirstElement.neighbors) {
                if(visitedNodes.containsKey(queueFirstElementNeighbor.label)) {
                    headNode.neighbors.add(visitedNodes.get(queueFirstElementNeighbor.label));
                } else {
                    UndirectedGraphNode neighborClone = new UndirectedGraphNode(queueFirstElementNeighbor.label);
                    headNode.neighbors.add(neighborClone);
                    visitedNodes.put(neighborClone.label, neighborClone);
                    BFSQueue.add(queueFirstElementNeighbor);
                }
            }
        }
        return clonedGraph;
    }

}
