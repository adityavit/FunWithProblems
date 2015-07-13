Course Schedule.
https://leetcode.com/problems/course-schedule/
https://leetcode.com/problems/course-schedule-ii/

This problem can be easily seen a topological sort problem.

So the main idea is detect whether there are cycles in the graph or not.
Usually topological sort can only be done when there is a DAG. So in this case it fail to create a pre-requisite graph if the graph has a cycle.

So basically just run DFS on the graph to find whether there are cycles or not.

The input is given as the list of the edges. So we need to create adjancency list of from the edges. This requires to visit each edge atleast once. O(E)

After adjancency list is created we run DFS on that.

So take the body of the DFS which looks like.

```Java

    doDFS(List<Integer>[] graph) {
        //Have used a visited as an array because the nodes are Integer ranging from 0 - n-1. So it acts like a map. Otherwise use an actual map.
        Boolean[] visited = new Boolean[graph.length];
        //This for loop is required so that DFS run on non connected components.
        for(int i = 0; i< graph.length ; i++) {
            if(visited[i] == null) {
                //Only when the nodes are not visited already.
                visited[i] = true;
                doDFSHelper(graph, i, visited);
            }
         }
    }
    //Does the the actual DFS of a node. Visiting all the nodes which can be reached from that node.
    doDFSHelper(List<Integer>[] graph, Integer startNode, Boolean[] visited){
        //base condition.very Imp. Case when there are no neigbors of the start node. I.e the list is null.
        if(graph[startNode] == null) {
            return;
        }
        List<Integer> neighbors = graph[startNode];
        for(Integer neighbor : neighbors) {
            // Vists each neighbor, in the list of neighbors.
            if(visited[neighbor] == null) {
                //Checks which neighbors are not visited and just visit them.
                visited[neighbor] = true;
                doDFSHelper(graph, neighbor, visited);
            }
        }
    }

```

doDFS function adds O(n) and doDFSHelper will take O(E). This is not O(EN) algorithm, this is a O(E+N) algorithm. As in the worst case all the edges will be reached by the first node so O(E) and then we will still need
to visit all the nodes in the doDFS function as we visit all the nodes only once.

After this skelton is present modifications can be mode to it for different problems.

- Detect Cycle.
    Pass another structure such as a set in the doDFSHelper which keeps track of the elements in the recursive cycle.
    So add the element to the set when you add one to the visited array, and then in the else part of the doDFSHelper check whether the element is present in the set or not. If the element is present then
    there is a cycle else there is not.
    Note:
    ----
    - For the directed graphs you will have to remove the element after the recursive call to doDFSHelper as if you don't then you can detect wrong cycles.
    For example in the graph.
    ```
           +-----+
           |     |
           |  2  |---------
           |     |        |
           +-----+        |
              ^           |
              |           v
           +-----+     +-----+
           |     |     |     |
           |  1  |---->|  3  |
           |     |     |     |
           +-----+     +-----+
    ```
    This graph doesn't have a cycle but if you don't remove element from the set then it will take all the elements on the DFS of 1 in to set i.e. {1,2,3} and when it will reach 3 again through path from 1 it
    will detect a cycle.

    I have added that in the line 101 in the Solution class.

    - For the undirected graph this problem won't come as if there is an edge to the node then that would surely be a part of the recursive cycle. Although topological sort cannot be done of undirected Graphs.
      But for directed graph where the edges are listed twice in the adjancey list, there is a problem that if the precaution is not take then an edge can be counted twice thinking as a beck edge leading to the code
      to give cycles when there might be.

      So to deal with that add a parent array, basically telling nodes parent, and use that array to ignore the neighbor if it is parent so that you don't recurse on it again. and going in an infinite loop.

  - Topological Sort.
        Topoological sort can be done using the above skeleton too. What you will need is a data structure to store the nodes as they are getting recurse in the order of their finish time. Basically after the
        doDFSHelper recursive call in doDFSTopologicalOrder and doDFSHelper. Push the node to an array of size of nodes. And at the end of the doDFS function read this array in reverse order i.e last element will be the first element of the topological sort.

  - Connected Components.
        Connected components are the components in the graph which cannot be reached by other nodes in other component. So basically if you do a DFS in a component it will cover all the ndoes.

        Every connected component will start inside the for loop doDFS when a node is visited earlier. So to collect a components pass a data structure which can keep track of the nodes
        which get visited in a particular call for node i.

  - DFS tree paath.
     To get the DFS path from this skelton pass a parent array, basically an array where each node tells what it's parent is. Fill this array by a statement in the doDFSHelper for loop before the
     recursive call. Topological order is also a tree path.
     ```Java
        parentArray[neighbor] = startNode;
     ```
