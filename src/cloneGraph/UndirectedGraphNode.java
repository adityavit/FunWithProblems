package cloneGraph;

import java.util.*;

/**
 * Created by adib on 7/4/15.
 */
public class UndirectedGraphNode {
    int label;
    List<UndirectedGraphNode> neighbors;

    UndirectedGraphNode(int x) {
        label = x;
        neighbors = new ArrayList<UndirectedGraphNode>();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UndirectedGraphNode that = (UndirectedGraphNode) o;

        if (label != that.label) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return label;
    }
}
