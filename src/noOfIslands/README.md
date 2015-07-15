https://leetcode.com/problems/number-of-islands/

Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

Example 1:

11110
11010
11000
00000
Answer: 1

Example 2:

11000
11000
00100
00011
Answer: 3

This Problem is connected component problem of the graph.

In the connected component problem we have to find the number of components in the graph. Every island or a set of 1 is one component. So the idea is to run a DFS on first one till you reach all the ones joined by that
one and continue then to the next available 1 in the grid which is not visited which will give the next component or island.

Use the basic DFS skeleton as in the courseSchedule problem add bunch of base case conditions and then run the DFS on the 4 children of a node.