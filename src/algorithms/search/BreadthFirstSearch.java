package algorithms.search;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class BreadthFirstSearch extends ASearchingAlgorithm {
    @Override
    public Solution solve(ISearchable Is) {
        ArrayList<AState> solArr = new ArrayList<AState>();

        // Create a queue of valid pass for BFS
        PriorityQueue<AState> queue = new PriorityQueue<AState>();

        // Mark the start state as visited and add it to the queue
        Is.getStartState().setVisited(true);
        queue.add(Is.getStartState());

        while (queue.size() != 0)
        {
            // remove a random state from the queue and add it to the solution path
            AState currState = queue.poll();
            solArr.add(currState);

            //get all the possible next states
            ArrayList<AState> neighbors = Is.getAllPossibleStates(currState);
            // go over all the neighbors of the curr state
            for (int i = 0; i < neighbors.size() ; i++) {
                //if the neighbor is not visited yet, set visited and set parent
                if (!neighbors.get(i).isVisited()){
                    neighbors.get(i).setVisited(true);
                    visitedNodes++;
                    neighbors.get(i).setCameFrom(currState);
                    //if we arrived to the end, exit
                    if (neighbors.get(i).equals(Is.getGoalState())) {
                        solArr.add(neighbors.get(i));
                        return new Solution(Is.getGoalState(), solArr);
                    }
                    //add the neighbor to the queue
                    queue.add(neighbors.get(i));
                }
            }
        }
        //if we arrived here there is no solution
        return null;
    }
}
