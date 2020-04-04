package algorithms.search;

import java.util.PriorityQueue;

public abstract class ASearchingAlgorithm implements ISearchingAlgorithm{

    //// I added from the mazeget

    protected PriorityQueue<AState> openList;
    protected int visitedNodes;

    public ASearchingAlgorithm() {
        this.openList = new PriorityQueue<AState>();
        this.visitedNodes = 0;
    }

    protected AState popOpenList(){
        visitedNodes++;
        return openList.poll();
    }

    @Override
    public Solution solve(ISearchable Is) {
        return null;
    }

    @Override
    public int getNumOfVisitedNodes() {
        return visitedNodes;
    }
}
