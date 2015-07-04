Clone a Graph.
https://leetcode.com/problems/clone-graph/
Clone an undirected graph. Each node in the graph contains a label and a list of its neighbors.

OJ's undirected graph serialization:
Nodes are labeled uniquely.

We use # as a separator for each node, and , as a separator for node label and each neighbor of the node.
As an example, consider the serialized graph {0,1,2#1,2#2,2}.

The graph has a total of three nodes, and therefore contains three parts as separated by #.

First node is labeled as 0. Connect node 0 to both nodes 1 and 2.
Second node is labeled as 1. Connect node 1 to node 2.
Third node is labeled as 2. Connect node 2 to node 2 (itself), thus forming a self-cycle.
Visually, the graph looks like the following:

```
       1
      / \
     /   \
    0 --- 2
         / \
         \_/

```

Solution
========

This Problem can be solved using DFS and BFS.

- DFS:

So the idea is to take a node clone that node label to new node.
Iterate over the node neighbors and for each of them clone recursively and put it in the neighbor of the cloned node.


This idea is really simple in it's nature.

The problem is cycles and also nodes which are visited once through path may get visited again, hence creating them again.
In such a case the graph would not be exact clone as the references won't be same.

This can be handled by a map data structure.
In the map store entries for the key as the label and value as the cloned node.

When cloned node is created add it to the map and when you see it again, if the label is already present in the map, returned the reference of the node already created.

Important
---------
I made a mistake of deleting the nodes from the map at the end of the path Line:31, this will create the problem as listed above and resulting in a timeout on leetcode.
So don't delete nodes from the map once visited, it keep track of all the nodes visited, and don't create them again.

- BFS:

So the BFS implementation uses a Map and Queue.

The algorithm can be defined as.

Clone the first Node and put it in the map with the label as the key.Also put that node in the queue.

Do while the queue is empty.
poll the first node in the queue let it be head.
Take the corresponding cloned node of the head from the map.
iterate over all the neighbors of the head
if the neighbor is already present in the map get it and add to the neighbor of the cloned node of the head.
else
create a clone of the neighbor, add that to the neighbor of the cloned head also add the neighbor clone to the map.
add the neighbor to the queue.

Will have to look for the time complexity of both these methods.



