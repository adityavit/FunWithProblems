package ChainedMines;

import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * Created by adib on 7/20/17.
 */
public class Solution {
    private class Node implements Comparable<Node>{
        int x;
        int y;
        Double radius;
        Double distance;

        public Node(int x, int y, Double radius) {
            this.x = x;
            this.y = y;
            this.radius = radius;
            distance = Math.sqrt(x*x + y*y);
        }

        @Override
        public int compareTo(Node o) {
            return this.distance.compareTo(o.distance);
        }

        public boolean inRadius(Node o) {
            Double inBetweenRadius = Math.sqrt((this.x - o.x) * (this.x - o.x) + (this.y - o.y) * (this.y - o.y));
            return inBetweenRadius > this.radius? false: true;
        }
    }

    private class Pair {
        Node source;
        Set<Node> cluster;
    }

    public static void main(String[] args) {

    }


    private static List<Pair> getConnectedComponents(List<Node> nodeList) {
        //Sort the list by their distance from the origin
        Collections.sort(nodeList);
        

    }



}
