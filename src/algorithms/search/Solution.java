package algorithms.search;

import java.util.ArrayList;

public class Solution {
    private AState goalState;
    private ArrayList<AState> path;

    public Solution(AState goalState, ArrayList<AState> path) {
        this.goalState = goalState;
        this.path = path;
    }

    public AState getGoalState() {
        return goalState;
    }

    public ArrayList<AState> getPath() {
        return path;
    }

    public void setPath(ArrayList<AState> path) {
        this.path = path;
    }
}
