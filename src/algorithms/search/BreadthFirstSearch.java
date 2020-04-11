package algorithms.search;

import algorithms.mazeGenerators.Position;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class BreadthFirstSearch extends ASearchingAlgorithm {

    public BreadthFirstSearch() {
        this.queue = new LinkedList<AState>();
        this.visitedNodes = 0;
    }

    @Override
    public Solution solve(ISearchable Is) {
        if (Is==null || Is.getStartState()==null || Is.getGoalState()==null)
            return null;
        Is.ClearVisited();
        ArrayList<AState> solArr = new ArrayList<AState>();

        // Mark the start state as visited and add it to the queue
        Is.getStartState().setVisited(true);
//        visitedNodes++;
//        solArr.add(Is.getStartState());
        queue.add(Is.getStartState());
        Solution sol = null;
        while (queue.size() != 0)
        {
            // remove a random state from the queue and add it to the solution path
            AState currState = queue.poll();
            if (currState.equals(Is.getGoalState())) {
                solArr.add(currState);
                sol = new Solution(currState);
                break;
            }
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
////////////////////////////////
                    //add the neighbor to the queue
                    queue.add(neighbors.get(i));
                }
            }
        }
        //if we arrived here there is no solution
        return sol;
    }

    @Override
    public String getName() {
        return "Breadth First Search";
    }

//    public void clearVisited(ISearchable Is){
//        for (int i = 0; i < Is.gstateMat.length; i++) {
//            for (int j = 0; j < stateMat[0].length; j++) {
//                Position currPos = new Position(i, j);
//                int currVal = m_maze.getMat()[i][j];
//                stateMat[i][j] = new MazeState(currPos, currVal);
//            }
//
//        }
//    }
}
