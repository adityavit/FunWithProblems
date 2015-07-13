package courseSchedule;

import java.util.*;

/**
 * Created by adib on 7/11/15.
 */
public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = createAdjList(numCourses, prerequisites);
        return doDFS(graph);
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = createAdjList(numCourses, prerequisites);
        return doDFSTopologicalOrder(graph);
    }

    //Creates adjacency List from the list of prerequistes of course.
    private List<Integer>[] createAdjList(int numOfNodes, int[][] prerequisites) {
        List<Integer>[] graph = (List<Integer>[]) new List[numOfNodes];
        for(int i =0; i < prerequisites.length ;i++) {
            int course = prerequisites[i][0];
            int prereq = prerequisites[i][1];
            if(graph[prereq] == null) {
                graph[prereq] = new LinkedList<Integer>();
            }
            graph[prereq].add(course);
        }
        return graph;
    }
    //Do DFS to detect cycles in the graph.
    //If there are cycles then there is no possible solution available and return false.
    private boolean doDFS(List<Integer>[] graph) {
        //Tracks which nodes in the graph got visited.
        Boolean[] visited = new Boolean[graph.length];
        //cycle detected
        boolean cycleDetected = true;
        List<Integer> topologicalOrder = new ArrayList<Integer>();
        for(int i = 0; i < graph.length ; i++) {
            //Check whether the node is visited.
            if(visited[i] == null) {
                //Node is not visited run DFS on that node.
                visited[i] = true;
                Set<Integer> recStackElems = new HashSet<Integer>();
                recStackElems.add(i);
                cycleDetected = doDFSHelper(graph, i, visited, recStackElems, topologicalOrder);
                if(cycleDetected == false) {
                    return false;
                }
            }
        }
        return true;
    }

    //Do DFS to detect cycles and return nodes in topological order.
    //If there are cycles then there is no possible solution available and return false.
    private int[] doDFSTopologicalOrder(List<Integer>[] graph) {
        //Tracks which nodes in the graph got visited.
        Boolean[] visited = new Boolean[graph.length];
        //cycle detected
        boolean cycleDetected = true;
        List<Integer> topologicalOrder = new ArrayList<Integer>();
        for(int i = 0; i < graph.length ; i++) {
            //Check whether the node is visited.
            if(visited[i] == null) {
                //Node is not visited run DFS on that node.
                visited[i] = true;
                Set<Integer> recStackElems = new HashSet<Integer>();
                recStackElems.add(i);
                cycleDetected = doDFSHelper(graph, i, visited, recStackElems, topologicalOrder);
                //Add the current node to the topological order list.
                topologicalOrder.add(i);
                if(cycleDetected == false) {
                    return new int[0];
                }
            }
        }
        Collections.reverse(topologicalOrder);
        int[] topologicalOrderNodes = new int[graph.length];
        int pointer = 0;
        for(Integer node: topologicalOrder) {
            topologicalOrderNodes[pointer++] = node;
        }
        return topologicalOrderNodes;
    }

    //Runs recursively on the nodes to check whether the cycle is present in the nodes of the graph.
    // Uses recStackElems to keep track of the elements being visited in the current stack of the DFS.
    private boolean doDFSHelper(List<Integer>[] graph, Integer node, Boolean[] visited, Set<Integer> recStackElems, List<Integer> topologicalOrder) {
        List<Integer> graphNeighbors = graph[node];
        if(graphNeighbors == null)
            return true;
        int noOfNeighbors = graphNeighbors.size();
        for(int i=0; i < noOfNeighbors; i++) {
            Integer neighbor = graphNeighbors.get(i);
            if(visited[neighbor] == null) {
                //In the neighbor is not yet visited then go over that neighbor recursively.
                visited[neighbor] = true;
                recStackElems.add(neighbor);
                boolean cycleDetected = doDFSHelper(graph, neighbor, visited, recStackElems, topologicalOrder);
                //remove the neighbor from the recursive set so that it doesn't count cross edges or forward edges as back edges.
                recStackElems.remove(neighbor);
                //Add the neighbor from the topological order.
                topologicalOrder.add(neighbor);
                if(cycleDetected == false)
                    return false;
            } else {
                //If the node is visited it can be because it was part of the another component or just a part of this recursive path.
                // If it is the path of recursive path then it is a back edge and there is a cycle. Otherwise it is a cross edge.
                if(recStackElems.contains(neighbor)) {
                    return false;
                }
            }
        }
        return true;
    }
}
