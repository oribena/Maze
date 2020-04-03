package algorithms.search;

import algorithms.mazeGenerators.Maze;

import java.util.ArrayList;

public class SearchableMaze implements ISearchable {

    private Maze m_maze;

    @Override
    public MazeState getStartState() {
        return null;
    }

    @Override
    public MazeState getGoalState() {
        return null;
    }

    @Override
    public ArrayList<AState> getAllPossibleStates(AState s) {
        return null;
    }
}
