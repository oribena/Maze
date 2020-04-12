package algorithms.search;

import java.util.*;

public class DepthFirstSearch extends ASearchingAlgorithm {

    private Stack<AState> stack;

    public DepthFirstSearch() {
        this.queue = new LinkedList<AState>();
        this.visitedNodes = 0;
        this.stack = new Stack<AState>();
    }

    @Override
    public Solution solve(ISearchable Is) {
        if (Is==null || Is.getStartState()==null || Is.getGoalState()==null)
            return null;
        Is.ClearVisited();
//        ArrayList<AState> solArr = new ArrayList<AState>();

        // Mark the start state as visited and add it to the queue
        Is.getStartState().setVisited(true);
//        visitedNodes++;
//        solArr.add(Is.getStartState());
        stack.push(Is.getStartState());
//        boolean finish = false;
        Solution sol = new Solution(null);
        while (!stack.isEmpty())
        {
            // remove a random state from the queue and add it to the solution path
            AState currState = stack.pop();
            if (currState.equals(Is.getGoalState())) {
//                        solArr.add(neighbors.get(i));
//                        Is.getGoalState().setCameFrom(currState);
                sol = new Solution(currState);
                break;
            }
//            solArr.add(currState);

            //get all the possible next states
            ArrayList<AState> neighbors = Is.getAllPossibleStates(currState, getName());
            // go over all the neighbors of the curr state
            for (int i = 0; i < neighbors.size() ; i++) {
                //if the neighbor is not visited yet, set visited and set parent
                if (!neighbors.get(i).isVisited()){
                    neighbors.get(i).setVisited(true);
                    visitedNodes++;
                    neighbors.get(i).setCameFrom(currState);
                    //if we arrived to the end, exit
                    //////////////////////////////////////
                    //add the neighbor to the queue
                    stack.push(neighbors.get(i));
                }
            }
        }
        //if we arrived here there is no solution
        return sol;




//        ArrayList<AState> solArr = new ArrayList<AState>();
//        recDFS(Is, Is.getStartState(), solArr);
//        ArrayList<AState> solArrForReal = new ArrayList<AState>();
//        AState stateToAdd = Is.getGoalState();
//        for (int i = 0; i<getNumberOfNodesEvaluated(); i++) {
//            if (stateToAdd.equals(Is.getStartState()))
//                break;
//            solArrForReal.add(stateToAdd);
//            stateToAdd = stateToAdd.getCameFrom();
//        }
//        return new Solution(Is.getGoalState(), solArrForReal);
    }

    @Override
    public String getName() {
        return "Depth First Search";
    }

//    void recDFS(ISearchable Is, AState currStart, ArrayList<AState> solArr) {
//        // Mark the start state as visited and add it to the queue
//        currStart.setVisited(true);
//        visitedNodes++;
//        solArr.add(currStart);
//
//            //get all the possible next states
//        ArrayList<AState> neighbors = Is.getAllPossibleStates(currStart, getName());
////        while (neighbors.size()!=0) {
//            // go over all the neighbors of the curr state
//            for (int i = 0; i < neighbors.size(); i++) {
//                //if the neighbor is not my parent
//                if (neighbors.get(i).equals(currStart.getCameFrom())) {
////                    neighbors.remove(neighbors.get(i));
//                    continue;
//                }
//                if (neighbors.get(i).isVisited())
//                    continue;
//                    //if the neighbor is not visited yet, set visited and set parent
//                else {
//                    neighbors.get(i).setVisited(true);
//                    visitedNodes++;
//                    neighbors.get(i).setCameFrom(currStart);
//                    //if we arrived to the end, exit
//                    if (neighbors.get(i).equals(Is.getGoalState())) {
//                        solArr.add(neighbors.get(i));
//                        return;
//                    }
//                }
//                recDFS(Is, neighbors.get(i), solArr);
//            }
////        }
////        return recDFS(Is, currStart.getCameFrom(), solArr);
//    }
}