package algorithms.search;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class DepthFirstSearch extends ASearchingAlgorithm {
    @Override
    public Solution solve(ISearchable Is) {
        ArrayList<AState> solArr = new ArrayList<AState>();
        solArr = recDFS(Is, Is.getStartState(), solArr);
        return new Solution(Is.getGoalState(), solArr);
    }

    ArrayList<AState> recDFS(ISearchable Is, AState currStart, ArrayList<AState> solArr) {
        // Mark the start state as visited and add it to the queue
        currStart.setVisited(true);
        visitedNodes++;
        solArr.add(currStart);

            //get all the possible next states
        ArrayList<AState> neighbors = Is.getAllPossibleStates(currStart);
        // go over all the neighbors of the curr state
        for (int i = 0; i < neighbors.size(); i++) {
            //if the neighbor is not my parent
            if (neighbors.get(i).equals(currStart.getCameFrom())) {
                neighbors.remove(neighbors.get(i));
                continue;
            }
            if (neighbors.get(i).isVisited())
                continue;
            //if the neighbor is not visited yet, set visited and set parent
            else {
                neighbors.get(i).setVisited(true);
                visitedNodes++;
                neighbors.get(i).setCameFrom(currStart);
                //if we arrived to the end, exit
                if (neighbors.get(i).equals(Is.getGoalState())) {
                    solArr.add(neighbors.get(i));
                    return solArr;
                }
            }
            return recDFS(Is, neighbors.get(i), solArr);
        }
        return null;
    }
}