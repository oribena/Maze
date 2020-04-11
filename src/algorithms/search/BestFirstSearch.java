package algorithms.search;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class BestFirstSearch extends BreadthFirstSearch {

    public BestFirstSearch() {
        this.queue = new PriorityQueue<AState>();
        this.visitedNodes = 0;
    }

    @Override
    public String getName() {
        return "Best First Search";
    }

}
